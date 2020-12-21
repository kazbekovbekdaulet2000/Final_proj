package sessions;

import java.util.logging.Logger;

import project.DataBase;
import users.TechSupportGuy;
import utils.Printer;

public class TechSupportSession {
	static DataBase db = DataBase.getInstance();
    public final static Logger log = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
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
				//TODO
			}else if(request.equals("2")) {
				Printer.writeLog(techSupport, a[1].substring(0));
				techSupport.viewAcceptedList();
			}else if(request.equals("3")) {
				Printer.writeLog(techSupport, a[2].substring(0));
				AdminSession.changePass(techSupport);
			}else if(request.equals("4")) {
				Printer.writeLog(techSupport, a[3].substring(0));
				Printer.print("News Todo");
			}else if(request.equals("5")) {
				Printer.writeLogPrimitive(techSupport, "Leave the intranet");
				Printer.print("Good byeee!");
				return;
			}
			db.save();
		}
	}
}
