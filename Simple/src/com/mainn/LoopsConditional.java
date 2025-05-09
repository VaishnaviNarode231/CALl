package com.mainn;

import java.util.Scanner;
import java.util.*;
public class LoopsConditional {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		String dayOfWeek;
//		System.out.println("Enter day ::");
//		dayOfWeek=sc.nextLine();
//		switch(dayOfWeek) {
//		case "Monday" ->System.out.println("Weekday");
//		case "Tuesday" ->System.out.println("Weekday");
//		case "Wednesday" ->System.out.println("Weekday");
//		case "Thursday" ->System.out.println("Weekday");
//		case "Friday" ->System.out.println("Weekend");
//		case "Saturday" ->System.out.println("Weekend");
//		default ->
//		System.out.println("not a day");
//	}	
	
		//+===============================
		String response=" ";
		while(!response.equals("Q")) {
			System.out.println("playing a game");
			System.out.println("press Q to quit");
			response=sc.next().toUpperCase();
		}
	}

}
