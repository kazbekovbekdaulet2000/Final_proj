
package sessions;

import java.util.Scanner;

import course.Course;
import enums.Faculty;
import project.DataBase;
import users.Admin;
import users.Manager;
import users.Student;
import users.Teacher;
import utils.Printer;

public class ManagerSession {
	static Scanner scan = new Scanner(System.in);
	static DataBase db = DataBase.getInstance();
	public static void start(Manager manager){
		System.out.println("Hello "+ manager.getName() +" "+manager.getSurname()+"! \nYou entered as a Manager");
		String request = null;
		while(request!="6") {
			System.out.println("1.View Teacher info");
			System.out.println("2.View Student info");
			System.out.println("3.Add Course");
			System.out.println("4.Send Message to Teacher");
			System.out.println("5.Change password");
			System.out.println("6.exit");
			System.out.println("Print num to get access");
			request = scan.nextLine();
			if(request.equals("1")) {
				//TODO
			}else if(request.equals("2")) {
				//TODO
			}else if(request.equals("3")) {
				addCourse(manager);
			}else if(request.equals("4")) {
				//TODO
			}else if(request.equals("5")) {
				changePass(manager);
			}else if(request.equals("6")) {
				System.out.println("Good byeee!");
				return;
			}
			db.save();
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
						System.out.println("New \""+course.getCourseName()+ "\" course with teacher "+ teacher.getName()+ " "
							+teacher.getSurname()+" was added");
					}else {
						System.out.println("\""+course.getCourseName()+ "\" course with teacher "+ teacher.getName()+ " "
								+teacher.getSurname()+" was not added");	
					}
				}else {
					System.out.println("We don't have such Teacher");	
				}
			}
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
	}
}
