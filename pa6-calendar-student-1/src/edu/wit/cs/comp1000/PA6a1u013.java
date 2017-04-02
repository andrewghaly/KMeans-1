package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a1u013 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);
		System.out.print(" ");
				if(startDay == 1){
					System.out.print("   ");
				}
				else if(startDay == 2){
					System.out.print("      ");
			    }
				else if(startDay == 3){
					System.out.print("         ");
			    }
				else if(startDay == 4){
					System.out.print("            ");
			    }
				else if(startDay == 5){
					System.out.print("               ");
			    }
				else if(startDay == 6){
					System.out.print("                  ");
				}
		for(int i = 0; i < numDays; i++){
			if(startDay > 6){
				System.out.println("");
				System.out.print(" ");
				startDay = 0;	
			}
			if(i < 9){
			System.out.print(" ");
			}
			System.out.print(i+1);
			if (startDay < 6 && i+1 != numDays){ System.out.print(" ");}
			startDay++;
		}
		System.out.println("");
		System.out.println("");
		if(startDay > 6){startDay = 0;}
		return startDay;
	}
	
	public static boolean isLeapYear(int year){
		if (year % 4 != 0){
			return false;
		}
		else if (year % 100 != 0){
			return true;
		}
		else if (year % 400 != 0){
			return false;
		}
		else {return true;}
	}
	
	public static void main(String[] args) {
		int year, day;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year: ");
		 year = input.nextInt();
		 System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		 day = input.nextInt();
		 if(year <0){
			 System.out.println(E_YEAR);
		 }
		 else if(day < 1 || day > 6){
			 System.out.println(E_DAY);
		 }
		 else{
		 int endDay = 0; 
		 for(int i = 0; i < 12; i++){
			 if(i == 0){
				 endDay = printMonth("January", day, 31);
				}
			 else if(i == 1){
				 if(isLeapYear(year) == true){
				 endDay = printMonth("Febuary", endDay, 29);
				 }
				 else{
					 endDay = printMonth("February", endDay, 28);
					 }
			 }
			 else if(i == 2){
				 endDay = printMonth("March", endDay, 31);
			 }
			 else if(i == 3){
				 endDay = printMonth("April", endDay, 30);
			 }
			 else if(i == 4){
				 endDay = printMonth("May", endDay, 31);
			 }
			 else if(i == 5){
				 endDay = printMonth("June", endDay, 30);
			 }
			 else if(i == 6){
				 endDay = printMonth("July", endDay, 31);
			 }
			 else if(i == 7){
				 endDay = printMonth("August", endDay, 31);
			 }
			 else if(i == 8){
				 endDay = printMonth("September", endDay, 30);
			 }
			 else if(i == 9){
				 endDay = printMonth("October", endDay, 31);
			 }
			 else if(i == 10){
				 endDay = printMonth("November", endDay, 30);
			 }
			 else if(i == 11){
				 endDay = printMonth("December", endDay, 31);
			 }
		 }
		}
	}
}
