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


public class DataBase {
    private static DataBase instance;
    public static Vector<Course> courses;
    public static Vector<User> users;
    public static Vector<Course_File> files;
    public static Vector<Mark> marks;
    public static Vector<Order> orders;
    public static Vector<News> news;
   
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
    public void serializeAll() {
        serializeUsers();
        serializeCourses();
        serializeFiles();
        serializeMarks();
        serializeOrders();
        serializeNews();
    }
    
    private void serializeNews() {
    	try {
            ObjectInputStream out = new ObjectInputStream(new FileInputStream("news.ser"));
            news = (Vector<News>) out.readObject();//    ???
            out.close();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("IO exception");
        }
	}

	private void serializeOrders() {
		try {
            ObjectInputStream out = new ObjectInputStream(new FileInputStream("orders.ser"));
            orders = (Vector<Order>) out.readObject();//    ???
            out.close();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("IO exception");
        }
	}

	private void serializeFiles() {
		try {
	        ObjectInputStream out = new ObjectInputStream(new FileInputStream("course_files.ser"));
	        files = (Vector<Course_File>) out.readObject();//    ???
	        out.close();
	    }
	    catch (ClassNotFoundException e) {
	        System.out.println("Class not found");
	    }
	    catch (FileNotFoundException e) {
	        System.out.println("File not found");
	    }
	    catch (IOException e) {
	        System.out.println("IO exception");
	    }
	}

	private void serializeMarks() {
		try {
            ObjectInputStream out = new ObjectInputStream(new FileInputStream("marks.ser"));
            marks = (Vector<Mark>) out.readObject();//    ???
            out.close();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("IO exception");
        }
	}

	private void serializeCourses() {
		try {
            ObjectInputStream out = new ObjectInputStream(new FileInputStream("courses.ser"));
            courses = (Vector<Course>) out.readObject();//    ???
            out.close();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("IO exception");
        }
	}

	private void serializeUsers() {
    	try {
            ObjectInputStream out = new ObjectInputStream(new FileInputStream("users.ser"));
            users = (Vector<User>) out.readObject();//    ???
            out.close();
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println("IO exception");
        }
	}

	public void deserializeAll() {
		deserializeUsers();
        deserializeCourses();
        deserializeFiles();
        deserializeMarks();
        deserializeOrders();
        deserializeNews();
    }
    
	private void deserializeUsers() {
		try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("users.ser"));
            out.writeObject(users);
            out.flush();
            out.close();
        }
        catch (FileNotFoundException e) {
        	System.out.println("Class not found");
        }
        catch (IOException e) {
        	System.out.println("IO Exception");
        }
	}
	
	private void deserializeCourses() {
		try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("courses.ser"));
            out.writeObject(courses);
            out.flush();
            out.close();
        }
        catch (FileNotFoundException e) {
        	System.out.println("Class not found");
        }
        catch (IOException e) {
        	System.out.println("IO Exception");
        }
	}
	
	private void deserializeFiles() {
		try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("course_files.ser"));
            out.writeObject(files);
            out.flush();
            out.close();
        }
        catch (FileNotFoundException e) {
        	System.out.println("Class not found");
        }
        catch (IOException e) {
        	System.out.println("IO Exception");
        }
	}
	
	private void deserializeMarks() {
		try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("marks.ser"));
            out.writeObject(marks);
            out.flush();
            out.close();
        }
        catch (FileNotFoundException e) {
        	System.out.println("Class not found");
        }
        catch (IOException e) {
        	System.out.println("IO Exception");
        }
	}
	
	private void deserializeOrders() {
		try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("orders.ser"));
            out.writeObject(orders);
            out.flush();
            out.close();
        }
        catch (FileNotFoundException e) {
        	System.out.println("Class not found");
        }
        catch (IOException e) {
        	System.out.println("IO Exception");
        }
		
	}
	
	private void deserializeNews() {
		try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("news.ser"));
            out.writeObject(news);
            out.flush();
            out.close();
        }
        catch (FileNotFoundException e) {
        	System.out.println("Class not found");
        }
        catch (IOException e) {
        	System.out.println("IO Exception");
        }
	}


    public void readDataBase(Course c) { //just an idea
//    	try {
//    		FileReader fr = new FileReader("allData.txt");
//			BufferedReader br = new BufferedReader(fr);
//			String str = br.readLine();
//			
//			while(str != null) {
//				str = br.readLine();
//				System.out.println(str);
//			}
//			br.close();
//		} catch (IOException e) {
//			System.out.println("No such file founded");
//		}
    }

    
}
