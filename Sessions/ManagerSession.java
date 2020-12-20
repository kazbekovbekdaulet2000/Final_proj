
package sessions;

import java.util.Vector;

import course.Course;
import enums.Faculty;
import project.DataBase;
import users.Admin;
import users.Manager;
import users.Student;
import users.Teacher;
import users.User;
import utils.Printer;

public class ManagerSession {
	static DataBase db = DataBase.getInstance();
	public static void start(Manager manager){
		Printer.print("Hello "+ manager.getName() +" "+manager.getSurname()+"! \nYou entered as a Manager");
		String request = null;
		while(request!="6") {
			String[] a = {"1.View Teacher info","2.View Student info","3.Add Course","4.Send Message to Teacher","5.Change password","6.Exit"};
			Printer.print(a);
			request = Printer.input("Print num to get access: ");;
			if(request.equals("1")) {
				viewTeacherInfo();
			}else if(request.equals("2")) {
				viewStudentInfo();
			}else if(request.equals("3")) {
				addCourse(manager);
			}else if(request.equals("4")) {
				//TODO
			}else if(request.equals("5")) {
				changePass(manager);
			}else if(request.equals("6")) {
				Printer.print("Good byeee!");
				return;
			}
			db.save();
		}
	}
	
	private static void viewTeacherInfo() {
		String search = Printer.input("Print teacher's name you want to search: ");
		Teacher teacher = null;
		boolean name = false;
		for (User k : DataBase.users) {
			if (search.equals(k.getName()) && k instanceof Teacher) {
				if(teacher==null) {
					teacher =(Teacher) k; 
				}else {
					name = true;
				}
			}
		}
		if(name==true) {
			teacher = null;
			String search_2 = Printer.input("Print teacher's surname you want to search: ");
			for (User k : DataBase.users) {
				if (search.equals(k.getName()) && search_2.equals(k.getSurname()) && k instanceof Teacher) {
					Printer.print(((Teacher) k).toString());
				}
			}
		}else {
			Printer.print(teacher.toString());
		}
	}
	
	private static void viewStudentInfo() {
		String search = Printer.input("Print studnet's name you want to search: ");
		Student student = null;
		boolean name = false;
		for (User k : DataBase.users) {
			if (search.equals(k.getName()) && k instanceof Student) {
				if(student==null) {
					student =(Student) k; 
				}else {
					name = true;
				}
			}
		}
		if(name==true) {
			student = null;
			String search_2 = Printer.input("Print student's surname you want to search: ");
			for (User k : DataBase.users) {
				if (search.equals(k.getName()) && search_2.equals(k.getSurname()) && k instanceof Student) {
					Printer.print(((Student) k).toString());
				}
			}
		}else {
			Printer.print(student.toString());
		}
	}
	
	private static void addCourse(Manager manager) {
		String ID = Printer.input("Course ID: ");
		String name = Printer.input("Course name: ");
		int credits = Integer.parseInt(Printer.input("Course credit number: "));
		int ECTS = Integer.parseInt(Printer.input("Course ECTS credit number: "));
		Faculty faculty = Faculty.fromString(Printer.input("Course Faculty: "));
		int studY = Integer.parseInt(Printer.input("For year of study: "));
		String teacher_name = Printer.input("Teacher name: ");
		String teacher_surname = Printer.input("Teacher surname: ");
		Teacher t = null;
		
		for(int i=0; i<DataBase.users.size(); ++i) {
			if(DataBase.users.elementAt(i) instanceof Teacher) {
				Teacher teacher = (Teacher) DataBase.users.elementAt(i);
				Vector<String> names = new Vector<String>();
				for(int j=0; j<DataBase.courses.size();++j){
					if(DataBase.courses.get(j).getTeacher().equals(teacher)){
						names.add(DataBase.courses.get(j).getCourseName());
					}
				}
				if(teacher.getName().equals(teacher_name) && teacher.getSurname().equals(teacher_surname) && !names.contains(name)) {
					t = (Teacher) DataBase.users.elementAt(i);
					Course course = new Course(ID, name, credits, ECTS, faculty, studY,teacher);
					if(manager.addCourse(course)) {
						Printer.print("New \""+course.getCourseName()+ "\" course with teacher "+ teacher.getName()+ " "
							+teacher.getSurname()+" was added");
					}else {
						Printer.print("\""+course.getCourseName()+ "\" course with teacher "+ teacher.getName()+ " "
								+teacher.getSurname()+" was not added");	
					}
				}
				names.removeAllElements();
			}
		}
		if(t == null) {
			Printer.print("We don't have such Teacher");	
		}
	}

	private static void changePass(Manager user) {
		String old_pass = Printer.input("Old Password: ");
		if(old_pass.equals(user.getPassword())) {
			String new_Pass = Printer.input("New Password: ");
			user.setPassword(new_Pass);
			if(new_Pass.equals(user.getPassword())) {
				Printer.print("Password is changed: ");	
			}
		}else{
			Printer.print("Wrong old password");
		}	
		AdminSession.updateLoginBase();
	}
}
