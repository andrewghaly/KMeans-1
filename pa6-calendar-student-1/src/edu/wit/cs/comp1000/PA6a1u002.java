package edu.wit.cs.comp1000;
import java.util.Scanner;

public class PA6a1u002 {
		
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		boolean leapyear = false;
		if (year%4 == 0 && year%100 != 0){
			return true;
		}
		else if (year%400 ==0){
					return true;
				}
		else 
			return false;
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);
		int nextLine = 1;
		boolean f1= false;
		for(int j=numDays,k=1;j>0;){
			if (startDay>0){
				for(int i=0;i<startDay;i++){
					System.out.print("   ");
					nextLine++;
				}
				startDay=0;
			}else{
				if(k <= 9){
				System.out.print("  "+k);}
				else if(k >= 10){
					System.out.print(" " + k);
				}	
				nextLine++;
			k++;
			j--;
			}
			if((nextLine>7)){
				if(j>0){
				System.out.printf("%n");nextLine=1;}
			else{
				nextLine=0;
				f1= true;
			}}
		}
		System.out.printf("%n");
		System.out.printf("%n");
		if (f1== true){
			return nextLine;
		}
		return (nextLine-1);
	}

	public static void main(String[] args) {
		String[] months={"January","February","March","April","May","June","July",
				"August","September","October","November","December"};
		int[] total_Days_in_Months = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the year: ");
		int year = in.nextInt();
			System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
			
			
			int day_of_the_week= in.nextInt();
			if(isLeapYear(year)){
				total_Days_in_Months[1]=29;
			}
			if(year <=0){
				System.out.println(E_YEAR);
				System.exit(0);
			}
			if(day_of_the_week <0 || day_of_the_week >6){
				System.out.println(E_DAY);
				System.exit(0);
			}
			
				
			for(int j=0;j<total_Days_in_Months.length;j++){
				int endDay = day_of_the_week;
				day_of_the_week = printMonth(months[j],endDay,total_Days_in_Months[j]);
			
				
				
			}
			
		
		
	}

}
