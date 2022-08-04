package com.fis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.fis.entity.Customer;

//Repository is another name for Dao
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select c.id from Customer c where c.email = ?1")
	public int findIfCustomerExists(String email);
	
	@Query("select count(c.id) from Customer c where c.email = ?1")
	public long findIfCustomerExistsv2(String email);

	//@Query("select c from Customer c where c.email = ?1 and c.password = ?2")
	public Customer findByEmailAndPassword(String email, String password);
}
