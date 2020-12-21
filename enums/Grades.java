package enums;

public enum Grades {
	A_plus("A+"),
	A_minus("A-"),
	B_plus("B+"),
	B("B"),
	B_minus("B-"),
	C_plus("C+"),
	C("C"),
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
			return Grades.D;
		}
		return Grades.NULL;
		
	}
}
