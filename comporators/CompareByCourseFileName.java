package comporators;

import java.util.Comparator;

import course.Course_File;

public class CompareByCourseFileName implements Comparator<Course_File> {
	@Override
	public int compare(Course_File p1, Course_File p2) {
		return p1.getFileName().compareTo(p2.getFileName());
	}
        
}