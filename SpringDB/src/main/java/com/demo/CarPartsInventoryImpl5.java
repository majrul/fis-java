package com.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;

@Component("carPartsInv5")
public class CarPartsInventoryImpl5 implements CarPartsInventory {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void addNewPart(CarPart carPart) {
		entityManager.persist(carPart); //persist will generate insert query
	}

	public List<CarPart> getAvailableParts() {
		List<CarPart> list = entityManager.createQuery("select c from CarPart c").getResultList();
		return list;
	}

}
