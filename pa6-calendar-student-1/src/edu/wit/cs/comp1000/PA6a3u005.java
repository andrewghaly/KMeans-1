package edu.wit.cs.comp1000;


import java.util.Scanner;

public class PA6a3u005
{
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year)
	{
		if (year % 4 == 0)
		{
			if (year % 400 == 0)
			{
				return true;
			}
			else if (year % 100 == 0)
			{
				return false;
			}
			else
			{
				return true;
			}
		}

		else
		{
			return false;
		}
	}
	
	public static int printMonth(String month, int startDay, int numDays)
	{
		int d = startDay;
		System.out.println(month);
		for (int c = 0; c < d; c++)
		{
			System.out.print("   ");
		}
		for (int i = 1; i <= numDays; i++)
		{
			if (d == 6)
			{
				if (i < 10)
				{
					System.out.println("  " + i);
				}
				else
				{
					System.out.println(" " + i);
				}
				d = 0;
			}
			else
			{
				if (i < 10)
				{
					System.out.print("  " + i);
				}
				else
				{
					System.out.print(" " + i);
				}
				d = d + 1;
			}
		}
		if (d == 0)
		{
			System.out.printf("%n");
		}
		else
		{
			System.out.printf("%n%n");
		}
		return d;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int year = 0;
		int day = 0;
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		System.out.print("Enter the year: ");
		year = in.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		day = in.nextInt();
		
		if (year < 0)
		{
			System.out.println(E_YEAR);
		}
		else if (day < 0 || day > 6)
		{
			System.out.println(E_DAY);
		}
		else
		{
			if (isLeapYear(year))
			{
				int[] days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
				int a = 0;
				while (a < 12)
				{
					day = printMonth(months[a], day, days[a]);
					a = a + 1;
				}
			}
			else
			{
				int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
				int a = 0;
				while (a < 12)
				{
					day = printMonth(months[a], day, days[a]);
					a = a + 1;
				}
			}
		}
	}

}
