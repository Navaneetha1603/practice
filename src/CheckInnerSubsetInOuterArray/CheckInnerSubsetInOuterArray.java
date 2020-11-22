package CheckInnerSubsetInOuterArray;

/*
Given two arrays of ints sorted in increasing order, outer and inner,
return true if all of the numbers in inner appear in outer. The best solution makes only a single "linear" pass of both arrays, 
taking advantage of the fact that both arrays are already in sorted order.*/
import java.util.Scanner;

public class CheckInnerSubsetInOuterArray {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// outer size of an array
		System.out.println("enter size of an outer array:");
		int size = sc.nextInt();
		int validSize = validateNumber(size);
		System.out.println("enter outer array elements:");
		int array[] = new int[validSize];
		for (int i = 0; i < validSize; i++) {
			array[i] = sc.nextInt();
		}
		//sorting outer array
		int sortedArray[] = bubblesort(array);
		// innersize of an array
		System.out.println("enter size of an inner array:");
		int size1 = sc.nextInt();
		int validSize2 = validateNumber(size1);
		System.out.println("enter inner array elements:");
		int array1[] = new int[validSize2];
		for (int i = 0; i < validSize2; i++) {
			array1[i] = sc.nextInt();
		}
		//sorting inner array
		int sortedArray1[] = bubblesort(array1);
		boolean result = findingSubset(sortedArray, sortedArray1);
		System.out.println(result);

	}
	private static boolean findingSubset(int[] innerArray, int[] outerArray) {
		int count = 0;
		for (int i = 0; i < outerArray.length; i++) {
			for (int j = 0; j < innerArray.length; j++) {
				if (outerArray[i] == innerArray[j]) {
					count++;
				}
			}
		}
		if (count >= outerArray.length) {
			return true;
		}
		return false;
	}
//bubble sort
	private static int[] bubblesort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
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
