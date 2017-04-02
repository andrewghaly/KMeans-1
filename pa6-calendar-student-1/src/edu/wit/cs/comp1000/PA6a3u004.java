package edu.wit.cs.comp1000;
import java.util.Scanner;
public class PA6a3u004 {

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

	for (int i = 0; i < startDay; i++) {
		System.out.print("   ");
	}
	for (int i = 1; i <= numDays; i++) {
		if (i < 10) {
		System.out.print("  " + i);	
	}
	else {
		System.out.print(" " + i);
	}
	startDay++;
	if (startDay % 7 == 0) {
		if (i != numDays){
			System.out.println();
	}
	}
	}
		System.out.println();
		System.out.println();

		return startDay % 7;
	}
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);

	int day = 0, year = 0;
	String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

	System.out.print("Enter the year: ");
	year = input.nextInt();

	System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
	day = input.nextInt();

	if (year < 0) {
	   System.out.println(E_YEAR);
	   System.exit(0);
	}
	if (day < 0 || day > 6) {
	   System.out.println(E_DAY);
	   System.exit(0);
	}
    int Feb = 28;
    
    if (isLeapYear(year))
	   Feb = 29;

		day = printMonth(months[0], day, 31);
		day = printMonth(months[1], day, Feb);
		day = printMonth(months[2], day, 31);
		day = printMonth(months[3], day, 30);
		day = printMonth(months[4], day, 31);
		day = printMonth(months[5], day, 30);
		day = printMonth(months[6], day, 31);
		day = printMonth(months[7], day, 31);
		day = printMonth(months[8], day, 30);
		day = printMonth(months[9], day, 31);
		day = printMonth(months[10], day, 30);
		day = printMonth(months[11], day, 31);
		
	input.close();

	}
}
