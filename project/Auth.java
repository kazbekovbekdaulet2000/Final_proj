package project;

import java.util.Scanner;
import java.util.Vector;

import Sessions.AdminSession;
import Sessions.StudentSession;
import Users.Admin;
import Users.Manager;
import Users.Student;
import Users.Teacher;
import Users.TechSupportGuy;
import Users.User;

public class Auth {
    private static Auth instance;
   
    public static Auth getInstance() {
    	if(instance == null)
    		instance = new Auth();
    	return instance; 
    }
	
    public void authorize() {
        DataBase db = DataBase.getInstance();
    	db.load();
    	Scanner scan = new Scanner(System.in);
    	for(int i=0;i<3;++i) {
			String mail = scan.nextLine();
			String password = scan.nextLine();
			User user = db.findUser(mail);
			if(user!=null) {
		        if(decoder(password) == user.hashCode()) {
		        	System.out.println("Done");
		        	break;
		        }else{
		        	System.out.println("failed");	
		        }
			}	
    	}
    }
    
    public static int decoder(String pass) {
		int res = 17;
		res+=res*31 + 17*pass.hashCode();
		return res;
	}
	
}
