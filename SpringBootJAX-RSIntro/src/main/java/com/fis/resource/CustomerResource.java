package com.fis.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import com.fis.entity.Customer;
import com.fis.service.CustomerService;

@Path("/customer")
public class CustomerResource {

	@Autowired
	private CustomerService customerService;
	
	/*
	 * To test this code from Postman, the URL will be:
	 * localhost:9090/api/customer/register
	 * And in the body of the request, you need to send
	 * the customer data in the json format, for ex:
	 	{
	    	"name" : "Majrul",
			"mobileNo" : 123456789,
			"email" : "majrul@gmail.com",
			"password" : "123456"
		}
	 */
	@POST
	@Path("/register")
	public String register(Customer customer) {
		customerService.register(customer);
		return "Customer registered successfully..";
	}
}
