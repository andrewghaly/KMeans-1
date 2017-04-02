package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a2u006 {

	static final String E_YEAR = "The year must be positive!";

	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	public static boolean isLeapYear(int year) {
		boolean leapyear = false;
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return !leapyear;
				}
				;
			} else {
				return !leapyear;
			}
		}
		return leapyear;
	}

	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);
		for(int o=0;o<startDay;o++){
            System.out.print("   ");
		}
        for(int i=0;i<=numDays;i++){
        	if(i>0){
        	if(i<10){
        	System.out.print("  "+i);
        	}
        	if(i>=10) {
        		System.out.print(" "+i);
        	}
        	startDay++;
        	if (startDay%7==0&&i!=numDays){
        		System.out.println();	
        	}
        }
        }
        System.out.println();
        System.out.println();
		return(startDay%7);
	}

	public static void main(String[] args) {

		String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		int[] total_Days_In_Months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        PA6a2u006 obj = new PA6a2u006();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int year = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int day_of_week = input.nextInt();
		if (year <= 0)
			System.out.println(obj.E_YEAR);
		else if (day_of_week < 0 || day_of_week > 6)
			System.out.println(obj.E_DAY);
		else {
			if (isLeapYear(year)) {
				total_Days_In_Months[1] = 29;
			}
			for (int j = 0; j < total_Days_In_Months.length; j++) {
				int endDay = day_of_week;
				day_of_week = printMonth(months[j], endDay, total_Days_In_Months[j]);
			}
		}
	}
}
