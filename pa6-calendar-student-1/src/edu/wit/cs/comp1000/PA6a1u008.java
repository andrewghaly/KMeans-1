package edu.wit.cs.comp1000;
import java.util.Scanner;
public class PA6a1u008 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)){
			return true;
		}
		else return false; 
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		int count = 0;
		System.out.println(month);
		while (count<startDay){
			System.out.print("   ");
			count++;
		}
		count=1;
		while (count<=numDays){
		if (count<10){
		System.out.print("  "+count);
		}
		else System.out.print(" "+count);
		startDay++;
		count++;
		if (startDay>=7){
			if (count!=numDays+1) System.out.println();
			startDay=0;
		}
		}
		System.out.println();
		System.out.println();
		return startDay; 
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean check = false;
		int y=-1, dW=-1, m;
		System.out.print("Enter the year: ");
		y = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		dW = input.nextInt();
		if (y<0){
			System.out.println(E_YEAR);
			System.exit(0);
		}
		if (dW<0 || dW>6){
			System.out.println(E_DAY);
			System.exit(0);
		}
		check = isLeapYear(y);
		dW = printMonth("January", dW, 31);
		if (check==true){
			dW = printMonth("February", dW, 29);
		}
		else dW = printMonth("February", dW, 28);
		dW = printMonth("March", dW, 31);
		dW = printMonth("April", dW, 30);
		dW = printMonth("May", dW, 31);
		dW = printMonth("June", dW, 30);
		dW = printMonth("July", dW, 31);
		dW = printMonth("August", dW, 31);
		dW = printMonth("September", dW, 30);
		dW = printMonth("October", dW, 31);
		dW = printMonth("November", dW, 30);
		dW = printMonth("December", dW, 31);
	}

}
