package FindingZerosInBinary;

import java.util.Scanner;

/*//Write a method named binaryZeros that accepts an integer n as a parameter
and returns the number of zeros that occur in the binary representation of n. 
For example, the call of binaryZeros(44) returns 3 because the binary representation of 44 is 101100,
which contains three zeros. You may assume that n is non-negative.*/
public class FIndNoOfZerosInBinary {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter number:");
		int number = sc.nextInt();
		int validNumber = validateNumber(number);
		int result=getNumberOfZeros(validNumber);
		System.out.println("number of zeros:"+result);
	}
//get number of zeros
	private static int getNumberOfZeros(int validNumber) {
		int zeroCount=0;
		String number="";
		while(validNumber>0)
		{
			int remainder=validNumber%2;
			validNumber=validNumber/2;
			number+=remainder;
			if(remainder==0)
			{
				zeroCount++;
			}	
			
		}
		String binaryNumber=reverseNumber(number);
		System.out.println(binaryNumber);
		return zeroCount;
	}

	private static String reverseNumber(String number) {
		String reNumber="";
		for(int i=number.length()-1;i>=0;i--)
		{
			reNumber+=number.charAt(i);
		}
	
	return reNumber;
}
	// validate number
	private static int validateNumber(int number) {
		boolean isValid = true;
		while (isValid) {
			if (number < 0) {
				System.out.println("Invalid number:once again enter:it should be positive number:");
				number = sc.nextInt();
			} else {
				isValid = false;
			}
		}
		return number;
	}

}
