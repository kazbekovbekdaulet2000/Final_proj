package comporators;

import java.util.Comparator;

import users.Teacher;

public class CompareByPos implements Comparator<Teacher> {
	
	@Override
	public int compare(Teacher o1, Teacher o2) {
		if (o1.getPos().ordinal()<o2.getPos().ordinal())
			return 1;
		else if (o1.getPos().ordinal()>o2.getPos().ordinal())
			return -1;
		else 
			return 0;
	}
        
}