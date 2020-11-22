package CircularString;

import java.util.Scanner;

//program to find if two strings are circular of each other.
public class CircularString {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
//		step1:scanning string input from the user 
		System.out.println("enter string 1:");
		String string1 = sc.next();
		//validate the string
		String validstring1 = validateString(string1);
		System.out.println("enter string2:");
		String string2 = sc.next();
		String validstring2 = validateString(string2);
		//check rotation
		boolean result = checkRotation(validstring1, validstring2);
		if (result == true) {
			System.out.println(validstring1 + " and " + validstring2 + " are circular");
		} else {
			System.out.println(validstring1 + " and " + validstring2 + " are not circular");
		}
	}
//checkRotation method (it will return whether
	private static boolean checkRotation(String string1, String string2) {
		if (string1.length() == string2.length()) {
			String string3 = string1 + string1;
			int result = string3.indexOf(string2);
			if (result >= 0) {
				return true;
			}
		}
		return false;
	}
//validate the string
	public static String validateString(String s) {
		boolean isValid = true;
		while (isValid) {
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				// int ch = (int) (s.charAt(i));
				char ch = s.charAt(i);
				if (ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122) {
					count++;
				}
			}
			if (count != s.length() || s.length() < 3) {
				System.out.println("invalid input:once again enter");
				s = sc.next();
			} else {
				isValid = false;
			}

		}
		return s;
	}
}
