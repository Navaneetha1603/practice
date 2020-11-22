package CalculateIncomeTax;

import java.util.Scanner;

//calculating the income tax of an employee based on given criteria
public class CalculateIncomeTax {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("enter rupees earning by employee:");
		long salary = sc.nextLong();
		long validSalary = validateSalary(salary);
		long result = getIncomeTax(validSalary);
		System.out.println("income tax is:" + result);

	}
//get income tax
	/*
	 * Slab rate IT rate Upto Rs. 50,000 Nil Upto Rs. 60,000 10% on additional
	 * amount Upto Rs. 1,50,000 20% on additional amount Above Rs. 1,50,000 30% on
	 * additional amount
	 */
	private static long getIncomeTax(long validSalary) {
		long incomeTax;
		if (validSalary <= 50000) {
			incomeTax = 0;
		} else if (validSalary > 50000 && validSalary <= 60000) {
			incomeTax = (long) (validSalary * (0.1));
		} else if (validSalary > 60000 && validSalary <= 150000) {
			incomeTax = (long) (validSalary * (0.2));
		} else {
			incomeTax = (long) (validSalary * (0.3));
		}
		return incomeTax;
	}

	// validate salary
	private static long validateSalary(long salary) {
		boolean isValid = true;
		while (isValid) {
			if (salary <= 0) {
				System.out.println("invalid input:once again enter:it should not be negative number:");
				salary = sc.nextLong();
			} else {
				isValid = false;
			}
		}
		return salary;
	}

}
