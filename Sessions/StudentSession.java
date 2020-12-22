package sessions;

import java.io.IOException;
import java.util.logging.Logger;

import course.Course;
import project.DataBase;
import users.Student;
import users.Teacher;
import utils.Printer;

public class StudentSession {
	static DataBase db = DataBase.getInstance();
	public static void start(Student student){
		Printer.print("Hello "+ student.getName() +" "+student.getSurname()
							+"! \nYou entered as a Student");
		String request = null;
		while(request!="6") {
			String[] a = {"1.Register for a Courses","2.View Courses","3.View Transcript","4.Change Password"
					,"5.View News","6.Exit"};
			Printer.print(a);
			request = Printer.input("Print num to get access: ");
			if(request.equals("1")) {
//				student.getCourses().removeAllElements();
				Printer.writeLog(student, a[0].substring(2));
				Register(student);
			}else if(request.equals("2")) {
				Printer.writeLog(student, a[1].substring(2));
				if(student.getCourses().size()>0) {
					Printer.print("Count of registrated courses: " +student.getCourses().size());
					student.viewRegisteredCourses();
				}else {
					Printer.print("No courses:");
				}
			}else if(request.equals("3")) {
				Printer.writeLog(student, a[2].substring(2));
				Printer.print("Count of registrated courses: " +student.getCourses().size());
				student.drawTranscriptTable();
			}else if(request.equals("4")) {
				Printer.writeLog(student, a[3].substring(2));
				AdminSession.changePass(student);
			}else if(request.equals("5")) {
				Printer.writeLog(student, a[4].substring(2));
				try {
					student.viewNewsTab();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(request.equals("6")) {
				Printer.writeLogPrimitive(student, "Leave the intanet");
				Printer.print("Good byeee!");
				return;
			}
			db.save();
		}
	}
	private static void Register(Student student) {
		if(DataBase.courses.size()-student.getCourses().size()>0) {
//			Printer.print("Count of available courses: " + (DataBase.courses.size()-student.getCourses().size()));
			student.viewAvailableCourses();
			String course_name = Printer.input("Print course Name or Code (back to go back): ");
			if(course_name.equals("back")) {
				return;
			}
			for(int i=0;i<student.getCourses().size();++i) {
				if(DataBase.courses.get(i).getCourseName().equals(course_name) ||
						DataBase.courses.get(i).getCourseID().equals(course_name)) {
					Printer.print(course_name + " already is registered");
					Printer.writeLogPrimitive(student, "fails to register "+ course_name + "(duplicate of exiting course)");
					db.save();
					return;
				}
			}
			Course course = null;
			for(int i=0;i<DataBase.courses.size();++i) {
				Course cr = DataBase.courses.elementAt(i);
				if(!student.getCourses().contains(cr)){
					if((cr.getCourseName().equals(course_name) || cr.getCourseID().equals(course_name))
							&& cr.getForStudYears().equals(student.getYear()) && cr.getFaculty().equals(student.getFaculty())){
						if(course == null) {
							course = DataBase.courses.elementAt(i);
						}else{
							RegisterWithTeacher(student, course_name);
							return;
						}
					}
				}
			}
			if(course!=null) {
				student.registerForCourse(course);
				student.setTotalCredits(student.getTotalCredits()+course.getCredits());
				student.setTotalECTS(student.getTotalECTS()+course.getCreditsECTS());
				Printer.print(course.getCourseName() + " was added");
				Printer.writeLogPrimitive(student, "added course: "+course.getCourseName());
			}else {
				Printer.writeLogPrimitive(student, "failed to register the course");
			}
			
			
		}else {
			Printer.print("No courses available");
		}
		db.save();
	}
	
	private static void RegisterWithTeacher(Student student, String course_name) {
		String name = Printer.input("Print course Teacher Name: ");
		String surname = Printer.input("Print course Teacher Surname: ");
		if(name.equals("back") || surname.equals("back")) {
			return;
		}
		Teacher teacher = null;
		for(int i=0;i<DataBase.users.size();++i) {
			if(DataBase.users.elementAt(i) instanceof Teacher) {
				Teacher t = (Teacher) DataBase.users.elementAt(i);
				if((t.getName().equals(name) && t.getSurname().equals(surname))){
						teacher = t;
				}
			}
		}
		Course new_course = null;
		for(int i=0;i<DataBase.courses.size();++i) {
			Course cr = DataBase.courses.elementAt(i);
			if((cr.getTeacher().equals(teacher))){
				new_course = cr;
			}
		}
		
		if(new_course!=null) {
			if(student.getCourses().add(new_course)) {
				student.setTotalCredits(student.getTotalCredits()+new_course.getCredits());
				student.setTotalECTS(student.getTotalECTS()+new_course.getCreditsECTS());
				Printer.print(new_course.getCourseName() + " was added");
				Printer.writeLogPrimitive(student, "added course: "+new_course.getCourseName());
			}
		}else {
			Printer.print("Wrong Name or Surname of Teacher");
		}
	}
}
