package sessions;

import java.io.IOException;
import java.util.logging.Logger;

import project.DataBase;
import project.Order;
import users.TechSupportGuy;
import utils.Printer;

public class TechSupportSession {
	static DataBase db = DataBase.getInstance();
	public static void start(TechSupportGuy techSupport){
		Printer.print("Hello "+ techSupport.getName() +" "+techSupport.getSurname()
							+"! \nYou entered as a Tech Support worker");
		String request = null;
		while(request!="5") {
			String[] a = {"1.View new orders","2.View accepted orders","3.Change password","4.View news","5.Exit"};
			Printer.print(a);
			request = Printer.input("Print num to get access: ");;
			if(request.equals("1")) {
				Printer.writeLog(techSupport, a[0].substring(0));
				viewNewOrders(techSupport);
			}else if(request.equals("2")) {
				Printer.writeLog(techSupport, a[1].substring(0));
				techSupport.viewAcceptedList();
			}else if(request.equals("3")) {
				Printer.writeLog(techSupport, a[2].substring(0));
				AdminSession.changePass(techSupport);
			}else if(request.equals("4")) {
				Printer.writeLog(techSupport, a[3].substring(0));
				try {
					techSupport.viewNewsTab();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(request.equals("5")) {
				Printer.writeLogPrimitive(techSupport, "Leave the intranet");
				Printer.print("Good byeee!");
				return;
			}
			db.save();
		}
	}
	
	public static void viewNewOrders(TechSupportGuy tsg) {
		if (tsg.getWaitingList().size()!=0) {
			Printer.print(tsg.getWaitingList().element().toString());
			String a[] = {"1.Accept","2.Reject","3.Back"};
			Printer.print(a);
			String request = Printer.input("What you want to do: ");
			if (request.equals("1")) {
				tsg.operateOrder();
			} else if (request.equals("2")) {
				tsg.rejectOrder();
			} else if (request.equals("3")) {
				return;
			}
		}
		else {
			Printer.print("No new orders!");
		}
		
	}
}

