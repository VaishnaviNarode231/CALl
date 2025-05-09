package com.mainn;

import java.util.Scanner;

public class Patterns {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter rows ");
		int n=sc.nextInt();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==0|| i==(n-1) || j==0|| j==(n-1)) {
					System.out.println("*");
				}
				else {
					System.out.println(" ");
				}
			}
			System.out.println("\n");
		}
		}
}
