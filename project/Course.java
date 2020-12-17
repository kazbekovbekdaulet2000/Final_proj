package project;

import java.io.Serializable;
import java.util.Vector;

import Users.Student;
import Users.Teacher;
import enums.Faculty;

public class Course implements Serializable {
    
	private String courseID;
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
    	this.courseID = id;
    	this.courseName = name;
    	this.credits = credits;
    	this.creditsECTS = ECTS;
    	this.forStudYears = studY;
    	this.teacher = teacher;
    	this.faculty = faculty;
    }                          
    
    public String getCourseID() {
		return courseID;
	}
	public void setCourseID(String courseID) {
		this.courseID = courseID;
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
	
    public int compareTo(Object o) {
    	if(getCourseName().compareTo(((Course)o).getCourseName()) == 0) {
    		return getCredits().compareTo(((Course)o).getCredits());
    	}
    	return getCourseName().compareTo(((Course)o).getCourseName());
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseID == null) ? 0 : courseID.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((credits == null) ? 0 : credits.hashCode());
		result = prime * result + ((creditsECTS == null) ? 0 : creditsECTS.hashCode());
		result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
		result = prime * result + ((files == null) ? 0 : files.hashCode());
		result = prime * result + ((forStudYears == null) ? 0 : forStudYears.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
		return result;
	}
    
    public boolean equals(Object o) {
    	if(o == null) return false;
    	if(o.getClass()!=getClass()) return false;
    	Course cs = (Course) o;
    	return cs.getCourseName().equals(getCourseName()) && cs.getCourseID().equals(getCourseID()) 
    			&& cs.getCredits().equals(getCredits()) && cs.getCreditsECTS().equals(getCreditsECTS()) 
    			&& cs.getFaculty().equals(getFaculty()) && cs.getFiles().equals(getFiles()) 
    			&& cs.getForStudYears().equals(getForStudYears()) && cs.getTeacher().equals(getTeacher());
    }
    
	@Override
	public String toString() {
		return "Course: "+ getCourseName()+"("+getCourseID()+") \n" + "Credits/ECTS: " + getCredits() +"/" + getCreditsECTS()
		+"\nFaculty: " + getFaculty() +"\nFor students of "+getForStudYears()+" year of education"+ "\nTeacher: "+ getTeacher().getName() + " "+ getTeacher().getSurname();
	}
    
    
}
