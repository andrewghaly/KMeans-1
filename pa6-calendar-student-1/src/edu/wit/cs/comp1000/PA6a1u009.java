package edu.wit.cs.comp1000;
import java.util.Scanner;
public class PA6a1u009 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) { 
		
		if(year%4!=0){
		return false;
		} else if(year%400==0){
			return true;
		} else if(year%100==0){
			return false;
		} else{
			return true;
		}
		
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		System.out.print(month);
		System.out.println();
		 int CurrentDay = startDay;
		  for(int i = 0; i < startDay; i++){
			  System.out.print("   ");
		  }
		  for(int day = 1; day < numDays + 1; day++){
			  if(CurrentDay > 5){
				  if(day < 10){
					  System.out.println(" " + day);
		  }  
		  else{
			  System.out.println("" + day);
		  }
		  CurrentDay = 0;
		  }
		  else{
			  if(day < 10){
				  System.out.print(" " + day + " ");
		  }
		  else{
			  System.out.print("" + day + " ");
		  }
		  CurrentDay++;
		  }
	 }
		  return CurrentDay;
 }
	

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int year;
		int StartDay;
		System.out.print("Enter the year: ");
		year=input.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		StartDay=input.nextInt();
		if(year<0){
			System.out.println(E_YEAR);
			System.exit(0);
		}
		if(StartDay<0||StartDay>6){
			System.out.println(E_DAY);
			System.exit(0);
		}
		 int FebDays = 28;
		 
		  if(isLeapYear(year)){
		  FebDays = 29;
		  }
		 
		  int NextStartDay = printMonth("January", StartDay, 31);
		 
		  System.out.println();
		 
		  NextStartDay = printMonth("February", NextStartDay, FebDays);
		 
		  System.out.println();
		 
		  NextStartDay = printMonth("March", NextStartDay, 31);
		 
		  System.out.println();
		  System.out.println();
		 
		  NextStartDay = printMonth("April", NextStartDay, 30);
		 
		  System.out.println();
		  System.out.println();
		 
		  NextStartDay = printMonth("May", NextStartDay, 31);
		 
		  System.out.println();
		  System.out.println();
		  
		  printMonth("June", NextStartDay, 30);
			 
		  System.out.println();
		  System.out.println();
		 
		  NextStartDay = printMonth("July", NextStartDay, 31);
		 
		  System.out.println();
		  System.out.println();
		 
		  NextStartDay = printMonth("August", NextStartDay, 31);
		 
		  System.out.println();
		  System.out.println();
		 
		 
		  NextStartDay = printMonth("September", NextStartDay, 30);
		 
		  System.out.println();
		  System.out.println();
		 
		  NextStartDay = printMonth("October", NextStartDay, 31);
		 
		  System.out.println();
		  System.out.println();
		 
		  NextStartDay = printMonth("November", NextStartDay, 30);
		 
		  System.out.println();
		  System.out.println();
		 
		  printMonth("December", NextStartDay, 31);
		 
		  System.out.println();
		  System.out.println();
		  
	
		 
		
		
	}

}
