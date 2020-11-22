package PercentageOfEmailAddress;

import java.util.Scanner;

/*
Implement a java program to find the percentage of uppercase letters,
lowercase letters and digits in a given input email address. 
Validation for input email address is that it should consist of an email prefix and a email domain. 
The prefix appears to the left of the @ symbol, and the domain appears to the right of the @ symbol.*/
public class PercentageOfEmailAddress {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter email address:");
		String email = sc.next();
		String validEmail = validateEmail(email);
		int count = getCount(validEmail);
//		System.out.println(count);
		/*
		 * float upperCasePercentage=getpercentageOfUpperCase(validEmail,count); float
		 * lowerCasePercentage=getpercentageOfLowerCase(validEmail,count); float
		 * digitPercentage=getpercentageOfDigits(validEmail,count);
		 */
		float resultArray[] = getPercentages(validEmail, count);
		System.out.println("UpperCase letters Percentage:" + resultArray[0]+"%");
		System.out.println("LowerCase letters Percentage:" + resultArray[1]+"%");
		System.out.println("Digits Percentage:" + resultArray[2]+"%");

	}

	private static float[] getPercentages(String validEmail, int count) {
		float percentageArray[] = new float[3];
		int upperCount = 0;
		int lowerCount = 0;
		int digitCount = 0;
		int count1 = 0;
		for (int i = 0; i < validEmail.length(); i++) {
			if (validEmail.charAt(i) >= 65 && validEmail.charAt(i) <= 90) {
				upperCount++;
			} else if (validEmail.charAt(i) >= 97 && validEmail.charAt(i) <= 122) {
				lowerCount++;
			} else if (validEmail.charAt(i) >= 48 && validEmail.charAt(i) <= 57) {
				digitCount++;
			} else {
				count1++;
			}
		}
		// percentage array
		percentageArray[0] = (upperCount * 100) / count;
		percentageArray[1] = (lowerCount * 100) / count;
		percentageArray[2] = (digitCount * 100) / count;

		return percentageArray;
	}

	/*
	 * //lowercase letters percentage private static float
	 * getpercentageOfLowerCase(String validEmail, int count) { float percentage;
	 * //lowercase letters count int count1=0; for(int
	 * i=0;i<validEmail.length();i++) { if(validEmail.charAt(i)>=97 &&
	 * validEmail.charAt(i)<=122) { count1++; } } percentage=(count1*100)/count;
	 * return percentage; } //digits percentage private static float
	 * getpercentageOfDigits(String validEmail, int count) {
	 * 
	 * float percentage; //digits letters count int count1=0; for(int
	 * i=0;i<validEmail.length();i++) { if(validEmail.charAt(i)>=65 &&
	 * validEmail.charAt(i)<=90) { count1++; } } percentage=(count1*100)/count;
	 * return percentage; } //uppercase letters percentage private static float
	 * getpercentageOfUpperCase(String validEmail, int count) { float percentage;
	 * //uppercase letters count int count1=0; for(int
	 * i=0;i<validEmail.length();i++) { if(validEmail.charAt(i)>=48 &&
	 * validEmail.charAt(i)<=57) { count1++; } } percentage=(count1*100)/count;
	 * return percentage; }
	 */
	// get count
	private static int getCount(String validEmail) {
		int count = 1;
		for (int i = 0; i < validEmail.length(); i++) {
			char ch = validEmail.charAt(i);
			if (ch >= 48 && ch <= 57 || ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122) {
				count++;
			}
		}
		return count;
	}

	// validate email
	private static String validateEmail(String email) {
		while (!email.matches("^[a-zA-Z0-9-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,4}$")) {
			System.out.println("invalid input\n once again enter:");
			email = sc.next();
		}
		return email;
	}
}
