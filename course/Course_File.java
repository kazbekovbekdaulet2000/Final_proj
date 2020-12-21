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
    
    public Course_File(String course_name, String fileName, String context) {     
    	this.fileName = fileName;
    	this.fileContext = context;
    	this.path = "files/"+course_name+"/"+fileName+".txt";
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
    	File newdirectory = new File("files/"+st);
    	boolean bool = newdirectory.mkdir();
    	if(bool) {
    		Printer.print("New "+st+" directory created succesfuly");
    	}
    	try {
    		File file = new File("files/"+st, fileName+".txt");
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
		return getFileName().compareTo(((Course_File)a).getFileName());
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((fileContext == null) ? 0 : fileContext.hashCode());
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		return result;
	}
     
    public boolean equals(Object o) {
    	if(o == null) return false;
    	if(o.getClass()!=getClass()) return false;
    	Course_File t = (Course_File) o;
    	return this.fileName.equals(t.getFileName()) && this.fileContext.equals(t.getFileContext()) && this.path.equals(t.getPath());
    }

    public Object clone() {
		return this.clone();
    }

	public String toString() {
    	File file = new File(path); 
    	return "File name: "+fileName+".txt" + 
    			"    size: " + file.length() + " bytes"
    			+"  Date of creaton: " + date.getDate()+"."+date.getMonth()+"."+(date.getYear()+1900);
    }
}