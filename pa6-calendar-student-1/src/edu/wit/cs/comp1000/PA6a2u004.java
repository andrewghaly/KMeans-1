package edu.wit.cs.comp1000;

import java.util.Scanner;


public class PA6a2u004 {

	static final String E_YEAR = "The year must be positive!";

	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	static final String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};

	static final int[] days={31,28,31,30,31,30,31,31,30,31,30,31};

	public static boolean isLeapYear(int y) {
		return (y%100==0 ? y%400==0 : y%4==0);
	}

	public static int printMonth(String month, int startDay, int numDays) {

		System.out.println(month);
		int day;
		for(int i = 0; i < startDay; i ++){
			System.out.print("   ");
		}
		day = startDay;

		for(int i = 0; i < numDays; i++){
			if(day>6) {
				day=0;
				System.out.println();
			}
			System.out.printf(i < 9 ? "  %d":" %d",i+1);
			day++;
		}
		System.out.println();
		System.out.println();

		if(day > 6) {
			day=0;
		}
		return day;
	}		

	public static void main(String[] args) {
		Scanner r = new Scanner(System.in);

		System.out.print("Enter the year: ");
		int year = r.nextInt();

		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int day = r.nextInt();

		r.close();
		if(year<=0) {
			System.out.println(E_YEAR);
			System.exit(0);
		}
		if(day<0 || day>6) {
			System.out.println(E_DAY);
			System.exit(0);
		}

		if(isLeapYear(year)) {
			days[1]=29;
		}

		for(int i = 0; i < 12; i++) {
			day = printMonth(months[i],day,days[i]);
		}
	}
}
