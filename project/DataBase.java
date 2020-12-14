package project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import Users.User;
import utils.Serializer;


public class DataBase {
    private static DataBase instance;
    public static Vector<Course> courses = new Vector<Course>();
    public static Vector<User> users = new Vector<User>();
    public static Vector<Course_File> files  = new Vector<Course_File>();
    public static Vector<Mark> marks = new Vector<Mark>();
    public static Vector<Order> orders = new Vector<Order>();
    public static Vector<News> news = new Vector<News>();
   
    public static DataBase getInstance() {
    	if(instance == null)
    		instance = new DataBase();
    	return instance; 
    }
	
	public String toString() {
		return " " + courses;
		//TODO
	}
	

    //                          Operations         
   public void load() {
	   this.users = load("Users.out", User.class);
	   this.courses = load("Courses.out", Course.class);
   }
   
   public boolean save() {
	   return save("Users.out",users) && save("Courses.out",courses);
   }
   
   private boolean save(String fileName, Object obj) {
	   return Serializer.serialize(fileName, obj);
   }
   
   private <T> Vector<T> load(String fileName, Class<T> usr){
	   Vector<T> vec = Serializer.deserializeVector(fileName, usr);
	   if(vec!=null) {
		   return vec;
	   }
	   return null;
   }
   
   public User findUser(String mail) {          
	   for(int i=0;i<users.size();++i) {
		   if(users.elementAt(i).getMail().equals(mail)) {
			   return users.elementAt(i);
		   }
	   }
	   return null;
	}

    
}
