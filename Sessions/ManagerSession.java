
package Sessions;

import java.util.Scanner;

import Users.Manager;
import Users.Student;
import Users.Teacher;
import enums.Faculty;
import project.Course;
import project.DataBase;

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
		System.out.print("Course ID: ");
		String ID = scan.nextLine();
		System.out.print("Course name: ");
		String name = scan.nextLine();
		System.out.print("Course credit number: ");
		int credits = Integer.parseInt(scan.nextLine());
		System.out.print("Course ECTS credit number: ");
		int ECTS = Integer.parseInt(scan.nextLine());
		System.out.print("Course Faculty: ");
		String f = scan.nextLine();
		Faculty faculty = Faculty.fromString(f);
		System.out.print("For year of study: ");
		int studY = Integer.parseInt(scan.nextLine());
		System.out.print("Teacher name: ");
		String teacher_name= scan.nextLine();
		System.out.print("Teacher surname: ");
		String teacher_surname = scan.nextLine();
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
		System.out.print("Old Pass: ");
		String old_pass = scan.nextLine();
		if(old_pass.equals(user.getPassword())) {
			System.out.print("New Pass: ");
			String new_Pass = scan.nextLine();
			user.setPassword(new_Pass);
		}else {
			System.out.println("Wrong old password");
		}	
	}
}
