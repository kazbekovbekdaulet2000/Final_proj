package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import project.News;

public class Serializer {
	public static boolean serialize(String fileName, Object obj) {
		try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(obj);
            out.flush();
            out.close();
            return true;
        }
        catch (FileNotFoundException e) {
        	System.out.println("Class not found");
        }
        catch (IOException e) {
        	System.out.println("IO Exception");
        }
		
		return false;
	}
	
	public static <T> T deserialize(String fileName, Class<T> usr) {
		try (
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (T) in.readObject();
        }
		catch (ClassNotFoundException e) {
			Printer.print("Class Not Found");
        }
		catch (FileNotFoundException e) {
			Printer.print("File not found");
        }
        catch (IOException e) {
        	Printer.print("IO Exception");
        }
		return null;	
	}
	
	public static <T> Vector<T> deserializeVector(String fileName, Class<T> usr){
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
			return (Vector<T>)in.readObject();
		}
		catch (ClassNotFoundException e) {
			Printer.print("Class Not Found");
        }
		catch (FileNotFoundException e) {
			Printer.print("File not found");
        }
        catch (IOException e) {
        	Printer.print("IO Exception");
        }
		return null;	
	}
}
