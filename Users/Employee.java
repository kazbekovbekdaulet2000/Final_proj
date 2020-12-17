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
    }
    
    public int compareTo(Object a) {
    	return 0;
    }
    
    public int hashCode() {
    	return super.hashCode();
    }
    
    public boolean equals(Object o) {
    	if(o == null) return false;
    	if(o.getClass()!=getClass()) return false;
    	Employee e = (Employee) o;
    	return super.equals(e) && e.getSalary().equals(getSalary());
    }
    
    @Override
	public String toString() {
		return super.toString() + "\nEmployee salary = " + Salary; //TODO
	}

	public void viewNewsTab() throws IOException {
		super.viewNewsTab();
	}
    
}
