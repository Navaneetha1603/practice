package SuperiorELeIndexInMatrix;

import java.util.Scanner;

/*Write a java program to display the index position of superior element of a matrix. 
The program should take input matrix of non negative integer elements from the user, 
display the matrix and display the index position of superior element of that matrix. 
While checking for the largest element,
if the largest element is duplicate either in row or column, 
consider the first duplicate element index position for superior element consideration.*/

public class SuperiorELeIndexInMatrix {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter rows and column of the given matrix:");
		int rows = sc.nextInt();
		int validRows = validateInt(rows);
		int col = sc.nextInt();
		int validCols = validateInt(col);
		// matrix creation
		int max = -99;
		int newIthindex = 0;
		int newJthIndex = 0;
		int matrix[][] = new int[validRows][validCols];
		System.out.println("enter matrix elements:");
		for (int i = 0; i < validRows; i++) {
			for (int j = 0; j < validCols; j++) {
				int element = sc.nextInt();
				int validEle = validateEle(element);
				matrix[i][j] = validEle;
				if (max < matrix[i][j]) {
					max = matrix[i][j];
					newIthindex = i;
					newJthIndex = j;
				}
			}
		}
		System.out.println("Superior element is =" + max + " and it is found at the index:(" + newIthindex + ","
				+ newJthIndex + ")");
	}

//validate element
	private static int validateEle(int element) {
		boolean isValid = true;
		while (isValid) {
			if (element < 0) {
				System.out.println("invalid input:\nit should not contain negatives\nplz once agin enter:");
				element = sc.nextInt();
			} else {
				isValid = false;
			}
			
		}
		return element;
	}

	// validate integer
	private static int validateInt(int rows) {
		boolean isValid = true;
		while (isValid) {
			if (rows <= 0 || rows > 10) {
				System.out.println("invalid input:\nit should not contain negatives\nplz once agin enter:");
				rows = sc.nextInt();
			} else {
				isValid = false;
			}
		}
		return rows;
	}

}
