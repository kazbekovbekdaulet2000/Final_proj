
package Sessions;

import java.util.Scanner;

import Users.Manager;
import Users.Student;
import Users.Teacher;
import enums.Faculty;
import project.Course;
import project.DataBase;

public class ManagerSession {
	static Scanner scan = new Scanner(System.in);
	static DataBase db = DataBase.getInstance();
	public static void start(Manager manager){
		System.out.println("Hello "+ manager.getName() +" "+manager.getSurname()+"! \nYou entered as a Manager");
		String request = null;
		while(request!="6") {
			System.out.println("1.View Teacher info");
			System.out.println("2.View Student info");
			System.out.println("3.Add Course");
			System.out.println("4.Send Message to Teacher");
			System.out.println("5.Change password");
			System.out.println("6.exit");
			System.out.println("Print num to get access");
			request = scan.nextLine();
			if(request.equals("1")) {
				//TODO
			}else if(request.equals("2")) {
				//TODO
			}else if(request.equals("3")) {
				addCourse(manager);
			}else if(request.equals("4")) {
				//TODO
			}else if(request.equals("5")) {
				changePass(manager);
			}else if(request.equals("6")) {
				System.out.println("Good byeee!");
				return;
			}
			db.save();
		}
	}
	
	private static void addCourse(Manager manager) {
		System.out.println("Course ID: ");
		String ID = scan.next();
		System.out.println("Course name: ");
		String name = scan.next();
		System.out.println("Course credit number: ");
		int credits = scan.nextInt();
		System.out.println("Course ECTS credit number: ");
		int ECTS = scan.nextInt();
		System.out.println("Course Faculty: ");
		String f = scan.next();
		Faculty faculty = null;
		if(f == "FIT")faculty = Faculty.FIT;          //needs to remake
		if(f == "FGGE")faculty = Faculty.FGGE;
		if(f == "FEOGI")faculty = Faculty.FEOGI;
		if(f == "FGE")faculty = Faculty.FGE;
		if(f == "BS")faculty = Faculty.BS;
		if(f == "ISE")faculty = Faculty.ISE;
		if(f == "KMA")faculty = Faculty.KMA;
		if(f == "SMC")faculty = Faculty.SMC;
		if(f == "SCE")faculty = Faculty.SCE;
		if(f == "CAE")faculty = Faculty.CAE;
		if(f == "SECMSCP")faculty = Faculty.SECMSCP;
		
		System.out.println("For year mof study: ");
		int studY = scan.nextInt();
		System.out.println("Teacher name: ");
		String teacher_name= scan.next();
		System.out.println("Teacher surname: ");
		String teacher_surname = scan.next();
		Teacher teacher = null;
		for(int i=0; i<db.users.size(); ++i) {
			if(db.users.elementAt(i) instanceof Teacher) {
				if(db.users.elementAt(i).getName().equals(teacher_name) && db.users.elementAt(i).getSurname().equals(teacher_surname)) {
					teacher = (Teacher)db.users.elementAt(i);
					manager.addCourse(new Course(ID, name, credits, ECTS, faculty, studY,teacher));
					System.out.println("New Course was added");
				}
			}
		}
	}

	private static void changePass(Manager user) {
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
