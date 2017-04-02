package edu.wit.cs.comp1000;
import java.util.Scanner;

public class PA6a1u003 {
	static final String E_YEAR = "The year must be positive!";
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	public static boolean isLeapYear(int year) {
		if (year%4.0 != 0.0) {
			return false;
		}
		else if (year%100.0 != 0.0) {
			return true;
		}
		else if (year%400.0 != 0.0) {
			return false;
		}
		else {
			return true;
		}
	}

	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);
		int weekDay = startDay;
		int blankDay = 0;
		while (blankDay != weekDay) {
			System.out.print("   ");
			blankDay++;
		}
		System.out.print("  1");
		if (weekDay == 6) {
			weekDay = 0;
			System.out.println("");
			System.out.print(" ");
		}
		else {
			weekDay++;
		}
		for (int i = 2; i <= numDays; i++) {
			String j = new String(Integer.toString(i));
			if (i < 10) {
				j = " " + j;
			}
			if (weekDay == 6) {
				if (i == 2) {
					System.out.print(" ");
				}
				if (i !=numDays) {
					System.out.println(j);
					System.out.print(" ");
				}
				else {
					System.out.print(j);
				}
				weekDay = 0;
			}
			else {
				if (i == 2 && weekDay != 0) {
					System.out.print(" ");
				}
				System.out.print(j);
				weekDay++;
				if (i != numDays) {
					System.out.print(" ");
				}
			}		
		}
		System.out.println("");
		System.out.println("");
		return weekDay;
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int year = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int startDay = input.nextInt();
		if (year < 1) {
			System.out.println(E_YEAR);
			System.exit(0);
		}
		if (startDay < 0 || startDay > 6) {
			System.out.println(E_DAY);
			System.exit(0);
		}
		String[] month_list = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		int[] month_days = {31,28,31,30,31,30,31,31,30,31,30,31};
		for (int k = 0; k < 12; k++) {
			if (k == 1) {
				if (isLeapYear(year) == true) {
					month_days[k] = 29;
				}
			}
			startDay = printMonth(month_list[k],startDay, month_days[k]);
		}
		
	}

}
