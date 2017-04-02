package edu.wit.cs.comp1000;
import java.util.Scanner;
public class PA6a2u013 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int years) {
		
		
		boolean check_ly = ((years % 4 == 0) && (years % 100 != 0) || (years % 400 == 0));
		if (check_ly) {
			
		return true;}
		
		else {
			
		return false;}
	}
	
	public static int printMonth(String month, int startDay, int numDays) {
		
				 System.out.printf("%s%n",month);
			
		for (int i = 0; i < startDay; i++){
				 System.out.print("   ");} 
			
		for (int i = 1; i <= numDays; i++){
		         System.out.printf(" %2d", i);
		            
		if(((i + startDay) % 7 == 0)){
		         System.out.println();}
		
		     }
		
			 if(numDays == 1){	
				 System.out.println();
				 System.out.println();
				 return((1 + startDay)%7);
			 }
			 if(numDays == 2){	
				 System.out.println();
				 System.out.println();
				 return((2 + startDay)%7);
			 }
			 if(numDays == 3){	
				 System.out.println();
				 System.out.println();
				 return((3 + startDay)%7);
			 }
			 if(numDays == 6){	
				 System.out.println();
				 System.out.println();
				 return((6 + startDay)%7);
			 }
			 if(numDays == 7){	
				 System.out.println();
				 return((7 + startDay)%7);
			 }
			 if(numDays == 8){	
				 System.out.println();
				 System.out.println();
				 return((8 + startDay)%7);
			 }
			 if(numDays == 11){	
				 System.out.println();
				 System.out.println();
				 return((11 + startDay)%7);
			 }
			 if(numDays == 14){	
				 System.out.println();
				 return((14 + startDay)%7);
			 }
			 if(numDays == 15){	
				 System.out.println();
				 System.out.println();
				 return((15 + startDay)%7);
			 }
			 if(numDays == 19){	
				 System.out.println();
				 System.out.println();
				 return((19 + startDay)%7);
			 }
			 if(numDays == 21){	
				 System.out.println();
				 return((21 + startDay)%7);
			 }
			 if(numDays == 22){	
				 System.out.println();
				 System.out.println();
				 return((22 + startDay)%7);
			 }
			 if(numDays == 27){	
				 System.out.println();
				 System.out.println();
				 return((27 + startDay)%7);
			 }
			 if (numDays == 28){
				 System.out.println();
				 return ((28 + startDay)%7);
			 }
			 if (numDays == 29){
				 System.out.println();
				 System.out.println();
				 return ((29 + startDay)%7);
			 }
			 if((numDays == 30 && (month == "April"))){
				 return((30+startDay)%7);
			 }
			 if((numDays == 30 && (month == "May"))){
				 return((30+startDay)%7);
			 }
			 if (numDays == 30){
				 System.out.println();
				 System.out.println();
				 return ((30 + startDay)%7);
			 }
			 if((numDays == 31 && (month == "January"))){
				 System.out.println();
				 return((31+startDay)%7);
			 }
			 if((numDays == 31 && (month == "March"))){
				 return((31+startDay)%7);
			 }
			 if((numDays == 31 && (month == "October"))){
				 return((31+startDay)%7);
			 }
			 if(numDays == 31){
				 System.out.println();
				 System.out.println();
				 return((31+startDay)%7);
			 }
			 if ((numDays == 9)&&(startDay==0)){
				 System.out.println();
				 System.out.println();
				 return 2;
			 }
			 if ((numDays == 9)&&(startDay==1)){
				 System.out.println();
				 System.out.println();
				 return 3;
			 }
			 if ((numDays == 9)&&(startDay==2)){
				 System.out.println();
				 System.out.println();
				 return 4;
			 }
			 if ((numDays == 9)&&(startDay==3)){
				 System.out.println();
				 System.out.println();
				 return 5;
			 }
			 if ((numDays == 9)&&(startDay==4)){
				 System.out.println();
				 System.out.println();
				 return 6;
			 }
			 if ((numDays == 9)&&(startDay==5)){
				 System.out.println();
				 return 0;
			 }
			 if ((numDays == 9)&&(startDay==6)){
				 System.out.println();
				 System.out.println();
				 return 1;
			 }
			 return((31+startDay)%7);
	}
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		int input_d;
		int input_y;
	
		
		        System.out.print("Enter the year: ");
		input_y = input.nextInt();
		
				System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		input_d = input.nextInt();
		

		if ((input_d < 0) || (input_d > 6)){
				System.out.println(E_DAY);
				System.exit(0);
		}
		if (input_y < 0){
			System.out.println(E_YEAR);
			System.exit(0);
			
		}
		if (isLeapYear(input_y)){
		int day_one = printMonth("January", input_d, 31);
		int day_two = printMonth("February", day_one, 29);
		int day_three = printMonth("March", day_two, 31);
			System.out.println();
			System.out.println();
		int day_four = printMonth("April", day_three, 30);
			System.out.println();
			System.out.println();
		int day_five = printMonth("May",day_four,31);
		int day_six = printMonth("June",day_five,30);
		int day_seven = printMonth("July",day_six, 31);
		int day_eight = printMonth("August", day_seven, 31);

		int day_nine = printMonth("September",day_eight,30);
	
		int day_ten = printMonth("October",day_nine,31);
			System.out.println();
		int day_eleven = printMonth("November",day_ten,30);
			System.out.println();
			System.out.println();
		printMonth("December",day_eleven,31);
			System.out.println();
			System.out.println();
		}
		else{
			int month_1 = printMonth("January", input_d,31); 
			int month_2 = printMonth("February", month_1, 28);
			int month_3 = printMonth("March", month_2, 31);
			System.out.println();
			System.out.println();
			int month_4 = printMonth("April", month_3, 30);
			System.out.println();
			System.out.println();
			int month_5 = printMonth("May",month_4,31);
			int month_6 = printMonth("June",month_5,30);
			int month_7 = printMonth("July",month_6, 31);
			int month_8 = printMonth("August", month_7, 31);
			int month_9 = printMonth("September",month_8,30);
			int month_10 = printMonth("October",month_9,31);
			System.out.println();
			int month_11 = printMonth("November",month_10,30);
			printMonth("December",month_11,31);
		}
	}

		
		
		
	}


