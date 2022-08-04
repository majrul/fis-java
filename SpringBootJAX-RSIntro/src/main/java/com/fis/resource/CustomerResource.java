package com.fis.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.fis.entity.Customer;
import com.fis.exception.CustomerServiceException;
import com.fis.model.CustomerInfo;
import com.fis.model.LoginInfo;
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
		try {
			customerService.registerv2(customer);
			return "Customer registered successfully..";
		}
		catch(CustomerServiceException e) {
			return e.getMessage();
		}
	}
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public CustomerInfo login(LoginInfo loginInfo) {
		try {
			Customer customer = customerService.login(loginInfo.getEmail(), loginInfo.getPassword());

			CustomerInfo info = new CustomerInfo();
			info.setStatus(true);
			info.setId(customer.getId());
			info.setName(customer.getName());
			return info;
		}
		catch(CustomerServiceException e) {
			//return e.getMessage();
			CustomerInfo info = new CustomerInfo();
			info.setStatus(false);
			info.setErrorIfAny(e.getMessage());
			return info;
		}
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer get(@PathParam("id") int id) {
		return customerService.get(id);
	}
	
	@GET
	@Path("/v2/{id}")
	public Response getv2(@PathParam("id") int id) {
		Customer cust = customerService.get(id);
		return Response
				.ok() //200 OK
				.header("cache-control", "no-cache") //setting an header
				//.cookie(null)
				.entity(cust) //response body
				.type(MediaType.APPLICATION_JSON)
				.build();
	}
	
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String update(Customer customer) {
		customerService.update(customer);
		return "Customer details updated successfully!";
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String delete(@PathParam("id") int id) {
		customerService.delete(id);
		return "Customer deleted successfully!";
	}
}
