package com.mainn1;

//Math and other methods : 

import java.util.Scanner;
public class Mainn {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		/*
		double result;
		result=Math.pow(2,5);
		System.out.println(result);
		
		result=Math.abs(-5);
		System.out.println(result);

		result=Math.sqrt(9);
		System.out.println(result);

		result=Math.round(3.15);
		System.out.println(result);

		result=Math.ceil(3.15);
		System.out.println(result);

		result=Math.floor(8.90);
		System.out.println(result);

		result=Math.min(111, 20);
		System.out.println(result);

		result=Math.max(111, 20);
		System.out.println(result);
*/
//=======================================================================
		/*
		//HYPOTENSUE c= Math.sqrt(a^2 + b^2)
		
		double a,b,c;
		System.out.println("Enter Length of side A :: ");
		a=sc.nextDouble();
		System.out.println("Enter Length of side B :: ");
		b=sc.nextDouble();
		
		c=Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
		System.out.println("Hypotenuse is :: " + c);
		*/
		/*
//======================================================================		
		//circumference= 2 * Math.PI *radius
		//area=Math.PI * Math.pow(radius ,2)
		//volume =(4.0/3.0) *Math.PI *Math.pow(radius,3)
		double radius,circumference,area,volume;
		
		System.out.println("Enter Radius:: ");
		radius=sc.nextDouble();
		circumference= 2 * Math.PI *radius;
		area=Math.PI * Math.pow(radius ,2);
		volume =(4.0/3.0) *Math.PI *Math.pow(radius,3);
		System.out.printf("circumference :: %.1f  ", circumference);
		System.out.printf("area :: %.1f ", area);
		System.out.printf("volume :: %.1f ", volume);
		String name=sc.nextLine();
		System.out.printf("Your name is %s\n",name);  
*/
 
	//=====================================================================	
	/*	// METHODS 
		String name="Bro Code";
		int length=name.length();
		System.out.println(length);
		char letter=name.charAt(0);
		System.out.println(letter);
		int index=name.indexOf("o");
		System.out.println(index);
		int lastIndex=name.lastIndexOf("o");
		System.out.println(lastIndex);
		name=name.toUpperCase();
		System.out.println(name);
		name=name.toLowerCase();
		System.out.println(name);
		name=name.replace("o", "i");
		System.out.println(name);
		name="       Bro Code            ";
		name=name.trim();
		System.out.println(name);
		
		if(name.isEmpty()) {
			System.out.println("name is empty");
		}
		else {
			System.out.println("hello "+name);
		}
		
		if(name.contains(" ")) {
			System.out.println("Space present ");
		}
		else {
			System.out.println("no space");
		}
		
		if(name.equalsIgnoreCase("password")) {
			System.out.println("name cannot be password");
		}
		else {
			System.out.println("ur name is "+name);
		}*/
		
		//====================================
		//substring() = A method used to extract a portion of a string
		
		String email="Vaishn231@gmail.com";
		String username=email.substring(0,9);
		String domain=email.substring(11);
		System.out.println(username);
		System.out.println(domain);
		
		//user input 
		System.out.println("Enter Email :: ");
		email=sc.nextLine();
		if(email.contains("@")) {
			username=email.substring(0,email.indexOf("@"));
			domain=email.substring(email.indexOf("@") +1);
			System.out.println(username);
			System.out.println(domain);
		}
		
	}
}
