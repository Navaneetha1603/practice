package FindingMirrorOfStringArray;

//Write a method mirror that accepts an Array of Strings as a parameter and produces a mirror copy of the list as output, 
//with the original values followed by those same values in the opposite order.
import java.util.Scanner;

public class MirrorOfStringArray {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter the size of string array:");
		int size = sc.nextInt();
		int validSize = validateSize(size);
		// string array creation
		String array[] = new String[validSize];
		System.out.println("enter words:");
		for (int i = 0; i < validSize; i++) {
			String word = sc.next();
			String validWord = validateString(word);
			array[i] = validWord;
		}
		String resultArray[] = getMirrorStringArray(array);
		// displaying result array
		for (int i = 0; i < resultArray.length; i++) {
			System.out.print(resultArray[i] + " ");
		}
	}

	// get mirror string array
	private static String[] getMirrorStringArray(String[] array) {
		String mirrorStringArray[] = new String[2 * array.length];
		for (int i = 0; i < mirrorStringArray.length; i++) {
			// length of the mirrorStringArray is more than the array length.then
			// the reverse input array is added to the mirrorStringArray
			// otherwise directly append to the mirrorStringArray
			if (i >= array.length) {
				for (int j = array.length - 1; j >= 0; j--) {
					mirrorStringArray[i++] = array[j];
				}
			} else {
				mirrorStringArray[i] = array[i];
			}
		}
		return mirrorStringArray;
	}

	// validate string
	public static String validateString(String string) {
		boolean isValid = true;
		while (isValid) {
			int count = 0;
			for (int i = 0; i < string.length(); i++) {
				// int ch = (int) (s.charAt(i));
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
	private static int validateSize(int size) {
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
