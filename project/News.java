package project;

import java.io.Serializable;
import java.sql.Date;

public class News implements Serializable {
    private Integer newsID;
    private String title;
    private String text;
    private Date date;
    
    public News() {}
    public News(int id, String title,String text, Date date) {
    	this.newsID = id;
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
	public boolean equals(Object a) {
    	return false;
        //TODO
    }
    @Override
	public String toString() {
		return " ";
	}
    
    
    public int hashCode() {
    	return 0;
        //TODO
    }
    
    public int compareTo(Object a){
    	return 0;
        //TODO
    }
    
}
