package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a2u007 {
	
	static final String ERROR_YEAR = "The year must be positive!";
	
	static final String ERROR_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		if (year % 4 != 0) {
			return false;
		}
		else if (year % 100 != 0) {
			return true;
		}
		else if (year % 400 != 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		
		return 0;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int year , startDay, i = 0;
		
		System.out.printf("Enter the year: ");
		year = input.nextInt();
		System.out.printf("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		startDay = input.nextInt();
		
		if (year < 1) {
			System.out.println(ERROR_YEAR);
		}
		if (startDay < 0 || startDay > 6) {
			System.out.println(ERROR_DAY);
		}
		
		
		int months[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		String month[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int numDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		
		
	}

}
