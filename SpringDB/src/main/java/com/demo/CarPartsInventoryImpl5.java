package com.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("carPartsInv5")
public class CarPartsInventoryImpl5 implements CarPartsInventory {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void addNewPart(CarPart carPart) {
		entityManager.persist(carPart); //persist will generate insert query
	}

	public List<CarPart> getAvailableParts() {
		return entityManager.createQuery("select c from CarPart c").getResultList();
	}

}
