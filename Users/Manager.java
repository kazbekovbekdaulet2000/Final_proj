package users;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import course.Course;
import project.DataBase;
import project.News;
import utils.Printer;
import utils.SearchByPattern;

public class Manager extends Employee implements Serializable {
	public Manager(){}
	public Manager(String mail,String firstname,String lastname,String phoneNum,int salary) {
    	super(mail,firstname,lastname, phoneNum, salary);
    }
	
    public boolean addCourse(Course c) {
        if(!DataBase.courses.contains(c)) {
        	return DataBase.courses.add(c);
        }
        return false;
    }

    public boolean deleteCourse(Course c) {
    	if(DataBase.courses.contains(c)) {
        	return DataBase.courses.remove((Course)c);
        }
    	return false;
    }
    
    public boolean sendMessage(String message, Teacher t) {
        if(DataBase.users.contains(t)) {
        	return t.addMessage(super.getName()+" "+super.getSurname()+": "+message);
        }else {
        	Printer.print("No such Teacher founded");
        	return false;
        }
    }
    
    public void searchTeacherInfo(String search) {
    	for (User k : DataBase.users) {
			if ((SearchByPattern.KMPSearch(search, k.getName()) || SearchByPattern.KMPSearch(search, k.getSurname()) 
					|| SearchByPattern.KMPSearch(search, k.getMail())) && k instanceof Teacher) {
				Printer.print("_________________________________");
				Printer.print(k.toString());
			}
		}
    	Printer.print("_________________________________");
    }
    
    public void searchStudentInfo(String search) {
    	for (User k : DataBase.users) {
			if ((SearchByPattern.KMPSearch(search, k.getName()) || SearchByPattern.KMPSearch(search, k.getSurname()) 
					|| SearchByPattern.KMPSearch(search, k.getMail())) && k instanceof Student) {
				Printer.print("_________________________________");
				Printer.print(k.toString());
			}
		}
    	Printer.print("_________________________________");
    }
    
    public String toString() {
        return super.toString() + "\nPosition: Manager";
    }
    
    public int hashCode() {
    	return super.hashCode();
    	//TODO
    }
    
    public boolean equals(Object o) {
    	if(o == null) return false;
    	if(o.getClass()!=getClass()) return false;
    	Manager m = (Manager)o;
    	return super.equals(m);
    }
    
    public void createNewsTab(String title,String text) {
    	News news = new News(title, text);
    	if(!DataBase.news.contains(news)) {
    		DataBase.news.add(news);
    		Printer.print("News was created");
    		Printer.writeLogPrimitive(this,"creates news");
    	}
    }
   
    public void updateNewsTab(News n, String new_title, String new_text) {
    	if(DataBase.news.contains(n)) {
    		Date date = Calendar.getInstance().getTime();
    		DataBase.news.get(DataBase.news.indexOf((News)n)).setTitle(new_title);
        	DataBase.news.get(DataBase.news.indexOf((News)n)).setText(new_text);
        	DataBase.news.get(DataBase.news.indexOf((News)n)).setDate(date);
    	}
    }
    
    public void viewNewsTab() throws IOException {
    	super.viewNewsTab();
    }
    
}

