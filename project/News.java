package project;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable {
    private Integer newsID;
    private String title;
    private String text;
    private Date date;
    
    public News() {}
    public News(String title,String text, Date date) {
//    	this.newsID = id;
    	this.title = title;
    	this.date = date;
    	this.text = text;
    }
    
    //                          Operations                                  
    
    public Integer getNewsID() {
		return newsID;
	}
	public void setNewsID(Integer newsID) {
		this.newsID = newsID;
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
		result = prime * result + ((newsID == null) ? 0 : newsID.hashCode());
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	
	public boolean equals(Object o) {
		if(o == null) return false;
    	if(o.getClass()!=getClass()) return false;
    	News n = (News) o;
    	return n.getClass()==getClass() && n.getDate() == getDate() && n.getText() == getText() && n.getTitle() == getTitle() &&
    			n.getNewsID() == getNewsID();
    }
    @Override
	public String toString() {
		return "   " + title + 
				"/n" + text;
	}
    
    
    
    
    public int compareTo(News a){
    	return getTitle().compareTo(a.getTitle());
    }
    
}
