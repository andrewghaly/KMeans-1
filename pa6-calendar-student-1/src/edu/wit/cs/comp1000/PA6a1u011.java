package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a1u011 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		 
		
		if (year %4 == 0 && year % 100 != 0 || year % 400 == 0 ){
			return true;
		}
		else{
			return false;
		}
		
		
	}
	
	public static int printMonth(String month, int startDay, int numDays){
		
		System.out.println(month);
		for(int i = 0; i < startDay; i++){
			System.out.print("   ");
	}
	 for(int i=1; i <= numDays; i++){
		 if(i<10){
			 System.out.print("  " + i);
		 }else{
			 System.out.print(" " + i);
		 }
		 
		 startDay++;
		 if(startDay%7 == 0 && i != numDays){
			 System.out.println();
		 }
	 }
	 System.out.println();
	System.out.println();	 
	
	return startDay % 7;
	
	}
	
	public static void main(String[] args) {
		
		Scanner input =new Scanner(System.in);
		
		System.out.print("Enter the year: ");
		System.out.print ("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): " );
		
		int year = input.nextInt();
		
		if (year < 0){
			System.out.println(E_YEAR);
		System.exit(0);
		}
		
		
		int startDay = input.nextInt();
		if(startDay < 0 || startDay > 6){
			System.out.println(E_DAY);
		System.exit(0);
		}
		
		
		int[] numDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


		if(isLeapYear(year) == false){

			numDays[1] = 28;
		}
	 
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		for(int i = 0; i < months.length; i++ ){
			
			printMonth(months[i],startDay,numDays[i]);
		}
	}
	
	
}
	
		
