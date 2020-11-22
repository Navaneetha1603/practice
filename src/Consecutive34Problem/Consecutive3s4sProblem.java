package Consecutive34Problem;

import java.util.Scanner;

/*Return an array that contains exactly the same numbers as the given array,
but rearranged so that every 3 is immediately followed by a 4. Do not move the 3's, 
but every other number may move. The array contains the same number of 3's and 4's, 
every 3 has a number after it that is not a 3, and a 3 appears in the array before any 4.*/
public class Consecutive3s4sProblem {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter size of an array:");
		int size = sc.nextInt();
		int validSize = validateSize(size);
		// array creation
		int threeCount = 0;
		int fourCount = 0;
		int array[] = new int[validSize];
		System.out.println("enter elements:");
		for (int i = 0; i < validSize; i++) {
			array[i] = sc.nextInt();
			if (array[i] == 3) {
				threeCount++;
			}
			if (array[i] == 4) {
				fourCount++;
			}
		}
		// check whether the array has equal number of 3 and 4
		if (threeCount == fourCount) {
			if (threeCount == 0 && fourCount == 0) {
				System.out.println("it should contain at least one pair of 3 and 4");
			} else {
				int resultArray[] = getConsecutivesOf3And4(array);
				for (int i = 0; i < resultArray.length; i++) {
					System.out.print(resultArray[i] + " ");
				}
			}
		} else {
			System.out.println("array should have equal number of 3's and 4's");
		}
	}

//consecutive threes and fours
	private static int[] getConsecutivesOf3And4(int[] array) {
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if ((i + 1) < array.length) {
				if (array[i] == 3) {
					// j loop starts from where the first 4 ends
					for (int j = k; j < array.length; j++) {
						if (array[j] == 4) {
							int temp = array[j];
							array[j] = array[i + 1];
							array[i + 1] = temp;
							k = j;
						}
					}
				}
			}
		}
		return array;
	}

	// validate element
	private static int validateSize(int element) {
		boolean isValid = true;
		while (isValid) {
			if (element < 0) {
				System.out.println("invalid input:\nit should not contain negatives\nplz once agin enter:");
				element = sc.nextInt();
			} else {
				isValid = false;
			}
		}
		return element;
	}
}
