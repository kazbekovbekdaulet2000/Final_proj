package Users;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import project.Course;
import project.DataBase;
import project.News;

public class Manager extends Employee implements Serializable {
	public Manager(){}
	public Manager(String mail,String firstname,String lastname,String phoneNum,int salary) {
    	super(mail,firstname,lastname, phoneNum, salary);
    }
	
    public void addCourse(Course c) {
        if(!DataBase.courses.contains(c)) {
        	DataBase.courses.add(c);
        }
    }

    public void deleteCourse(Course c) {
    	if(DataBase.courses.contains(c)) {
        	DataBase.courses.remove((Course)c);
        }
    }
    
    public void sendMessage(String message, Teacher t) {
        if(DataBase.users.contains(t)) {
        	t.addMessage(message);
        }else {
        	System.out.println("No such Teacher founded");
        }
    }
    
    public void viewTeacherInfo(Teacher t) {
        for(int i=0;i<DataBase.users.size();++i) {
        	if(t.getClass() == DataBase.users.get(i).getClass()) {
        		System.out.println(t.toString());
        	}
        }
    }
    
    public void viewStudentInfo(Student s) {
    	for(int i=0;i<DataBase.users.size();++i) {
        	if(s.getClass() == DataBase.users.get(i).getClass()) {
        		System.out.println(s.toString());
        	}
        }
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
    	return o.getClass() == getClass() && m.getName() == getName() && 
    			m.getSurname() == getSurname() && m.getMail() == getMail() && m.getPhoneNum() == getPhoneNum() &&
    			m.getSalary() == getSalary();
    }
    
    
    public void createNewsTab(News n) {
        //TODO
    }
    
    public void createNewsTab(String title,String text) {
    	Date date=Calendar.getInstance().getTime();
    	News news = new News(title, text, date);
    	if(!DataBase.news.contains(news)) {
    		DataBase.news.add(news);
    	}
    }
   
    public void updateNewsTab(News n, String new_title, String new_text) {
    	if(DataBase.news.contains(n)) {
    		Date date = Calendar.getInstance().getTime();               // update time;
    		DataBase.news.get(DataBase.news.indexOf((News)n)).setTitle(new_title);
        	DataBase.news.get(DataBase.news.indexOf((News)n)).setText(new_text);
        	DataBase.news.get(DataBase.news.indexOf((News)n)).setDate(date);
    	}
    }
    
    public void viewNewsTab() throws IOException {
    	super.viewNewsTab();
    }
    
}
