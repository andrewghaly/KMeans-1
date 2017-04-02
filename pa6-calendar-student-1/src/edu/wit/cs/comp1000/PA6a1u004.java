package edu.wit.cs.comp1000;
import java.util.Scanner;

public class PA6a1u004 {

	static final String E_YEAR = "The year must be positive!";

	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			return true;
		} else {
			return false;
		}

	}

	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);
		for (int i = 0; i <= startDay - 1; i = i + 1) {
			System.out.print("   ");
		}
		for (int e = 1; e <= numDays; e = e + 1) {
			if (e < 10) {
				System.out.print("  " + e);
			} else {
				System.out.print(" " + e);
			}

			startDay++;
			if (startDay % 7 == 0 && e != numDays) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();

		return startDay % 7;
	}

	public static void main(String[] args) {
		int year;
		int startDay;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year: ");
		year = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");

		startDay = input.nextInt();
		if (year <= 0) {
			System.out.println(E_YEAR);
			System.exit(0);
		}

		if (startDay < 0 || startDay > 7) {
			System.out.println(E_DAY);
			System.exit(0);
		}
		String[] month = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int[] numDays = new int[12];
		numDays[0] = 31;
		numDays[2] = 31;
		numDays[3] = 30;
		numDays[4] = 31;
		numDays[5] = 30;
		numDays[6] = 31;
		numDays[7] = 31;
		numDays[8] = 30;
		numDays[9] = 31;
		numDays[10] = 30;
		numDays[11] = 31;
		if (isLeapYear(year) == true) {
			numDays[1] = 29;
		} else if (isLeapYear(year) == false) {
			numDays[1] = 28;
		}
	
	

		startDay = printMonth(month[0], startDay, numDays[0]);
		startDay = printMonth(month[1], startDay, numDays[1]);
		startDay = printMonth(month[2], startDay, numDays[2]);
		startDay = printMonth(month[3], startDay, numDays[3]);
		startDay = printMonth(month[4], startDay, numDays[4]);
		startDay = printMonth(month[5], startDay, numDays[5]);
		startDay = printMonth(month[6], startDay, numDays[6]);
		startDay = printMonth(month[7], startDay, numDays[7]);
		startDay = printMonth(month[8], startDay, numDays[8]);
		startDay = printMonth(month[9], startDay, numDays[9]);
		startDay = printMonth(month[10], startDay, numDays[10]);
		printMonth(month[11], startDay, numDays[11]);
	}

	private static void printMonth(Object month, int startDay, Object numDays) {
	

	}
}
