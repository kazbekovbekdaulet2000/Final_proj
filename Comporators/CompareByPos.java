package Comporators;

import java.util.Comparator;

import Users.Teacher;

public class CompareByPos implements Comparator<Teacher> {
	
	@Override
	public int compare(Teacher o1, Teacher o2) {
		return o1.getPos().compareTo(o2.getPos());
	}
        
}