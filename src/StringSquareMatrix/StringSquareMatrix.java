package StringSquareMatrix;

/*String Square Matrix: Write a program to find a string in a matrix.
 Write a menu driven program to implement the following:
a) Give an option to get the dimensions for a square matrix.
b) Give an option to fill the matrix with characters.
c) Given an option to get a string from the user.
The program should search the input string in the matrix. 
The string should be searched in all the rows, all the columns and all the diagonals ( left to right ).

*/
import java.util.Scanner;

public class StringSquareMatrix {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		int op;
		int validDimension = 0;
		char matrix[][] = null;
		do {
			System.out.println("choose an option:\n1.Dimension for a matrix\n2.Fill the matrix with characters\n"
					+ "3.Search the String\n4.Exit\n");
			System.out.println("enter an option:");
			op = sc.nextInt();
			switch (op) {
			case 1:
				System.out.println("enter the size of the square matrix:");
				int dimension = sc.nextInt();
				validDimension = validateDim(dimension);
				break;
			case 2:
				System.out.println("enter characters:");
				// matrix creation
				matrix = new char[validDimension][validDimension];
				for (int i = 0; i < validDimension; i++) {
					for (int j = 0; j < validDimension; j++) {
						matrix[i][j] = sc.next().charAt(0);
					}
				}
				break;
			case 3:
				boolean result = checkStringInMatrix(matrix);
				String checkString = (result == true) ? "String is found" : "String is not found";
				System.out.println(checkString);
				break;
			case 4:
				break;
			default:
				System.out.println("invalid option:");

			}
		} while (op != 4);
	}

	private static boolean checkStringInMatrix(char[][] matrix) {
		System.out.println("enter search string:");
		String searchString = sc.next();
		String rowWord = "";
		String columnWord = "";
		String diagonalWord = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				// diagonalWord
				if (i == j) {
					diagonalWord += matrix[i][j];
				}
				// rowwords
				rowWord += matrix[i][j];
				// columnWord
				columnWord += matrix[j][i];
			}
			if (rowWord.equalsIgnoreCase(searchString) || columnWord.equalsIgnoreCase(searchString)
					|| diagonalWord.equalsIgnoreCase(searchString)) {
				diagonalWord = "";
				return true;
			}
			rowWord = "";
			columnWord = "";
		}
		return false;
	}

	// validate dimension
	private static int validateDim(int dimension) {
		boolean isValid = true;
		while (isValid) {
			if (dimension <= 0 || dimension >= 10) {
				System.out.println(
						"invalid input:it should not be negative number and also more than 10:once again enter");
				dimension = sc.nextInt();
			} else {
				isValid = false;
			}
		}
		return dimension;
	}

	// validate the strings
	private static String validateString(String string) {
		boolean isValid = true;
		while (isValid) {
			int count = 0;
			for (int i = 0; i < string.length(); i++) {
				char ch = string.charAt(i);
				// ascii values for uppercase and lower case letters
				if (ch >= 65 && ch <= 90 || ch >= 97 && ch <= 122) {
					count++;
				}
			}
			if (count != string.length() || string.length() < 3) {
				System.out.println("invalid string :plz once again enter:");
				string = sc.next();
			} else {
				isValid = false;
			}
		}
		return string;
	}

}
