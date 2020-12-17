package Users;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
//import java.util.NoSuchElementException;
import java.util.Vector;

import project.Course;
import project.DataBase;
import project.Mark;

public class Student extends User implements Serializable {
    
    private Integer year;
    private Integer totalECTS;
    private Integer totalCredits;
    private String ID;
    private double gpa;
    private Vector<Course> courses;
    private HashMap<Course,Mark> grades;
    
    {
        gpa = 0;
        totalECTS = 0;
        totalCredits = 0;
        courses = new Vector<Course>();
        grades = new HashMap<Course, Mark>(); 
//        ID = generateID(1);
    }
    
    public Student() {}
    public Student(String mail, String firstname, String lastname, String phoneNum, int year) {
    	super(mail,firstname,lastname,phoneNum);
    	this.year = year;
    	this.ID = generateID(year, mail, firstname, lastname, phoneNum);
    }
    
    private String generateID(int year,String mail, String firstname,String lastname, String pn) {
    	int code = (firstname.hashCode()+lastname.hashCode()+mail.hashCode()+pn.hashCode())%100000+100000;
        if(Calendar.getInstance().get(Calendar.MONTH)>5) {
        	return (Calendar.getInstance().get(Calendar.YEAR)-year-1999)+ "B" + code;
        }
    	return (Calendar.getInstance().get(Calendar.YEAR)-year-2000)+ "B" + code;
	}
    
	//                          Operations                                  
    public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getTotalECTS() {
		return totalECTS;
	}
	public void setTotalECTS(Integer totalECTS) {
		this.totalECTS = totalECTS;
	}
	public Integer getTotalCredits() {
		return totalCredits;
	}
	public void setTotalCredits(Integer totalCredits) {
		this.totalCredits = totalCredits;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public Vector<Course> getCourses() {
		return courses;
	}
	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}
	public HashMap<Course, Mark> getGrades() {
		return grades;
	}
	public void setGrades(HashMap<Course, Mark> grades) {
		this.grades = grades;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	public void registerForCourse(Course c) {
		viewAvailableCourses(); 
		if(DataBase.courses.contains(c)) {
			courses.add(c);
		}else {
			System.out.println("No "+c.getCourseName()+ " Course founded try again"); 
		}
    }
	
	public void viewCourseTeacher(Course c) {
        c.getTeacher().toString();
    }
    
    public void viewCourseFile(Course c) {
        try {
	        for(int i=0; i<c.getFiles().size();++i) {
	        	System.out.println(c.getFiles().get(i).toString());
	        }
        }catch (NullPointerException ex) {
        	System.out.println("No Files");
        }
    }
    
    public void viewAvailableCourses() {
    	for(int i=0; i<DataBase.courses.size(); ++i) {
    		System.out.println(DataBase.courses.get(i).toString());
    	}
    }
    
//    public void viewRegisteredCourses() {
//    	for(int i=0; i<getCourses().size(); ++i) {
//    		System.out.println(getCourses().get(i).toString());
//    	}
//    }
    
    public void drawTranscriptTable() {
    	int width=5;
        int count=1; 
        System.out.println("+  code  +      name      + Credit + ECTS + Mark + String Mark + GPA +");
        for(int i=0;i<courses.size()+1 ; i++) {
        	String lines = "+--------+----------------+--------+------+------+-------------+-----+";
        	System.out.println(lines);
            System.out.println();
            if(i==courses.size()+1){
            	System.out.println("+--------+----------------+--------+------+------+-------------+-----+");
            }
        }
    }
    
    public String toString() {
    	return super.toString() + "\nYear of education " + year + "\nStudent ID: "+ getID();
    }
   
    public int hashCode() {
    	return super.hashCode();
    }
    
    public boolean equals(Object o) {
    	if(o == null) return false;
    	if(o.getClass()!=getClass()) return false;
    	Student s = (Student) o;
    	return o.getClass() == getClass() && s.getName() == getName() && 
    			s.getSurname() == getSurname() && s.getMail() == getMail() && s.getPhoneNum() == getPhoneNum() &&
    			s.getYear() == getYear() && s.getID() == getID();
    }
    
    public int compareTo(Student stud) {
    	return getName().compareTo(stud.getName());
    }
    
    public void viewNewsTab() throws IOException {
    	super.viewNewsTab();
    }
	public void viewRegisteredCourses() {
		for(int i=0;i<courses.size();++i) {
			System.out.println(courses.get(i).toString());
			System.out.println("_________________________________________________");
		}
	}
}
