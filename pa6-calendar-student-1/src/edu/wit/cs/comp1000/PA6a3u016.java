package edu.wit.cs.comp1000;

import java.util.Scanner;
public class PA6a3u016
{
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year)
	{
		if (year%4 != 0)
		{
			return false;
		}
		else if (year%100 != 0)
		{
			return true;
		}
		else if (year%400 != 0)
			
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
		
		
		
		for (int i=0; i < startDay; i++)
		{
			System.out.print("   ");
		}
		for (int i = 1; i <= numDays; i++ )
		{
			if (startDay == 6)
			{	
				 if ((i<= 9))
				{
					System.out.println("  "+ i);
					startDay = 0;
				}
				else if (i >9)
				{
					System.out.println(" "+ i);
					startDay = 0;
				}
			}
			else if ((i<= 9))
			{
				System.out.print("  "+ i);
				startDay++;
			}
			else if (i >9)
			{
				System.out.print(" "+ i);
				startDay++;
			}
			if (startDay == 0 && i == numDays)
			{
				System.out.println();
			}
			else if (startDay != 0 && i == numDays)
			{
				System.out.println();
				System.out.println();
			}
		}
		
		return (startDay);
		
		
		
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner (System.in);
		int year;
		int day;
		int numdays = 0;
		String monthName = null;
		System.out.print("Enter the year: ");
		year = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		day = input.nextInt();
		String [] month = new String [] {"January","February","March","April","May","June","July","August","September","October","November","December" };
		if (year <= 0)
		{
			System.out.println(E_YEAR);
		}
		else if ((day > 6) || (day < 0))
		{
			System.out.println(E_DAY);
		}
		else
		{
		for (int i = 0; i< month.length; i++)
		{
			monthName = month[i];
		
		switch (monthName)
		{
		case  "January": 	numdays = 31; 		break;
		case  "February" : if (isLeapYear(year))
							{
								numdays = 29; 
							}
							else 
							{
								numdays = 28;
							}
							break;
		case "March" : 		numdays = 31; 		break;
		case "April" : 		numdays = 30; 		break;
		case "May" : 		numdays = 31; 		break;
		case "June" : 		numdays = 30; 		break;
		case "July" : 		numdays = 31; 		break;
		case "August" :		numdays = 31; 		break;
		case "September" : 	numdays = 30; 		break;
		case "October" : 	numdays = 31; 		break;
		case "November" : 	numdays = 30; 		break;
		case "December" : 	numdays = 31; 		break;
		}
		day = printMonth(monthName, day, numdays);
		
	}
		

   }
  }
}
