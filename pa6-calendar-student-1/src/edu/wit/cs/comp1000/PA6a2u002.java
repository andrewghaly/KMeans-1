package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a2u002 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		if((year % 4 == 0) && (year % 100 != 0)){
			return true;}
		if(year % 400 == 0){
			return true;}
		return false;
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);
		int dayofweek = 1;
		int z;
		while(dayofweek <= numDays){
			if(dayofweek == 1){
				for(z = 0; z < startDay; z++){
					System.out.print("   ");
				}
			}
		
		System.out.printf("%3d", dayofweek);
		dayofweek++;
		if(startDay < 6){
			startDay++;}
		else{
			System.out.println();
			startDay = 0;}
		if(dayofweek - 1 == numDays && startDay != 0){
			System.out.println();
			System.out.println();}
		else if (dayofweek - 1 == numDays) {
			System.out.println();
		}
		}
		return startDay; 
	}

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		int year;
		int dayofweek;
		
		System.out.print("Enter the year: ");
		year = input.nextInt();
		
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		dayofweek = input.nextInt();
		
		int[] monthdays = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
		
		String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		if(year <= 0){
			System.out.println(E_YEAR);}
		else if(dayofweek < 0 || dayofweek > 6){
			System.out.println(E_DAY);}
		else{
			for(int count = 0; count < months.length; count++){
				dayofweek = printMonth(months[count], dayofweek, monthdays[count]);
			}
		}
		
				
		}
	}


