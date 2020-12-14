package Sessions;

import java.util.Scanner;

import Users.Admin;
import Users.Student;
import project.DataBase;

public class StudentSession {
	static Scanner scan = new Scanner(System.in);
	static DataBase db = DataBase.getInstance();
	public static void start(Student student){
		System.out.println("Hello "+ student.getName() +" "+student.getSurname()
							+"! \nYou entered as a Student");
		String request = null;
		while(request!="5") {
			System.out.println("1.Register for a Courses");
			System.out.println("2.View Courses");
			System.out.println("3.View Transcript");
			System.out.println("4.Change Password");
			System.out.println("5.exit");
			System.out.println("Print num to get access");
			request = scan.nextLine();
			if(request.equals("1")) {
				Register(student);
			}else if(request.equals("2")) {
				//TODO
			}else if(request.equals("3")) {
				//TODO
			}else if(request.equals("4")) {
				changePass(student);
			}else if(request.equals("5")) {
				System.out.println("Good byeee!");
			}
			db.save();
		}
	}
	private static void Register(Student student) {
		student.viewAvailableCourses();
	}

	private static void changePass(Student user) {
		System.out.println("Old Pass: ");
		String old_pass = scan.nextLine();
		if(old_pass.equals(user.getPassword())) {
			System.out.println("New Pass: ");
			String new_Pass = scan.nextLine();
			user.setPassword(new_Pass);
		}else {
			System.out.println("Wrong old password");
		}	
	}
}
