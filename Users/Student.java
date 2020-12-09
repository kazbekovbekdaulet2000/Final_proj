package Users;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
//import java.util.NoSuchElementException;
import java.util.Vector;

import project.Course;
import project.DataBase;
import project.Mark;

public class Student extends User {
    
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
    }
    
    public Student() {}
    public Student(String mail, String firstname, String lastname, String phoneNum, int year) {
    	super(mail,firstname,lastname,phoneNum);
    	this.year = year;
    	this.ID = generateID(year);
    }
    private String generateID(int year2) {
        Random random = new Random();
        StringBuilder subID = new StringBuilder();
        for(int i = 0; i < 6; i++) {
        	int index = random.nextInt(10);
        	subID.append(index);
        }
        
        return (Calendar.getInstance().get(Calendar.YEAR)-year-2000)+ "B" + subID.toString();    // Maybe update by month????
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
	
	
	
	
	public void registerForCourse() {
		viewAvailableCourses();
        
    }
	
	
	public void viewCourseTeacher(Course c) {
        c.getTeacher().toString();
    }
    
    public void viewCourseFile(Course c) {
        try {
	        for(int i=0; i<c.getFiles().size();++i) {
	        	System.out.println(c.getFiles().get(i).toString());
	        }
        }catch (Exception ex) {
        	System.out.println("Error");
        }
    }
    
    public void viewAvailableCourses() {
    	try {
    		DataBase db;
    	}catch(Exception e) {
    		System.err.println("Error found");
    	}
    	
    }
    
    public void drawTranscriptTable() {
        //TODO
    }
    
    public String toString() {
    	return super.toString() + " ";
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
    
    public int compareTo(Object a) {
    	return 0;
        //TODO
    }
    
    public void viewNewsTab() {
        //TODO
    }
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
    
}
