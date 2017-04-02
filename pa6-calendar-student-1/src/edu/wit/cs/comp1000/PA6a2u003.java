package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a2u003 {

	static final String E_YEAR = "The year must be positive!";

	static final String E_DAY = "The day of January 1st must be between 0 and 6!";

	public static boolean isLeapYear(int year) {

		if (!(year % 4 == 0)) {

			return false;

		} else if (!(year % 100 == 0)) {
			return true;

		} else if (!(year % 400 == 0)) {
			return false;

		} else {
			System.out.print("leap year");
			return true;
		}
	}

	public static int printMonth(String month, int startDay, int numDays) {

		int dayofweek = 0;

		
		
		System.out.print(month + "\n");

		int i;		
int j;
		for (j = 0; j < startDay % 7; j++) {
			System.out.print("   ");

			dayofweek++;

		}

		for (i = 1; i < numDays + 1; i++) {
			if (dayofweek > 6) {
				dayofweek = 0;
				System.out.print("\n");
				
			}
			

			if (i < 10) {
				System.out.print("  " + i);
				dayofweek++;
			}

			else if (i >= 10) {
				System.out.print(" " + i);
				dayofweek++;
			}



		}
		int t=(((numDays)%7)+j);
		
		
	 System.out.print("\n");
	 System.out.print("\n");
	 if ((startDay)<=4)
		{
			return t;
		}
		else 
		{
		return (((numDays)%7)+j-7);
		
		}
	}

	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int year;
		int day;

		
		
		System.out.print("Enter the year: Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		year = input.nextInt();
		day = input.nextInt();
		
		
		if (year<=0){
			System.out.println(E_YEAR);
			System.exit(0);
		}
		
		if (day <= 0 || day >=7)
		{
			System.out.println("The day of January 1st must be between 0 and 6!");
			System.exit(0);
		}
		
		int yearcase = year - 2000;

		printMonth("January", day, 31); 
		boolean result = isLeapYear(year);
		if (result = true){
		
		printMonth("February", ((yearcase + 4 +2)%7), 28);
		}
		else if (result =false ) {
		printMonth("February", ((yearcase + 4 +2)%7), 29);
		}
		
		printMonth("March", (yearcase + 4+2)%7 , 31);
		printMonth("April", (yearcase+0 +2)%7 , 30);
		printMonth("May", ((yearcase+2 +2)%7) , 31);
		printMonth("June",((yearcase+5 +2)%7) , 30);
		printMonth("July", ((yearcase+0 +2)%7) , 31);
		printMonth("August", ((yearcase+3 +2)%7) , 31);
		printMonth("September", ((yearcase+6 +2)%7) , 30);
		printMonth("October", ((yearcase+1 +2)%7) , 31);
		printMonth("November", ((yearcase+4 +2)%7) , 30);
		printMonth("December", ((yearcase+6 +2)%7), 31);
		
	}

}
