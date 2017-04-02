package edu.wit.cs.comp1000;
import java.util.Scanner;
public class PA6a1u012 {
	public static void main(String[] args) {
	     Scanner input = new Scanner(System.in);                                                                         
         System.out.print("Enter the year: ");                                                                           
         int year = input.nextInt();                          													      
         System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");        
         int startDay = input.nextInt();    
         if((year <= 0) && ((startDay < 0) || (startDay > 6))){                          
                System.out.println(E_YEAR);                                              
                System.out.println(E_DAY);                                               
                System.exit(0);                                                          
         }
         if(year <= 0) {                                                                  
                System.out.println(E_YEAR);                                              
                System.exit(0);                                                         
         }
         if((startDay < 0) || (startDay > 6)){                                              
                System.out.println(E_DAY);                                           
                System.exit(0);                                                      
         }
         boolean x;                                                                        
         x = isLeapYear(year);                                                             
         int b = 0;             
         int a = printMonth("January", startDay, 31); 
         if(x == false){                                                                  
                b = printMonth("February", a, 28);                                 
         }
         else if(x == true){                                                       
                b = printMonth("February", a, 29);                                 
         }
         int c = printMonth("March", b, 31);                     							
         int d = printMonth("April", c, 30); 												
         int e = printMonth("May", d, 31); 													
         int f = printMonth("June", e, 30); 												
         int g = printMonth("July", f, 31); 												
         int h = printMonth("August", g, 31); 												
         int i = printMonth("September", h, 30); 											
         int j = printMonth("October", i, 31); 												
         int k = printMonth("November", j, 30);												
         int l = printMonth("December", k, 31); 											
   }
   static final String E_YEAR = "The year must be positive!";                               
   static final String E_DAY = "The day of January 1st must be between 0 and 6!";           
   public static boolean isLeapYear(int year) {    
         boolean z=false;                                                                 
         if((year % 4) == 0 && year % 100 > 0) {                                            
                z = true;                                                                 
         }else if (year % 4 == 0 && year % 100 == 0 && year % 400==0 ){
        	  z =true;
         }else if (year%4 == 0 && year% 100==0 && year % 400>0 ){                            
                z = false;                                                                 
         }else {
        	 z =false;
         }
         return z;                                                                          
   }
   
   public static int printMonth(String month, int startDay, int numDays) {   
	   System.out.println(month);																    
	   int stday=0;																					
	   int days=0;
	   for (stday = 0; stday < startDay; stday=stday+1)											
		   System.out.print("   ");
	   for (days = 1;days <= numDays; days=days+1){									 
		   if (days < 10 && days != numDays){ 												
			   System.out.print("  " + days);
	       if ((startDay + days) % 7 == 0){ 													 
	    	   System.out.println();
	   }
    }
	   else if (days >= 10 && days != numDays){													
		   System.out.print(" " + days);
	   if ((startDay + days) % 7 == 0){															
		   System.out.println();}
	   
	   }
	   else if (days == numDays){												 
	   if (days < 10){															
		   System.out.println("  " + days);
		   System.out.println();}
	   else{
		   System.out.println(" " + days);
		   System.out.println();}
	   } 
	   }
	   return (startDay + numDays) % 7; 										
	   }     

}
