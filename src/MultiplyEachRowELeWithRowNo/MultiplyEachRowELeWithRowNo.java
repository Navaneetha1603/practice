package MultiplyEachRowELeWithRowNo;

import java.util.Scanner;

//program to multiple each row of the matrix with the corresponding row number and print the final matrix.

public class MultiplyEachRowELeWithRowNo {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter no or rows and columns of the matrix:");
		int rows = sc.nextInt();
		int validRows = validateInteger(rows);
		int col = sc.nextInt();
		int validCol = validateInteger(col);
		// matrix creation by using rows and cols
		int matrix[][] = new int[validRows][validCol];
		System.out.println("enter matrix elements:");
		for (int i = 0; i < validRows; i++) {
			for (int j = 0; j < validCol; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		int resultArray[][] = new int[validRows][validCol];
		int finalMatrix[][] = getMultipleOfRowMatrix(matrix, resultArray);
		// displaying final matrix
		System.out.println("final matrix:");
		for (int i = 0; i < validRows; i++) {
			for (int j = 0; j < validCol; j++) {
				System.out.print(finalMatrix[i][j] + " ");
			}
			System.out.println();
		}

	}

//multiply each row with corresponding row numer 
	private static int[][] getMultipleOfRowMatrix(int[][] matrix, int[][] resultArray) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				resultArray[i][j] = i * matrix[i][j];
			}
		}
		return resultArray;
	}

	// validate integer
	private static int validateInteger(int rows) {
		boolean isValid = true;
		while (isValid) {
			if (rows <= 0 || rows >= 10) {
				System.out.println(
						"INvalid input:plz once again enter:it should not contain negative numbers and more than 10");
				rows = sc.nextInt();
			} else {
				isValid = false;
			}
		}
		return rows;
	}

}
