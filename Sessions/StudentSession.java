package sessions;

import project.DataBase;
import users.Admin;
import users.Student;
import utils.Printer;

public class StudentSession {
	static DataBase db = DataBase.getInstance();
	public static void start(Student student){
		Printer.print("Hello "+ student.getName() +" "+student.getSurname()
							+"! \nYou entered as a Student");
		String request = null;
		while(request!="5") {
			String[] a = {"1.Register for a Courses","2.View Courses","3.View Transcript","4.Change Password","5.Exit"};
			Printer.print(a);
			request = Printer.input("Print num to get access: ");
			if(request.equals("1")) {
				Register(student);
			}else if(request.equals("2")) {
				Printer.print("Count of registrated courses: " +student.getCourses().size());
				student.viewRegisteredCourses();
			}else if(request.equals("3")) {
				Printer.print("Count of registrated courses: " +student.getCourses().size());
				student.drawTranscriptTable();
			}else if(request.equals("4")) {
				changePass(student);
			}else if(request.equals("5")) {
				Printer.print("Good byeee!");
				return;
			}
			db.save();
		}
	}
	private static void Register(Student student) {
		Printer.print("Count of available courses: " + (db.courses.size()-student.getCourses().size()));
		student.viewAvailableCourses();
		String course_name = Printer.input("Print course Name or Code (back to go back): ");
		if(course_name.equals("back")) {
			return;
		}
		for(int i=0;i<db.courses.size();++i) {
			if((course_name.equals(db.courses.elementAt(i).getCourseName())
					|| course_name.equals(db.courses.elementAt(i).getCourseID()))
					&& db.courses.elementAt(i).getForStudYears().equals(student.getYear()) ){
				student.getCourses().add(db.courses.elementAt(i));
				Printer.print(db.courses.elementAt(i).getCourseName() + " was added");
			}else {
				Printer.print("Wrond Name or Id of Course");
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
		AdminSession.updateLoginBase();
	}
}
