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
        //TODO
    }

    public void deleteCourse(Course c) {
        //TODO
    }
    
    public void sendMessage(String message, Teacher t) {
        t.addMessage(message);
    }
    
    public void viewTeacherInfo(Teacher t) {
        //TODO
    }
    
    public void viewStudentInfo(Student s) {
        //TODO
    }
    
    public String toString() {
        return super.toString();
    }
    
    public int hashCode() {
    	return 0;
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
        //TODO
    }
   
    public void updateNewsTab(News n) {
        //TODO
    }
    
    public void viewNewsTab() throws IOException {
    	super.viewNewsTab();
    }
    
}
