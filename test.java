import java.util.Scanner;

import Sessions.AdminSession;
import Sessions.StudentSession;
import Users.Admin;
import Users.Manager;
import Users.Student;
import Users.Teacher;
import Users.TechSupportGuy;
import Users.User;
import project.Auth;
import project.DataBase;
import enums.Faculty;

public class test {

	public static void main(String[] args) {   
		Auth auth = Auth.getInstance();
		auth.authorize();
//		Scanner scan = new Scanner(System.in);
//		String f = scan.nextLine();
//		Faculty faculty = Faculty.valueOf(f);
//		System.out.println(faculty.decryption);
		
		
	}

}
