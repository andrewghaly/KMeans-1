package edu.wit.cs.comp1000;

import java.util.Scanner;

//import exercise.April;
//import exercise.January;
//import exercise.July;
//import exercise.October;

public class PA6a3u006 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		if ((year%400 == 0) || ((year%4 == 0) && (year%100 != 0))) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static int printMonth(String month, int startDay, int numDays) {
		System.out.printf(""+month+"%n");
		int i;
		for(int s=0; s<=startDay-1; s++){
			System.out.printf("   ");
		}
		
		for(i=0; i<=numDays; i++, startDay++){
			if(i>0){
			System.out.printf("%3d", i);
			}
			if(startDay==7){
				System.out.println();
				startDay=0;
			
			}
		}
		if(startDay>1){
		System.out.println();
		}
		System.out.println();
		return startDay-1; 
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year, start;
		boolean leap;
		
		System.out.print("Enter the year: ");
		year = input.nextInt();
		System.out.printf("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		start = input.nextInt();
		
		if(year<=0){
			System.out.println("The year must be positive!");
		}
		if((start<0) || (start>6)){
			System.out.println("The day of January 1st must be between 0 and 6!");
		}
		if((year>0) && (start>=0) && start<=6){
		leap = isLeapYear(year);
		
		
		start=printMonth("January", start, 31);
		
		if(leap==true){
		start=printMonth("February", start, 29);
		}else if(leap==false){
		start=printMonth("February", start, 28);
		}
		
		start=printMonth("March", start, 31);
		start=printMonth("April", start, 30);
		start=printMonth("May", start, 31);
		start=printMonth("June", start, 30);
		start=printMonth("July", start, 31);
		start=printMonth("August", start, 31);
		start=printMonth("September", start, 30);
		start=printMonth("October", start, 31);
		start=printMonth("November", start, 30);
		start=printMonth("December", start, 31);
	}

}
}
