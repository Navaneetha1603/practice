package MatrixMultiplication;

import java.util.Scanner;

public class MatrixMultiplication {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int row1, row2, col1, col2;
		System.out.println("enter number of rows of first matrix:");
		row1 = sc.nextInt();
		System.out.println("enter number of columns of first matrix:");
		col1 = sc.nextInt();
		System.out.println("enter number of rows of second matrix:");
		row2 = sc.nextInt();
		System.out.println("enter number of columns of second matrix:");
		col2 = sc.nextInt();
		int a[][] = new int[row1][col1];
		int b[][] = new int[row2][col2];
		int mul[][] = new int[row1][col2];
		if (col1 != row2) {
			System.out
					.println("number of columns in first matrix is must be equal to number of rows in second matrix\n");
		} else {
//			first matrix 
			System.out.println("enter elements in first matrix:");
			for (int i = 0; i < row1; i++) {
				for (int j = 0; j < col1; j++) {
					a[i][j] = sc.nextInt();
				}
			}
//			second matrix
			System.out.println("enter elements in second matrix:");
			for (int i = 0; i < row2; i++) {
				for (int j = 0; j < col2; j++) {
					b[i][j] = sc.nextInt();
				}
			}
			// matrix multiplication
			for (int i = 0; i < row1; i++) {
				for (int j = 0; j < col2; j++) {
//					intialize the 0 to all multiplication matrix
					mul[i][j] = 0;
					for (int k = 0; k < col1; k++) {
						mul[i][j] = mul[i][j] + (a[i][k] * b[k][j]);
					}
					System.out.print(mul[i][j] + " ");
				}
				System.out.println();
			}

		}

	}

}
