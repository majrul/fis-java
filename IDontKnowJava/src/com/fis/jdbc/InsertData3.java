package com.fis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData3 {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "passw0rd");
			st = conn.prepareStatement("insert into tbl_product(name, price, quantity) values(?, ?, ?)");
			
			String ans = "";
			do {
				Scanner s = new Scanner(System.in);
				System.out.println("Enter product name");
				String name = s.nextLine();
				System.out.println("Enter price");
				double price = Double.parseDouble(s.nextLine());
				System.out.println("Enter quantity");
				int quantity = Integer.parseInt(s.nextLine());
	
				//now substituting ? with the actual data
				st.setString(1, name);
				st.setDouble(2, price);
				st.setInt(3, quantity);
				st.executeUpdate();

				System.out.println("Record inserted..");
				
				System.out.println("Do you wish to continue (y/n) ?");
				ans = s.nextLine();
			} while(ans.equals("y"));
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

}
