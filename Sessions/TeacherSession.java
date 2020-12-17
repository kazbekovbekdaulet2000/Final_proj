package Sessions;

import java.util.Scanner;

import Users.Admin;
import Users.Student;
import Users.Teacher;
import project.DataBase;

public class TeacherSession {
	static Scanner scan = new Scanner(System.in);
	static DataBase db = DataBase.getInstance();
	public static void start(Teacher teacher){
		System.out.println("Hello "+ teacher.getName() +" "+teacher.getSurname()
							+"! \nYou entered as a Teacher");
		String request = null;
		while(request!="7") {
			System.out.println("1.Add course ");
			System.out.println("2.Manage Courses");
			System.out.println("3.View Students");
			System.out.println("4.Put Marks");
			System.out.println("5.Send Order to IT support");
			System.out.println("6.Change password");
			System.out.println("7.exit");
			System.out.println("Print num to get access");
			request = scan.nextLine();
			if(request.equals("1")) {
				//TODO
			}else if(request.equals("2")) {
				//TODO
			}else if(request.equals("3")) {
				//TODO
			}else if(request.equals("4")) {
				//TODO
			}else if(request.equals("5")) {
				//TODO
			}else if(request.equals("6")) {
				changePass(teacher);
			}else if(request.equals("7")) {
				System.out.println("Good byeee!");
				return;
			}
			db.save();
		}
	}
	

	private static void manageCourse(Teacher teacher) {
		String manage = null;
		while(manage!="4") {
			System.out.println("1.View courses");
			System.out.println("2.Add course file");
			System.out.println("3.Delete course file");
			System.out.println("4.back");
			System.out.println("Print num to get access");
			manage = scan.nextLine();
			if(manage.equals("1")) {
				teacher.viewCourses();
			}else if(manage.equals("2")) {
				//TODO
			}else if(manage.equals("3")) {
				//TODO
			}else if(manage.equals("4")) {
				return;
			}
			db.save();
		}
	}
	
	private static void changePass(Teacher teacher) {
		System.out.print("Old Pass: ");
		String old_pass = scan.nextLine();
		if(old_pass.equals(teacher.getPassword())) {
			System.out.print("New Pass: ");
			String new_Pass = scan.nextLine();
			teacher.setPassword(new_Pass);
		}else{
			System.out.println("Wrong old password");
		}	
	}
}
