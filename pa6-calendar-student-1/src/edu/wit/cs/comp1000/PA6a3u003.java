package edu.wit.cs.comp1000;

import java.util.Scanner;


public class PA6a3u003 {
	public static String[] months = new String[12];

	public static int[] days = new int[12];

	static final String E_YEAR = "The year must be positive!";

	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	public static boolean isLeapYear(int year) {
		{
			if (year % 4 != 0) {
				return false;
			} else if (year % 400 == 0) {
				return true;
			} else if (year % 100 == 0) {
				return false;
			} else {
				return true;
			}
		}

	}

	public static boolean LeapYear;


	public static int printMonth(String month, int startDay, int numDays) {
		{
			System.out.println(month);
			if (LeapYear && month == "February")
				numDays = 29;
			int i = 1;
			int days = 0;
			while (i <= numDays + startDay) {
				if (i <= startDay)

					System.out.print("   ");
				else {
					pad(i - startDay, 3);
				}
				if (i % 7 == 0)
					System.out.println();
				days++;
				i++;
				if (days == 7)
					days = 0;
			}
			if ((numDays + startDay) % 7 != 0)
				System.out.println();
			System.out.println();
			return days;
		}

	}

	public static void printYear(int year, int startDate) {
		for (int i = 0; i < months.length; i++) {
			startDate = printMonth(months[i], startDate, days[i]);
		}
	}

	public static void pad(int val, int space) {
		int numSpaces = space - Integer.toString(val).length();
		String str = "";
		for (int i = 0; i < numSpaces; i++)
			str += " ";
		str += val;
		System.out.print(str);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int year = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int startDay = input.nextInt();
		if (year <= 0) {
			System.out.println(E_YEAR);
			System.exit(0);
		}
		if (startDay < 0 || startDay > 6) {
			System.out.println(E_DAY);
			System.exit(0);
		}
		LeapYear = isLeapYear(year);
		months[0] = "January";
		months[1] = "February";
		months[2] = "March";
		months[3] = "April";
		months[4] = "May";
		months[5] = "June";
		months[6] = "July";
		months[7] = "August";
		months[8] = "September";
		months[9] = "October";
		months[10] = "November";
		months[11] = "December";

		days[0] = 31;
		days[1] = 28;
		days[2] = 31;
		days[3] = 30;
		days[4] = 31;
		days[5] = 30;
		days[6] = 31;
		days[7] = 31;
		days[8] = 30;
		days[9] = 31;
		days[10] = 30;
		days[11] = 31;

		LeapYear = isLeapYear(year);
		printYear(year, startDay); 

	}

}
