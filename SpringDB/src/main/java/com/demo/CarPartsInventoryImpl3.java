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
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("carPartsInv3")
public class CarPartsInventoryImpl3 implements CarPartsInventory {

	@Autowired
	@Qualifier("dataSource1")
	private DataSource dataSource;
	
	public void addNewPart(CarPart carPart) {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		jt.update("insert into tbl_carpart values(?, ?, ?, ?, ?)", 
				carPart.getPartNo(), carPart.getPartName(), carPart.getCarModel(), carPart.getPrice(), carPart.getQuantity());
	}

	public List<CarPart> getAvailableParts() {
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		List<CarPart> list = jt.query("select * from tbl_carpart", 
										BeanPropertyRowMapper.newInstance(CarPart.class));
		return list;
	}

}
