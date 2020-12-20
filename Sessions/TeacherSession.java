package sessions;

import java.util.Scanner;

import course.Course;
import enums.Faculty;
import project.DataBase;
import users.Admin;
import users.Student;
import users.Teacher;
import utils.Printer;

public class TeacherSession {
	static DataBase db = DataBase.getInstance();
	public static void start(Teacher teacher){
		Printer.print("Hello "+ teacher.getName() +" "+teacher.getSurname()
							+"! \nYou entered as a Teacher");
		String request = null;
		while(request!="7") {
			String[] a = {"1.Add course ","2.Manage Courses","3.View Students",
					"4.Put Marks","5.Send Order to IT support","6.Change password","7.exit","Print num to get access"};
			Printer.print(a);
			request = Printer.input("Print num to get access: ");;
			if(request.equals("1")) {
				addCourse(teacher);
			}else if(request.equals("2")) {
				manageCourse(teacher);
			}else if(request.equals("3")) {
				Printer.print("List of students for different courses: ");
				teacher.listofStudents();
				Printer.print("_______________________________________");
			}else if(request.equals("4")) {
				//TODO
			}else if(request.equals("5")) {
				//TODO
			}else if(request.equals("6")) {
				changePass(teacher);
			}else if(request.equals("7")) {
				Printer.print("Good byeee!");
				return;
			}
			db.save();
		}
	}

	private static void manageCourse(Teacher teacher) {
		String manage = null;
		String course_name = Printer.input("Print course name or code: ");
		Course course = null;
		for(int i=0;i<db.courses.size();++i) {
			if(db.courses.get(i).getCourseName().equals(course_name) || db.courses.get(i).getCourseName().equals(course_name)) {
				if(db.courses.get(i).getTeacher().equals(teacher)) {
					course=db.courses.get(i);
					break;
				}
			}
		}
		if(course==null) {
			Printer.print("No Such course or wrong name of course");
			return;
		}
		while(manage!="5") {
			String[] a = {"1.View course","2.View course students","3.Add course file","4.Delete course file","5.Back"};
			Printer.print(a);
			manage = Printer.input("Print num to get access: ");;
			
			if(manage.equals("1")) {
				teacher.viewCourse(course);
			}else if(manage.equals("2")) {
				Printer.print("List of students for "+course.getCourseName()+" course: ");
				teacher.listofStudents(course);
				Printer.print("_______________________________________");
			}else if(manage.equals("3")) {
				//TODO
			}else if(manage.equals("4")) {
				//TODO
			}else if(manage.equals("5")) {
				return;
			}
			db.save();
		}
	}
	
	private static void addCourse(Teacher teacher) {
		String ID = Printer.input("Course ID: ");
		String name = Printer.input("Course name: ");
		int credits = Integer.parseInt(Printer.input("Course credit number: "));
		int ECTS = Integer.parseInt(Printer.input("Course ECTS credit number: "));
		Faculty faculty = Faculty.fromString(Printer.input("Course Faculty: "));
		int studY = Integer.parseInt(Printer.input("For year of study: "));
		Course course = new Course(ID, name, credits, ECTS, faculty, studY, teacher);
		db.courses.add(course);
		Printer.print("New \""+course.getCourseName()+ "\" was added");
	}
	
	private static void addCourseFile(Teacher teacher) {
		Printer.print("Print Course name: ");
	}

	private static void changePass(Teacher user) {
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
