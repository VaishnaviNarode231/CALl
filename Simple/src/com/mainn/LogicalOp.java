package com.mainn;

import java.util.Scanner;

public class LogicalOp {

	public static void main(String[] args) {
				// TODO Auto-generated method stub
//		double temp=20;
//		boolean isSunny=true;
//		
//		if( temp<=30 && temp>=0 && isSunny) {
//			System.out.println("Good weather");
//		}
//		else {
//			System.out.println("Bad wether");
//		}
		
		
		//============================+================
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter usernme :");
		String username=sc.next();
		if(username.length() < 4 || username.length()>12) {
			System.out.println("User name must be between 4-12 characters ..");
		}
		else if(username.contains(" ") || username.contains("_")) {
			System.out.println("no spaces or underscore");
		}
		else {
			System.out.println("welcome " + username);
		}
	}

}
