package CheckPresenceOfTriplets;

import java.util.Scanner;

//Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array. 
//Return true if the array does not contain any triples.
public class CheckPresenceOfTriplets {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter size of an array:");
		int size = sc.nextInt();
		int validSize = validateNumber(size);
		System.out.println("enter elements:");
		int array[] = new int[validSize];
		for (int i = 0; i < validSize; i++) {
			array[i] = sc.nextInt();
		}
		boolean result = checkTriplets(array);
		System.out.println(result);
	}

//check triplets
	private static boolean checkTriplets(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if ((i + 2) < array.length) {
				if (array[i] == array[i + 1] && array[i] == array[i + 2]) {
					return false;
				}
			}
		}
		return true;
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
