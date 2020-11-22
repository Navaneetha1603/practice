package RepeatedStingBynumber;

/*Given a string and a non-negative int n, 
we'll say that the front of the string is the first 3 chars, or whatever is there if the string is less than length 3. Return n copies of the front;
*/
import java.util.Scanner;

public class RepeatedStringByNUmber {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter string:");
		String string = sc.next();
		String validString = validateString(string);
		System.out.println("enter number of times it is repeated:");
		int number = sc.nextInt();
		int validNumber = validateNumber(number);
		String result = getRepeatedString(validString, validNumber);
		System.out.println(result);

	}

	// get repeated string
	private static String getRepeatedString(String validString, int validNumber) {
		// newString stores getting first three characters from the given string
		String newString = "";
		String repeatedString = "";
		if (validString.length() <= 3) {
			for (int i = 0; i < validString.length(); i++) {
				newString += validString.charAt(i);
			}
		} else {
			for (int i = 0; i < 3; i++) {
				newString += validString.charAt(i);
			}
		}
		// repeatedString stores 3 times of the newString
		for (int i = 0; i < validNumber; i++) {
			repeatedString += newString;

		}
		return repeatedString;
	}

	// validate the string
	private static String validateString(String string) {

		boolean isValid = true;
		while (isValid) {
			int count = 0;
			for (int i = 0; i < string.length(); i++) {
				char ch = string.charAt(i);
				if (ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122) {
					count++;
				}
			}
			if (count != string.length()) {
				System.out.println("invalid input:once again enter");
				string = sc.next();
			} else {
				isValid = false;
			}
		}
		return string;
	}

	// validate size of an array
	private static int validateNumber(int size) {
		boolean isValid = true;
		while (isValid) {
			if (size <= 0 || size >= 30) {
				System.out.println("invalid input:\nit should not contain negative numbers:once again enter:");
				size = sc.nextInt();
			} else {
				isValid = false;
			}
			
		}
		return size;
	}
}
