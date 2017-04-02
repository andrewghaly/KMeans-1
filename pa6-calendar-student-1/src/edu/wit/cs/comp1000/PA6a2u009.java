package edu.wit.cs.comp1000;
import java.util.Scanner;
public class PA6a2u009 {
	Scanner input = new Scanner(System.in);
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		if(year%4==0 && (year%400==0 || year%100 != 0)){
		return true;
		}
		else;
		return false;
		
		
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		int counter,counter2, line;
		boolean a=true;
		System.out.printf(month + "%n");
		line=0;
		counter=0;
		counter2=1;
		for (int i=0; i<startDay; i++) {
		System.out.print("   ");
		}
		counter=0;
		for(int i =0 ; i<numDays;i++ ){
			counter++;
			counter2++;
			a=true;
			System.out.printf("%3d", i+1);
			if (line==0){
				if (counter==(7-startDay)){
					line++;
					counter=0;
					System.out.printf("%n");
					a=false;

				}
				
			}
			else {
				if (counter==7){
					counter=0;
					System.out.printf("%n");
					if (counter2-1==numDays){
						counter2 = 0;
						
					}
				}
					
			}
			if (counter2-1==numDays && a==true)
				System.out.printf("%n");
			
		}
	
		System.out.printf("%n");
		return counter;
		
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int year,day,leap;
		
		
		System.out.print("Enter the year: ");
		year=input.nextInt();
		System.out.printf("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		day=input.nextInt();
		if (year < 0){
			System.out.printf("The year must be positive!%n");
			System.exit(0);
		}
		if (day>7 || day<0){
			System.out.println("The day of January 1st must be between 0 and 6!");
			System.exit(0);
		}
		
		int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String month[] = {"PlaceHolder","January", "February", "March",
				"April", "May", "June","July", "August","September",
				"October", "November", "December"};
		
		for (int i=1; i <= 12; i++ ){
			if (month[2]=="February"){
				if (isLeapYear(year)==true){
					days[2]=29;	
				}
				
			
				
		day = printMonth(month[i],day, days[i] );
			
			
}
		
	}
		}
				}


