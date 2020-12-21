package sessions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import enums.Faculty;
import enums.Teacher_pos;
import project.DataBase;
import users.Admin;
import users.Employee;
import users.Student;
import users.Teacher;
import users.User;
import utils.Printer;

public class AdminSession {
	static DataBase db = DataBase.getInstance();
	public static void start(Admin admin) {
		Printer.print("You entered as Admin");
		String request = null;
		while(request!="6") {
			String[] a = {"1.Manage Users","2.See log files","3.Change Password","4.View accounts"
					,"5.View news","6.Exit"};
			Printer.print(a);
			request = Printer.input("Print num to get access: ");
			if(request.equals("1")) {
				Printer.writeLog(admin, a[0].substring(2));
				manageUsers(admin);
			}else if(request.equals("2")) {
				Printer.writeLog(admin, a[1].substring(5));
				db.readLog();
			}else if(request.equals("3")) {
				Printer.writeLog(admin, a[2].substring(2));
				changePass(admin);
			}else if(request.equals("4")) {
				Printer.writeLog(admin, a[3].substring(2));
				updateLoginBase();
				readLoginBase();
			}else if(request.equals("5")) {
				Printer.writeLog(admin, a[4].substring(2));
				try {
					admin.viewNewsTab();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else if(request.equals("6")) {
				Printer.writeLogPrimitive(admin, "Leave the intranet");
				Printer.print("Good byeee!");
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
					Printer.print(str);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected static void updateLoginBase() {
		try {
			FileWriter myWriter = new FileWriter("loginBase.txt");
			for(int i=0; i<DataBase.users.size(); ++i) {
				String mails = "Mail: "+DataBase.users.elementAt(i).getMail()+" "
						+ " Password: "+DataBase.users.elementAt(i).getPassword()+ " " 
						+ " User type: "+DataBase.users.elementAt(i).getClass().getSimpleName()+"\n";
				myWriter.write(mails);
			}
		    myWriter.close();
		} catch (IOException e) {
		    Printer.print("An error occurred.");
		    e.printStackTrace();
		}
	}

	private static void manageUsers(Admin admin) {
		String manageRequest = null;
		while(manageRequest!="4") {
			String[] a = {"1.Add User","2.Remove User","3.Update info about User","4.Back"};
			Printer.print(a);
			manageRequest = Printer.input("Print num to get access: ");
			if(manageRequest.equals("1")) {
				Printer.writeLog(admin, a[0].substring(2));
				addUser(admin);
			}else if(manageRequest.equals("2")) {
				Printer.writeLog(admin, a[1].substring(2));
				removeUser(admin);
			}else if(manageRequest.equals("3")) {
				Printer.writeLog(admin, a[2].substring(2));
				updateUser(admin);
			}else if(manageRequest.equals("4")) {
				Printer.writeLog(admin, "Main screen");
				break;
			}
			
		}
		db.save();
	}

	private static void addUser(Admin admin) {
		String creator= null;
		while(creator!="6") {
			String[] a = {"1.Add Student","2.Add Teacher","3.Add Tech Support","4.Add Manager","5.Add Admin","6.Back"};
			Printer.print(a);
			creator = Printer.input("Print num to get access: ");
			
			if(creator.equals("1")) {
				Printer.writeLog(admin, a[0].substring(2));
				addUserType(admin, "Student");
			}else if(creator.equals("2")) {
				Printer.writeLog(admin, a[1].substring(2));
				addUserType(admin, "Teacher");
			}else if(creator.equals("3")) {
				Printer.writeLog(admin, a[2].substring(2));
				addUserType(admin, "Tech Support");
			}else if(creator.equals("4")) {
				Printer.writeLog(admin, a[3].substring(2));
				addUserType(admin, "Manager");
			}else if(creator.equals("5")) {
				Printer.writeLog(admin, a[4].substring(2));
				addUserType(admin, "Admin");
			}else if(creator.equals("6")) {
				Printer.writeLog(admin, "Manage User screen");
				break;
			}
			updateLoginBase();
		}
	}

	private static void removeUser(Admin admin) {
		String ans = Printer.input("Want to see all logins(Y/N): ");
		if(ans.equals("Y")) {
			admin.viewMails();
		}
		
		String mail = Printer.input("User mail");	
		try{
			User user = db.findUser(mail);
			if(user!=null) {
				admin.deleteUser(user);
			}
			Printer.writeLogPrimitive(admin,"deleted user: "+user.getName()+ " "+user.getSurname());
		}catch(NullPointerException np) {
			Printer.print("Finded dublicates of mails");
			Printer.writeLogWarning(admin,"finded dublicates of mails");
		}
		db.save();
	}
	
	private static void updateUser(Admin admin) {
		String updateRequest = null;
		while (updateRequest!="2") {
			String a[] = {"1.Change user info", "2.Back"};
			Printer.print(a);
			updateRequest = Printer.input("Print num to get access: ");
			if (updateRequest.equals("1")) {
				Printer.writeLog(admin, a[0].substring(2));
				showUsers();
				String id = Printer.input("Print id of user you want to change: ");
				int i = Integer.parseInt(id);
				for (User u : db.users) {
					if (i == db.users.indexOf(u)) {
						Printer.print("You want to change "+u.getName()+" "+u.getSurname()+" info");
						if (u instanceof Student) 
							updateStudent(admin,(Student)u);
						if (u instanceof Employee)
							updateEmployee(admin,(Employee)u);
					}
				}
			} else if(updateRequest.equals("2")) {
				Printer.writeLog(admin, "Manage users");
				break;
			}
		}
		db.save();
	}
	
	private static void showUsers() {
		for (int i=0;i<db.users.size();i++) {
			Printer.print(i+"  "+db.users.get(i).toString());
			Printer.print("_________________________________");
		}
	}
	
	private static void updateStudent(Admin admin, Student s) {
		String request = null;
		String a[] = {"1.Change name","2.Change surname","3.Change phone number","4.Change faculty","5.Change study year","6.Change mail","7.Back"};
		while (request!="7") {
			Printer.print(a);
			request = Printer.input("Print num to get access: ");
			if (request.equals("1")) {
				String n = Printer.input("Print new name: ");
				s.setName(n);
				Printer.writeLogPrimitive(admin, "Changed name of "+s.getMail());
				db.save();
			} else if (request.equals("2")) {
				String n = Printer.input("Print new surname: ");
				s.setSurname(n);
				Printer.writeLogPrimitive(admin, "Changed surname of "+s.getMail());
				db.save();
			} else if (request.equals("3")) {
				String n = Printer.input("Print new phone number: ");
				s.setPhoneNum(n);
				Printer.writeLogPrimitive(admin, "Changed phone number of "+s.getMail());
				db.save();
			} else if (request.equals("4")) {
				Faculty faculty = Faculty.fromString(Printer.input("Faculty: "));
				s.setFaculty(faculty);
				Printer.writeLogPrimitive(admin, "Changed faculty of "+s.getMail());
				db.save();
			} else if (request.equals("5")) {
				String n = Printer.input("Print new study year: ");
				int year = Integer.parseInt(n);
				s.setYear(year);
				Printer.writeLogPrimitive(admin, "Changed study year of "+s.getMail());
				db.save();
			} else if (request.equals("6")) {
				String n = Printer.input("Print new mail: ");
				s.setMail(n);
				Printer.writeLogPrimitive(admin, "Changed mail of "+s.getName()+" "+s.getSurname());
				db.save();
			} else if (request.equals("7")) {
				break;
			}
			updateLoginBase();
			
		}
	}
	
	private static void updateEmployee(Admin admin, Employee e) {
		String request = null;
		if (e instanceof Teacher) {
			String a[] = {"1.Change name","2.Change surname","3.Change phone number","4.Change salary","5.Change teacher position","6.Change mail","7.Back"};
			while (request!="7") {
				Printer.print(a);
				request = Printer.input("Print num to get access: ");
				if (request.equals("1")) {
					String n = Printer.input("Print new name: ");
					e.setName(n);
					Printer.writeLogPrimitive(admin, "Changed name of "+e.getMail());
					Printer.print("Successfully changed!");
					db.save();
				} else if (request.equals("2")) {
					String n = Printer.input("Print new surname: ");
					e.setSurname(n);
					Printer.writeLogPrimitive(admin, "Changed surname of "+e.getMail());
					Printer.print("Successfully changed!");
					db.save();
				} else if (request.equals("3")) {
					String n = Printer.input("Print new phone number: ");
					e.setPhoneNum(n);
					Printer.writeLogPrimitive(admin, "Changed phone number of "+e.getMail());
					Printer.print("Successfully changed!");
					db.save();
				} else if (request.equals("4")) {
					String n = Printer.input("Salary :");
					e.setSalary(Integer.parseInt(n));
					Printer.writeLogPrimitive(admin, "Changed salary of "+e.getMail());
					Printer.print("Successfully changed!");
					db.save();
				} else if (request.equals("5")) {
					Teacher_pos pos = Teacher_pos.fromString(Printer.input("Teacher position: "));
					((Teacher) e).setPos(pos);
					Printer.writeLogPrimitive(admin, "Changed teacher position of "+e.getMail());
					Printer.print("Successfully changed!");
					db.save();
				} else if (request.equals("6")) {
					String n = Printer.input("Print new mail: ");
					e.setMail(n);
					Printer.writeLogPrimitive(admin, "Changed mail of "+e.getName()+" "+e.getSurname());
					Printer.print("Successfully changed!");
					db.save();
				} else if (request.equals("7")) {
					break;
				}
				updateLoginBase();
			}
		} else {
			String a[] = {"1.Change name","2.Change surname","3.Change phone number","4.Change salary","5.Change mail"};
			while (request!="6") {
				Printer.print(a);
				request = Printer.input("Print num to get access: ");
				if (request.equals("1")) {
					String n = Printer.input("Print new name: ");
					e.setName(n);
					Printer.writeLogPrimitive(admin, "Changed name of "+e.getMail());
					Printer.print("Successfully changed!");
					db.save();
				} else if (request.equals("2")) {
					String n = Printer.input("Print new surname: ");
					e.setSurname(n);
					Printer.writeLogPrimitive(admin, "Changed surname of "+e.getMail());
					Printer.print("Successfully changed!");
					db.save();
				} else if (request.equals("3")) {
					String n = Printer.input("Print new phone number: ");
					e.setPhoneNum(n);
					Printer.writeLogPrimitive(admin, "Changed phone number of "+e.getMail());
					Printer.print("Successfully changed!");
					db.save();
				} else if (request.equals("4")) {
					String n = Printer.input("Salary :");
					e.setSalary(Integer.parseInt(n));
					Printer.writeLogPrimitive(admin, "Changed salary of "+e.getMail());
					Printer.print("Successfully changed!");
					db.save();
				} else if (request.equals("6")) {
					String n = Printer.input("Print new mail: ");
					e.setMail(n);
					Printer.writeLogPrimitive(admin, "Changed mail of "+e.getName()+" "+e.getSurname());
					Printer.print("Successfully changed!");
					db.save();
				} else if (request.equals("6")) {
					break;
				}
				updateLoginBase();
			}
		}
	}
	
	
	protected static void changePass(User user) {
		String old_pass = Printer.input("Old Password: ");
		if(old_pass.equals(user.getPassword())) {
			String new_Pass = Printer.input("New Password: ");
			user.setPassword(new_Pass);
			if(new_Pass.equals(user.getPassword())) {
				Printer.print("Password is changed: ");	
				Printer.writeLogPrimitive(user,"changed password");
				db.save();
			}
		}else{
			Printer.print("Wrong old password");
		}	
	}
	
	private static void addUserType(Admin admin, String userType) {
		String mail = Printer.input("Mail: ");
		for(int i=0;i<DataBase.users.size();++i) {
    		if(mail.equals(DataBase.users.get(i).getMail())){
    			Printer.print("-----------a mail dublication!-----------");
    			return;
    		}
    	}
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
		db.save();
		Printer.writeLogPrimitive(admin,"add " + userType + " " + name + " " + surname + " was added");
		
	}
}
