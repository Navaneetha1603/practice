package WordCount;

/*it is menu driven approach ..to count the number of words and 
number of vowels and also return array of words*/
import java.util.Scanner;

public class WordCount {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int op;
		String validSentence = null;
		do {
			System.out
					.println("Choose an option\n1.Enter the sentence\n2.Count the words\n3.Count the Number of vowels\n"
							+ "4.Return array of words \n5.Exit");
			System.out.println("enter the option\n");
			op = sc.nextInt();
			switch (op) {
			case 1:
				System.out.println("enter sentence:");
				String sentence = sc.nextLine() + sc.nextLine();
				validSentence = validateString(sentence);
				System.out.println("length" + validSentence.length());
				break;
			case 2:
				// int count = getCountWords(validSentence);
				String wordsArray[] = getArrayOfWords(validSentence);
				int count = getCountOfWords(wordsArray);
				System.out.println("Number of words:" + count);
				break;
			case 3:
				int vowelCount = getVowelCount(validSentence);
				System.out.println("number of vowels:" + vowelCount);
				break;
			case 4:
				System.out.println("array of words");
				String array[] = getArrayOfWords(validSentence);
				for (int i = 0; i < array.length; i++) {
					if(array[i]!="") {
					System.out.println(array[i]);}
				}
				break;
			case 5:
				break;
			default:
				System.out.println("Invalid Option\n");
			}
		} while (op != 5);
	}

	public static int getCountOfWords(String[] array) {

		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i]!="") {
				count++;
			}
		}
		return count;
	}

	private static String[] getArrayOfWords(String validSentence) {
		int wordsCount = getCountWords(validSentence);
		String word = "";
		String wordsArray[] = new String[wordsCount];
		// words array index
		int i = 0;
		for (int j = 0; j < validSentence.length(); j++) {
			// if space is found in sentence then words will store in to wordsArray
			if (validSentence.charAt(j) == ' ') {
				wordsArray[i] = word;
				i++;
				word = "";
			}
			// otherwise it is append to words
			else {
				word += validSentence.charAt(j);
			}
		}
		// this is for storing last word in wordsArray
		wordsArray[i] = word;
		return wordsArray;
	}

	// get number of vowel from the sentence
	private static int getVowelCount(String validSentence) {
		int count = 0;
		for (int i = 0; i < validSentence.length(); i++) {
			char ch = validSentence.charAt(i);
			if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'a' || ch == 'e' || ch == 'i'
					|| ch == 'o' || ch == 'u') {
				count++;
			}
		}
		return count;
	}

	// get count the words from the sentence
	private static int getCountWords(String validSentence) {
		int count = 1;
		// if string contain the space then it is end of the word.
		for (int i = 0; i < validSentence.length(); i++) {
			if (validSentence.charAt(i) == ' ') {
				count++;
			}
		}
		return count;
	}

	// validate the string
	private static String validateString(String sentence) {
		boolean isValid = true;
		while (isValid) {
			int count = 0;
			for (int i = 0; i < sentence.length(); i++) {
				// int ch = (int) (s.charAt(i));
				char ch = sentence.charAt(i);
				// it is used to check uppercase and lowercase and also space
				if (ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122 || ch == 32) {
					count++;
				}
			}
			if (count != sentence.length() || sentence.length() < 3) {
				System.out.println("invalid input:once again enter");
				sentence = sc.next();
			} else {
				isValid = false;
			}

		}
		return sentence;
	}
}
