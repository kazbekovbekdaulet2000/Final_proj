package sessions;

import java.util.Scanner;

import project.DataBase;
import users.Admin;
import users.Student;
import utils.Printer;

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
				System.out.println("Count of registrated courses: " +student.getCourses().size());
				student.viewRegisteredCourses();
			}else if(request.equals("3")) {
				System.out.println("Count of registrated courses: " +student.getCourses().size());
				student.drawTranscriptTable();
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
		Printer.print("Count of available courses: " + (db.courses.size()-student.getCourses().size()));
		student.viewAvailableCourses();
		Printer.print("Print course Name or Code (back to go back): ");
		String course_name = scan.nextLine();
		if(course_name.equals("back")) {
			return;
		}
		for(int i=0;i<db.courses.size();++i) {
			if((course_name.equals(db.courses.elementAt(i).getCourseName())
					|| course_name.equals(db.courses.elementAt(i).getCourseID()))
					&& db.courses.elementAt(i).getForStudYears().equals(student.getYear()) ){
				student.getCourses().add(db.courses.elementAt(i));
				System.out.println(db.courses.elementAt(i).getCourseName() + " was added");
			}else {
				System.out.println("Wrond Name or Id of Course");
			}
		}
	}

	private static void changePass(Student user) {
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
