package Users;

import java.io.IOException;
import java.io.Serializable;
import java.util.Vector;

import enums.Teacher_pos;
import project.Course;
import project.Course_File;
import project.DataBase;
import project.Mark;
import project.Order;

/**
* @generated
*/
public class Teacher extends Employee implements Serializable {
    
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
        if(DataBase.courses.contains(c)) {
        	System.out.println(c.toString());
        }
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
    	if(DataBase.courses.contains(c)) {
    		int t = DataBase.courses.indexOf(c);
    		if(DataBase.courses.elementAt(t).getTeacher().equals(this)) {
    	    	s.getGrades().put(c, m);
    	    	DataBase.marks.add(m);
    		}
    	}else {
    		System.out.println("Error occupied");
    	}
    }
    
//    public void putFirstAtt(Course c, Student s, double first) {
//    	if(DataBase.courses.contains(c)) {
//    		int t = DataBase.courses.indexOf(c);
//    		if(DataBase.courses.elementAt(t).getTeacher().equals(this)) {
////    	    	s.getGrades().values().
//    		}
//    	}
//    }
//    
//    public void putSecondAtt(Course c, Student s, double second) {
//    	//TODO
//    }
//    
//    public void putFinalAtt(Course c, Student s, double last) {
//    	//TODO
//    }
    
    
    public void addMessage(String s) {
    	getMessages().add(s);
    }
    
    public String toString() {
    	return super.toString()+"\nPosition: "+pos;
        //TODO
    }
    
    public int hashCode() {
		return super.hashCode();       // IDK
        //TODO
    }
    
    public boolean equals(Object o) {
    	if(o == null) return false;
    	if(o.getClass()!=getClass()) return false;
    	Teacher t = (Teacher) o;
    	return t.getName() == getName() && 
    			t.getSurname() == getSurname() && t.getMail() == getMail() && t.getPhoneNum() == getPhoneNum() &&
    			t.getSalary() == getSalary() && t.getPos() == getPos();
    
    }
    
    public void sendOrder(Order o, TechSupportGuy tsg) {
        //TODO
    }
    
    public void sendOrder(String title, String text, TechSupportGuy tsg) {
        //TODO
    }
    
    public void viewMessages() {
        for(int i=0;i<getMessages().size();++i) {
        	System.out.print("Message from manager:  ");
        	System.out.println(getMessages().get(i));
        }
    }
    
    public void viewNewsTab() throws IOException {
    	super.viewNewsTab();
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
