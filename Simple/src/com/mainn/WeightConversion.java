package com.mainn;
import java.util.Scanner;

public class WeightConversion {
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	double weight,newWeight;
	System.out.println("1.Convert lbs to kgs ");
	System.out.println("2.Convert kgs to lbs ");
	
	System.out.println("Enter Choice  :");
	int ch=sc.nextInt();
	if(ch==1) {
		System.out.println("Enter Weight in lbs  :");
		weight=sc.nextDouble();
		newWeight=weight*0.453592;
		System.out.println("Weight in kgs :" + newWeight );
	}
	else if(ch==2) {
		System.out.println("Enter Weight in kgs  :");
		weight=sc.nextDouble();
		newWeight=weight*2.20462;
		System.out.println("Weight in lbs :" + newWeight );	
	}
	else {
		System.out.println("Invalid choice .......");
		
	}
}
}
