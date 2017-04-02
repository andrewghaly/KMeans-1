package edu.wit.cs.comp1000;
import java.util.Scanner;

public class PA6a3u001 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		if (year % 400 == 0) {
			return true;
		} else if (year > 1900 && year % 4 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);
		int weekday = 1;
		int iSpace;
		while (weekday <= numDays) {
			if (weekday == 1) {
				for (iSpace = 0; iSpace < startDay; iSpace++) {
					System.out.print("   ");
				}
			}
			if (weekday < 10) {
				System.out.print("  " + weekday);
			} else {
				System.out.print(" " + weekday);
			}
			weekday++;
			if (startDay < 6) {
				startDay++;
			} else {
				System.out.println();
				startDay = 0;
			}
			if (weekday - 1 == numDays) {
				System.out.println();
			}
			if (weekday - 1 == numDays && startDay != 0) {
				System.out.println();
			}
		}
		return startDay;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year: ");
		long year = input.nextLong();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int day = input.nextInt();
		int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		if (year <= 0) {
			System.out.println(E_YEAR);
		} else if (day < 0 || day > 6) {
			System.out.println(E_DAY);
		} else {
			for (int month = 0; month < months.length; month++) {
				day = printMonth(months[month], day, days[month]);
			}
		}
		input.close();
	}

}
