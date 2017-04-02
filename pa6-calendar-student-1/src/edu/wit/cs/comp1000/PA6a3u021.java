package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a3u021 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		
		if (year % 4 != 0) {
			
			return false;
		}
		else if (year % 100 != 0) {
			
			return true;
		}
		else if (year % 400 != 0) {
			
			return false;
		}
		else {
			
			return true;
		}
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
			
		System.out.println(month);
			
		String spaces = null;
			
		for (int i = 0; i < startDay; ++i) {
				
			if (i == 0)
				spaces = "   ";
			else {
					
				spaces += "   ";
			}
		}
			
		if (spaces != null)
		System.out.print(spaces);
			
		int temp_day = 1;
			
		for (int i = startDay + 1; i < numDays + startDay + 1; ++i) {
				
			if (i % 7 == 0 && i != 0) {
					
				if ((i == 7 || (i == 14 && temp_day == 9) || (i == 14 && temp_day == 8)) && i != numDays + startDay) {
						
					System.out.printf("  " + temp_day + "%n");
				}
				else if (i == numDays + startDay) {
					
					if (i == 7 || (i == 14 && temp_day < 10)) {
						
						System.out.printf("  " + temp_day);
					}
					else {
						
						System.out.printf(" " + temp_day);
					}
				}
				else {
							
					System.out.printf(" " + temp_day + "%n");
				}
			}
			else {
				
				if (temp_day < 10) {
						
					System.out.print("  " + temp_day);
				}
				else {
						
					System.out.print(" " + temp_day);
				}
			}
				
			++temp_day;
		}
			
		System.out.println("");
		System.out.println("");
		
		
		return (numDays + startDay) % 7;
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int year, day_of_week;
		
		System.out.print("Enter the year: ");
		year = input.nextInt();
		
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		day_of_week = input.nextInt();
		
		if (day_of_week < 0 || day_of_week > 6) {
			
			System.out.println(E_DAY);
		}
		else if (year < 0) {
			
			System.out.println(E_YEAR);
		}
		else {
			
			if (isLeapYear(year)) {
				
				int returns = printMonth("January", day_of_week, 31);
				returns = printMonth("February", returns, 29);
				returns = printMonth("March", returns, 31);
				returns = printMonth("April", returns, 30);
				returns = printMonth("May", returns, 31);
				returns = printMonth("June", returns, 30);
				returns = printMonth("July", returns, 31);
				returns = printMonth("August", returns, 31);
				returns = printMonth("September", returns, 30);
				returns = printMonth("October", returns, 31);
				returns = printMonth("November", returns, 30);
				returns = printMonth("December", returns, 31);
			}
			else {
				
				int returns = printMonth("January", day_of_week, 31);
				returns = printMonth("February", returns, 28);
				returns = printMonth("March", returns, 31);
				returns = printMonth("April", returns, 30);
				returns = printMonth("May", returns, 31);
				returns = printMonth("June", returns, 30);
				returns = printMonth("July", returns, 31);
				returns = printMonth("August", returns, 31);
				returns = printMonth("September", returns, 30);
				returns = printMonth("October", returns, 31);
				returns = printMonth("November", returns, 30);
				returns = printMonth("December", returns, 31);
			}
		}
		
		input.close();
	}

}



















