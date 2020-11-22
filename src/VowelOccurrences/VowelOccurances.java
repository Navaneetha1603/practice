package VowelOccurrences;

//Write a program to count the number of occurrences of vowels in the sentence “Actions speak louder than words.”
import java.util.Scanner;

public class VowelOccurances {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("enter string");
		String string = sc.nextLine();
		String validString = validateString(string);
		char charArray[] = getCharArray(validString);
		char arrayOfVowel[] = vowelArr(charArray);
		getVowelOccurrances(arrayOfVowel);
	}

//get vowel occurrances
	//step1:get an ocurrance array ,it will store count of each  distinct vowel.
	//if any vowel is repeated then ,it is replaced with -1 
	private static void getVowelOccurrances(char[] distinctVowelArray) {
		int ocurrance[] = new int[distinctVowelArray.length];
		for (int i = 0; i < distinctVowelArray.length; i++) {
			int count = 1;
			for (int j = i + 1; j < distinctVowelArray.length; j++) {
				if (distinctVowelArray[i] == distinctVowelArray[j]) {
					count++;
					ocurrance[j] = -1;
				}
			}
			if (ocurrance[i] != -1) {
				ocurrance[i] = count;
			}
		}
		for (int i = 0; i < ocurrance.length; i++) {
			if (ocurrance[i] != -1) {
				System.out.println(distinctVowelArray[i]+":"+ocurrance[i]);
			}
		}
	}

	// getting vowel array
	private static char[] vowelArr(char[] charArray) {
		String distinctVowels = "";
		char vowelArray[] = { 'a', 'e', 'i', 'o', 'u' };
		for (int i = 0; i < charArray.length; i++) {
			int vowelCount = 0;
			for (int j = 0; j < vowelArray.length; j++) {
				if (charArray[i] == vowelArray[j]) {
					vowelCount++;
				}
			}
			if (vowelCount == 1) {
				distinctVowels += charArray[i];
			}
		}
		char distinctVowelArray[] = getCharArray(distinctVowels);
		return distinctVowelArray;

	}

	// get charcterArray
	// charArray stores the all lowercase characters
	private static char[] getCharArray(String validString) {
		char charArray[] = new char[validString.length()];
		for (int i = 0; i < charArray.length; i++) {
			char ch = validString.charAt(i);
			if (ch >= 65 && ch <= 90) {
				charArray[i] = (char) ((int) validString.charAt(i) + 32);
			} else {
				charArray[i] = validString.charAt(i);
			}
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
