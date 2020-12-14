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

public class test {

	public static void main(String[] args) {   
		DataBase db = DataBase.getInstance();
		Auth auth = Auth.getInstance();
		db.load();
		System.out.println("Users account count: " + db.users.size());
		Scanner scan = new Scanner(System.in);
		String mail = scan.nextLine();                 //mail: qwerty
		String password = scan.nextLine();             //password: WcHKRnEw
		User user = db.findUser(mail);
		if(user!=null) {
	        if(decoder(password) == user.hashCode()) {
	        	System.out.println("Done");
	        }else{
	        	System.out.println("Wrong Password");	
	        }
		}else {
			System.out.println("Wrong Mail");
		}
		db.save();
	}
	
	public static int decoder(String pass) {
		int res = 17;
		res+=res*31 + 17*pass.hashCode();
		return res;
	}

}
