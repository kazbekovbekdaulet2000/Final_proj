package project;


import java.io.File;
import java.io.Serializable;
import java.nio.file.Path;
import java.sql.Date;

public class Course_File implements Serializable {    // no Ideas
    private String fileName;
    private Path path;
    private double size;
    private Date date;
    
    private static final String PATH = "course_files/";
    
    public Course_File(String fileName, Path path, double size, Date date) {    // i think there is no need for constructors if we 
    	this.fileName = fileName;                                                // want to create files and directories ??? 
    	this.path = path;
    	this.size = size;
    	this.date = date;
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
    
    public double getSize() {
        return this.size;
    }
    
    public double setSize(double size) {
        return this.size = size;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public Date setDate(Date date) {
        return this.date = date;
    }
    //                          Operations                                  
    
//    public static void CreateDirectory(String st) {
//    	File newdirectory = new File(PATH+st);
//    }
    
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
    
    public Object clone() {
		return this.clone();
        //TODO
    }
    
}