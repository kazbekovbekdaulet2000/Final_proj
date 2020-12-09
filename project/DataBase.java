package project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import Users.User;


public class DataBase {
    private static DataBase instance;
    private Vector<Course> courses;
    private Vector<User> users;
    private Vector<Course_File> files;
    private Vector<Mark> marks;
    private Vector<Order> orders;
    private Vector<News> news;
    
    private DataBase(){}
    
    DataBase(Vector<Course> courses, Vector<User> users, Vector<Course_File> files, Vector<Mark> marks, Vector<Order> orders, Vector<News> news){
    	this.courses = courses;
    	this.users = users;
    	this.files = files;
    	this.marks = marks;
    	this.news = news;
    	this.orders = orders;
    }
   
    public static DataBase getInstance() {
    	if(instance == null)
    		instance = new DataBase();
    	return instance; 
    }
                            
    public Vector<Course> getCourses() {
		return courses;
	}
	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}
	public Vector<User> getUsers() {
		return users;
	}
	public void setUsers(Vector<User> users) {
		this.users = users;
	}
	public Vector<Course_File> getFiles() {
		return files;
	}
	public void setFiles(Vector<Course_File> files) {
		this.files = files;
	}
	public Vector<Mark> getMarks() {
		return marks;
	}
	public void setMarks(Vector<Mark> marks) {
		this.marks = marks;
	}
	public Vector<Order> getOrders() {
		return orders;
	}
	public void setOrders(Vector<Order> orders) {
		this.orders = orders;
	}
	public Vector<News> getNews() {
		return news;
	}
	public void setNews(Vector<News> news) {
		this.news = news;
	}
	
	
	public String toString() {
		return " " + courses;
		//TODO
	}
	

    //                          Operations         
    public void serializeAll() {
        //TODO
    }
    
    public void deserializeAll() {
        //TODO
    }
    
    public void readDataBase(Course c) {
    	try {
    		FileReader fr = new FileReader("allData.txt");
			BufferedReader br = new BufferedReader(fr);
			String str = br.readLine();
			
			while(str != null) {
				str = br.readLine();
				System.out.println(str);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("No such file founded");
		}
    }

	
    
    
    
}
