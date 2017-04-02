package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a1u018 {

	static final String E_YEAR = "The year must be positive!";

	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	public static boolean isLeapYear(int year) {	
		if (year >= 2000) {
			if (year % 4 != 0) {	
				return false;
			} else {
				return true;
			}

		} else if ((year / 100) % 4 == 0) {	
			return true;
		} else {
			return false;
		}
	}

	public static int printMonth(String month, int startDay, int numDays) {	
		System.out.println(month);
		for (int i = 0; i < startDay; i++) {
			System.out.print("   ");
		}
		for (int i = 1; i <= numDays; i++) {

			if (startDay == 6) {
				if (i < 10) {
					System.out.println("  " + i);
				} else {
					System.out.println(" " + i);
				}
				startDay = 0;

			} else if (i > 9) {
				System.out.print(" " + i);
				startDay++;
			} else {
				System.out.print("  " + i);
				startDay++;
			}
			if (i == numDays && startDay == 0) {
				System.out.println();
			} else if (i == numDays && startDay > 0) {
				System.out.println();
				System.out.println();
			}

		}

		return startDay;

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int year = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int day = input.nextInt();
		if (year < 0 || (day < 0 || day > 6)) {	
			if (year < 0) {
				System.out.println(E_YEAR);	
			}
			if (day < 0 || day > 6) {
				System.out.println(E_DAY);	
			}
		} else {
			int startDay = printMonth("January", day, 31); 
			if (isLeapYear(year) == true) { 
				startDay = printMonth("February", startDay, 29); 
			} else {
				startDay = printMonth("February", startDay, 28); 
			}
			startDay = printMonth("March", startDay, 31);	
			startDay = printMonth("April", startDay, 30);	
			startDay = printMonth("May", startDay, 31);		
			startDay = printMonth("June", startDay, 30);	
			startDay = printMonth("July", startDay, 31);	
			startDay = printMonth("August", startDay, 31);	
			startDay = printMonth("September", startDay, 30);	
			startDay = printMonth("October", startDay, 31);	
			startDay = printMonth("November", startDay, 30);	
			startDay = printMonth("December", startDay, 31);	
		}

	}

}
