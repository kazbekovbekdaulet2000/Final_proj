package users;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

import project.Auth;
import project.DataBase;
import utils.Printer;

public abstract class User implements Serializable, Comparable<Object>, Cloneable {
    private String name;
    private String surname;
    private String phoneNum;
    private String mail;
    private String password;
    
    {
    	password = generatePass();                 //automatic generation of Password
    }
    
    public User() {
	}
    
	public User(String mail,String firstname,String lastname,String phoneNum){ 
		this.mail=mail;
		this.name=firstname;
		this.surname=lastname;
		this.phoneNum=phoneNum;
	};

	private String generatePass() {
    	String vocabulary = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for(int i = 0; i < 8; i++) {
        	int index = random.nextInt(vocabulary.length());
        	char randomChar = vocabulary.charAt(index);
        	password.append(randomChar);
        }
        
        return password.toString();
	}

	public String getName() {
        return this.name;
    }
    
    public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    @Override
	public String toString() {
		return "Name: " + name + ", Surname: " + surname + "\nPhone Number: " + phoneNum + "\nMail: "
				+ mail + " ";
	}

	public Object clone() {
		return this.clone();
    }
    
    public int hashCode() {
    	int res = 17;
        res+=res*31+17*password.hashCode();
        return res;
    }
    
    public boolean equals(Object obj) {
    	  if (obj==null) return false;
          if (getClass()!=obj.getClass()) return false;
          User u = (User) obj;
          return  u.getName().equals(getName()) && u.getSurname().equals(getSurname()) 
        		  && u.getMail().equals(getMail()) && u.getPhoneNum().equals(getPhoneNum());
    }
    
    public void viewNewsTab() throws IOException {
    	for(int i=0; i<DataBase.news.size(); ++i) {
    		Printer.print(DataBase.news.get(i).toString());
    	}
    }

	@Override
	public int compareTo(Object o) {
		return getName().compareTo(((User)o).getName());
	}
    
}
