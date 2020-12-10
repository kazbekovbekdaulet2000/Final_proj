package Users;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import project.DataBase;
import project.Order;

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
    
    public void setWaitingList(Queue<Order> waitingList) {
        this.waitingList = waitingList;
    }

    //                          Operations                                  
    public void operateOrder() {
        //TODO
    }
    
    public void addToWaitingList(Order o) {
        //TODO
    }
    
    
    public String toString() {
    	return super.toString() + " TechSupp";
        //TODO
    }
    
    public int hashCode() {
    	return super.hashCode();
        //TODO
    }
    
    public boolean equals(Object o) {
    	if(o == null) return false;
    	if(o.getClass()!=getClass()) return false;
    	TechSupportGuy tsg = (TechSupportGuy)o;
    	return o.getClass() == getClass() && tsg.getName() == getName() && 
    			tsg.getSurname() == getSurname() && tsg.getMail() == getMail() && tsg.getPhoneNum() == getPhoneNum() &&
    			tsg.getSalary() == getSalary();
    
    }
    
    public void viewAcceptedList() {
        for(int i=0; i<acceptedList.size();++i){
        	System.out.println(acceptedList.get(i).toString());
        }
    }
    
    public void viewNewsTab() throws IOException {
    	super.viewNewsTab();
    	//TODO
    }
    
}
