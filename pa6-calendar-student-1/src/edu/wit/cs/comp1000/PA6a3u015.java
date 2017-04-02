package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a3u015 {

	static final String E_YEAR = "The year must be positive!";

	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	public static boolean isLeapYear(int year) {
		 if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))){
			return true;
			}
		 else return false;
		}
	public static int test;
	public static int printMonth(String month, int startDay, int numDays) {
		int i=0;
		System.out.println(month);
		while(i<startDay){
			System.out.print("   ");
			i++;
		}
		for(int a=0;a<numDays;a++){
			if (startDay==7){
				System.out.println();
				startDay=0;
			}
			if (a<9){
				System.out.print("  "+(a+1));
			}
			if (a>=9){
				System.out.print(" "+(a+1));
			}
			startDay++;
		}
		System.out.println();

		if (startDay==7){
			startDay=0;
		}
		System.out.println();
		return startDay;
	}



	public static void main(String[] args) {
		int[] numDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] month = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int year = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		if (year<0){
			System.out.println(E_YEAR);
			System.exit(0);
		}
		if(isLeapYear(year) == true){
			numDays[1]=29;
		}
		int startDay = input.nextInt();
		if (startDay<0||startDay>6){
			System.out.println(E_DAY);
			System.exit(0);
		}
		int z=0;
		while (z<12){
		startDay=printMonth(month[z],startDay,numDays[z]);

		z++;
		}

	}	
	
}
