package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a3u022 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		double leap = year % 4;
		double leap2 = year % 100;
		double leap3 = year % 400;
		if (leap != 0){
			return false;
		}
		else if (leap2 != 0){
			return true;
		}
		else if (leap3 != 0){
			return false;
		}
		else {
			return true;
		}
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);
		int x =0;
		if (startDay == 0){
			System.out.println("  1  2  3  4  5  6  7");
			System.out.println("  8  9 10 11 12 13 14");
			System.out.println(" 15 16 17 18 19 20 21");
			System.out.println(" 22 23 24 25 26 27 28");
			if (numDays == 29){
				System.out.println(" 29");
				x = 1;
			}
			if (numDays == 30){
				System.out.println(" 29 30");
				x = 2;
			}
			if (numDays == 31){
				System.out.println(" 29 30 31");
				x = 3;
			}
		}
		if (startDay == 1){
			System.out.println("     1  2  3  4  5  6");
			System.out.println("  7  8  9 10 11 12 13");
			System.out.println(" 14 15 16 17 18 19 20");
			System.out.println(" 21 22 23 24 25 26 27");
			if (numDays == 28){
				System.out.println(" 28");
				x = 1;
			}
			if (numDays == 29){
				System.out.println(" 28 29");
				x = 2;
			}
			if (numDays == 30){
				System.out.println(" 28 29 30");
				x = 3;
			}
			if (numDays == 31){
				System.out.println(" 28 29 30 31");
				x = 4;
			}
		}
		if (startDay == 2){
			System.out.println("        1  2  3  4  5");
			System.out.println("  6  7  8  9 10 11 12");
			System.out.println(" 13 14 15 16 17 18 19");
			System.out.println(" 20 21 22 23 24 25 26");
			if (numDays == 28){
				System.out.println(" 27 28");
				x = 2;
			}
			if (numDays == 29){
				System.out.println(" 27 28 29");
				x = 3;
			}
			if (numDays == 30){
				System.out.println(" 27 28 29 30");
				x = 4;
			}
			if (numDays == 31){
				System.out.println(" 27 28 29 30 31");
				x = 5;
			}
		}
		if (startDay == 3){
			System.out.println("           1  2  3  4");
			System.out.println("  5  6  7  8  9 10 11");
			System.out.println(" 12 13 14 15 16 17 18");
			System.out.println(" 19 20 21 22 23 24 25");
			if (numDays == 28){
				System.out.println(" 26 27 28");
				x = 3;
			}
			if (numDays == 29){
				System.out.println(" 26 27 28 29");
				x = 4;
			}
			if (numDays == 30){
				System.out.println(" 26 27 28 29 30");
				x = 5;
			}
			if (numDays == 31){
				System.out.println(" 26 27 28 29 30 31");
				x = 6;
			}
		}
		if (startDay == 4){
			System.out.println("              1  2  3");
			System.out.println("  4  5  6  7  8  9 10");
			System.out.println(" 11 12 13 14 15 16 17");
			System.out.println(" 18 19 20 21 22 23 24");
			if (numDays == 28){
				System.out.println(" 25 26 27 28");
				x = 4;
			}
			if (numDays == 29){
				System.out.println(" 25 26 27 28 29");
				x= 5;
			}
			if (numDays == 30){
				System.out.println(" 25 26 27 28 29 30");
				x = 6;
			}
			if (numDays == 31){
				System.out.println(" 25 26 27 28 29 30 31");
				x = 0;
			}
		}
		if (startDay == 5){
			System.out.println("                 1  2");
			System.out.println("  3  4  5  6  7  8  9");
			System.out.println(" 10 11 12 13 14 15 16");
			System.out.println(" 17 18 19 20 21 22 23");
			if (numDays == 28){
				System.out.println(" 24 25 26 27 28");
				x = 5;
			}
			if (numDays == 29){
				System.out.println(" 24 25 26 27 28 29");
				x = 6;
			}
			if (numDays == 30){
				System.out.println(" 24 25 26 27 28 29 30");
				x = 0;
			}
			if (numDays == 31){
				System.out.println(" 24 25 26 27 28 29 30");
				System.out.println(" 31");
				x = 1;
			}
		}
		if (startDay == 6){
			System.out.println("                    1");
			System.out.println("  2  3  4  5  6  7  8");
			System.out.println("  9 10 11 12 13 14 15");
			System.out.println(" 16 17 18 19 20 21 22");
			if (numDays == 28){
				System.out.println(" 23 24 25 26 27 28");
				x = 6;
			}
			if (numDays == 29){
				System.out.println(" 23 24 25 26 27 28 29");
				x = 0;
			}
			if (numDays == 30){
				System.out.println(" 23 24 25 26 27 28 29");
				System.out.println(" 30");
				x = 1;
			}
			if (numDays == 31){
				System.out.println(" 23 24 25 26 27 28 29");
				System.out.println(" 30 31");
				x = 2;
			}
		}
		return x;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int year = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int startDay = input.nextInt();
		if (year <= 0){
			System.out.println(E_YEAR);
			System.exit(0);
		}
		if ((startDay < 0) || (startDay > 7)){
			System.out.println(E_DAY);
			System.exit(0);
		}
		isLeapYear(year);
		String[] month = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int[] numDays = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		startDay = printMonth("January", startDay, 31);
		System.out.println();
		if (false){
			startDay = printMonth("February", startDay, 29);
		}
		else{
			startDay = printMonth("February", startDay, 28);
		}
		System.out.println();
		startDay = printMonth("March", startDay, 31);
		System.out.println();
		startDay = printMonth("April", startDay, 30);
		System.out.println();
		startDay = printMonth("May", startDay, 31);
		System.out.println();
		startDay = printMonth("June", startDay, 30);
		System.out.println();
		startDay = printMonth("July", startDay, 31);
		System.out.println();
		startDay = printMonth("August", startDay, 31);
		System.out.println();
		startDay = printMonth("September", startDay, 30);
		System.out.println();
		startDay = printMonth("October", startDay, 31);
		System.out.println();
		startDay = printMonth("November", startDay, 30);
		System.out.println();
		startDay = printMonth("December", startDay, 31);
		System.out.println();
	}

}
