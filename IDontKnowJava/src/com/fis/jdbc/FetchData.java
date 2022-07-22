package com.fis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FetchData {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "passw0rd");
			st = conn.prepareStatement("select * from tbl_product where price >= ?");

			Scanner s = new Scanner(System.in);
			System.out.println("Enter base price for the products to search");
			double baseprice = s.nextDouble();
			
			//substituting ? with the actual value
			st.setDouble(1, baseprice);
			rs = st.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("product_id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				int quantity = rs.getInt("quantity");
				System.out.println(id + " , " + name + " , " + price + " , " + quantity);
			}
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}

	}
}
