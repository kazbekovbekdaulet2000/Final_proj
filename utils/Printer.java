package utils;

import java.util.Scanner;

public class Printer {
	public static String input(String text) {
		System.out.print(text);
		Scanner scan = new Scanner(System.in);
		String new_text = scan.nextLine();
		return new_text;
	}
	
	public static void print(String text) {
		System.out.println(text);
	}
}
