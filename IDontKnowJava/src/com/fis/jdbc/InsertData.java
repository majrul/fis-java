package com.fis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "passw0rd");
			st = conn.createStatement();
			
			st.executeUpdate("insert into tbl_product(name, price, quantity) values('iPhone 13 Pro', 120000, 75)"); //DML
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
