package project;

import java.io.Serializable;
import java.util.Vector;

import Users.Teacher;
import enums.Faculty;

public class Course implements Serializable {
    
	private String coureID;
    private String courseName;
    private Integer credits;
    private Integer creditsECTS;
    private Faculty faculty;
    private Vector<Course_File> files;
    private Integer forStudYears;
    private Teacher teacher;
    
    {
    	files = new Vector<Course_File>();
    }
    
    public Course() {}
    public Course(String id, String name, int credits, int ECTS, Faculty faculty, int studY, Teacher teacher) {
    	this.coureID = id;
    	this.courseName = name;
    	this.credits = credits;
    	this.creditsECTS = ECTS;
    	this.forStudYears = studY;
    	this.teacher = teacher;
    }                          
    
    public String getCoureID() {
		return coureID;
	}
	public void setCoureID(String coureID) {
		this.coureID = coureID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getCredits() {
		return credits;
	}
	public void setCredits(Integer credits) {
		this.credits = credits;
	}
	public Integer getCreditsECTS() {
		return creditsECTS;
	}
	public void setCreditsECTS(Integer creditsECTS) {
		this.creditsECTS = creditsECTS;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public Vector<Course_File> getFiles() {
		return files;
	}
	public void setFiles(Vector<Course_File> files) {
		this.files = files;
	}
	public Integer getForStudYears() {
		return forStudYears;
	}
	public void setForStudYears(Integer forStudYears) {
		this.forStudYears = forStudYears;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	//  Operations        
	
    public int compareTo(Object a) {
		return 0;
        //TODO
    }
    
    public boolean equals(Object a) {
		return false;
        //TODO
    }
   
    public int hashCode() {
		return 0;
        //TODO
    }
	@Override
	public String toString() {
		return "";
	}
    
    
}
