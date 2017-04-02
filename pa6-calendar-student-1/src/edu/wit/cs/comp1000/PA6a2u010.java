package edu.wit.cs.comp1000;

import java.util.Scanner;
public class PA6a2u010 {

	static final String E_YEAR = "The year must be positive!";

	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	public static boolean isLeapYear(int year) {
		if (year % 400 == 0) {
			return true;
		}
		if (year % 100 == 0) {
			return false;
		}
		if (year % 4 == 0) {
			return true;
		}
		return false;

	}

	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);

		int dm = 1;
		int dw = startDay;
				for (int i = dw; i!= 0; i--) {
					System.out.print("   ");
					

				}
		while (dm <= numDays) {
			System.out.print(" ");
			if (dm < 10) {
				System.out.print(" ");

			}
			System.out.print(dm);
			if (dw == 6 && dm != numDays) {
				System.out.println();

			}
			dw = dw == 6 ? 0 : dw + 1;
			dm++;
		}
		System.out.println();
		System.out.println();
		
		return dw;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int year = s.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int dw = s.nextInt();
		if (year <= 0) {
			System.out.println(E_YEAR);
		} else if (dw > 6 || dw < 0) {
			System.out.println(E_DAY);
		} else {
			String[] month = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
					"October", "November", "December" };
			int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
			if (isLeapYear(year)) {
				days[1] = 29;
			}
			for (int i = 0; i < 12; i++) {
				dw = printMonth(month[i], dw, days[i]);
			}
		}
		
		s.close();
	}

}
