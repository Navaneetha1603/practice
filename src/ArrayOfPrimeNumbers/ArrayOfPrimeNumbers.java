package ArrayOfPrimeNumbers;

import java.util.Scanner;

//Write a program to find the number of prime numbers in an array and form a new array of prime numbers.
public class ArrayOfPrimeNumbers {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter size of an array:");
		int size = sc.nextInt();
		int count = 0;
		int validSize = validateSize(size);
		int array[] = new int[validSize];
		System.out.println("enter elements:");
		for (int i = 0; i < validSize; i++) {
			array[i] = sc.nextInt();
		}
		int primeArray[] = getPrimeNumberArray(array);
		// displaying array
		for (int i = 0; i < primeArray.length; i++) {
			if (primeArray[i] != 0) {
				count++;
				System.out.print(primeArray[i] + " ");
			}
		}
		System.out.println("\nno of prime numbers are:"+count);
		if (count == 0) {
			System.out.println("No prime Array exist:");
		}
	}

	// getPrimeNUmberArray
	// step1:create primenumber array and then check each element in the input array
	// ,if it is prime number
	// then add to primenumber array.
	private static int[] getPrimeNumberArray(int[] array) {
		int primeArray[] = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			int flag = 0;
			if (array[i] <= 1) {
				flag = 1;
			}
			for (int j = 2; j <= (array[i] / 2); j++) {
				if (array[i] % j == 0) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				primeArray[i] = array[i];
			}
		}
		return primeArray;
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
