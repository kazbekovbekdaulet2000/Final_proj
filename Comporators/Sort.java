package Comporators;

import java.util.Vector;

import Users.User;

public class Sort<E> {
	static <E> void swap(Vector<E> vec , int i, int j) {  
		E temp = vec.get(i);
		vec.set(i, vec.get(j));
		vec.set(j, temp);
		
	} 
	
	static <E extends Comparable<E>> void quickSort(Vector<E> vec, int l, int r) {
		int i = l;
		int j = r;
		E pos = vec.elementAt((i+j)/2);
		while (i <j){
			while (pos.compareTo(vec.elementAt(i))>0)i++;
		    while (pos.compareTo(vec.elementAt(j))<0)j--;
		    if (i <= j) {
		    	if (i < j) {
		    		swap(vec,i,j);
		        }
		        i++;
		        j--;
		    }
		};
		if(i<r)quickSort(vec, i, r);
		if(l<j)quickSort(vec, l, j);
	}		 
}
