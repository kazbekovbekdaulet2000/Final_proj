
package Sessions;

import java.util.Scanner;

import Users.Manager;
import Users.Student;
import project.DataBase;

public class ManagerSession {
	static Scanner scan = new Scanner(System.in);
	static DataBase db = DataBase.getInstance();
	public static void start(Manager manager){
		System.out.println("Hello "+ manager.getName() +" "+manager.getSurname()+"! \nYou entered as Manager");
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
				//TODO
			}else if(request.equals("4")) {
				//TODO
			}else if(request.equals("5")) {
				changePass(manager);
			}else if(request.equals("6")) {
				System.out.println("Good byeee!");
			}
			db.save();
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
