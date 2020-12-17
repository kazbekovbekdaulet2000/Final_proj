package Sessions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import Users.Admin;
import Users.User;
import enums.Teacher_pos;
import project.DataBase;

public class AdminSession {
	static Scanner scan = new Scanner(System.in);
	static DataBase db = DataBase.getInstance();
	public static void start(Admin admin) {
		System.out.println("You entered as Admin");
		String request = null;
		while(request!="5") {
			System.out.println("1.Manage Users");
			System.out.println("2.See log files");
			System.out.println("3.Change Password");
			System.out.println("4.View all accounts with class");
			System.out.println("5.exit");
			System.out.println("Print num to get access");
			request = scan.nextLine();
			if(request.equals("1")) {
				manageUsers(admin);
			}else if(request.equals("2")) {
				//TODO
			}else if(request.equals("3")) {
				changePass(admin);
			}else if(request.equals("4")) {
				readLoginBase();
			}else if(request.equals("5")) {
				System.out.println("Good byeee!");
				return;
			}
			updateLoginBase();
			db.save();
		}
	}
	
	private static void readLoginBase() {
		try {
			 File myObj = new File("loginBase.txt");
		     while (scan.hasNextLine()) {
		        String data = scan.nextLine();
		        System.out.println(data);
		     }
		     scan.close();
		}catch (Exception e) {
		      System.out.println("File Not Found");
		      e.printStackTrace();
		}
	}

	private static void updateLoginBase() {
		try {
			FileWriter myWriter = new FileWriter("loginBase.txt");
			for(int i=0; i<db.users.size(); ++i) {
				String mails = "Mail: "+db.users.elementAt(i).getMail()+" "
						+ " Password: "+db.users.elementAt(i).getPassword()+ " " 
						+ " User type: "+db.users.elementAt(i).getClass().getSimpleName()+"\n";
				myWriter.write(mails);
			}
		    myWriter.close();
		    System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
		    System.out.println("An error occurred.");
		    e.printStackTrace();
		}
	}

	private static void manageUsers(Admin admin) {
		String manageRequest = null;
		while(manageRequest!="4") {
			System.out.println("1.Add User");
			System.out.println("2.Remove User");
			System.out.println("3.Update info about User");
			System.out.println("4.Back");
			System.out.println("Print num to get access");
			
			manageRequest = scan.nextLine();
			if(manageRequest.equals("1")) {
				addUser(admin);
			}else if(manageRequest.equals("2")) {
				removeUser(admin);
			}else if(manageRequest.equals("3")) {
				//TODO
			}else if(manageRequest.equals("4")) {
				break;
			}
			
		}
		db.save();
	}

	private static void addUser(Admin admin) {
		String creator= null;
		while(creator!="6") {
			System.out.println("1.Add Student");
			System.out.println("2.Add Teacher");
			System.out.println("3.Add Tech Support");
			System.out.println("4.Add Manager");
			System.out.println("5.Add Admin");
			System.out.println("6.Back");
			System.out.println("Print num to get access");
			
			creator = scan.nextLine();
			if(creator.equals("1")) {
				addEmployee(admin, "Student");
			}else if(creator.equals("2")) {
				addEmployee(admin, "Teacher");
			}else if(creator.equals("3")) {
				addEmployee(admin, "Tech Support");
			}else if(creator.equals("4")) {
				addEmployee(admin, "Manager");
			}else if(creator.equals("5")) {
				addEmployee(admin, "Admin");
			}else if(creator.equals("6")) {
				break;
			}
			updateLoginBase();
			db.save();
		}
	}

	private static void removeUser(Admin admin) {
		System.out.print("Want to see all logins?(Y/N)");
		String ans = scan.nextLine();
		if(ans.equals("Y")) {
			for(int i=0; i<db.users.size(); ++i) {
				System.out.println("Mail: "+db.users.elementAt(i).getMail()+" "
//						+ " Password: "+db.users.elementAtadm(i).getPassword()+ " " 
						+ " User type: "+db.users.elementAt(i).getClass().getSimpleName());
			}
		}
		System.out.print("User mail: ");
		String mail = scan.nextLine();
		User user = db.findUser(mail);
		admin.deleteUser(user);
	}
	
	private static void changePass(Admin admin) {
		System.out.print("Old Pass: ");
		String old_pass = scan.nextLine();
		if(old_pass.equals(admin.getPassword())) {
			System.out.print("New Pass: ");
			String new_Pass = scan.next();
			admin.setPassword(new_Pass);
		}else{
			System.out.println("Wrong old password");
		}	
	}
	
	private static void addEmployee(Admin admin, String userType) {
		System.out.print("Mail: ");
		String mail = scan.nextLine();
		System.out.print("Name: ");
		String name = scan.nextLine();
		System.out.print("Surname: ");
		String surname = scan.nextLine();
		System.out.print("Phone Number: ");
		String phoneNum = scan.nextLine();
		if(userType == "Student") {
			System.out.println("Year of education: ");
			int year = Integer.parseInt(scan.nextLine());
			admin.addUser(mail, name, surname, phoneNum, year, "Student");
		}else {
			System.out.println("Salary: ");
			int salary = Integer.parseInt(scan.nextLine());
			if(userType == "Teacher") {
				System.out.println("Teacher position: ");
				Teacher_pos pos = Teacher_pos.fromString(scan.nextLine());
				admin.addUser(mail, name, surname, phoneNum, salary, pos, userType);
			}else {
				admin.addUser(mail, name, surname, phoneNum, salary, userType);	
			}
		}
		System.out.println(userType + " " + name + " " + surname + " was added");
		
	}
}
