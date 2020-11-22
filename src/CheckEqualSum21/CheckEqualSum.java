package CheckEqualSum21;

import java.util.Scanner;

//Given a non-empty array, return true if there is a place to split the array 
//so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
public class CheckEqualSum {
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
		boolean result = checkEqualSum(array);
		System.out.println(result);
	}

	// check equal sum when if the array split in to two parts
	// step:1-> index i starts from left to right of the array and j is starts from
	// right to left
	// step2-> if leftsum==rightsum then both indexes are incremented
	// step3->if leftsum<rightsum only i is incremented otherwise j is incremented
	// step:4->these steps are repeated until the i+1 is equal to j .
	private static boolean checkEqualSum(int[] array) {
		int i = 0;
		int length = array.length;
		int j = length - 1;
		int leftSum = 0;
		int rightSum = 0;
		int flag = 0;

		// for(i=0,j=length-1;i<length && j>=0;i++,j--)
		//if array contain two elements
		if (array.length == 2) {
			if (array[0] == array[1]) {
				return true;
			} else {
				return false;
			}
		} else {
			while (i < length) {
				if (leftSum == rightSum) {
					if ((i + 1) == j || (i - 1) == j) {
						flag = 1;
						break;
					} else {
						leftSum += array[i];
						rightSum += array[j];
						i++;
						j--;
					}
				} else if (leftSum < rightSum) {
					leftSum += array[i];
					i++;
				} else {
					rightSum += array[j];
					j--;
				}
			}
			if (flag == 1) {
				return true;
			}
		}
		return false;
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
