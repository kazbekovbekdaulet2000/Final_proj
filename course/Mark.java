package course;

import java.io.Serializable;

import enums.Grades;

public class Mark implements Serializable, Comparable {
    
    private double firstAtt;
    private double secondAtt;
    private double finalgrade;
    private Grades grade;
    
    private final double limit_att = 30;
    private final double limit_final = 40; 
    
    
    public Mark() {
    	this.firstAtt = 0;
    	this.secondAtt = 0;
    	this.finalgrade = 0;
    	this.grade = Grades.NULL;
    }
    
    public Mark(double first, double sec, double fin) {    //I think wrong concept because teachers never put all marks together
    	this.firstAtt = first;
    	this.secondAtt = sec;
    	this.finalgrade = fin;
    	this.grade = Grades.mark(first+sec+fin);
    }
    
    public double getFirstAtt() {
		return firstAtt;
	}
	public void setFirstAtt(double first) {
		if(first>limit_att && first<0)
			return;
		this.firstAtt = first;
	}
	public double getSecondAtt() {
		return secondAtt;
	}
	public void setSecondAtt(double second) {
		if(second > limit_att && second<0)
			return;
		this.secondAtt = second;
	}
	public double getFinalgrade() {
		return finalgrade;
	}
	public void setFinalgrade(double final_mark) {
		if(final_mark > limit_final && final_mark<0)
			return;
		this.finalgrade = final_mark;
	}
	
    //  Operations 
	
	
    public boolean equals(Object a) {
    	if(a ==null)
    		return false;
    	if(getClass()!=a.getClass())
    		return false;
    	Mark m = (Mark) a;
    	return this.firstAtt == m.getFirstAtt() && this.secondAtt == m.getSecondAtt() &&
    			this.finalgrade == m.getFinalgrade();
    }
    @Override
	public String toString() {
		return "First attestation = " + firstAtt + ", Second attestation = " + secondAtt + ", Final exam = " + finalgrade
				+ ", Grade = " + (firstAtt + secondAtt + finalgrade) + ", Letter grade = " + stringfinalGrade.toString();
	}
    
    
    public int hashCode() {
    	return 0;
        //TODO
    }
    /**
    * @generated
    */
    public int compareTo(Object a){
    	return 0;
        //TODO
    }
    
}
