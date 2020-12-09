package Users;

import java.util.Vector;

import enums.Teacher_pos;
import project.Course;
import project.Course_File;
import project.Mark;
import project.Order;

/**
* @generated
*/
public class Teacher extends Employee {
    
    private Teacher_pos pos;
    private Vector<String> messages;
    {
    	messages = new Vector<String>();
    }
    public Teacher(String mail,String firstname,String lastname,String phoneNum,int salary, Teacher_pos pos) {
    	super(mail, firstname, lastname, phoneNum, salary);
    	this.pos = pos;
    }
    
    public Teacher_pos getPos() {
		return pos;
	}

	public void setPos(Teacher_pos pos) {
		this.pos = pos;
	}

	public Vector<String> getMessages() {
		return messages;
	}

	public void setMessages(Vector<String> messages) {
		this.messages = messages;
	}

	// Operations

    public void manageCourse(Course c) {
        //TODO
    }
    
    public void viewCourse(Course c) {
        //TODO
    }
    
	public void addCourseFile(Course c, Course_File cf) {
        c.getFiles().add(cf);
    }
    
    public void removeCourseFile(Course c, Course_File cf) {
    	if(c.getFiles().contains(cf)) {
        	c.getFiles().remove(cf);
        }
    }
    
    public void putMark(Course c, Student s, Mark m) {
    	s.getGrades().put(c, m);
    }
    
    public void putFirstAtt(Course c, Student s, double m) {
//    	if()
    	//TODO
    }
    
    
    public void addMessage(String s) {
    	getMessages().add(s);
    }
    
    public String toString() {
    	return super.toString()+"Position: "+pos;
        //TODO
    }
    
    public int hashCode() {
		return super.hashCode();
        //TODO
    }
    
    public boolean equals(Object a) {
		return false;
        //TODO
    }
    
    public void sendOrder(Order o) {
        //TODO
    }
    
    public void viewMessages() {
        for(int i=0;i<getMessages().size();++i) {
        	System.out.print("Message from manager:  ");
        	System.out.println(getMessages().get(i));
        }
    }
    
    public void viewNewsTab() {
        //TODO
    }
    
    public int compareTo(Teacher a) {
//		if(getName().equals(a.getName())) {
//			return 0;
//		}else if(getName()>a.getName()) {
//			return 1;
//		}else {
//			return -1;
//		}
    	return getName().compareTo(a.getName());
    	
    }
    
}
