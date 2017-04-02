package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a3u007 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static Boolean isLeapYear(int year)
	{
		return ((year%4==0)&&(year%100!=0)||(year%400==0));
	}
	
		public static int printMonth(String month, int startDay, int numDays)
		{
			
			int day=1;
			String extra="";
			System.out.println(month);
			while(day<=numDays)
			{
				if(day==1)
				{
					for(int i=0;i<startDay;i++)
					{
						System.out.print("   ");
					}
					if(startDay==6)
					{
						System.out.println("  "+day);
						startDay=0;
						day++;
					}
					else
					{
						System.out.print("  "+day);
						day++;
						startDay=startDay+1;
					}
				}
				if(day>1 && numDays>1)
				{
				if(day<10)
					extra=" ";
				else if(day>=10)
					extra="";
					if(startDay==6)
						System.out.println(" "+extra+day);
					else
						System.out.print(" "+extra+day);
				day++;
				if(startDay==6)
					startDay=0;
				else
					startDay++;
				}
			}
			if(startDay==0) 
			{
				System.out.println("");
			}else
			{
			System.out.println("");
			System.out.println("");
			}
			return startDay;
		}

	public static void main(String[] args)
	{
		Scanner scan=new Scanner(System.in);
		String month[]=new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
		int daysInMonth[]=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		int year=0;
		int start=0;
		System.out.print("Enter the year: ");
		year=scan.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		start=scan.nextInt();
		scan.close();
		if(year>=0)
		{
			if(start%1==0 && start>=0 && start<=6)
			{
				if(isLeapYear(year)==true)
					daysInMonth[1]=29;
				for(int i=0;i<12;i++)
					start=printMonth(month[i],start,daysInMonth[i]);
			}
			else
				System.out.println("The day of January 1st must be between 0 and 6!");
			
		}else
			System.out.println("The year must be positive!");	
	}

}
