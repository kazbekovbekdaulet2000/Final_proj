package Comporators;

import java.util.Comparator;

import Users.User;

public class CompareByName implements Comparator<User> {
	
	@Override
	public int compare(User p1, User p2) {
		if (p1.getSurname().compareTo(p2.getSurname())!=0)
		   return p1.getSurname().compareTo(p2.getSurname());
		else return p1.getName().compareTo(p2.getName());
	}
        
}
