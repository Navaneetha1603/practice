package CircularStrings;
// program to form distinct circular strings of a given length from a given string.

import java.util.Scanner;

public class CircularStrings {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// input from user
		System.out.println("enter the string:");
		String string = sc.next();
		String validString = validateString(string);
		System.out.println("enter number of character that distinct strings form:");
		int number = sc.nextInt();
		int validNumber = validateInt(number);
		String resultArray[] = getCircularStrings(validString, validNumber);
		// displaying the resultArray
		for (int i = 0; i < resultArray.length; i++) {
			System.out.println(resultArray[i]);
		}
	}

//get circular strings based on number of characters
//DESCRIPTION OF LOGIC
	/*
	 * 1.j is for resultArray index(it is starts from 0 to length of the validString
	 * 2.validStirng=aabc and valid number =3 3.ch string stores the character which
	 * is the length less than the validnumber 4. ch =aa 5.newstring stores the
	 * validString and also ch string 6.newstring=aabcaa 7. if the word length
	 * reaches to validnumber then it will store in the resultArray and once it is
	 * stored ,we need to decrement the i to validnumber-1
	 */
	private static String[] getCircularStrings(String validString, int validNumber) {
		String resultArray[] = new String[validString.length()];
		String word = "";
		String ch = "";
		int j = 0;
		for (int i = 0; i < validNumber - 1; i++) {
			ch += validString.charAt(i);
		}
		String newString = validString + ch;
		for (int i = 0; i < newString.length(); i++) {
			word += newString.charAt(i);
			if (word.length() == validNumber) {
				resultArray[j] = word;
				j++;
		   		word = "";
				i = i - (validNumber - 1);
			}
		}
		return resultArray;
	}

//validate the number
	private static int validateInt(int number) {
		boolean isValid = true;
		while (isValid) {
			if (number <= 0 || number >= 20) {
				System.out.println("invalid input:number must be positive number:once again enter");
				number = sc.nextInt();
			} else {
				isValid = false;
			}
		}
		return number;
	}

	// validate the strings
	private static String validateString(String string) {
		boolean isValid = true;
		while (isValid) {
			int count = 0;
			for (int i = 0; i < string.length(); i++) {
				char ch = string.charAt(i);
				// ascii values for uppercase and lower case letters
				if (ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122) {
					count++;
				}
			}
			if (count != string.length() || string.length() < 3) {
				System.out.println("invalid string :plz once again enter:");
				string = sc.next();
			} else {
				isValid = false;
			}
		}
		return string;
	}

}
