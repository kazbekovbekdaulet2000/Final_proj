package Users;

import project.Course;
import project.News;

public class Manager extends Employee {
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
    
    public boolean equals(Object a) {
    	return false;
        //TODO
    }
    
    
    public void createNewsTab(News n) {
        //TODO
    }
   
    public void updateNewsTab(News n) {
        //TODO
    }
    
    public void viewNewsTab() {
        //TODO
    }
    
}
