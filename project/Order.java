package project;


import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

public class Order implements Serializable {
	private String title;
    private String subtitle;
    private Date date;
    
    public Order() {};
    
    public Order(String title, String subtitle) {
    	this.title = title;
    	this.subtitle = subtitle;
    	this.date = (Date)Calendar.getInstance().getTime();
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
		return "Order [title=" + title + ", subtitle=" + subtitle + ", date=" + date +"]";
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
