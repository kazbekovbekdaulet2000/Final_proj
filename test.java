import java.util.HashMap;

import course.Course;
import course.Course_File;
import course.Mark;
import project.Auth;

public class test {
	public static void main(String[] args) {   
		Auth auth = Auth.getInstance();
		auth.authorize();
//		HashMap<String, String> a = new HashMap<>();
//		a.put("lol", "lol");
//		System.out.println(a.size());
	}

}
