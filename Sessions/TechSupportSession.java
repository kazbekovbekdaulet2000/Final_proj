package Sessions;

import java.util.Scanner;

import Users.Admin;
import Users.Teacher;
import Users.TechSupportGuy;
import project.DataBase;

public class TechSupportSession {
	static Scanner scan = new Scanner(System.in);
	static DataBase db = DataBase.getInstance();
	public static void start(TechSupportGuy techSupport){
		System.out.println("Hello "+ techSupport.getName() +" "+techSupport.getSurname()
							+"! \nYou entered as a Tech Support worker");
		String request = null;
		while(request!="4") {
			System.out.println("1.View new orders");
			System.out.println("2.View accepted orders");
			System.out.println("3.Change password");
			System.out.println("4.exit");
			System.out.println("Print num to get access");
			request = scan.nextLine();
			if(request.equals("1")) {
				//TODO
			}else if(request.equals("2")) {
				//TODO
			}else if(request.equals("3")) {
				//TODO
			}else if(request.equals("4")) {
				System.out.println("Good byeee!");
				return;
			}
			db.save();
		}
	}
	
	private static void changePass(TechSupportGuy tsg) {
		System.out.print("Old Pass: ");
		String old_pass = scan.nextLine();
		if(old_pass.equals(tsg.getPassword())) {
			System.out.print("New Pass: ");
			String new_Pass = scan.nextLine();
			tsg.setPassword(new_Pass);
		}else{
			System.out.println("Wrong old password");
		}	
	}
}
