package edu.wit.cs.comp1000;
import java.util.Scanner;


public class PA6a3u009 {
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	
	
	
	public static boolean isLeapYear(int year) {
		if(year % 4 != 0){
			return false;
		}else if(year % 100 != 0){
			return true;
		}else if(year % 400 != 0){
			return false;
		}else{
			return true;
		}

	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);
		
			switch(startDay){
				case 0:	System.out.printf("");
						startDay = loopDays(startDay, numDays);
						System.out.println();
						break;
				case 1:	System.out.printf("   ");
						startDay = loopDays(startDay, numDays);
						System.out.println();
						break;
				case 2:	System.out.printf("      ");
						startDay = loopDays(startDay, numDays);
						System.out.println();
						break;
				case 3: System.out.printf("         ");
						startDay = loopDays(startDay, numDays);		
						System.out.println();
						break;
				case 4: System.out.printf("            ");
						startDay = loopDays(startDay, numDays);		
						System.out.println();
						break;
				case 5: System.out.printf("               ");
						startDay = loopDays(startDay, numDays);		
						System.out.println();
						break;
				case 6: System.out.printf("                  ");
						startDay = loopDays(startDay, numDays);		
						System.out.println();
						break;
			}

		return startDay; 
	}

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		int year = 0;
		int startDay = 0;
		boolean isLeapYear;
		
		System.out.printf("Enter the year: ");
		year = userInput.nextInt();
		
		isLeapYear = isLeapYear(year);
		
		int monthIncrement = 0;
		String[] monthArray = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		String month = monthArray[monthIncrement]; 
		
	
		int daysIncrement = 0;
		int[] numDaysArray = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int numDays = numDaysArray[daysIncrement];
	
		if(isLeapYear == true){
			numDaysArray[1] = 29;
		}
		
		System.out.printf("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		startDay = userInput.nextInt();
		
		if(startDay < 0 || startDay > 6){
			System.out.println(E_DAY);
		}else{
			
			if(year < 0){
				System.out.println(E_YEAR);
			}else{
				startDay = printMonth(month, startDay, numDays);
				monthIncrement++;
				month = monthArray[monthIncrement];
				daysIncrement++;
				numDays = numDaysArray[daysIncrement];
			
				
				
				startDay = printMonth(month, startDay, numDays);
				monthIncrement++;
				month = monthArray[monthIncrement];
				daysIncrement++;
				numDays = numDaysArray[daysIncrement];
			
				
				startDay = printMonth(month, startDay, numDays);
				monthIncrement++;
				month = monthArray[monthIncrement];
				daysIncrement++;
				numDays = numDaysArray[daysIncrement];
		
				startDay = printMonth(month, startDay, numDays);
				monthIncrement++;
				month = monthArray[monthIncrement];
				daysIncrement++;
				numDays = numDaysArray[daysIncrement];
			
				startDay = printMonth(month, startDay, numDays);
				monthIncrement++;
				month = monthArray[monthIncrement];
				daysIncrement++;
				numDays = numDaysArray[daysIncrement];
	
				startDay = printMonth(month, startDay, numDays);
				monthIncrement++;
				month = monthArray[monthIncrement];
				daysIncrement++;
				numDays = numDaysArray[daysIncrement];

				startDay = printMonth(month, startDay, numDays);
				monthIncrement++;
				month = monthArray[monthIncrement];
				daysIncrement++;
				numDays = numDaysArray[daysIncrement];
				
				startDay = printMonth(month, startDay, numDays);
				monthIncrement++;
				month = monthArray[monthIncrement];
				daysIncrement++;
				numDays = numDaysArray[daysIncrement];
				
				startDay = printMonth(month, startDay, numDays);
				monthIncrement++;
				month = monthArray[monthIncrement];
				daysIncrement++;
				numDays = numDaysArray[daysIncrement];
			
				startDay = printMonth(month, startDay, numDays);
				monthIncrement++;
				month = monthArray[monthIncrement];
				daysIncrement++;
				numDays = numDaysArray[daysIncrement];
			
				startDay = printMonth(month, startDay, numDays);
				monthIncrement++;
				month = monthArray[monthIncrement];
				daysIncrement++;
				numDays = numDaysArray[daysIncrement];
				
				startDay = printMonth(month, startDay, numDays);
				
			}
		}

		
		
	}
	
	
	public static int loopDays(int startDay, int numDays){
		int calendarDayNumber = 1;
		
		while(calendarDayNumber <= numDays){
			for(int i = startDay; i < 7; i++){
				
				if(calendarDayNumber < 10){
					System.out.printf("  %d", calendarDayNumber);
				}else{
					System.out.printf(" %d", calendarDayNumber);
				}
				calendarDayNumber++;
			
				if(i == 6){
					System.out.println();
				}
				if(calendarDayNumber > numDays){
					startDay = i + 1;
					if(startDay == 7){
						startDay = 0;
					}else{
						System.out.println();
					}	
					return startDay;
					
				}
			}
		
			startDay = 0;
			
		}
		
		return startDay;
	}
	
}
