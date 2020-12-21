package sessions;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import course.Course;
import course.Course_File;
import enums.Faculty;
import project.DataBase;
import users.Teacher;
import utils.Printer;

public class TeacherSession {
	static DataBase db = DataBase.getInstance();
	public static void start(Teacher teacher){
		Printer.print("Hello "+ teacher.getName() +" "+teacher.getSurname()
							+"! \nYou entered as a Teacher");
		String request = null;
		while(request!="9") {
			String[] a = {"1.Add course ","2.Manage Courses","3.View Students",
					"4.Put Marks","5.Send Order to IT support","6.View messages","7.Change password","8.View news","9.Exit"};
			Printer.print(a);
			request = Printer.input("Print num to get access: ");;
			if(request.equals("1")) {
				Printer.writeLog(teacher, a[0].substring(2));
				addCourse(teacher);
			}else if(request.equals("2")) {
				Printer.writeLog(teacher, a[1].substring(2));
				manageCourse(teacher);
			}else if(request.equals("3")) {
				Printer.writeLog(teacher, a[2].substring(2));
				Printer.print("List of students for different courses: ");
				teacher.listofStudents();
				Printer.print("_______________________________________");
			}else if(request.equals("4")) {
				Printer.writeLog(teacher, a[3].substring(2));
				//TODO
			}else if(request.equals("5")) {
				Printer.writeLog(teacher, a[4].substring(2));	
				//TODO
			}else if(request.equals("6")) {
				Printer.writeLog(teacher, a[6].substring(2));
				teacher.viewMessages();
			}else if(request.equals("7")) {
				Printer.writeLog(teacher, a[5].substring(2));
				AdminSession.changePass(teacher);
			}else if(request.equals("8")) {
				Printer.writeLog(teacher, a[7].substring(2));
				try {
					teacher.viewNewsTab();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(request.equals("9")) {
				Printer.writeLogPrimitive(teacher, "Leave the intranet");
				Printer.print("Good byeee!");
				return;
			}
			db.save();
		}
	}
	


	private static void manageCourse(Teacher teacher) {
		String manage = null;
		String ans = Printer.input("View courses?(Y/N): ");
		int c=1;
		if(ans.equals("Y") || ans.equals("y")) {
			int cnt=0;
			for(int i=0;i<DataBase.courses.size();++i) {
				if(DataBase.courses.get(i).getTeacher().equals(teacher)) {
					Printer.print(DataBase.courses.get(i).toString());
					cnt++;
				}
			}
			c=cnt;
		}
		if(c!=0) {
			String course_name = Printer.input("Print course name or code: ");
			Course course = null;
			for(int i=0;i<DataBase.courses.size();++i) {
				if(DataBase.courses.get(i).getCourseName().equals(course_name) || DataBase.courses.get(i).getCourseName().equals(course_name)) {
					if(DataBase.courses.get(i).getTeacher().equals(teacher)) {
						course=DataBase.courses.get(i);
						break;
					}
				}
			}
			if(course==null) {
				Printer.writeLogPrimitive(teacher, "Fail to manage course");
				Printer.print("No Such course or wrong name of course");
				return;
			}
			while(manage!="6") {
				String[] a = {"1.View course","2.View course students","3.View course files",
						"4.Add course file","5.Delete course file","6.Back"};
				Printer.print(a);
				manage = Printer.input("Print num to get access: ");;
				
				if(manage.equals("1")) {
					Printer.writeLog(teacher, a[0].substring(2));
					teacher.viewCourse(course);
				}else if(manage.equals("2")) {
					Printer.writeLog(teacher, a[1].substring(2));
					Printer.print("List of students for "+course.getCourseName()+" course: ");
					teacher.listofStudents(course);
					Printer.print("_______________________________________");
				}else if(manage.equals("3")) {
					Printer.writeLog(teacher, a[2].substring(2));
					Printer.print("Course file count: " +course.getFiles().size());
					for(int i=0;i<course.getFiles().size();++i) {
						Printer.print(course.getFiles().get(i).toString());
					}
				}else if(manage.equals("4")) {
					Printer.writeLog(teacher, a[3].substring(2));
					addCourseFile(teacher, course);
				}else if(manage.equals("5")) {
					Printer.writeLog(teacher, a[4].substring(2));
					deleteCourseFile(teacher, course);
				}else if(manage.equals("6")) {
					Printer.writeLogPrimitive(teacher, "Mail screen");
					return;
				}
				db.save();
			}
		}else {
			Printer.print("You haven't any courses");
		}
	}
	
	private static void addCourseFile(Teacher teacher, Course cr) {
		String file_name = Printer.input("File name: ");
		String file_context = Printer.input("You can paste you text here: ");
		Course_File file = new Course_File(cr.getCourseName()+"_"+teacher.getName()+"_"+teacher.getSurname(), file_name, file_context);
		cr.getFiles().add(file);
		Printer.writeLogPrimitive(teacher,"added course file for " + cr.getCourseName());
	}

	private static void deleteCourseFile(Teacher teacher, Course cr) {
		String file_name = Printer.input("File name to delete: ");
		Course_File file = null;
		for(int i=0;i<cr.getFiles().size();++i) {
			if(cr.getFiles().get(i).getFileName().equals(file_name)) {
				cr.getFiles().remove(cr.getFiles().get(i));
				try{         
					String dir = cr.getCourseName()+"_"+teacher.getName()+"_"+teacher.getSurname();
					File f= new File("files/"+dir+"/" +file_name+".txt");            
					if(f.delete()){                  
						Printer.print(f.getName() + " deleted");
						Printer.writeLogPrimitive(teacher,"deleted course file from " + cr.getCourseName() + "\nfile name: " + file_name);
					}else{  
						Printer.writeLogPrimitive(teacher," failed to deleted course file from " + cr.getCourseName() + "\nfile name: " + file_name);
						Printer.print("failed to delete file "+ file_name);  
					}  
				}catch(Exception e){  
					e.printStackTrace();    
				}  
			}
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
		DataBase.courses.add(course);
		Printer.print("New \""+course.getCourseName()+ "\" was added");
		Printer.writeLogPrimitive(teacher, "added new \""+ course.getCourseName()+"\"");
	}
	
//	private static void addCourseFile(Teacher teacher) {
//		Printer.print("Print Course name: ");
//	}
}
