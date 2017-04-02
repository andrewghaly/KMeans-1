 package edu.wit.cs.comp1000;
 import java.util.Scanner;
 
public class PA6a3u019 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		
		if(year % 4 != 0){
			return false;
		}
		else if(year % 100 != 0){
			return true;
		}
		else if(year % 400 != 0){
			return false;
		}
		else{
			return true;
		}
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		
		System.out.println(month);

		for(int i = 0; i < startDay; i++){
			System.out.print("   ");
		}

		for(int i = 1; i <= numDays; i++){
			if(startDay == 6){                 
				if(i < 10){						
					System.out.println("  " + i); 
				}
				else{							
					System.out.println(" " + i);
				}
				startDay = 0;
				
			}
			else if(i < 10){				
				System.out.print("  " + i);
				startDay++;					
			}
			else{
				System.out.print(" " + i);
				startDay++;
			}
			
			if(i == numDays && startDay == 0){
													
				System.out.println();
			}
			
			else if(i == numDays && (startDay > 0)){

				System.out.println();
				System.out.println();
			}
		}
			
			return startDay;
}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the year: "); 
		int year = input.nextInt(); 
		
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int startingDay = input.nextInt();
		
		if(year < 0){
			System.out.println(E_YEAR);
		}
		else if(startingDay < 0 || startingDay > 6){
			System.out.println(E_DAY);
		}
		else{
			
		startingDay = printMonth("January", startingDay, 31);
		
		if (isLeapYear(year)){
			startingDay = printMonth("February", startingDay, 29);
		}
		else{
			startingDay = printMonth("February", startingDay, 28);
		}
		
		startingDay = printMonth("March", startingDay, 31);

		startingDay = printMonth("April", startingDay, 30);

		startingDay = printMonth("May", startingDay, 31);
		
		startingDay = printMonth("June", startingDay, 30);
	
		startingDay = printMonth("July", startingDay, 31);

		startingDay = printMonth("August", startingDay, 31);
		
		startingDay = printMonth("September", startingDay, 30);
	
		startingDay = printMonth("October", startingDay, 31);
	
		startingDay = printMonth("November", startingDay, 30);
		
		startingDay = printMonth("December", startingDay, 31);
		
		} 
	}
}
