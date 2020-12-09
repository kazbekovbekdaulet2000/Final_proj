package Users;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

import project.Order;

public class TechSupportGuy extends Employee {
    
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
    
    public boolean equals(Object a) {
    	return false;
        //TODO
    }
    
    public void viewAcceptedList() {
        //TODO
    }
    
    public void viewNewsTab() {
        //TODO
    }
    
}
