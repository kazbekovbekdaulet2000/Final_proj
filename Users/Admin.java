package Users;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import project.DataBase;

public class Admin extends Employee {
	
    public Admin() {}
    public Admin(String mail,String firstname,String lastname,String phoneNum,int salary) {
    	super(mail,firstname,lastname,phoneNum, salary);
    }
    public void addUser(User u) {
        
    }
    public void deleteUser(User u) {
        //TODO
    }
    
    public void updateUserInfo(User u) {
        //TODO
    }
    
    public void viewLogFilles() {
        //TODO
    }
    
    public String toString() {
        return " ";
    }
    
    public int hashCode() {
    	return 0; 
        //TODO
    }
    
    public boolean equals(Object a) {
    	return false;
        //TODO
    }
    
    
    public void viewNewsTab() throws IOException {
    	FileReader fr = new FileReader("news.txt");
		BufferedReader br = new BufferedReader(fr);
		String str = br.readLine();
		
		while(str != null) {
			str = br.readLine();
			System.out.println(str);
		}
		br.close();
    }
    
}
