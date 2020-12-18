package project;

import java.util.Scanner;
import java.util.Vector;

import sessions.AdminSession;
import sessions.ManagerSession;
import sessions.StudentSession;
import sessions.TeacherSession;
import sessions.TechSupportSession;
import users.Admin;
import users.Manager;
import users.Student;
import users.Teacher;
import users.TechSupportGuy;
import users.User;

public class Auth {
    private static Auth instance;
    DataBase db = DataBase.getInstance();
    public static Auth getInstance() {
    	if(instance == null)
    		instance = new Auth();
    	return instance; 
    }
	
    public void authorize() {
    	db.load(); //deserializatioan
		System.out.println("Users account count: " + db.users.size());
		Scanner scan = new Scanner(System.in);
//		Admin admin = new Admin("admin","admin","admin","admin",200000);
//		db.users.add(admin);
//		System.out.println(admin.getPassword());
		for(int i=0;i<3;++i) {
			System.out.println("You have "+ (3-i)+" tries");
			String mail = scan.nextLine();
			String password = scan.nextLine();             
			User user = db.findUser(mail);
			if(user!=null) {
		        if(encode(password) == user.hashCode()) {
		        	if(user instanceof Admin) {
			        	AdminSession.start((Admin)user);	
		        	}else if(user instanceof Student) {
		        		StudentSession.start((Student)user);
		        	}else if(user instanceof Manager) {
		        		ManagerSession.start((Manager)user);
		        	}else if(user instanceof Teacher) {
		        		TeacherSession.start((Teacher)user);
		        	}else if(user instanceof TechSupportGuy) {
		        		TechSupportSession.start((TechSupportGuy)user);
		        	}
		        	break;
		        }else{
		        	System.out.println("Wrong Password");
		        	if(i == 2){
						System.out.println("You haven't no more tries to enter the intranet");
					}
		        }
			}else {
				System.out.println("Wrong Mail");
				if(i == 2) {
					System.out.println("You haven't no more tries to enter the intranet");
				}
			}
		}
    }
    
    public static int encode(String pass) {
		int res = 17;
		res+=res*31 + 17*pass.hashCode();
		return res;
	}
	
}
