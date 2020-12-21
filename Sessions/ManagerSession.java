
package sessions;

import java.io.IOException;
import java.util.Vector;

import course.Course;
import enums.Faculty;
import project.DataBase;
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
		while(request!="8") {
			String[] a = {"1.View Teacher info","2.View Student info","3.Add Course","4.Send Message to a Teacher",
					"5.Change password","6.Add News","7.View news","8.Exit"};
			Printer.print(a);
			request = Printer.input("Print num to get access: ");;
			if(request.equals("1")) {
				Printer.writeLog(manager, a[0].substring(2));
				viewTeacherInfo();
			}else if(request.equals("2")) {
				Printer.writeLog(manager, a[1].substring(2));
				viewStudentInfo();
			}else if(request.equals("3")) {
				Printer.writeLog(manager, a[2].substring(2));
				addCourse(manager);
			}else if(request.equals("4")) {
				Printer.writeLog(manager, a[3].substring(2));
				Messanger(manager);
			}else if(request.equals("5")) {
				Printer.writeLog(manager, a[4].substring(2));
				AdminSession.changePass(manager);
			}else if(request.equals("6")) {
				Printer.writeLog(manager, a[5].substring(2));
				NewsCreator(manager);
			}else if(request.equals("7")) {
				Printer.writeLog(manager, a[6].substring(2));
				try {
					manager.viewNewsTab();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(request.equals("8")) {
				Printer.writeLogPrimitive(manager, "Leave the intranet");
				Printer.print("Good byeee!");
				return;
			}
			db.save();
		}
	}
	
	private static void NewsCreator(Manager manager) {
		String title = Printer.input("News title: ");
		String text = Printer.input("text: ");
		manager.createNewsTab(title, text);
	}

	private static void Messanger(Manager manager) {
		String mail = Printer.input("Print teacher's mail you want to send message: ");
		Teacher teacher = null;
		for (User k : DataBase.users) {
			if (mail.equals(k.getMail()) && k instanceof Teacher) {
				teacher =(Teacher) k; 
			}
		}
		if(teacher!=null) {
			String text = Printer.input("Print text of your message: ");
			manager.sendMessage(text, teacher);
			Printer.print("Message is delivered");
		}else {
			Printer.print("Can't find teacher with such mail");
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
						Printer.writeLogPrimitive(manager, "added new\""+course.getCourseName()+ "\" course with teacher"+ 
							teacher.getName()+" "+teacher.getSurname());
					}else {
						Printer.print("Course was not added");	
						Printer.writeLogPrimitive(manager, "Fail to add course");
					}
				}
				names.removeAllElements();
			}
		}
		if(t == null) {
			Printer.writeLogPrimitive(manager, "Fail to add Course");
			Printer.print("We don't have such Teacher");	
		}
	}
}
