package com.fis.exceptionhandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class InputNumbers3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try {
			System.out.println("Enter number 1");
			int x = Integer.parseInt(s.nextLine());
		
			System.out.println("Enter number 2");
			int y = Integer.parseInt(s.nextLine());
		
			int z = x + y;

			System.out.println("The sum of " + x +" and " + y +" is " + z);
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
			//System.out.println("Incorrect number entered!");
		}
	}
}
