package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

@Component("carPartsInv1")
public class CarPartsInventoryImpl1 implements CarPartsInventory {

	public void addNewPart(CarPart carPart) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "passw0rd");
			st = conn.prepareStatement("insert into tbl_carpart values(?, ?, ?, ?, ?)");
			
			st.setInt(1, carPart.getPartNo());
			st.setString(2, carPart.getPartName());
			st.setString(3, carPart.getCarModel());
			st.setDouble(4, carPart.getPrice());
			st.setInt(5, carPart.getQuantity());
			st.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

	public List<CarPart> getAvailableParts() {
		return null;
	}

}
