package edu.wit.cs.comp1000;
import java.util.Scanner;

public class PA6a2u019 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year)
	{
		if (year % 4 != 0) 
			return false;
		
		else if (year % 100 != 0) 
			return true;
		
		else if (year % 400 != 0) 
			return false;
		
		else 
			return true;
	}
	
	public static int printMonth(String month, int startDay, int numDays)
	{
		int j;
		
		System.out.println(month);

		for (int i = 0; i < startDay; i++)
			System.out.print("   ");
		
		for (j = 1; j <= numDays; j++)
		{
			System.out.printf(" %2d", j);
			
			if (((j + startDay) % 7 == 0) || (j == numDays)) 
				System.out.println();
		}	
		
		System.out.println();
		
		int bookmark = (j - 1 + startDay) % 7;
		return bookmark;
	}

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		String[] months = {"January", "February", "March", "April", "May", "June",
						   "July", "August", "September", "October", "November", "December"};
		
		int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		System.out.print("Enter the year: ");
		int year = input.nextInt();
			
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int weekday = input.nextInt();
		
		if (year < 0)
		{
			System.out.println(E_YEAR);
			System.exit(0);
		}
		else if (weekday < 0 || weekday > 6)
		{
			System.out.println(E_DAY);
			System.exit(0);
		}
		
		if (isLeapYear(year))
			daysPerMonth[1] += 1;
		
		for (int i = 0; i < 12; i++)
			weekday = printMonth(months[i], weekday, daysPerMonth[i]);
	}
}
