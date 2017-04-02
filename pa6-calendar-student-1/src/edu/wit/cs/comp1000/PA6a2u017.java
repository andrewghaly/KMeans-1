package edu.wit.cs.comp1000;
import java.util.Scanner;
public class PA6a2u017 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
	}
	public static int printMonth(String month, int startDay, int numDays) {
		System.out.printf("%s%n", month);
		
		for (int i=0; i<startDay; i++){
			System.out.printf("   ");
		}
			for (int i=1;i<=numDays;i++){
				System.out.printf("%3d", i);
				if(((i+startDay) % 7 == 0)){
					System.out.printf("%n");
					
				}
				
			}
		if (numDays == 28){
			return ((28+startDay)%7);
					
		}
		
		if (numDays == 29){	
			return ((29+startDay)%7);
		}
		
		if (numDays == 30){	
			return ((30+startDay)%7);
		}
		if (numDays == 31){
		return ((31+startDay)%7);
		}
		
		return 1;
	}


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int year;
		System.out.print("Enter the year: ");
		year = input.nextInt();
		
		int dow;
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		dow = input.nextInt();
		if (year <= 0){
			System.out.println(E_YEAR);
			System.exit(0);
		}
		else if (dow < 0 || dow > 6) {
			System.out.println(E_DAY);
		}
		if (isLeapYear(year)) {
			int a = printMonth("January",dow,31);
			System.out.println();
			int b = printMonth("February",a,29);
			System.out.println();
			int c = printMonth("March",b,31);
			System.out.println();
			System.out.println();
			int d = printMonth("April",c,30);
			System.out.println();
			System.out.println();
			int e = printMonth("May",d,31);
			System.out.println();
			System.out.println();
			int f = printMonth("June",e,30);
			System.out.println();
			System.out.println();
			int g = printMonth("July",f,31);
			System.out.println();
			System.out.println();
			int h = printMonth("August",g,31);
			System.out.println();
			System.out.println();
			int i = printMonth("September",h,30);
			System.out.println();
			System.out.println();
			int j = printMonth("October",i,31);
			System.out.println();
			int k = printMonth("November",j,30);
			System.out.println();
			System.out.println();
			int l = printMonth("December",k,31);
			System.out.println();
			System.out.println();
			}
		
		else if (isLeapYear(year)){
			int a = printMonth("January",dow,31);
			System.out.println();
			int b = printMonth("February",a,28);
			System.out.println();
			int c = printMonth("March",b,31);
			System.out.println();
			System.out.println();
			int d = printMonth("April",c,30);
			System.out.println();
			System.out.println();
			int e = printMonth("May",d,31);
			System.out.println();
			System.out.println();
			int f = printMonth("June",e,30);
			System.out.println();
			System.out.println();
			int g = printMonth("July",f,31);
			System.out.println();
			System.out.println();
			int h = printMonth("August",g,31);
			System.out.println();
			System.out.println();
			int i = printMonth("September",h,30);
			System.out.println();
			System.out.println();
			int j = printMonth("October",i,31);
			System.out.println();
			int k = printMonth("November",j,30);
			System.out.println();
			System.out.println();
			int l = printMonth("December",k,31);
			System.out.println();
			System.out.println();
		}
		}
		
		
		
		
	}


