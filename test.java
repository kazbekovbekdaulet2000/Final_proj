import course.Course;
import course.Course_File;
import project.Auth;

public class test {
	public static void main(String[] args) {   
		Auth auth = Auth.getInstance();
		auth.authorize();
	}

}
