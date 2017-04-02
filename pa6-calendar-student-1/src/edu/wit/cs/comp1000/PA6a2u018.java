package edu.wit.cs.comp1000;

import java.util.Scanner;

public class PA6a2u018 {
	
	static final String E_YEAR = "The year must be positive!";
	
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	public static boolean isLeapYear(int year) {
		boolean count = ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
		if (count) {
			return true;
		}
		else {
		return false; 
		}
		
		}
	
	public static int printMonth(String month, int startDay, int numDays) {
			System.out.printf("%s%n",month);
		for (int i = 0; i < startDay; i++){
			System.out.print("   ");
		} 
		 for (int i = 1; i <= numDays; i++){
	            System.out.printf(" %2d", i);
	            if(((i + startDay) % 7 == 0)){
	            	System.out.println();
	            }
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
		
		int day;
		int year;
		
		System.out.print("Enter the year: ");
		year = input.nextInt();
	
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		day = input.nextInt();
		if (year <= 0){
			System.out.println(E_YEAR);
			System.exit(0);
		}
		if ((day < 0) || (day > 6)){
			System.out.println(E_DAY);
			System.exit(0);
			
		}
		if (isLeapYear(year)){
			int one = printMonth("January", day,31); 
			int two=printMonth("February", one, 29);
			int three=printMonth("March", two, 31);
			System.out.println();
			System.out.println();
			int four=printMonth("April", three, 30);
			System.out.println();
			System.out.println();
			int five=printMonth("May",four,31);
			int six=printMonth("June",five,30);
			int sev=printMonth("July",six, 31);
			int eig=printMonth("August", sev, 31);
			int nine=printMonth("September",eig,30);
			int ten=printMonth("October",nine,31);
			System.out.println();
			int ele=printMonth("November",ten,30);
			printMonth("December",ele,31);
		}
		else{
			int one = printMonth("January", day,31); 
			int two=printMonth("February", one, 28);
			int three=printMonth("March", two, 31);
			System.out.println();
			System.out.println();
			int four=printMonth("April", three, 30);
			System.out.println();
			System.out.println();
			int five=printMonth("May",four,31);
			int six=printMonth("June",five,30);
			int sev=printMonth("July",six, 31);
			int eig=printMonth("August", sev, 31);
			int nine=printMonth("September",eig,30);
			int ten=printMonth("October",nine,31);
			System.out.println();
			int ele=printMonth("November",ten,30);
			printMonth("December",ele,31);
		}
	}
}
