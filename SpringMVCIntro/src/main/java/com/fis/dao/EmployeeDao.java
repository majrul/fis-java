package com.fis.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fis.entity.Employee;

//Data Access Object
//classes which contain DB code are commonly referred to as Dao classes
@Component
public class EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void add(Employee emp) {
		entityManager.persist(emp);
	}

}
