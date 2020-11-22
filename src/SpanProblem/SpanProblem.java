package SpanProblem;

import java.util.Scanner;
//Consider the leftmost and rightmost appearances of some value in an array.
//We'll say that the "span" is the number of elements between the two inclusive. Print the sum of the span found in the error
public class SpanProblem {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("enter size of an array:");
		int size = sc.nextInt();
		int validSize = validateNumber(size);
		System.out.println("enter elements:");
		int array[] = new int[validSize];
		for (int i = 0; i < validSize; i++) {
			array[i] = sc.nextInt();
		}
		int result=getSpanSum(array);
		System.out.println(result);

	}
	//getSpanSum
	private static int getSpanSum(int[] array) {
		int sum=0;
		for(int i=1;i<array.length-1;i++)
		{
			sum+=array[i];
		}
		return sum;
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
