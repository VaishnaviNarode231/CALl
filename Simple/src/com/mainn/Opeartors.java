package com.mainn;

import java.util.Scanner;

public class Opeartors {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		double num1,num2;
		double result = 0;
		char op;
		boolean validOp=true;
		System.out.println("Enter 1st number :");
		num1=sc.nextDouble();
		System.out.println("Enter operator :");
		op=sc.next().charAt(0);
		System.out.println("Enter 2nd number :");
		num2=sc.nextDouble();
		
		switch(op) {
		case '+' -> result=num1+num2;
		case '-' -> result=num1-num2;
		case '*' -> result=num1*num2;
		case '/' -> {if(num2!=0)
			result=num1/num2;
		else System.out.println("Divide by zero error");
		validOp=false;
		}
		case '^' -> Math.pow(num1,num2);
		default ->{
			System.out.println("INVALID OP");

			validOp=false;
		}
		}
		if(validOp) {
			System.out.println(result);	
		}
		sc.close();
	}
}
