package users;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import project.DataBase;
import project.Order;
import utils.Printer;

public class TechSupportGuy extends Employee implements Serializable {
    
    private Vector<Order> acceptedList;
    private Queue<Order> waitingList;
    
    {
    	acceptedList = new Vector<Order>();
    	waitingList = new LinkedList<Order>();  // we can't directly use Queue because Queue in java is interface;
    }
    
    public TechSupportGuy() {}
    public TechSupportGuy(String mail,String firstname,String lastname,String phoneNum, int salary) {
    	super(mail,firstname,lastname,phoneNum,salary);
    }
    
    
    
    public Vector<Order> getAcceptedList() {
        return this.acceptedList;
    }
    
    public void setAcceptedList(Vector<Order> acceptedList) {
        this.acceptedList = acceptedList;
    }
    public Queue<Order> getWaitingList() {
        return this.waitingList;
    }
    
    public void setWaitingList(LinkedList<Order> waitingList) {
        this.waitingList = waitingList;
    }

    //                          Operations                                  
    public void operateOrder() {                 // Need more update
        Order o = waitingList.poll();
        acceptedList.add(o);
    }
    
    public void rejectOrder() {
    	waitingList.poll();
    }
    
    public void addToWaitingList(Order o) {
        waitingList.add(o);
    }
    
    
    public String toString() {
    	return super.toString() + "\nPosition: Tech Support";
    }
    
    public int hashCode() {
    	return super.hashCode();
    }
    
    public boolean equals(Object o) {
    	if(o == null) return false;
    	if(o.getClass()!=getClass()) return false;
    	TechSupportGuy tsg = (TechSupportGuy)o;
    	return super.equals(tsg);
    
    }
    
    public void viewAcceptedList() {
    	if (acceptedList.size()!=0)
	        for(int i=0; i<acceptedList.size();++i){
//	        	Printer.print(acceptedList.get(i).toString());
	        	Timestamp ts = new Timestamp(acceptedList.get(i).getDate().getTime());
	        	long tenMinutesAgo = System.currentTimeMillis()-10 * 60 * 1000;
	        	if (ts.getTime() < tenMinutesAgo)
	        		Printer.print("Done " + acceptedList.get(i).toString());
	        	else
	        		Printer.print(acceptedList.get(i).toString());
	        }
    	else 
    		Printer.print("No accepted orders!");
    }
    
    public void viewNewsTab() throws IOException {
    	super.viewNewsTab();
    }
    
}


