package sessions;

import java.util.Scanner;

import project.DataBase;
import users.Admin;
import users.Teacher;
import users.TechSupportGuy;
import utils.Printer;

public class TechSupportSession {
	static Scanner scan = new Scanner(System.in);
	static DataBase db = DataBase.getInstance();
	public static void start(TechSupportGuy techSupport){
		Printer.print("Hello "+ techSupport.getName() +" "+techSupport.getSurname()
							+"! \nYou entered as a Tech Support worker");
		String request = null;
		while(request!="4") {
			Printer.print("1.View new orders");
			Printer.print("2.View accepted orders");
			Printer.print("3.Change password");
			Printer.print("4.exit");
			Printer.print("Print num to get access");
			request = scan.nextLine();
			if(request.equals("1")) {
				//TODO
			}else if(request.equals("2")) {
				//TODO
			}else if(request.equals("3")) {
				changePass(techSupport);
			}else if(request.equals("4")) {
				Printer.print("Good byeee!");
				return;
			}
			db.save();
		}
	}
	
	private static void changePass(TechSupportGuy user) {
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
