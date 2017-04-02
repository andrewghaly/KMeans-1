package edu.wit.cs.comp1000;
import java.util.Scanner;
public class PA6a1u016 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
			return true;
		}else
		return false;
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);
		int i = 0;
		int day = 1;
		
		while(i < startDay){
			System.out.print("   ");
			i++;
		}
		
		while(day <= numDays){
			String space;
			if(day < 10){
				space = "  ";
			}else{
				space = " ";
			}
			System.out.print(space + day);
			day++;
			startDay = (startDay+1) % 7;
			if(startDay == 0){
				System.out.println();
			}
		}
		
		if(startDay != 0){
			System.out.println();
		}
		
		System.out.println();
		return startDay;
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int leap = 0;
		
		System.out.print("Enter the year: ");
		int year = reader.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int first = reader.nextInt();
		if(year <= 0){
			System.out.println(E_YEAR);
			System.exit(0);
		}else if(first < 0 || first > 6){
			System.out.println(E_DAY);
			System.exit(0);
		}
		
		if(isLeapYear(year)){
			leap = 1;
		}
		
		String[] months = {
				"January" , "February" , "March" , "April" , "May" , "June" , 
				"July" , "August" , "September" , "October" , "November" , "December"
		};
		int[] numDays = {31, 28 + leap, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for(int i = 0; i < months.length; i++){
			first = printMonth(months[i] , first , numDays[i]);
		}
	}

}
