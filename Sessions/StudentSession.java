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
				System.out.println("Count of available Courses: "+db.courses.size());
				System.out.println(student.getCourses().elementAt(0).toString());
//				student.viewRegisteredCourses();
			}else if(request.equals("3")) {
				//TODO
			}else if(request.equals("4")) {
				changePass(student);
			}else if(request.equals("5")) {
				System.out.println("Good byeee!");
				return;
			}
			db.save();
		}
	}
	private static void Register(Student student) {
		student.viewAvailableCourses();
		System.out.println("Print course Name or Code: ");
		String course_name = scan.nextLine();
		if((course_name.equals(db.courses.elementAt(0).getCourseName())
				|| course_name.equals(db.courses.elementAt(0).getCourseID()))
				&& db.courses.elementAt(0).getForStudYears().equals(student.getYear()) ){
			student.getCourses().add(db.courses.elementAt(0));
			System.out.println(db.courses.elementAt(0).getCourseName() + " was added");
		}else {
			System.out.println("Wrond Name or Id of Course");
		}
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
