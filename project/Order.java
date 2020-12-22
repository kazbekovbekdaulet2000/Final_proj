package project;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Order implements Serializable {
	private String title;
    private String subtitle;
    private Date date;
    private String teacher;
    
    public Order() {};
    
    public Order(String teacher,String title, String subtitle, Date time) {
    	this.teacher = teacher;
    	this.title = title;
    	this.subtitle = subtitle;
    	this.date = time;
    };
    //                          Operations                                  
   
    
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Order [teacher=" + teacher+", title=" + title + ", subtitle=" + subtitle + ", date=" + date +"]";
	}
	
	public boolean equals(Object a) {
    	return false;
        //TODO
    }
    
    public int hashCode() {
    	return 0;
        //TODO
    }
    
}

