package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a1u014 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		if(year % 4 != 0){
			return false; 
		} else if(year % 100 != 0){
			return true;
		} else if(year % 400 != 0){
			return false;
		} else{
			return true;
		}
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);
		for(int i = 0; i < startDay; i++){
			System.out.print("   ");
		}
		for(int j = 1; j <= numDays; j++){
			if(j/10 == 0){
				System.out.printf("  %d", j);
			} else {
				System.out.printf(" %d", j);
			}
			
			if(((j + startDay)%7 == 0) && (j != numDays)){
				System.out.printf("%n");
			}
		}
		System.out.printf("%n%n");
		return (startDay + numDays)%7;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the year: ");
		int year = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int firstDay = input.nextInt();
		
		if(year <= 0){
			System.out.println("The year must be positive!");
			System.exit(0);
		}
		
		if((firstDay < 0 ) ||(firstDay > 6)){
			System.out.println("The day of January 1st must be between 0 and 6!");
			System.exit(0);
		}
		
		String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(isLeapYear(year)){
			monthDays[1] = 29;
		}
		
		for(int i = 0; i < 12; i++){
			firstDay = printMonth(monthNames[i], firstDay, monthDays[i]);
		}
	}

}
