package course;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import utils.Printer;

public class Course_File implements Serializable {    // no Ideas
    private String fileName;
    private String fileContext;
    private Date date;
    private String path;
    private static final String PATH = "files/";
    
    public Course_File(String course_name, String fileName, String context) {     
    	this.fileName = fileName;
    	this.fileContext = context;
    	this.setPath(PATH+course_name+"/"+fileName+".txt");
    	this.date = (Date)Calendar.getInstance().getTime();
    	createFile(course_name, fileName, fileContext);
    }

	public String getFileName() {
        return this.fileName;
    }
    
    public String setFileName(String fileName) {
        return this.fileName = fileName;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public Date setDate(Date date) {
        return this.date = date;
    }
    
    public String getFileContext() {
		return fileContext;
	}

	public void setFileContext(String fileContext) {
		this.fileContext = fileContext;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
    private void createFile(String st , String fileName, String fileContext) {
    	File newdirectory = new File(PATH+st);
    	boolean bool = newdirectory.mkdir();
    	if(bool) {
    		Printer.print("New "+st+" directory created succesfuly");
    	}
    	try {
    		File file = new File(PATH+st, fileName+".txt");
			file.createNewFile();
			try(BufferedWriter context = new BufferedWriter(new FileWriter(path, true))){
				if(fileContext.length()/120 == 0) {
					context.write(fileContext);
				}else {
					for(int i=0;i<fileContext.length()/120;++i) {
						context.write(fileContext.substring(120*i, 120*i+120));
						context.write("\n");
					}
				}

			}catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
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
    	return this.fileName.equals(t.getFileName());
    }
    
    public int hashCode() {
		return 0;
        //TODO
    }
    
    public Object clone() {
		return this.clone();
        //TODO
    }
    
    public String toString() {
    	File file = new File(path); 
    	return "File name: "+fileName+".txt" + "      size: " + file.length() + " bytes";
    }
}