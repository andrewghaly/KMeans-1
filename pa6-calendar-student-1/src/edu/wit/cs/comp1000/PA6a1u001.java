package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a1u001 {
	
	static int tester;
	static final String JANUARY = "January";
	static final String FEBUARY = "Febuary";
	static final String MARCH = "March";
	static final String APRIL = "April";
	static final String MAY = "May";
	static final String JUNE = "June";
	static final String JULY = "July";
	static final String AUGUST = "August";
	static final String SEPTEMBER = "September";
	static final String OCTOBER = "October";
	static final String NOVEMBER = "November";
	static final String DECEMBER = "December";
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
			return true;
		} else
			return false;
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		int x = 0;
		System.out.println(month);
		
		while (x < startDay) {
			System.out.print("   ");
			x++;
		}
		for (int i = 0; i < numDays; i++) {
			if (startDay == 7) {
				System.out.println();
				startDay = 0;
			}
			if (i < 9) {
				System.out.print("  " + (i + 1));
			}
			if (i >= 9) {
				System.out.print(" " + (i + 1));
			}
			
			startDay++;
		}
		System.out.println();
		
		if (startDay == 7) {
			startDay = 0;
		}
		System.out.println();
		return startDay;
	}
	
	public static void main(String[] args) {
		int[] numDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int year = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		if (year < 0) {
			System.out.println(E_YEAR);
			System.exit(0);
		}
		if (isLeapYear(year) == true) {
			numDays[1] = 29;
		}
		int startDay = input.nextInt();
		if (startDay < 0 || startDay > 6) {
			System.out.println(E_DAY);
			System.exit(0);
		}
		int x = 0;
		tester = startDay;
		while (x < 12) {
			startDay = printMonth(months[x], startDay, numDays[x]);
			x++;
		}
	}
}
