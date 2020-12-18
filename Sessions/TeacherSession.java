package sessions;

import java.util.Scanner;

import course.Course;
import enums.Faculty;
import project.DataBase;
import users.Admin;
import users.Student;
import users.Teacher;

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
		Course course = new Course(ID, name, credits, ECTS, faculty, studY, teacher);
		db.courses.add(course);
		System.out.println("New \""+course.getCourseName()+ "\" was added");
	}
	
	private static void addCourseFile(Teacher teacher) {
		System.out.println("Print Course name: ");
	}

	private static void changePass(Teacher user) {
		System.out.print("Old Pass: ");
		String old_pass = scan.nextLine();
		if(old_pass.equals(user.getPassword())) {
			System.out.print("New Pass: ");
			String new_Pass = scan.nextLine();
			user.setPassword(new_Pass);
			if(new_Pass.equals(user.getPassword())) {
				System.out.print("Password is changed: ");	
			}
		}else{
			System.out.println("Wrong old password");
		}	
	}
}
