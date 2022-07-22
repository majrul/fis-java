package com.fis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertData2 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "passw0rd");
			st = conn.createStatement();
			
			Scanner s = new Scanner(System.in);
			System.out.println("Enter product name");
			String name = s.nextLine();
			System.out.println("Enter price");
			double price = Double.parseDouble(s.nextLine());
			System.out.println("Enter quantity");
			int quantity = Integer.parseInt(s.nextLine());
			
			st.executeUpdate("insert into tbl_product(name, price, quantity) values('" + name + "'," + price + "," + quantity + ")"); //DML
			//st.executeUpdate("insert into tbl_product(name, price, quantity) values('iPhone 13 Pro', 120000, 75)"); //DML
			System.out.println("Record inserted..");
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

}
