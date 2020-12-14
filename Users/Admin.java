package Users;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

import enums.Teacher_pos;
import project.DataBase;

public class Admin extends Employee implements Serializable {
    public Admin() {}
    public Admin(String mail,String firstname,String lastname,String phoneNum,int salary) {
    	super(mail,firstname,lastname,phoneNum, salary);
    }
    
    public void addUser(User u) {   // Need contains check!!!!!!!!!
    	if(u == null) {
    		System.out.println("No user added there are only null data");
    	}else if(u instanceof Student) {    DataBase.users.add((Student)u);
    	}else if(u instanceof Teacher) {	DataBase.users.add((Teacher)u);
    	}else if(u instanceof Manager) { 	DataBase.users.add((Manager)u);
    	}else if(u instanceof TechSupportGuy) {   DataBase.users.add((TechSupportGuy)u);
    	}else if(u instanceof Admin) {    		DataBase.users.add((Admin)u);
    	}else {
    		System.out.println("No user added");
    	}
    }
    
    public void addUser(String mail,String firstname,String lastname,String phoneNum, int salaryORyear, String userType){
    	if(userType=="Manager") {         //manager
    		Manager manager = new Manager(mail, firstname, lastname, phoneNum,salaryORyear);
    		if(!DataBase.users.contains(manager)) {
    			DataBase.users.add(manager);
    		}else {
    			System.out.println(manager.getName()+" "+manager.getSurname() + " already exist in the database" );
    		}
    	}else if(userType == "Tech Support") {    //TechSupp
    		TechSupportGuy tsg = new TechSupportGuy(mail, firstname, lastname, phoneNum,salaryORyear);
    		if(!DataBase.users.contains(tsg)) {
    			DataBase.users.add(tsg);
    		}else {
    			System.out.println(tsg.getName() +" "+tsg.getSurname()+ " already exist in the database");
    		}
    	}else if(userType == "Admin") {    //Admin
    		Admin admin = new Admin(mail, firstname, lastname, phoneNum,salaryORyear);
    		if(!DataBase.users.contains(admin)) {
    			DataBase.users.add(admin);
    		}else {
    			System.out.println(admin.getName() + " " + admin.getSurname() + " already exist in the database");
    		}
    		DataBase.users.add(new Admin(mail, firstname, lastname, phoneNum,salaryORyear));
    	}else if(userType == "Student"){      //Student
    		Student st = new Student(mail, firstname, lastname, phoneNum,salaryORyear);
    		if(!DataBase.users.contains(st)) {
    			DataBase.users.add(st);
    		}else {
    			System.out.println(st.getName()+" "+st.getSurname() + " already exist in the database" );
    		}	
    	}else {
    		System.out.println("No user added");
    	}
    }
    
    public void addUser(String mail,String firstname,String lastname,String phoneNum, int salary, Teacher_pos pos, String userType){
    	if(userType=="Teacher") {             
    		Teacher teacher = new Teacher(mail, firstname, lastname, phoneNum, salary, pos);
    		if(!DataBase.users.contains(teacher)) {
    			DataBase.users.add(teacher);
    		}else {
    			System.out.println(teacher.getName() + " " + teacher.getSurname() + " already exist in the database");
    		}
    	}else{
    		System.out.println("No user added");
    	}
    }
    
    public void deleteUser(User u) {
        if(DataBase.users.contains(u)) {
        	DataBase.users.remove(DataBase.users.indexOf(u));
        }else {
        	System.out.println("User not found");
        }
    }
    
    public void updateUserInfo(User u) {
        //TODO
    }
    
    public void viewLogFilles() {
        //TODO
    }
    
    public String toString() {
        return super.toString() + "\nPosition: Admin";
    }
    
    public int hashCode() {
    	return super.hashCode(); 
        //TODO
    }
    
    public boolean equals(Object o) {
    	if(o == null) return false;
    	if(o.getClass()!=getClass()) return false;
    	Admin a = (Admin)o;
    	return o.getClass() == getClass() && a.getName() == getName() && 
    			a.getSurname() == getSurname() && a.getMail() == getMail() && a.getPhoneNum() == getPhoneNum() &&
    			a.getSalary() == getSalary();
    }
    
    
    public void viewNewsTab() throws IOException {
//    	FileReader fr = new FileReader("news.txt");
//		BufferedReader br = new BufferedReader(fr);
//		String str = br.readLine();
//		
//		while(str != null) {
//			str = br.readLine();
//			System.out.println(str);
//		}
//		br.close();
    	
    	super.viewNewsTab();
    }
    
}
