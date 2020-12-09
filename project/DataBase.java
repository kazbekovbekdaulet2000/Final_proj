package project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
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
    	//TODO
	}

	private void serializeOrders() {
		// TODO Auto-generated method stub
		
	}

	private void serializeFiles() {
		// TODO Auto-generated method stub
		
	}

	private void serializeMarks() {
		// TODO Auto-generated method stub
		
	}

	private void serializeCourses() {
		// TODO Auto-generated method stub
		
	}

	private void serializeUsers() {
    	try {
            ObjectInputStream out = new ObjectInputStream(new FileInputStream("users.ser"));

            users = (Vector<User>) out.readObject();

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
