package ShuffleCharacters;

import java.util.Scanner;

public class ShuffleCharacters {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Step 1: read the input from the user
		System.out.println("enter string:");
		String word = sc.next();
		String validWord = getValidString(word);
		String resultWord = getShuffleCharacters(validWord);
		System.out.println("final string:" + resultWord);
	}

//get valid string
	private static String getValidString(String word) {
		boolean isValid = true;
		while (isValid) {
			int count = 0;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122) {
					count++;
				}
			}
			if (count != word.length() || word.length() < 3) {
				System.out.println("invalid input:once again enter");
				word = sc.next();
			} else {
				isValid = false;
			}
		}
		return word;
	}

	private static String getShuffleCharacters(String word) {
		// calculate the length of the string
		int length = word.length();
		int j = 0;
		int lastchar = length - 1;
		String result = "";
		int midChar = (0 + length - 1) / 2;

		for (int i = 0; i < length - 1; i++) {
			// adding forward characters to the result
			if (j >= 0) {
				char ch = word.charAt(j);
				char ch1 = 0;
				// char ch1=checkingChar(word,ch);
				// char ch1=getLowerChar(ch);
				//if it is upper case letter then it is convert in to lowercase
				if (ch >= 65 && ch <= 90) {
					ch1 = getLowerChar(ch);
				} else {
					ch1 = ch;
				}
				result = result + ch1;
				j++;
			}
			if (lastchar == midChar) {
				break;
			}
			// appending backward characters to the result
			if (lastchar >= 0) {
				char ch = word.charAt(lastchar);
				char ch1 = getUpperChar(ch);
				// char ch1=checkingChar(word,ch);
				result = result + ch1;
				lastchar--;
			}
			// if ith index is equal to mid character then it should break the loop
			if (i == midChar) {
				break;
			}
		}
		return result;
	}

//checking letters
	private static char checkingChar(String word, char ch) {
		char ch1;
		if (ch >= 65 && ch <= 90) {
			ch1 = getLowerChar(ch);
		} else {
			ch1 = getUpperChar(ch);
		}
		return ch1;
	}

	// get upper case letter
	private static char getUpperChar(char ch) {
		return (char) ((int) ch - 32);
	}

//get lowercharacters
	private static char getLowerChar(char ch) {
		return (char) ((int) ch + 32);
	}

}
