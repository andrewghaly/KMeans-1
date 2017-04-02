package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a1u010 {

	static final String E_YEAR = "The year must be positive!";

	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	public static int Year;

	public static boolean isLeapYear(int year) {

		if ((year % 4) != 0) {

			return false;

		}

		else if ((year % 100) != 0) {

			return true;
		}

		else if ((year % 400) != 0) {

			return false;

		}

		else {

			return true;

		}

	}

	public static int printMonth(String month, int startDay, int numDays) {

		boolean check = true;
		int dayCount = numDays;
		int dayBuffer = startDay;
		System.out.println(month);
		
		if (dayCount == 28 && isLeapYear(Year)) {
			dayCount = 29;
		}

		for (int i = 1; i <= dayCount; i++) {

			while (check) {

				for (int j = 0; j < dayBuffer; j++) {

					System.out.printf("%3s", "");

				}

				check = false;

			}

			if (dayBuffer < 6 && dayBuffer > 0) {

				System.out.printf("%3d", i);

				dayBuffer++;

			}
			else if (dayBuffer == 0) {
				System.out.printf("%3d", i);

				dayBuffer++;
			}

			else if (dayBuffer == 6) {
				

				dayBuffer = 0;

				System.out.printf("%3d", i);
				if (i != dayCount) {
					System.out.println();
				}
			}

		}
		System.out.println();
		System.out.println();
		return dayBuffer;

	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Enter the year: ");
		Year = input.nextInt();

		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int dayStart = input.nextInt();

		if ((Year < 0)) {
			System.out.println("The year must be positive!");
			System.exit(0);
		}
		if ((dayStart < 0) || (dayStart > 6)) {
			System.out.println("The day of January 1st must be between 0 and 6!");
			System.exit(0);
		}

		String[] month = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int[] day = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int i = 0; i <= month.length - 1; i++) {
			dayStart = printMonth(month[i], dayStart, day[i]);
		}

	}
}
