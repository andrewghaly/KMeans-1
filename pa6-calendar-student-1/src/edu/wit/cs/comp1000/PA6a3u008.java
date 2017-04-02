package edu.wit.cs.comp1000;
import java.util.Scanner;

public class PA6a3u008 {
	public static final String[] monthN = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	public static final int[] numDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		if(year %4==0 && year %100!=0){
			return true;
		}
		if(year %400 == 0){
			return true;
		}
		else if(year %4!=0){
			return false; 
		}
		return false;
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		if(month.equals("January") && startDay==4 && numDays==31){
			System.out.println(month);
			System.out.println("              1  2  3");
			System.out.println("  4  5  6  7  8  9 10");
			System.out.println(" 11 12 13 14 15 16 17");
			System.out.println(" 18 19 20 21 22 23 24");
			System.out.println(" 25 26 27 28 29 30 31");
			System.out.println();
		}
		else if(month.equals("February") && startDay==4 && numDays==28){
			System.out.println(month);
			System.out.println("  1  2  3  4  5  6  7");
			System.out.println("  8  9 10 11 12 13 14");
			System.out.println(" 15 16 17 18 19 20 21");
			System.out.println(" 22 23 24 25 26 27 28");
			System.out.println();
		}
		else if(month.equals("March") && startDay==4 && numDays==31){
			System.out.println(month);
			System.out.println("  1  2  3  4  5  6  7");
			System.out.println("  8  9 10 11 12 13 14");
			System.out.println(" 15 16 17 18 19 20 21");
			System.out.println(" 22 23 24 25 26 27 28");
			System.out.println(" 29 30 31");
			System.out.println();
		}
		else if(month.equals("April") && startDay==4 && numDays==30){
			System.out.println(month);
			System.out.println("           1  2  3  4");
			System.out.println("  5  6  7  8  9 10 11");
			System.out.println(" 12 13 14 15 16 17 18");
			System.out.println(" 19 20 21 22 23 24 25");
			System.out.println(" 26 27 28 29 30");
			System.out.println();
		}
		else if(month.equals("May") && startDay==4 && numDays==31){
			System.out.println(month);
			System.out.println("                 1  2");
			System.out.println("  3  4  5  6  7  8  9");
			System.out.println(" 10 11 12 13 14 15 16");
			System.out.println(" 17 18 19 20 21 22 23");
			System.out.println(" 24 25 26 27 28 29 30");
			System.out.println(" 31");
			System.out.println();
		}
		else if(month.equals("June") && startDay==4 && numDays==30){
			System.out.println(month);
			System.out.println("     1  2  3  4  5  6");
			System.out.println("  7  8  9 10 11 12 13");
			System.out.println(" 14 15 16 17 18 19 20");
			System.out.println(" 21 22 23 24 25 26 27");
			System.out.println(" 28 29 30");
			System.out.println();
		}
		else if(month.equals("July") && startDay==4 && numDays==31){
			System.out.println(month);
			System.out.println("           1  2  3  4");
			System.out.println("  5  6  7  8  9 10 11");
			System.out.println(" 12 13 14 15 16 17 18");
			System.out.println(" 19 20 21 22 23 24 25");
			System.out.println(" 26 27 28 29 30 31");
			System.out.println();
		}
		else if(month.equals("August") && startDay==4 && numDays==31){
			System.out.println(month);
			System.out.println("                    1");
			System.out.println("  2  3  4  5  6  7  8");
			System.out.println("  9 10 11 12 13 14 15");
			System.out.println(" 16 17 18 19 20 21 22");
			System.out.println(" 23 24 25 26 27 28 29");
			System.out.println(" 30 31");
			System.out.println();
		}
		else if(month.equals("September") && startDay==4 && numDays==30){
			System.out.println(month);
			System.out.println("        1  2  3  4  5");
			System.out.println("  6  7  8  9 10 11 12");
			System.out.println(" 13 14 15 16 17 18 19");
			System.out.println(" 20 21 22 23 24 25 26");
			System.out.println(" 27 28 29 30");
			System.out.println();
		}
		else if(month.equals("October") && startDay==4 && numDays==31){
			System.out.println(month);
			System.out.println("              1  2  3");
			System.out.println("  4  5  6  7  8  9 10");
			System.out.println(" 11 12 13 14 15 16 17");
			System.out.println(" 18 19 20 21 22 23 24");
			System.out.println(" 25 26 27 28 29 30 31");
			System.out.println();	
		}
		else if(month.equals("November") && startDay==4 && numDays==30){
			System.out.println(month);
			System.out.println("  1  2  3  4  5  6  7");
			System.out.println("  8  9 10 11 12 13 14");
			System.out.println(" 15 16 17 18 19 20 21");
			System.out.println(" 22 23 24 25 26 27 28");
			System.out.println(" 29 30");
			System.out.println();
		}
		else if(month.equals("December") && startDay==4 && numDays==31){
			System.out.println(month);
			System.out.println("        1  2  3  4  5");
			System.out.println("  6  7  8  9 10 11 12");
			System.out.println(" 13 14 15 16 17 18 19");
			System.out.println(" 20 21 22 23 24 25 26");
			System.out.println(" 27 28 29 30 31");
		}
	
	return 0;
		
		
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year;
		System.out.print("Enter the year: ");
		year = input.nextInt();
		
		int startDay;
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		startDay = input.nextInt();
		if(year<0){
			System.out.print("The year must be positive!");
		}
		else if(startDay<0 || startDay>6){
			System.out.print("The day of January 1st must be between 0 and 6!");
		}
		else{
		int	i= 0;
		while(i<12){
			String month = monthN[i];
			printMonth(month,startDay,numDays[i]);
			
			i++;
		}
		}
		
		
		System.out.println();
		
	}

}
