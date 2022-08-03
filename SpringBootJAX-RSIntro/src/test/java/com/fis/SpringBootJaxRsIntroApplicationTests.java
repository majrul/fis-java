package com.fis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.fis.entity.Customer;
import com.fis.repository.CustomerRepository;

@SpringBootTest
class SpringBootJaxRsIntroApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	void add() {
		Customer customer = new Customer();
		customer.setName("Indrajeet");
		customer.setMobileNo(987654321);
		customer.setEmail("indrajeet@gmail.com");
		customer.setPassword("456");
		
		customerRepository.save(customer);
	}

	@Test
	void checkIfCustomerExists() {
		int id = customerRepository.findIfCustomerExists("majrul@gmail.com");
		System.out.println(id);
	}
}
