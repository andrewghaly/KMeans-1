package edu.wit.cs.comp1000;
import java.util.Scanner;

public class PA6a3u014 {
	
	public static boolean isLeapYear(int year) {
		if(year%4!=0){
		return false;
		}
		else if(year%100!=0){
		return true;
		}
		else if(year%400!=0){
		return false;
		}
		else
		return true;
	}
	
	public static void main(String[] args) {
		
		int year;
		int startDay;
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the year: ");
		year = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		startDay = input.nextInt();
		
		if(year <= 0){
			System.out.println("The year must be positive!");
			System.exit(0);
		}
		else if(startDay < 0 || startDay > 6){
			System.out.println("The day of January 1st must be between 0 and 6!");
			System.exit(0);
		}
		startDay= printMonth("January", startDay,31);
		if (isLeapYear(year)){
		startDay= printMonth("February", startDay,29);
		}
		else{
		startDay= printMonth("February", startDay,28);
		}
		startDay= printMonth("March", startDay,31);
		startDay= printMonth("April", startDay,30);
		startDay= printMonth("May", startDay,31);
		startDay= printMonth("June", startDay,30);
		startDay= printMonth("July", startDay,31);
		startDay= printMonth("August", startDay,31);
		startDay= printMonth("September", startDay,30);
		startDay= printMonth("October", startDay,31);
		startDay= printMonth("November", startDay,30);
		startDay= printMonth("December", startDay,31);
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);
		
		for(int i = 0; i<=startDay-1; i=i+1){
			System.out.print("   ");
		}
		for(int a = 1; a<=numDays; a=a+1){
			if (a < 10){
				System.out.print("  "+ a);
			}
			else
				System.out.print(" "+ a);
		startDay++;
		if (startDay % 7==0 && a != numDays){
			System.out.println();
		}
	}
		System.out.println();
		System.out.println();
		
		return startDay%7;
}
}
