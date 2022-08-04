package com.fis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fis.entity.Customer;
import com.fis.exception.CustomerServiceException;
import com.fis.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	/*public void register(Customer customer) {
		try {
			int id = customerRepository.findIfCustomerExists(customer.getEmail());
			//throw an exception to report registration has failed
		}
		catch(Exception e) {
			customerRepository.save(customer);
		}
	}*/
	
	public void registerv2(Customer customer) {
		long count = customerRepository.findIfCustomerExistsv2(customer.getEmail());
		if(count == 0)
			customerRepository.save(customer);
		else
			throw new CustomerServiceException("Customer already registered!");		
	}
	
	public Customer login(String email, String password) {
		Customer customer = customerRepository.findByEmailAndPassword(email, password);
		if(customer != null)
			return customer;
		else
			throw new CustomerServiceException("Invalid Email/Password");
	}
	
	public Customer get(int id) {
		return customerRepository.findById(id).get();
	}
	
	public void update(Customer customer) {
		customerRepository.save(customer);
	}
	
	public void delete(int id) {
		customerRepository.deleteById(id);
	}
}
