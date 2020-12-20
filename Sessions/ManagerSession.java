
package sessions;

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
		String search = Printer.input("Print teacher's name/surname/mail you want to search");
		for (User k : DataBase.users) {
			if ((search.equals(k.getName()) || search.equals(k.getName()) || search.equals(k.getMail())) && k instanceof Teacher)
				Printer.print(k.toString());
		}
	}
	
	private static void viewStudentInfo() {
		String search = Printer.input("Print student's name/surname/mail you want to search");
		for (User k : DataBase.users) {
			if ((search.equals(k.getName()) || search.equals(k.getName()) || search.equals(k.getMail())) && k instanceof Student)
				Printer.print(k.toString());
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
		Teacher teacher = null;
		for(int i=0; i<DataBase.users.size(); ++i) {
			if(DataBase.users.elementAt(i) instanceof Teacher) {
				if(DataBase.users.elementAt(i).getName().equals(teacher_name) && DataBase.users.elementAt(i).getSurname().equals(teacher_surname)) {
					teacher = (Teacher) DataBase.users.elementAt(i);
					Course course = new Course(ID, name, credits, ECTS, faculty, studY,teacher);
					if(manager.addCourse(course)) {
						Printer.print("New \""+course.getCourseName()+ "\" course with teacher "+ teacher.getName()+ " "
							+teacher.getSurname()+" was added");
					}else {
						Printer.print("\""+course.getCourseName()+ "\" course with teacher "+ teacher.getName()+ " "
								+teacher.getSurname()+" was not added");	
					}
				}
			}
		}
		if(teacher == null) {
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
