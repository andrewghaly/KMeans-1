package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a2u012 {
	
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
		else
		return true; 
		
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		int i = numDays;
		System.out.println(month);
		if (startDay == 0){
		for (i = 1; i <= numDays; i++){
			if(i >= 10){
				System.out.print(" "+i);
			}
			else {
				System.out.print("  "+i);
			}
		    if((i%7 == 0)||(i==numDays)){
		    	System.out.println();
		    }
		}
		}
		else if (startDay == 1){
			System.out.print("   ");
			for (i = 1; i <= numDays; i++){
				if(i >= 10){
					System.out.print(" "+i);
				}
				else {
					System.out.print("  "+i);
				}
			    if(((i+1)%7 == 0)||(i==numDays)){
		    	System.out.println();
		        }
			}
			}
		else if (startDay == 2){
			System.out.print("      ");
			for (i = 1; i <= numDays; i++){
				if(i >= 10){
					System.out.print(" "+i);
				}
				else {
					System.out.print("  "+i);
				}
			    if(((i+2)%7 == 0)||(i==numDays)){
		    	System.out.println();
		        }
			}
			}
		else if (startDay == 3){
			System.out.print("         ");
			for (i = 1; i <= numDays; i++){
				if(i >= 10){
					System.out.print(" "+i);
				}
				else {
					System.out.print("  "+i);
				}
			    if(((i+3)%7 == 0)||(i==numDays)){
		    	System.out.println();
		        }
			}
			}
		else if (startDay == 4){
			System.out.print("            ");
			for (i = 1; i <= numDays; i++){
				if(i >= 10){
					System.out.print(" "+i);
				}
				else {
					System.out.print("  "+i);
				}
			    if(((i+4)%7 == 0)||(i==numDays)){
		    	System.out.println();
		        }
			}
			}
		else if (startDay == 5){
			System.out.print("               ");
			for (i = 1; i <= numDays; i++){
				if(i >= 10){
					System.out.print(" "+i);
				}
				else {
					System.out.print("  "+i);
				}
			    if(((i+5)%7 == 0)||(i==numDays)){
		    	System.out.println();
		        }
			}
			}
		else if (startDay == 6){
			System.out.print("                  ");
			for (i = 1; i <= numDays; i++){
				if(i >= 10){
					System.out.print(" "+i);
				}
				else {
					System.out.print("  "+i);
				}
			    if(((i+6)%7 == 0)||(i==numDays)){
		    	System.out.println();
		        }
			}
			}
		
		System.out.println();
		
		startDay = (startDay+numDays)%7;
		
		return startDay; 
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year, day, a;
		
		System.out.print("Enter the year: ");
		year = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		day = input.nextInt();
		if (year < 0) {
			System.out.println(E_YEAR);
			System.exit(0);
		}
		if ((day<0)||(day>6)) {
			System.out.println(E_DAY);
			System.exit(0);
		}
		
		
		day=printMonth("January", day, 31);
		if(isLeapYear(year)==true){
			day=printMonth("February", day, 29);
			
		}
		else {
			day=printMonth("February", day, 28);
		}
		day=printMonth("March", day, 31);
		day=printMonth("April", day, 30);
		day=printMonth("May", day, 31);
		day=printMonth("June", day, 30);
		day=printMonth("July", day, 31);
		day=printMonth("August", day, 31);
		day=printMonth("September", day, 30);
		day=printMonth("October", day, 31);
		day=printMonth("November", day, 30);
		day=printMonth("December", day, 31);
		
		
       
	}

}
