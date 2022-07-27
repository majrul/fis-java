package com.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("carPartsInv4")
public class CarPartsInventoryImpl4 implements CarPartsInventory {

	@Autowired
	private JdbcTemplate jt;
	
	public void addNewPart(CarPart carPart) {
		jt.update("insert into tbl_carpart values(?, ?, ?, ?, ?)", 
				carPart.getPartNo(), carPart.getPartName(), carPart.getCarModel(), carPart.getPrice(), carPart.getQuantity());
	}

	public List<CarPart> getAvailableParts() {
		List<CarPart> list = jt.query("select * from tbl_carpart", 
										BeanPropertyRowMapper.newInstance(CarPart.class));
		return list;
	}

}
