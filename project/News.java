package project;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class News implements Serializable {
    private String title;
    private String text;
    private Date date;
    
    public News() {}
    public News(String title,String text) {
    	this.title = title;
    	this.date = (Date)Calendar.getInstance().getTime();
    	this.text = text;
    }
    
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	public boolean equals(Object o) {
		if(o == null) return false;
    	if(o.getClass()!=getClass()) return false;
    	News n = (News) o;
    	return n.getText() == getText() && n.getTitle() == getTitle();
    }
    @Override
	public String toString() {
		return "----->TITLE:   " + title + 
				"\n" + text +"\nDate of creaton: " + date.getDate()+"."+date.getMonth()+"."+(date.getYear()+1900);
	}
    
    
    
    
    public int compareTo(News a){
    	return getTitle().compareTo(a.getTitle());
    }
    
}
