package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a2u015 {

	static final String E_YEAR = "The year must be positive!";

	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	public static boolean isLeapYear(int year) {
		if (!(year % 100 == 0) && (year % 4 == 0) || (year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);

		int day = 1;
		String space = "";
		while (day <= numDays) {
			if (day == 1) {
				for (int i = 0; i < startDay; i++) {
					System.out.print("   ");
				}
				if (startDay == 6) {
					System.out.println("  " + day);
					day++;
					startDay = 0;
				} else {
					System.out.print("  " + day);
					day++;
					startDay++;
				}
			}
			if (day > 1 && numDays > 1) {

				if (day < 10) {
					space = " ";
				} else if (day >= 10) {
					space = "";
				}

				if (startDay == 6) {
					System.out.println(" " + space + day);
				} else {
					System.out.print(" " + space + day);
				}

				day++;

				if (startDay == 6) {
					startDay = 0;
				} else {
					startDay++;
				}
			}
		}
		if (startDay == 0) {
			System.out.println("");
		} else {
			System.out.println("");
			System.out.println("");
		}
		return startDay;
	}

	public static void main(String[] args) {
		Scanner myScan = new Scanner(System.in);
		int Days[] = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String Months[] = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		int year = 0;
		int day = 0;
		System.out.print("Enter the year: ");
		year = myScan.nextInt();
		System.out.print("Enter the day of the week of January 1st " + "(0=Sunday, 1=Monday, ... 6=Saturday): ");
		day = myScan.nextInt();

		if (year >= 0) {
			if (day % 1 == 0 && day >= 0 && day <= 6) {
				if (isLeapYear(year) == true) {
					Days[1] = 29;
				}

				for (int i = 0; 1 < 12; i++) {
					day = printMonth(Months[i], day, Days[i]);
				}
			} else {
				System.out.println(E_DAY);
			}
		} else {
			System.out.println(E_YEAR);
		}
	}
}
