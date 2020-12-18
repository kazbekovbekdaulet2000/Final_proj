package course;


import java.io.File;
import java.io.Serializable;
import java.nio.file.Path;
import java.sql.Date;

import users.Teacher;

public class Course_File implements Serializable {    // no Ideas
    private String fileName;
    private Path path;
    private Date date;
    private Course course;
    private static final String PATH = "Files/";
    
    public Course_File(Course course, String fileName, Path path, double size, Date date) {     
    	this.fileName = fileName;
    	this.path = path;
    	this.date = date;
    	this.setCourse(course);
    }
    
    public String getFileName() {
        return this.fileName;
    }
    
    public String setFileName(String fileName) {
        return this.fileName = fileName;
    }
    
    public Path getPath() {
        return this.path;
    }
    
    public Path setPath(Path path) {
        return this.path = path;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public Date setDate(Date date) {
        return this.date = date;
    }
    
    public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
    //                          Operations                                  
    
    public static void CreateDirectory(String st) {
    	File newdirectory = new File(PATH+st);
    	boolean bool = newdirectory.mkdir();
    	if(bool) {
    		System.out.println("New "+st+" directory created succesfuly");
    	}else {
    		System.out.println("Can't create "+st+" directory");
    	}
    }
    
    public int compareTo(Object a) {
		return 0;
        //TODO
    }
    
    public boolean equals(Object o) {
    	if(o == null) return false;
    	if(o.getClass()!=getClass()) return false;
    	Course_File t = (Course_File) o;
    	return this.path.equals(t.getPath()) && this.fileName.equals(t.getFileName());
    }
    
    public int hashCode() {
		return 0;
        //TODO
    }
    
    public Object clone() {
		return this.clone();
        //TODO
    }
}
