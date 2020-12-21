package project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import course.Course;
import course.Course_File;
import course.Mark;
import users.User;
import utils.Printer;
import utils.Serializer;


public class DataBase {
    private static DataBase instance;
    public static Vector<Course> courses = new Vector<Course>();
    public static Vector<User> users = new Vector<User>();
    public static Vector<News> news = new Vector<News>();
   
    public static DataBase getInstance() {
    	if(instance == null)
    		instance = new DataBase();
    	return instance; 
    }
	
    //                          Operations         
   public void load() {
	   this.users = load("Users.out", User.class);
	   this.courses = load("Courses.out", Course.class);
	   this.news = load("News.out",News.class);
   }
   
   public boolean save() {
	   return save("Users.out",users) && save("Courses.out",courses) && save("News.out", news);
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
	   User user = null;
	   for(int i=0;i<users.size();++i) {
		   if(users.elementAt(i).getMail().equals(mail)) {
			   if(user == null) {
				   user = users.elementAt(i);
			   }else {
				   return null;
			   }
		   }
	   }
	   return user;
	}
   
   public static void readLog(){
	   try {
			BufferedReader log = new BufferedReader(new FileReader("log.txt"));
			String line = log.readLine();
			while(line!=null) {
				System.out.println(line);
				line = log.readLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
   }

    
}
