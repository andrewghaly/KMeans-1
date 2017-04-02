package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a3u020 {
	   
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		 if  ((year % 4 == 0) && (year % 100 != 0)) return true;
	     if  (year % 400 == 0) return true;
		return false; 
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		
		String [] m = {
	             "",                               
	             "January", "February", "March",
	             "April", "May", "June",
	             "July", "August", "September",
	             "October", "November", "December"
	         };
	      int [] start = {
	    		  0, 1, 2, 3, 4, 5, 6
	      };
	     int[] days = {
	             0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
	         };
		return 0; 
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner (System.in);
		
		int year;	
		int day;
		
		System.out.print("Enter the year: ");
        year = input.nextInt();
		
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		day = input.nextInt();
		
		if ( year < 0 ){
			System.out.println("The year must be positive!");
		}
		
		if (day < 0 || day > 6) {
			System.out.printf("The day of January 1st must be between 0 and 6!%n");
		}
		
		
		
		
	}

}
