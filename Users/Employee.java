package Users;

import java.io.IOException;
import java.io.Serializable;

import project.DataBase;

public class Employee extends User implements Serializable {
    
    private Integer Salary;

    public Employee() {}
    
    public Employee(String mail,String firstname,String lastname,String phoneNum,int salary) {
    	super(mail,firstname,lastname,phoneNum);
    	this.Salary = salary;
    }
    
    public Integer getSalary() {
        return this.Salary;
    }
    
    public void setSalary(Integer Salary) {
        this.Salary = Salary;
    }

    //                          Operations                                  
    
    public Object clone() {
    	return super.clone();
        //TODO
    }
    
    public int compareTo(Object a) {
    	return 0;
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
    
    @Override
	public String toString() {
		return super.toString() + "\nEmployee salary = " + Salary; //TODO
	}

	public void viewNewsTab() throws IOException {
		super.viewNewsTab();
	}
    
}
