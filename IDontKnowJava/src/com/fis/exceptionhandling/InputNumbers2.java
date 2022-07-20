package com.fis.exceptionhandling;

import java.util.Scanner;

public class InputNumbers2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Hello\nEveryone");
		
		System.out.println("Enter number 1");
		//int x = s.nextInt();
		int x = 0;
		try {
			x = Integer.parseInt(s.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("You seem to have entered a wrong number. Please enter only digits!");
			System.out.println("Enter number 1 again");
			x = Integer.parseInt(s.nextLine());
		}
		
		System.out.println("Enter number 2");
		//int y = s.nextInt();
		int y = Integer.parseInt(s.nextLine());
		
		int z = x + y;

		System.out.println("The sum of " + x +" and " + y +" is " + z);
		System.out.printf("The sum of %d and %d is %d", x, y, z);
	}
}
