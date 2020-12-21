package enums;

public enum Grades {
	A_plus("A+"),
	A_minus("A-"),
	B_plus("B+"),
	B("B"),
	B_minus("B-"),
	C_plus("C+"),
	C("C"),
	C_minus("C-"),
	D_plus("D+"),
	D("D"),
	F("F"),
	NULL("null");
	
	private String sign;
	private static double gpa;
	
	Grades(String sign) {
		this.sign = sign;
	}
	
	public String toString() {
		return sign;
	}
	
	public String getSign() {
		return sign;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public static Grades fromString(String sign) {
        for (Grades b : Grades.values()) {
            if (b.sign.equalsIgnoreCase(sign)) {
                return b;
            }
        }
        return Grades.NULL;  //as default
    }

	public static Grades mark(double gradeDouble) {
		if(gradeDouble<50) {
			gpa = 0.00;
			return Grades.F;
		}else if(gradeDouble>=50 && gradeDouble<55) {
			gpa = 1.00;
			return Grades.D;
		}else if(gradeDouble>=55 && gradeDouble<60) {
			gpa = 1.33;
			return Grades.D_plus;
		}else if(gradeDouble>=60 && gradeDouble<65) {
			gpa = 1.67;
			return Grades.C_minus;
		}else if(gradeDouble>=65 && gradeDouble<70) {
			gpa = 2.00;
			return Grades.C;
		}else if(gradeDouble>=70 && gradeDouble<75) {
			gpa = 2.33;
			return Grades.C_plus;
		}else if(gradeDouble>=75 && gradeDouble<80) {
			gpa = 2.67;
			return Grades.B_minus;
		}else if(gradeDouble>=80 && gradeDouble<85) {
			gpa = 3.00;
			return Grades.B;
		}else if(gradeDouble>=85 && gradeDouble<90) {
			gpa = 3.33;
			return Grades.B_plus;
		}else if(gradeDouble>=90 && gradeDouble<95) {
			gpa = 3.67;
			return Grades.A_minus;
		}else if(gradeDouble>=95 && gradeDouble<100) {
			gpa = 4.00;
			return Grades.A_minus;
		}
		return Grades.NULL;
		
	}
}
