package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a3u013 {

	static final String E_YEAR = "The year must be positive!";

	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	public static boolean isLeapYear(int year) {
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			return true;
		} else {
			return false;
		}

	}

	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);
		System.out.print(" ");
		for (int i = 0; i < startDay; i++) {
			System.out.print("   ");
		}
		for (int l = 1; l <= numDays; l++) {
			if (startDay < 6) {
				if (l < 10) {
					System.out.print(" " + l);
				} else {
					System.out.print(l);
				}
				String s;
				if (l == numDays) {
					s = "";
				} else {
					s = " ";
				}
				System.out.print(s);
				startDay++;
			} else {
				if (l < 10) {
					System.out.print(" " + l);
				} else {
					System.out.print(l);
				}
				if (l != numDays) {
					System.out.println();
					System.out.print(" ");
				} else {
					System.out.print("");
				}
				startDay = 0;
			}
		}
		System.out.println();
		System.out.println();
		return startDay;

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year, day;
		System.out.print("Enter the year: ");
		year = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		day = input.nextInt();

		String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		if (year <= 0) {
			System.out.println(E_YEAR);
		} else if (day <= 0 || day >= 6) {
			System.out.println(E_DAY);

		} else {
			int Days = 0;
			for (int k = 0; k < months.length; k++) {
				String month = months[k];
				switch (month) {
				case "January":
					Days = 31;
					break;
				case "February":
					if (isLeapYear(year)) {
						Days = 29;
					} else {
						Days = 28;
					}
					break;
				case "March":
					Days = 31;
					break;
				case "April":
					Days = 30;
					break;
				case "May":
					Days = 31;
					break;
				case "June":
					Days = 30;
					break;
				case "July":
					Days = 31;
					break;
				case "August":
					Days = 31;
					break;
				case "September":
					Days = 30;
					break;
				case "October":
					Days = 31;
					break;
				case "November":
					Days = 30;
					break;
				case "December":
					Days = 31;
					break;

				}
				printMonth(month, day, Days);
				day = day + (Days % 7);
				if (day > 6) {
					day = day - 7;

				}

			}

		}

	}

}
