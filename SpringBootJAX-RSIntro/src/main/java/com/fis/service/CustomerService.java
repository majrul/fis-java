package com.fis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.entity.Customer;
import com.fis.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public void register(Customer customer) {
		try {
			int id = customerRepository.findIfCustomerExists(customer.getEmail());
			//throw an exception to report registration has failed
		}
		catch(Exception e) {
			customerRepository.save(customer);
		}
	}
	
	public void registerv2(Customer customer) {
		long count = customerRepository.findIfCustomerExistsv2(customer.getEmail());
		if(count == 0)
			customerRepository.save(customer);
		//else
			//throw an exception to report registration has failed			
	}
}
