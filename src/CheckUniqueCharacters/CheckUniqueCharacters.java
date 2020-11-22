package CheckUniqueCharacters;

import java.util.Scanner;

//method in java to determine if a string has unique characters or not.
public class CheckUniqueCharacters {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter string");
		String string = sc.nextLine();
		String validString = validateString(string);
		char charArray[] = getCharArray(validString);
		boolean result = checkUniqueCharacter(charArray);
		String result1 = (result == true) ? "yes,it has unique elements" : "No Unique elements";
		System.out.println(result1);
	}
	
	private static boolean checkUniqueCharacter(char[] charArray) {
		String uniqueElements = "";
		for (int i = 0; i < charArray.length; i++) {
			int count = 0;
			for (int j = 0; j < charArray.length; j++) {
				if (charArray[i] == charArray[j]) {
					count++;
				}
			}
			if (count == 1) {
				uniqueElements += charArray[i];
			}
		}
		//uniqueElements length is greater than 0.it means has unique elements
		if(uniqueElements.length()>0) {
			System.out.println("unique elements:" + uniqueElements);
			return true;
		}
		return false;
	}

	// get charcter array
	private static char[] getCharArray(String validString) {
		char charArray[] = new char[validString.length()];
		for (int i = 0; i < charArray.length; i++) {
			charArray[i] = validString.charAt(i);
		}
		return charArray;
	}

	// validate string
	private static String validateString(String string) {
		boolean isValid = true;
		while (isValid) {
			int count = 0;
			for (int i = 0; i < string.length(); i++) {
				// int ch = (int) (s.charAt(i));
				char ch = string.charAt(i);
				if (ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122 || ch == 32) {
					count++;
				}
			}
			if (count != string.length() || string.length() < 3) {
				System.out.println("invalid input:once again enter");
				string = sc.nextLine();
			} else {
				isValid = false;
			}

		}
		return string;
	}

}
