package users;

import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import course.Course;
import project.DataBase;
import project.News;
import utils.Printer;

public class Manager extends Employee implements Serializable {
	public Manager(){}
	public Manager(String mail,String firstname,String lastname,String phoneNum,int salary) {
    	super(mail,firstname,lastname, phoneNum, salary);
    }
	
    public boolean addCourse(Course c) {
        if(!DataBase.courses.contains(c)) {
        	return DataBase.courses.add(c);
        }
        return false;
    }

    public boolean deleteCourse(Course c) {
    	if(DataBase.courses.contains(c)) {
        	return DataBase.courses.remove((Course)c);
        }
    	return false;
    }
    
    public boolean sendMessage(String message, Teacher t) {
        if(DataBase.users.contains(t)) {
        	return t.addMessage(super.getName()+" "+super.getSurname()+": "+message);
        }else {
        	Printer.print("No such Teacher founded");
        	return false;
        }
    }
    
    public void viewTeacherInfo(Teacher t) {
        for(int i=0;i<DataBase.users.size();++i) {
        	if(t.getClass() == DataBase.users.get(i).getClass()) {
        		Printer.print(t.toString());
        	}
        }
    }
    
    public Teacher viewTeacherInfo(String name) {
    	int cnt=0;
    	Teacher teacher = null;
        for(int i=0;i<DataBase.users.size();++i) {
        	if(DataBase.users.get(i) instanceof Teacher && DataBase.users.get(i).getName().equals(name)){
        		cnt+=1;
        		if(cnt==2) {
        			return null;
        		}
        		teacher =(Teacher)DataBase.users.get(i);
        	}
        }
        return teacher;
    }
    
    public Teacher viewTeacherInfo(String name, String surname) {
    	int cnt=0;
    	Teacher teacher = null;
        for(int i=0;i<DataBase.users.size();++i) {
        	if(DataBase.users.get(i) instanceof Teacher && DataBase.users.get(i).getName().equals(name)
        			&& DataBase.users.get(i).getSurname().equals(surname)){
        		cnt+=1;
        		if(cnt==2) {
        			return null;
        		}
        		teacher =(Teacher)DataBase.users.get(i);
        	}
        }
        return teacher;
    }
    
    public Teacher viewTeacherInfo(String name, String surname, String mail) {
    	int cnt=0;
    	Teacher teacher = null;
        for(int i=0;i<DataBase.users.size();++i) {
        	if(DataBase.users.get(i) instanceof Teacher && DataBase.users.get(i).getName().equals(name)
        			&& DataBase.users.get(i).getSurname().equals(surname) && DataBase.users.get(i).getMail().equals(mail)){
        		cnt+=1;
        		if(cnt==2) {
        			return null;
        		}
        		teacher =(Teacher)DataBase.users.get(i);
        	}
        }
        return teacher;
    }
    
    public void viewStudentInfo(Student s) {
    	for(int i=0;i<DataBase.users.size();++i) {
        	if(s.getClass() == DataBase.users.get(i).getClass()) {
        		Printer.print(s.toString());
        	}
        }
    }
    
    public Student viewStudentInfo(String name) {
    	int cnt=0;
    	Student stud = null;
        for(int i=0;i<DataBase.users.size();++i) {
        	if(DataBase.users.get(i) instanceof Student && DataBase.users.get(i).getName().equals(name)){
        		cnt+=1;
        		if(cnt==2) {
        			return null;
        		}
        		stud  = (Student)DataBase.users.get(i);
        	}
        }
        return stud;
    }
    
    public Student viewStudentInfo(String name, String surname) {
    	int cnt=0;
    	Student stud = null;
        for(int i=0;i<DataBase.users.size();++i) {
        	if(DataBase.users.get(i) instanceof Student && DataBase.users.get(i).getName().equals(name)
        			&& DataBase.users.get(i).getSurname().equals(surname)){
        		cnt+=1;
        		if(cnt==2) {
        			return null;
        		}
        		stud =(Student)DataBase.users.get(i);
        	}
        }
        return stud;
    }
    
    public Student viewStudentInfo(String name, String surname, String mail) {
    	int cnt=0;
    	Student stud = null;
        for(int i=0;i<DataBase.users.size();++i) {
        	if(DataBase.users.get(i) instanceof Student && DataBase.users.get(i).getName().equals(name)
        			&& DataBase.users.get(i).getSurname().equals(surname) && DataBase.users.get(i).getMail().equals(mail)){
        		cnt+=1;
        		if(cnt==2) {
        			return null;
        		}
        		stud =(Student)DataBase.users.get(i);
        	}
        }
        return stud;
    }
    
    public String toString() {
        return super.toString() + "\nPosition: Manager";
    }
    
    public int hashCode() {
    	return super.hashCode();
    	//TODO
    }
    
    public boolean equals(Object o) {
    	if(o == null) return false;
    	if(o.getClass()!=getClass()) return false;
    	Manager m = (Manager)o;
    	return super.equals(m);
    }
    
    public void createNewsTab(String title,String text) {
    	News news = new News(title, text);
    	if(!DataBase.news.contains(news)) {
    		DataBase.news.add(news);
    		Printer.print("News was created");
    		Printer.writeLogPrimitive(this,"creates news");
    	}
    }
   
    public void updateNewsTab(News n, String new_title, String new_text) {
    	if(DataBase.news.contains(n)) {
    		Date date = Calendar.getInstance().getTime();
    		DataBase.news.get(DataBase.news.indexOf((News)n)).setTitle(new_title);
        	DataBase.news.get(DataBase.news.indexOf((News)n)).setText(new_text);
        	DataBase.news.get(DataBase.news.indexOf((News)n)).setDate(date);
    	}
    }
    
    public void viewNewsTab() throws IOException {
    	super.viewNewsTab();
    }
    
}
