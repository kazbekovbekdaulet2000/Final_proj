package comporators;

import java.util.Comparator;

import users.Student;

public class CompareByGPA implements Comparator<Student>{
	public int compare(Student s1, Student s2) {
		return (Double.valueOf(s1.getGpa())).compareTo(Double.valueOf(s2.getGpa()));
	}

}
