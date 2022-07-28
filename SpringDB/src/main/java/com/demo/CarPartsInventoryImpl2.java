package com.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("carPartsInv2")
public class CarPartsInventoryImpl2 implements CarPartsInventory {

	@Autowired
	//@Qualifier("dataSource1")
	private DataSource dataSource;

	public void addNewPart(CarPart carPart) {
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = dataSource.getConnection();
			st = conn.prepareStatement("insert into tbl_carpart values(?, ?, ?, ?, ?)");
			
			st.setInt(1, carPart.getPartNo());
			st.setString(2, carPart.getPartName());
			st.setString(3, carPart.getCarModel());
			st.setDouble(4, carPart.getPrice());
			st.setInt(5, carPart.getQuantity());
			st.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}
	}

	public List<CarPart> getAvailableParts() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			st = conn.prepareStatement("select * from tbl_carpart");
			rs = st.executeQuery();
			
			List<CarPart> list = new ArrayList<CarPart>();
			while(rs.next()) {
				CarPart cp = new CarPart();
				cp.setPartNo(rs.getInt("part_no"));
				cp.setPartName(rs.getString("part_name"));
				cp.setCarModel(rs.getString("car_model"));
				cp.setPrice(rs.getDouble("price"));
				cp.setQuantity(rs.getInt("quantity"));
				list.add(cp);
			}
			return list;
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null; //bad, rather we should have thrown the exception
		}
		finally {
			try { conn.close(); } catch(Exception e) { }
		}

	}

}
