package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a2u016 {

	static final String E_YEAR = "The year must be positive!";

	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {

			return true;
		}

		return false;
	}

	public static int printMonth(String month, int startDay, int numDays) {

		System.out.println(month);

		for (int j = 0; j < startDay; j++)
			System.out.print("   ");

		for (int i = 0; i < numDays; i++) {
			if (startDay == 7) {

				System.out.println();

				startDay = 0;
			}

			if ((i + 1) < 10)
				System.out.print("  " + (i + 1));

			else
				System.out.print(" " + (i + 1));

			startDay++;
		}

		System.out.println();
		System.out.println();
		if (startDay == 7) {

			startDay = 0;
		}
		return startDay;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int day;

		int feb = 28;

		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		System.out.print("Enter the year: ");
		int year = input.nextInt();

		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int startDay = input.nextInt();

		if (year < 0) {
			System.out.println(E_YEAR);
			System.exit(0);
		}
		if ((startDay < 0) || (startDay > 6)) {
			System.out.println(E_DAY);
			System.exit(1);
		}

		if (isLeapYear(year))
			feb++;

		int days = 0;
		for (int i = 0; i < months.length; i++) {

			if (months[i].equals("January"))
				days = 31;

			else if (months[i].equals("February"))
				days = feb;

			else if (months[i].equals("March"))
				days = 31;

			else if (months[i].equals("April"))
				days = 30;

			else if (months[i].equals("May"))
				days = 31;

			else if (months[i].equals("June"))
				days = 30;

			else if (months[i].equals("July"))
				days = 31;

			else if (months[i].equals("August"))
				days = 31;

			else if (months[i].equals("September"))
				days = 30;

			else if (months[i].equals("October"))
				days = 31;

			else if (months[i].equals("November"))
				days = 30;

			else if (months[i].equals("December"))
				days = 31;

			startDay = printMonth(months[i], startDay, days);

		}

	}

}
