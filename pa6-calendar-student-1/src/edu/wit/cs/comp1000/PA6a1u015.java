package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a1u015 {

	static final String E_YEAR = "The year must be positive!";

	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0) {
			return true;
		}
		if (year % 400 == 0) {
			return true;
		}
		return false;
	}

	public static int printMonth(String month, int startDay, int numDays) {
		System.out.printf(month + "%n");
		int i;
		for (int a = 0; a <= startDay - 1; a++) {
			System.out.printf("   ");
		}
		for (i = 0; i <= numDays; i++, startDay++) {
			if (i > 0) {
				System.out.printf("%3d", i);
			}
			if (startDay == 7) {
				System.out.println();
				startDay = 0;
			}
		}
		if (startDay > 1) {
			System.out.println();
		}
		System.out.println();
		return startDay - 1;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int eyear, emonth, eday, count = 0;
		boolean leap = false;
		boolean year = true;
		boolean month = true;
		while (year == true) {
			System.out.print(
					"Enter the year: Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
			eyear = input.nextInt();
			if (eyear < 0) {
				System.out.println("The year must be positive!");
				return;
			} else {
				leap = isLeapYear(eyear);
				leap = leap;
				year = false;
			}
			while (month == true) {
				eday = input.nextInt();
				if (eday < 0 || eday > 6) {
					System.out.println("The day of January 1st must be between 0 and 6!");
					month = false;
				} else {
					int x = printMonth("January", eday, 31);
					if (year == true)
						x = printMonth("February", x, 29);
					else {
						x = printMonth("February", x, 28);
					}
					x = printMonth("March", x, 31);
					x = printMonth("April", x, 30);
					x = printMonth("May", x, 31);
					x = printMonth("June", x, 30);
					x = printMonth("July", x, 31);
					x = printMonth("August", x, 31);
					x = printMonth("September", x, 30);
					x = printMonth("October", x, 31);
					x = printMonth("November", x, 30);
					x = printMonth("December", x, 31);
					month = false;
				}
			}
		}
	}
}
