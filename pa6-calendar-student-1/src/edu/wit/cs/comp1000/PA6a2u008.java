package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a2u008 {

	static final String E_YEAR = "The year must be positive!";

	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	public static boolean isLeapYear(int year) {
		if ((year % 4) != 0) {
			return false;
		} else if ((year % 100) != 0) {
			return true;
		} else if ((year % 400) != 0) {
			return false;
		} else {
			return true;
		}

	}


	public static int printMonth(String month, int startDay, int numDays) {
		int CurrentPos = startDay;

		System.out.print(month);
		System.out.println();
		for (int i = 0; i < startDay; i++) {
			System.out.print("   ");
		}

		for (int day = 1; day <= numDays; day++) {
			if (CurrentPos > 5) {
				if (day < 10) {
					System.out.println("  " + day + "");

				} else {
					System.out.println(" " + day + "");
				}
				CurrentPos = 0;
			} else {
				if (day < 10) {
					System.out.print("  " + day + "");

				} else {
					System.out.print(" " + day + "");
				}
				CurrentPos ++;
			}

		}
		if(CurrentPos == 0){
			System.out.println();
			
		}
		else {
		System.out.println();
		System.out.println();
		}
		return CurrentPos;
		
		
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int entered_year = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int day_of_week = input.nextInt();
		if (entered_year < 1) {
			System.out.println("The year must be positive!");
			System.exit(0);
		}
		if (day_of_week < 0 || day_of_week > 7) {
			System.out.println("The day of January 1st must be between 0 and 6!");
			System.exit(0);
		}
		
		int next_startDay;
		next_startDay = printMonth("January", day_of_week, 31);
	
		
		if (isLeapYear(entered_year) == true) {
			next_startDay = printMonth("February", next_startDay, 29);
		} else {
			next_startDay= printMonth("February", next_startDay, 28);
		}
		next_startDay = printMonth("March", next_startDay, 31);

		next_startDay = printMonth("April", next_startDay, 30);
		
		next_startDay = printMonth("May", next_startDay, 31);
	
		next_startDay = printMonth("June", next_startDay, 30);
		
		next_startDay = printMonth("July", next_startDay, 31);

		next_startDay = printMonth("August", next_startDay, 31);

		next_startDay = printMonth("September", next_startDay, 30);

		next_startDay = printMonth("October", next_startDay, 31);

		next_startDay = printMonth("November", next_startDay, 30);
	
		printMonth("December", next_startDay, 31);
	
	}
}
