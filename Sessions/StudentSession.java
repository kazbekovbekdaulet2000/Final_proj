package Sessions;

import Users.Student;

public class StudentSession {

	public static void start(Student student){
		System.out.println("Hello "+ student.getName() +" "+student.getSurname()+"!");
		System.out.println("View courses");
		
	}

}
