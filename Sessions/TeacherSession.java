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
				addCourse(teacher);
			}else if(request.equals("2")) {
				manageCourse(teacher);
			}else if(request.equals("3")) {
				System.out.println("List of students for different courses: ");
				teacher.listofStudents();
				System.out.println("_______________________________________");
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
		System.out.println("Print course name or code: ");
		String course_name = scan.nextLine();
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
			System.out.println("No Such course or wrong name of course");
			return;
		}
		while(manage!="5") {
			System.out.println("1.View course");
			System.out.println("2.View course students");
			System.out.println("3.Add course file");
			System.out.println("4.Delete course file");
			System.out.println("5.back");
			System.out.println("Print num to get access");
			manage = scan.nextLine();
			if(manage.equals("1")) {
				teacher.viewCourse(course);
			}else if(manage.equals("2")) {
				System.out.println("List of students for "+course.getCourseName()+" course: ");
				teacher.listofStudents(course);
				System.out.println("_______________________________________");
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
		System.out.println("New \""+course.getCourseName()+ "\" was added");
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
	}
}
