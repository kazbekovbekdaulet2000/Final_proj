package utils;

import java.io.*;
import java.util.Calendar;
import users.User;

public class Printer {
	public static String input(String text) {
		try {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
			System.out.print(text);
			String new_text;
			new_text = buffer.readLine();
			writeFile(text, new_text);
			return new_text;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static void writeFile(String text) {
		try(BufferedWriter buffer = new BufferedWriter(new FileWriter("output.txt", true))){
			buffer.write(text+"\n");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeFile(String text, String ans) {
		try(BufferedWriter buffer = new BufferedWriter(new FileWriter("output.txt", true))){
			buffer.write(text+ans+"\n");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeLog(User user, String text) {
		try(BufferedWriter log = new BufferedWriter(new FileWriter("log.txt", true))){
			log.write(Calendar.getInstance().getTime() +" "+ user.getClass().getSimpleName()+
					"::"+user.getName()+ " Entered: "+ text+"\n");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void writeLogPrimitive(User user, String text) {
		try(BufferedWriter log = new BufferedWriter(new FileWriter("log.txt", true))){
			log.write(Calendar.getInstance().getTime()+" "+user.getClass().getSimpleName()+
					"::"+user.getName() + " "+ text+"\n");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeLogWarning(User user, String text) {
		try(BufferedWriter log = new BufferedWriter(new FileWriter("log.txt", true))){
			log.write(Calendar.getInstance().getTime()+" "+user.getClass().getSimpleName()+
					"::"+user.getName() + " WARNING!! "+ text+"\n");
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void print(String text) {
		System.out.println(text);
		writeFile(text);
	}
	
	public static void print(String[] text) {
		for(int i=0;i<text.length;++i) {
			print(text[i]);
		}
	}

}
