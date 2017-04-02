package edu.wit.cs.comp1000;
import java.util.Scanner;
public class PA6a1u017 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		if (year >= 2000 && year % 4 == 0) {
			return true;
		} else if (year % 100 == 0 && year % 400 == 0) {
			return true;
		}else{
		return false;
		}
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);
		int day_of_week = 1;
		int i = 0;
		while(day_of_week <= numDays){
			if(day_of_week == 1){
				for(i=0; i < startDay; i++){
					System.out.print("   ");}
			}
		System.out.printf("%3d", day_of_week);
		day_of_week++;
		
		if(startDay < 6){
			startDay++;
		}
		else{
			System.out.println();
			startDay =0; 
		}
		
		if(day_of_week - 1 == numDays && startDay != 0){
			System.out.println();
			System.out.println();
		} else if (day_of_week - 1 == numDays) {
			System.out.println();
		}
		
		
		}			
		return startDay;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year;
		int day;
		
		System.out.print("Enter the year: ");
		year = input.nextInt();
		
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		day = input.nextInt();
		
		int[] myArray = new int[] {31,28,31,30,31,30,31,31,30,31,30,31
				
		};
		 String[] yourArray = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		 
		 if(year <= 0){
			 System.out.println(E_YEAR);}
			 else if(day < 0 || day > 6){
				 System.out.println(E_DAY);
			 }else{ 
				 for (int x = 0; x < yourArray.length; x++) {
					 day = printMonth(yourArray[x], day, myArray[x]);
					 
				 }
					 
				 }
			 }
		 
			 }
		 
		
	
