package Sessions;

import java.util.Scanner;

import Users.Admin;
import project.DataBase;

public class AdminSession {
	static Scanner scan = new Scanner(System.in);
	static DataBase db = DataBase.getInstance();
	public static void start(Admin admin) {
		System.out.println("You entered as Admin");
		String request = null;
		while(request!="4") {
			System.out.println("1.Manage Users");
			System.out.println("2.See log files");
			System.out.println("3.Change Password");
			System.out.println("4.exit");
			System.out.println("Print num to get access");
			request = scan.nextLine();
			if(request.equals("1")) {
				manageUsers(admin);
			}else if(request.equals("2")) {
				
			}else if(request.equals("3")) {
				
			}else if(request.equals("4")) {
				System.out.println("Good byeee!");
			}
			db.save();
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
				db.save();
			}else if(manageRequest.equals("2")) {
				removeUser(admin);
			}else if(manageRequest.equals("3")) {
				return;
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
				addStudent(admin);
				return;
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
		}
		db.save();
	}

	private static void removeUser(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	private static void changePass(Admin admin) {
		System.out.println("Old Pass: ");
		String old_pass = scan.nextLine();
		if(old_pass.equals(admin.getPassword())) {
			System.out.println("New Pass: ");
			String new_Pass = scan.nextLine();
			admin.setPassword(new_Pass);
		}else {
			System.out.println("Wrong old password");
		}	
	}
	
	private static void addEmployee(Admin admin, String userType) {
		System.out.println("Mail: ");
		String mail = scan.nextLine();
		System.out.println("Name: ");
		String name = scan.nextLine();
		System.out.println("Surname: ");
		String surname = scan.nextLine();
		System.out.println("Phone Number: ");
		String phoneNum = scan.nextLine();
		System.out.println("Salary: ");
		int salary = scan.nextInt();
		
		admin.addUser(mail, name, surname, phoneNum, salary, userType);
		addUser(admin);
	}
		

	private static void addStudent(Admin admin) {
		System.out.println("Mail: ");
		String mail = scan.nextLine();
		System.out.println("Name: ");
		String name = scan.nextLine();
		System.out.println("Surname: ");
		String surname = scan.nextLine();
		System.out.println("Phone Number: ");
		String phoneNum = scan.nextLine();
		System.out.println("Year of education: ");
		int year = scan.nextInt();
		
		admin.addUser(mail, name, surname, phoneNum, year, "Student");
		addUser(admin);
	}
}
