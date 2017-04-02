package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a3u017 {

	static final String E_YEAR = "The year must be positive!";

	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	public static boolean isLeapYear(int year) {

		if (year % 4 != 0) {

			return false;
		} else if (year % 100 != 0) {

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

		int i = 0;

		System.out.print(month);

		if (startDay < 7) {
			System.out.println();

			while (i < startDay) {

				if (startDay < 10) {
					System.out.print("   ");

				} else if (startDay >= 10) {

					System.out.print("  ");

				}
				i++;
			}
		} else if (startDay == 7) {
			
		}

		for (int z = 1; z <= numDays; z++) {

			if (startDay == 7) {
				System.out.println();
				startDay = 0;

			}

			if (z < 10) {
				System.out.print("  " + z);
			} else if (z >= 10) {
				System.out.print(" " + z);

			}

			startDay++;

		}
		
		if(startDay == 7){
			startDay = 0;
		}

		System.out.println();
		System.out.println();

		return startDay;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the year: ");
		int year = sc.nextInt();

		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int startDay = sc.nextInt();
		
		sc.close();
		
		if (year < 0) {
			System.out.println(E_YEAR);
			System.exit(0);
		}

		if (startDay <= -1 || startDay > 6) {

			System.out.println(E_DAY);
			System.exit(0);

		}

		String Months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		int numDays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		for (int i = 0; i < 12; i++) {

			if (!isLeapYear(year)) {
				startDay = printMonth(Months[i], startDay, numDays[i]);
			} else if (isLeapYear(year)) {

				numDays[1] = 29; 
				startDay = printMonth(Months[i], startDay, numDays[i]);

			}
		}
	}
}
