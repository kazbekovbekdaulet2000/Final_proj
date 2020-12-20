package sessions;

import course.Course;
import project.DataBase;
import users.Admin;
import users.Student;
import users.Teacher;
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
				student.getCourses().removeAllElements();
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
		Course course = null;
		for(int i=0;i<db.courses.size();++i) {
			if((course_name.equals(db.courses.elementAt(i).getCourseName())
					|| course_name.equals(db.courses.elementAt(i).getCourseID()))
					&& db.courses.elementAt(i).getForStudYears().equals(student.getYear())
							&& !student.getCourses().contains(db.courses.elementAt(i)) ){
				System.out.print("lol");
				if(course == null) {
					course = db.courses.elementAt(i);
				}else{
					RegisterWithTeacher(student, course_name);
					return;
				}
				
			}
		}
		if(student.getCourses().add(course)) {
			Printer.print(course.getCourseName() + " was added");
		}
	}
	
	private static void RegisterWithTeacher(Student student, String course_name) {
		String name = Printer.input("Print course Teacher Name: ");
		String surname = Printer.input("Print course Teacher Surname: ");
		if(name.equals("back") || surname.equals("back")) {
			return;
		}
		Course new_course = null;
		for(int i=0;i<db.users.size();++i) {
			if((name.equals(db.users.elementAt(i).getName()) && surname.equals(db.users.elementAt(i).getSurname()))
					&& db.users.elementAt(i) instanceof Teacher){
				if(new_course==null) {
					new_course = db.courses.elementAt(i);
				}else {
					return;
				}
				
			}
		}
		if(new_course!=null) {
			if(student.getCourses().add(new_course)) {
				Printer.print(new_course.getCourseName() + " was added");
			}
		}else {
			Printer.print("Wrond Name or Surname of Teacher");
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
