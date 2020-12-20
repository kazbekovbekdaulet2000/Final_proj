package users;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import enums.Faculty;
import enums.Teacher_pos;
import project.DataBase;
import utils.Printer;

public class Admin extends Employee implements Serializable {
    public Admin() {}
    public Admin(String mail,String firstname,String lastname,String phoneNum,int salary) {
    	super(mail,firstname,lastname,phoneNum, salary);
    }
    
    public void addUser(String mail,String firstname,String lastname,String phoneNum, int salary, String userType){
    	if(userType=="Manager") {
    		Manager manager = new Manager(mail, firstname, lastname, phoneNum, salary);
    		if(!DataBase.users.contains(manager)) {
    			DataBase.users.add(manager);
    		}else {
    			Printer.print(manager.getName()+" "+manager.getSurname() + " already exist in the database" );
    		}
    	}else if(userType == "Tech Support") {
    		TechSupportGuy tsg = new TechSupportGuy(mail, firstname, lastname, phoneNum, salary);
    		if(!DataBase.users.contains(tsg)) {
    			DataBase.users.add(tsg);
    		}else {
    			Printer.print(tsg.getName() +" "+tsg.getSurname()+ " already exist in the database");
    		}
    	}else if(userType == "Admin") {
    		Admin admin = new Admin(mail, firstname, lastname, phoneNum, salary);
    		if(!DataBase.users.contains(admin)) {
    			DataBase.users.add(admin);
    		}else {
    			Printer.print(admin.getName() + " " + admin.getSurname() + " already exist in the database");
    		}
    		DataBase.users.add(new Admin(mail, firstname, lastname, phoneNum, salary));
    	}else {
    		Printer.print("Wrong User Type");
    	}
    	
    }
    
    public void addUser(String mail,String firstname,String lastname,String phoneNum, int year, Faculty faculty, String userType){
    	if(userType == "Student"){ 
    		Student st = new Student(mail, firstname, lastname, phoneNum, year, faculty);
    		if(!DataBase.users.contains(st)) {
    			DataBase.users.add(st);
    		}else {
    			Printer.print(st.getName()+" "+st.getSurname() + " already exist in the database" );
    		}	
    	}else {
    		Printer.print("Wrong User Type");
    	}
    }
    
    
    public void addUser(String mail,String firstname,String lastname,String phoneNum, int salary, Teacher_pos pos, String userType){
    	if(userType=="Teacher") {             
    		Teacher teacher = new Teacher(mail, firstname, lastname, phoneNum, salary, pos);
    		if(!DataBase.users.contains(teacher)) {
    			DataBase.users.add(teacher);
    		}else {
    			Printer.print(teacher.getName() + " " + teacher.getSurname() + " already exist in the database");
    		}
    	}else{
    		Printer.print("Wrong User Type");
    	}
    }
    
    public void deleteUser(User u) {
        if(DataBase.users.contains(u)) {
        	DataBase.users.remove(DataBase.users.indexOf(u));
        	Printer.print(u.getName() + " " + u.getSurname() + " have been deleted");
        }else {
        	Printer.print("User not found");
        }
    }
    
    public void viewMails() {
    	for(int i=0; i<DataBase.users.size(); ++i) {
			Printer.print("Mail: "+DataBase.users.elementAt(i).getMail()
					+" Name: "+DataBase.users.elementAt(i).getName()
					+" Surname: "+DataBase.users.elementAt(i).getSurname()
					+ " User type: "+DataBase.users.elementAt(i).getClass().getSimpleName());
		}
    }
    
    public void updateUserInfo(User u) {
        //TODO
    }
    
    public void viewLogFilles() {
    	DataBase.viewLogFiles();
    }
    
    public String toString() {
        return super.toString() + "\nPosition: Admin";
    }
    
    public int hashCode() {
    	return super.hashCode(); 
    }
    
    public boolean equals(Object o) {
    	if(o == null) return false;
    	if(o.getClass()!=getClass()) return false;
    	Admin a = (Admin)o;
    	return super.equals(a);
    }
    
    
    public void viewNewsTab() throws IOException {
    	super.viewNewsTab();
    }
    
}
