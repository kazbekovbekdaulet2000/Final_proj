package comporators;

import java.util.Comparator;

import users.Teacher;

public class CompareByPos implements Comparator<Teacher> {
	
	@Override
	public int compare(Teacher o1, Teacher o2) {
		return o1.getPos().compareTo(o2.getPos());
	}
        
}