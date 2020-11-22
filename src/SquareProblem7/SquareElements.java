package SquareProblem7;

import java.util.Scanner;

//program that should print squares of natural numbers (1,2….10) the square should not go beyond 100, &
//array size should not store more than 10 elements. Generate exception if range overflow.

public class SquareElements {
	public static void main(String[] args) {
		int array[]=new int[10];
		int j=0;
		for(int i=1;i<=11;i++)
		{
			array[j]=(i*i);
			System.out.println(array[j]);
			j++;
			if(i>=10)
			{
				System.out.println("Range overflow");
			}
			
		}
		
	}

}
