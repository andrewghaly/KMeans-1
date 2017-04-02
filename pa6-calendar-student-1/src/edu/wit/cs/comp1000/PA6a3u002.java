package edu.wit.cs.comp1000;
import java.util.Scanner;
public class PA6a3u002
{
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year)
	{
		if (year % 4 != 0)
		{
			return false;
		}
		else if (year % 100 != 0)
		{
			return true;
		}
		else if (year % 400 != 0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static int printMonth(String month, int startDay, int numDays)
	{
		System.out.println(month);
		int i = 0;
		while(i < startDay)
		{
			System.out.print("   ");
			i++;
		}
		int j = 1;
		while (j <= numDays)
		{
			if(j >= 10)
			{
				System.out.printf(" %d", j);
			}
			else
			{
				System.out.printf("  %d", j);
			}
			startDay++;
			if(startDay % 7 == 0 && j !=numDays)
			{
				System.out.println();
			} 
			j++;
		}
		System.out.println();
		System.out.println();
		
		return (startDay % 7);
		
	}

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int year = scan.nextInt();

		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int startDay = scan.nextInt();
		
		if(startDay < 0 || startDay > 6)
		{
			System.out.println(E_DAY);
			System.exit(0);

		}
		if(year < 0)
		{
			System.out.println(E_YEAR);
			System.exit(0);
		}
		
		int feb = 28;
		if(isLeapYear(year) == true)
		{
			feb = 29;
		}
		int x = printMonth("January", startDay, 31);
		x = printMonth("February", x, feb);
		x = printMonth("March", x, 31);
		x = printMonth("April", x, 30);
		x = printMonth("May", x, 31);
		x = printMonth("June", x, 30);
		x = printMonth("July", x, 31);
		x = printMonth("August", x, 31);
		x = printMonth("September", x, 30);
		x = printMonth("October", x, 31);
		x = printMonth("November", x, 30);
		x = printMonth("December", x, 31);
			
	}

}
