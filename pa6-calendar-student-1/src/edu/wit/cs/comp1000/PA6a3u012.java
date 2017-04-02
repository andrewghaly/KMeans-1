package edu.wit.cs.comp1000;
import java.util.Scanner;


public class PA6a3u012 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
			if (year%4!=0) {
			return false;
		}
			else if(year%100!=0) {
				return true;
			}
			else if(year%400!=0) {
				return false;
			}
			else	{
				return true;
			}
			
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		int dow= 0;
		System.out.println(month);
		 
		 for(int i=0; i<startDay; i++) {
			 System.out.print("   ");
			 dow++;
		 }
		 for(int i=1; i<=numDays; i++){
			 if (i<10){
			System.out.print("  " +i);
			dow++;
			 }
			 else {
			System.out.print(" " +i);
			dow++;
			 }
			 if (dow > 6) {
				 dow=0;
				 System.out.println("");
			 }
		 }
		if (dow == 0) {
			System.out.println("");
		}
		else {
			System.out.println("");
			System.out.println("");
		}
		return dow;
	}
	
		


	public static void main(String[] args) {
		
		Scanner input= new Scanner(System.in);		
		
		int fd=0;
		System.out.print("Enter the year: ");
		int year= input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int day= input.nextInt();
		
		if (year<1){
		System.out.println(E_YEAR);
		System.exit(0);
		}
		if ((day>6) || (day<0)){
			System.out.println(E_DAY);
			System.exit(0);
		}
		
		if(isLeapYear(year)) {
			fd=29;
		}
		else {
			fd=28;
		}
		
		int prev;
		prev= printMonth("January", day, 31);
		prev= printMonth("February", prev, fd);
		prev= printMonth("March", prev, 31);
		prev= printMonth("April", prev, 30);
		prev= printMonth("May", prev, 31);
		prev= printMonth("June", prev, 30);
		prev= printMonth("July", prev, 31);
		prev= printMonth("August", prev, 31);
		prev= printMonth("September", prev, 30);
		prev= printMonth("October", prev, 31);
		prev= printMonth("November", prev, 30);
		prev= printMonth("December", prev, 31);
	}
		
	}


