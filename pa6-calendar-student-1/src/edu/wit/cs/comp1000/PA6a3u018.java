package edu.wit.cs.comp1000;
import java.util.Scanner;


public class PA6a3u018 {

	static final String E_YEAR = "The year must be positive!";

	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	public static boolean isLeapYear(int year) {
		if (year % 4 != 0) {
			return false;
		} else if (year % 100 != 0) {
			return true;
		} else if (year % 400 != 0) {
			return false;
		} else {
			return true;
		}

	}

	public static int printMonth(String month, int startDay, int numDays) {
		int l = startDay;
		System.out.println(month);

		for (int i = 0; i < startDay; i++) {
			System.out.print("   ");
		}

		for (int i = 1; i <= numDays; i++) {
			if (i >= 10) {
				System.out.printf(" %d", i);
			} else if (i < 10) {
				System.out.printf("  %d", i);
			}

			l++; 
			if (l % 7 == 0)
			{
				if (i != numDays) {
					System.out.println();
				}

			}

		}
		System.out.printf("%n%n");

		return (l % 7);
	}

	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the year: ");
		int year = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		
		if (year <= 0)
		{
			System.out.print(E_YEAR);
			System.out.println();
			System.exit(0);
		}
		 int dayOfWeek = input.nextInt();
		 if (dayOfWeek < 0 || dayOfWeek > 6)
		 {
			 System.out.print(E_DAY);
			 System.out.println();
			 System.exit(0);
		 }
		
		 String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		 int[] TotalDaysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		 
		 if(isLeapYear(year))
		 {
			 TotalDaysInMonths[1] = 29;
		 }
		 
		 for (int i = 0; i < 12; i++)
		 {
			 int endDay = dayOfWeek;
			 dayOfWeek = printMonth(months[i], endDay, TotalDaysInMonths[i]);
		 }
		 
	}

}
