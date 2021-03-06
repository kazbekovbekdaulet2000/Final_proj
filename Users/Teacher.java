package users;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

import comporators.CompareByName;
import course.Course;
import course.Course_File;
import course.Mark;
import enums.Teacher_pos;
import project.DataBase;
import project.Order;
import utils.Printer;

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
        	Printer.print(c.toString());
        }
    }
    
    public void viewCourses() {
        for(int i=0;i<DataBase.courses.size();++i) {
        	if(DataBase.courses.elementAt(i).getTeacher().equals(this)) {
        		Printer.print(DataBase.courses.elementAt(i).toString());
        		Printer.print("_________________________________________________________");
        	}
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
    		int course = DataBase.courses.indexOf(c);
    		if(DataBase.courses.elementAt(course).getTeacher().equals(this) && s.getCourses().contains(c)) {
    	    	s.getGrades().put(c, m);
    		}else {
    			Printer.print("Student is not registered for this course");
    		}
    	}else {
    		Printer.print("No such Course founded");
    	}
    }
   
    public void putFirstAtt(Course c, Student s, double first) {
    	if(DataBase.courses.contains(c)) {
    		int course = DataBase.courses.indexOf(c);
    		if(DataBase.courses.elementAt(course).getTeacher().equals(this) && s.getCourses().contains(c)) {
    			Mark new_m = s.getGrades().get(c);
    			new_m.setFirstAtt(first);
    			s.getGrades().replace(c,new_m);
    		}else {
    			Printer.print("Student is not registered for this course");
    		}
    	}else {
    		Printer.print("No such Course founded");
    	}
    }
    
    public void putSecondAtt(Course c, Student s, double second) {
    	if(DataBase.courses.contains(c)) {
    		int course = DataBase.courses.indexOf(c);
    		if(DataBase.courses.elementAt(course).getTeacher().equals(this) && s.getCourses().contains(c)) {
    			Mark new_m = s.getGrades().get(c);
    			new_m.setSecondAtt(second);
    			s.getGrades().replace(c,new_m);
    		}else {
    			Printer.print("Student is not registered for this course");
    		}
    	}else {
    		Printer.print("No such Course founded");
    	}
    }
    
    public void putFinalAtt(Course c, Student s, double last) {
    	if(DataBase.courses.contains(c)) {
    		int course = DataBase.courses.indexOf(c);
    		if(DataBase.courses.elementAt(course).getTeacher().equals(this) && s.getCourses().contains(c)) {
    			Mark new_m = s.getGrades().get(c);
    			new_m.setFinalgrade(last);
    			s.getGrades().replace(c,new_m);
    		}else {
    			Printer.print("Student is not registered for this course");
    		}
    	}else {
    		Printer.print("No such Course founded");
    	}
    }
    
    public boolean addMessage(String s) {
    	return getMessages().add(s);
    }
    
    public String toString() {
    	return super.toString()+"\nPosition: "+pos;
    }
    
    public int hashCode() {
		return super.hashCode();
    }
    
    public boolean equals(Object o) {
    	if(o == null) return false;
    	if(o.getClass()!=getClass()) return false;
    	Teacher t = (Teacher) o;
    	return super.equals(t) && t.getPos().equals(getPos());
    
    }
    
    public void sendOrder(Order o, TechSupportGuy tsg) {
    	if(DataBase.users.contains(tsg)) {
    		tsg.addToWaitingList(o);
    	}else {
			Printer.print("The system error your order was not recived");
    	}
    }
    
    public void sendOrder(String title, String text, TechSupportGuy tsg) {
    	if(DataBase.users.contains(tsg)) {
    		tsg.addToWaitingList(new Order(getMail(), title, text, Calendar.getInstance().getTime()));
    	}else {
			Printer.print("The system error your order was not recived");
    	}
    }
    
    public void viewMessages() {
    	if(!getMessages().isEmpty()) {
	        for(int i=0;i<getMessages().size();++i) {
	        	Printer.print("Message from "+ getMessages().get(i));
	        }
        }else {
        	Printer.print("Messages is empty");
        }
    }
    
    public void viewNewsTab() throws IOException {
    	super.viewNewsTab();
    }
    
    public int compareTo(Teacher a) {
    	return getName().compareTo(a.getName());
    	
    }

	public void listofStudents() {
		for(int i=0;i<DataBase.courses.size();++i) {
			if(DataBase.courses.elementAt(i).getTeacher().equals(this)) {
				Printer.print("----------->Course: " + DataBase.courses.elementAt(i).getCourseName()+ "<-----------");
				Collections.sort(DataBase.users, new CompareByName()); //sort by name and surname
				for(int j=0;j<DataBase.users.size();++j) {
					if(DataBase.users.get(j) instanceof Student) {
						Student st = (Student)DataBase.users.get(j);
						if(st.getCourses().contains(DataBase.courses.get(i))) {
							Printer.print(st.getName()+ " " + st.getSurname());
						}
					}
				}
			}
			
		}

	}

	public void listofStudents(Course course) {
		Collections.sort(DataBase.users, new CompareByName()); //sort by name and surname
		for(int j=0;j<DataBase.users.size();++j) {
			if(DataBase.users.get(j) instanceof Student) {
				Student st = (Student)DataBase.users.get(j);
				if(st.getCourses().contains(course)) {
					Printer.print(st.getName()+ " " + st.getSurname()+ " mail: "+ st.getMail());
				}
			}
		}
	}
    
}
