package SmallestMultiplesOf1s;

import java.util.Scanner;

//take one integer and find out the smallest multiples of 1s sequence
public class SmallestMultiplesOfOnes {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter the number:");
		long number = sc.nextLong();
		long validNumber = validateNumber(number);
		long result = ones(validNumber);
		System.out.println(result);
		if(result<1)
		{
			System.out.println("Not found:");
		}

	}

	/*
	 * private static long ones(long validNumber) { long result=1; String
	 * onesCount=""; while(validNumber>0) { if(result%validNumber==0) {
	 * System.out.println("1s sequence:"+result); onesCount+=result; break; } else {
	 * result=result*10+1; }
	 * 
	 * } return onesCount.length(); }
	 */
//return the smallest multiple of ones sequence
	private static long ones(long validNumber) {
		long result=1;
		String onesCount="";
		while(validNumber>0)
		{
			if(result%validNumber==0)
			{
				System.out.println("1s sequence:"+result);
				onesCount+=result;
				break;
			}
			else
			{
				result=result*10+1;
			}
			
		}
		return onesCount.length();
	}

//	validate number which is in between 0 to 10000 and not divisible by 2 or 5
	private static long validateNumber(long number) {
		boolean isValid = true;
		while (isValid) {
			if (number < 0 || number > 10000) {
				System.out.println("invalid input:it must be between 0 to 10000 :once again enter:");
				number = sc.nextLong();
			} else {
				if (number % 2 == 0 || number % 5 == 0) {
					System.out.println("inalid input:It should not be divisible by 2 or 5:once again enter");
					number = sc.nextLong();
				} else {
					isValid = false;
				}
			}

		}

		return number;
	}

}
