package edu.wit.cs.comp1000;
import java.util.*;
import java.text.*;
public class PA6a2u001 {

	static final String E_YEAR = " The year must be positive!";

	static final String E_DAY = " The day of January 1st must be between 0 and 6!";

	public static boolean isLeapYear(int year) {

		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				}
				else return false;	
				} 
			else
				return true;
			}
			else
				return false;

		}

	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);

		int array[] = new int[numDays];
		int count = 0;
		int c = 0;
		int k = 3 * startDay;
		for (c = 0; c < k; c++) {

			System.out.print(" ");
		}

		for (int i = 0; i < numDays; i++) {
			array[i] = i + 1;

			if (array[i] < 10) {
				System.out.print("  " + array[i] );
				count++;
			}

			if (array[i] >= 10) {
				System.out.print(" " + array[i]);
				count++;
			}
			int value = count + startDay;
			if (value % 7 == 0) {
				System.out.println();

			}
		}
		int nextday = (count + startDay) % 7;
		System.out.println();
		return nextday;

	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inYear;
		int year, start1, start2, start3, start4, start5, start6, start7, start8, start9, start10, start11, start12;
		System.out.print(
				"Enter the year: Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday):");
		year = input.nextInt();
		start1 = input.nextInt();
		
		if (year <= 0) {
			System.out.println(E_YEAR);
		} else if (start1 < 0 || start1 > 6) {
			System.out.println(E_DAY);
		} else {
			start2 = printMonth(" January", start1, 31);
			boolean chkyear = isLeapYear(year);
			if (chkyear == true) {
				start3 = printMonth("February", start2, 29);
			} else {
				start3 = printMonth("February", start2, 28);
			}
			start4 = printMonth("March", start3, 31);
			System.out.println();
			start5 = printMonth("April", start4, 30);
			System.out.println();
			start6 = printMonth("May", start5, 31);
			System.out.println();
			start7 = printMonth("June", start6, 30);
			System.out.println();
			start8 = printMonth("July", start7, 31);
			System.out.println();
			start9 = printMonth("August", start8, 31);
			System.out.println();
			start10 = printMonth("September", start9, 30);
			System.out.println();
			start11 = printMonth("October", start10, 31);
			start12 = printMonth("November", start11, 30);
			System.out.println();
			start1 = printMonth("December", start12, 31);
			System.out.println();

		}
	}

}
