package com.fis.exceptionhandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Checking {

	public static void main(String[] args) {
		int x = Integer.parseInt("100fgg"); //NumberFormatException is an unchecked exception
		
		try {
			Connection con = DriverManager.getConnection(""); //SQLException is a checked exception
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
