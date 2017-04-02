package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a1u006 {
	
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
		System.out.printf("%s%n", month);
		
		int d = startDay;
		
		if(d > 0){
			for(int j = 1; j <= d; j++ ){
				System.out.printf("   ");
			}
		}
		
		for(int i = 1; i <= numDays; i++){
			if(d == 6){
				if(i == numDays){
					if(i < 10){
						System.out.printf("  %d%n%n", i);
					}else{
						System.out.printf(" %d%n%n", i);
					}
					if(d == 6){
						d = 0;
					}else{
						d++;
					}
				}else{
					if(i < 10){
						System.out.printf("  %d%n", i);
					}else{
						System.out.printf(" %d%n", i);
					}
					if(d == 6){
						d = 0;
					}else{
						d++;
					}
				}
			}else{
				if(i == numDays){
					if(i < 10){
						System.out.printf("  %d%n%n", i);
					}else{
						System.out.printf(" %d%n%n", i);
					}
					if(d == 6){
						d = 0;
					}else{
						d++;
					}
				}else{
					if(i < 10){
						System.out.printf("  %d", i);
					}else{
						System.out.printf(" %d", i);
					}
					if(d == 6){
						d = 0;
					}else{
						d++;
					}
				}
			}	
		}
		return d;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int yr;
		int dOne;
		
		System.out.printf("Enter the year: ");
		yr = in.nextInt();
		System.out.printf("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		dOne = in.nextInt();
		
		if(yr < 0){
			System.out.printf("%s%n", E_YEAR);
		}else if(dOne < 0 || dOne > 6){
			System.out.printf("%s%n", E_DAY);
		}else{
			int nDay;
			
			nDay = printMonth("January", dOne, 31);
			
			if(isLeapYear(yr)){
				nDay = printMonth("February", nDay, 29);
			}else{
				nDay = printMonth("February", nDay, 28);
			}
			
			nDay = printMonth("March", nDay, 31);
		
			nDay = printMonth("April", nDay, 30);

			nDay = printMonth("May", nDay, 31);

			nDay = printMonth("June", nDay, 30);

			nDay = printMonth("July", nDay, 31);

			nDay = printMonth("August", nDay, 31);

			nDay = printMonth("September", nDay, 30);

			nDay = printMonth("October", nDay, 31);

			nDay = printMonth("November", nDay, 30);

			nDay = printMonth("December", nDay, 31);
		}
	}

}
