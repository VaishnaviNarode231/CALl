package com.mainn;

import java.util.Scanner;

public class JavaBase {
   public static void main(String[] args) {
	  /* //Ternary operator 
	   int num=3;
	   String evenOrOdd= (num % 2==0) ?"Even" :"Odd";
	   System.out.println(evenOrOdd);
	   
	   int score=65;
	   String check= (score > 75) ?"pass" :"fail";
	   System.out.println(check);
	   */
	   //================================================
	  // Temperature scale
	   Scanner sc=new Scanner(System.in);
	   double temp,newTemp;
	   String unit;
	   System.out.println("Enter Temperature :");
	   temp=sc.nextDouble();
	   System.out.println("Convert to Celsius or fahrenheit (C or F ) :");
	   unit =sc.next().toUpperCase();
	   
	   System.out.println(temp);
	   System.out.println(unit);
	   newTemp=(unit.equals("C0"))? (temp -32) * 5/9 : (temp* 5/ 9)+32 ;
	   System.out.printf("New temperature is  %.2f %s",newTemp,unit);

   }
}
