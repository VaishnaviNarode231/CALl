package com.mainn;

import java.util.Random;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Random r=new Random();
			Scanner sc=new Scanner(System.in);
			int no1,no2;
			System.out.println("Enter 2 numbers ::");
			no1=sc.nextInt();
			no2=sc.nextInt();

			int n= r.nextInt(no1,no2);
			System.out.println("Random number between "+no1 +" and "+ no2 +" is " +n);
			boolean isStudent;
			 isStudent=r.nextBoolean();
			if(isStudent) {
				System.out.println("Student");

			}
			else {
				System.out.println("not Student");

			}
	}

}
