package sessions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import enums.Faculty;
import enums.Teacher_pos;
import project.DataBase;
import users.Admin;
import users.User;
import utils.Printer;

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
				System.out.println("NO DATA");
				//TODO
			}else if(request.equals("3")) {
				changePass(admin);
			}else if(request.equals("4")) {
				updateLoginBase();
				readLoginBase();
			}else if(request.equals("5")) {
				System.out.println("Good byeee!");
				return;
			}
			db.save();
		}
	}
	
	private static void readLoginBase() {
		try {
			FileReader fr = new FileReader("LoginBase.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			
			while(str != null) {
				str = br.readLine();
				if(str!=null) {
					System.out.println(str);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
				addUserType(admin, "Student");
			}else if(creator.equals("2")) {
				addUserType(admin, "Teacher");
			}else if(creator.equals("3")) {
				addUserType(admin, "Tech Support");
			}else if(creator.equals("4")) {
				addUserType(admin, "Manager");
			}else if(creator.equals("5")) {
				addUserType(admin, "Admin");
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
			admin.viewMails();
		}
		System.out.print("User mail: ");
		String mail = scan.nextLine();
		User user = db.findUser(mail);
		admin.deleteUser(user);
	}
	
	private static void changePass(Admin user) {
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
	}
	
	private static void addUserType(Admin admin, String userType) {
		String mail = Printer.input("Mail: ");
		String name = Printer.input("Name: ");
		String surname = Printer.input("Surname: ");
		String phoneNum = Printer.input("Phone Number: ");
		if(userType == "Student") {
			int year = Integer.parseInt(Printer.input("Year of education: "));
			Faculty faculty = Faculty.fromString(Printer.input("Faculty: "));
			admin.addUser(mail, name, surname, phoneNum, year, faculty, userType);
		}else {
			int salary = Integer.parseInt(Printer.input("Salary: "));
			if(userType == "Teacher") {
				Teacher_pos pos = Teacher_pos.fromString(Printer.input("Teacher position: "));
				admin.addUser(mail, name, surname, phoneNum, salary, pos, userType);
			}else {
				admin.addUser(mail, name, surname, phoneNum, salary, userType);	
			}
		}
		Printer.print(userType + " " + name + " " + surname + " was added");
		
	}
}
