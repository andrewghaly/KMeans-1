package edu.wit.cs.comp1000;
import java.util.Scanner;
public class PA6a3u010 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		if (year % 4 != 0)
			return false;
		else if (year % 100 != 0)
			return true;
		else if (year % 400 != 0)
			return false;
		else
			return true;
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		int weekday = startDay, date = 1;
		System.out.printf("%s%n", month);
		for(int i = 0; i < startDay; i++){
			System.out.printf("   ");
		}
		do{
			if(date < 10){
				System.out.printf("  %d", date);
			}else{
				System.out.printf(" %d", date);
			}
			weekday++; date++;
			if(weekday > 6 && date <= numDays){
				System.out.printf("%n");
				weekday = 0;
			}else if(weekday > 6){
				weekday = 0;
			}
		}while(date <= numDays);
		System.out.printf("%n%n");
		return weekday;
	}

	public static void main(String[] args) {
		int year, weekday;
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int[] month_lengths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter the year: ");
		year = sc.nextInt();
		System.out.printf("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		weekday = sc.nextInt();
		if(year < 0){
			System.out.printf("%s%n", E_YEAR);
			System.exit(0);
		}
		if(weekday < 0 || weekday > 6){
			System.out.printf("%s%n", E_DAY);
			System.exit(0);
		}
		if(isLeapYear(year)){
			month_lengths[1] = 29;
		}
		for(int i = 0; i < 12; i++){
			weekday = printMonth(months[i], weekday, month_lengths[i]);
		}
	}

}
