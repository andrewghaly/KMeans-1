package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a3u011 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	int[] dayPerMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static boolean isLeapYear(int year) {
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				} else {
					return false;
				}
			} return true;
		} else {
			return false;
		}
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		if (startDay == 0 && numDays >27) {
			System.out.println(month);
			System.out.println("  1  2  3  4  5  6  7");
			System.out.println("  8  9 10 11 12 13 14");
			System.out.println(" 15 16 17 18 19 20 21");
			System.out.println(" 22 23 24 25 26 27 28");
			if (numDays == 31) {
				System.out.println(" 29 30 31");
				System.out.println();
				return 3;
			} else if (numDays == 30) {
				System.out.println(" 29 30");
				System.out.println();
				return 2;
			} else if (numDays == 29) {
				System.out.println(" 29");
				System.out.println();
				return 1;
			} else if (numDays == 28) {
				System.out.println();
				return 0;
			}
		} else if (startDay == 1 && numDays > 27) {
			System.out.println(month);
			System.out.println("     1  2  3  4  5  6");
			System.out.println("  7  8  9 10 11 12 13");
			System.out.println(" 14 15 16 17 18 19 20");
			System.out.println(" 21 22 23 24 25 26 27");
			if (numDays == 31) {
				System.out.println(" 28 29 30 31");
				System.out.println();
				return 4;
			} else if (numDays == 30 ) {
				System.out.println(" 28 29 30");
				System.out.println();
				return 3;
			} else if (numDays == 29) {
				System.out.println(" 28 29");
				System.out.println();
				return 2;
			} else if (numDays == 28) {
				System.out.println(" 28");
				System.out.println();
				return 1;
			}
		} else if (startDay == 2 && numDays > 27) {
			System.out.println(month);
			System.out.println("        1  2  3  4  5");
			System.out.println("  6  7  8  9 10 11 12");
			System.out.println(" 13 14 15 16 17 18 19");
			System.out.println(" 20 21 22 23 24 25 26");
			if (numDays == 31) {
				System.out.println(" 27 28 29 30 31");
				System.out.println();
				return 5;
			} else if (numDays == 30) {
				System.out.println(" 27 28 29 30");
				System.out.println();
				return 4;
			} else if (numDays == 29) {
				System.out.println(" 27 28 29");
				System.out.println();
				return 3;
			} else if (numDays == 28) {
				System.out.println(" 27 28");
				System.out.println();
				return 2;
			}
		} else if (startDay == 3 && numDays > 27) {
			System.out.println(month);
			System.out.println("           1  2  3  4");
			System.out.println("  5  6  7  8  9 10 11");
			System.out.println(" 12 13 14 15 16 17 18");
			System.out.println(" 19 20 21 22 23 24 25");
			if (numDays == 31) {
				System.out.println(" 26 27 28 29 30 31");
				System.out.println();
				return 6;
			} else if (numDays == 30) {
				System.out.println(" 26 27 28 29 30");
				System.out.println();
				return 5;
			} else if (numDays == 29) {
				System.out.println(" 26 27 28 29");
				System.out.println();
				return 4;
			} else if (numDays == 28) {
				System.out.println(" 26 27 28");
				System.out.println();
				return 3;
			}
		} else if (startDay == 4 && numDays > 27) {
			System.out.println(month);
			System.out.println("              1  2  3");
			System.out.println("  4  5  6  7  8  9 10");
			System.out.println(" 11 12 13 14 15 16 17");
			System.out.println(" 18 19 20 21 22 23 24");
			if (numDays == 31) {
				System.out.println(" 25 26 27 28 29 30 31");
				System.out.println();
				return 0;
			} else if (numDays == 30) {
				System.out.println(" 25 26 27 28 29 30");
				System.out.println();
				return 6;
			} else if (numDays == 29) {
				System.out.println(" 25 26 27 28 29");
				System.out.println();
				return 5;
			} else if (numDays == 28) {
				System.out.println(" 25 26 27 28");
				System.out.println();
				return 4;
			}
		} else if (startDay == 5 && numDays > 27) {
			System.out.println(month);
			System.out.println("                 1  2");
			System.out.println("  3  4  5  6  7  8  9");
			System.out.println(" 10 11 12 13 14 15 16");
			System.out.println(" 17 18 19 20 21 22 23");
			if (numDays == 31) {
				System.out.println(" 24 25 26 27 28 29 30");
				System.out.println(" 31");
				System.out.println();
				return 1;
			} else if (numDays == 30) {
				System.out.println(" 24 25 26 27 28 29 30");
				System.out.println();
				return 0;
			} else if (numDays == 29) {
				System.out.println(" 24 25 26 27 28 29");
				System.out.println();
				return 6;
			} else if (numDays == 28) {
				System.out.println(" 24 25 26 27 28");
				System.out.println();
				return 5;
			}
		} else if (startDay == 6 && numDays > 27) {
			System.out.println(month);
			System.out.println("                    1");
			System.out.println("  2  3  4  5  6  7  8");
			System.out.println("  9 10 11 12 13 14 15");
			System.out.println(" 16 17 18 19 20 21 22");
			if (numDays == 31) {
				System.out.println(" 23 24 25 26 27 28 29");
				System.out.println(" 30 31");
				System.out.println();
				return 2;
			} else if (numDays == 30) {
				System.out.println(" 23 24 25 26 27 28 29");
				System.out.println(" 30");
				System.out.println();
				return 1;
			} else if (numDays == 29) {
				System.out.println(" 23 24 25 26 27 28 29");
				System.out.println();
				return 0;
			} else if (numDays == 28) {
				System.out.println(" 23 24 25 26 27 28");
				System.out.println();
				return 6;
			}
		} else if (numDays < 28 && numDays > 0) { //illegitimate months
			System.out.println(month);
			int count = 0;
			for (int i = 0; i < startDay; i++) {
				System.out.print("   ");
				count++;
			}
			for (int i2 = 1; i2 <= numDays; i2++) {
				if (i2 < 10) {
					System.out.print("  "+i2);
					count++;
				} else {
					System.out.print(" "+i2);
					count++;
				}
				if (count == 7 && numDays != 6) {
					System.out.println();
					count = 0;
				}
			}
			if (startDay + numDays % 7 == 0 || month.equals("May")) {
				System.out.println();
			} else {
				System.out.println();
				System.out.println();
			}
			
			
			return count;
		}
		
		return 10000;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int year = input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int dayIndex = input.nextInt();
		
		if (year < 0) {
			System.out.println(E_YEAR);
		} else if (dayIndex < 0 || dayIndex > 6) {
			System.out.println(E_DAY);
		} else {
		
		
			boolean leapDeDo = isLeapYear(year);
			int nextIndex;
		
		
			nextIndex = printMonth("January", dayIndex, 31);
			if (leapDeDo == true) {
				nextIndex = printMonth("February", nextIndex, 29);
			} else {
				nextIndex = printMonth("February", nextIndex, 28);
			}
			nextIndex = printMonth("March", nextIndex, 31);
			nextIndex = printMonth("April", nextIndex, 30);
			nextIndex = printMonth("May", nextIndex, 31);
			nextIndex = printMonth("June", nextIndex, 30);
			nextIndex = printMonth("July", nextIndex, 31);
			nextIndex = printMonth("August", nextIndex, 31);
			nextIndex = printMonth("September", nextIndex, 30);
			nextIndex = printMonth("October", nextIndex, 31);
			nextIndex = printMonth("November", nextIndex, 30);
			nextIndex = printMonth("December", nextIndex, 31);
			input.close();
		}
	}

}
