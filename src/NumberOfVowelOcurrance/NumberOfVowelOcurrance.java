package NumberOfVowelOcurrance;

import java.util.Scanner;

public class NumberOfVowelOcurrance {
	static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("enter string");
		String string = sc.nextLine();
		String validString = validateString(string);
		char charArray[] = getCharArray(validString);
		int count=getVowelOcurrence(charArray);
		System.out.println("count of number of ocurrences of the vowels:"+count);

	}

//getVowelOcurrence

	private static int getVowelOcurrence(char[] charArray) {
		int vowelCount=0;
		for(int i=0;i<charArray.length;i++)
		{
			char ch=charArray[i];
			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
			{
				vowelCount++;
			}
		}
		return vowelCount;
	}



	// get charcterArray
		// charArray stores the all lowercase characters
		private static char[] getCharArray(String validString) {
			char charArray[] = new char[validString.length()];
			for (int i = 0; i < charArray.length; i++) {
				char ch = validString.charAt(i);
				if (ch >= 65 && ch <= 90) {
					charArray[i] = (char) ((int) validString.charAt(i) + 32);
				} else {
					charArray[i] = validString.charAt(i);
				}
			}
			return charArray;
		}

		// validate string
		private static String validateString(String string) {
			boolean isValid = true;
			while (isValid) {
				int count = 0;
				for (int i = 0; i < string.length(); i++) {
					// int ch = (int) (s.charAt(i));
					char ch = string.charAt(i);
					if (ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122 || ch == 32) {
						count++;
					}
				}
				if (count != string.length() || string.length() < 3) {
					System.out.println("invalid input:once again enter");
					string = sc.nextLine();
				} else {
					isValid = false;
				}

			}
			return string;
		}
}
