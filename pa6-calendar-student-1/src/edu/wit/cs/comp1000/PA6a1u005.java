package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a1u005 {
	static final String E_YEAR = "The year must be positive!";
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	static final String[] month = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
	
	public static boolean isLeapYear(int year) 
	{
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		int dayNum = 0;
		int weekNum = 0;
		String weekOne = "";
		
		System.out.println(month);
		
		if (numDays>=8){
		switch(startDay)
		{
		
		case 0: weekOne = "  1  2  3  4  5  6  7"; dayNum = 8; 
		break;
		case 1: weekOne = "     1  2  3  4  5  6"; dayNum = 7;
		break;
		case 2: weekOne = "        1  2  3  4  5"; dayNum = 6;
		break;
		case 3: weekOne = "           1  2  3  4"; dayNum = 5;
		break;
		case 4: weekOne = "              1  2  3"; dayNum = 4;
		break;
		case 5: weekOne = "                 1  2"; dayNum = 3;
		break;
		case 6: weekOne = "                    1"; dayNum = 2;
		break;
		}
		
		System.out.println(weekOne);
		}
		
		else if (numDays<=7){
			for (int i=1 ; i<=numDays ; i++){
				System.out.print("  " + i);
				dayNum = i;
			}
			if (dayNum==7) dayNum=0;
			System.out.println();
			System.out.println();
			return dayNum;
		}
		for(int i = dayNum - 1; i < numDays; i++)
		{
			if(dayNum < 10 && dayNum <= numDays)
			{
				System.out.print("  " + dayNum);
			}
			else if(dayNum <= numDays)
			{
				System.out.print(" " + dayNum);
			}
			if(numDays > 6)
			{
				if(weekNum < 6)
				{
					weekNum++;
				}
				
				else if(weekNum == 6 && i+1 != numDays)
				{
					System.out.println("");
					
					weekNum = 0;
				}
				else if(weekNum == 6 && i+1 == numDays)
				{
					weekNum = 0;
				}
			}
			if(i+1 == numDays)
			{
				System.out.println("");
			}
			dayNum++;
		}
		System.out.println("");
		return weekNum; 
		
	}
	
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		int year = 0, day = 0;
		int lastDay = 0;
		int[] days = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		System.out.print("Enter the year: ");
		year = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		day = input.nextInt();
		input.close();
		
		if(year > 0)
		{
			if(day >=0 && day < 7)
			{
				if(isLeapYear(year))
				{
					days[1] = 29;
				}
				for(int i = 0; i < month.length; i++)
				{
					if(i == 0)
					{
						lastDay = printMonth(month[i], day, days[i]);
					}
					else
					{
						lastDay = printMonth(month[i], lastDay, days[i]);
					}
				}
			}
			else
			{
				System.out.println("The day of January 1st must be between 0 and 6!");
			}
		}
		else
		{
			System.out.println("The year must be positive!");
		}
	}
}
	
