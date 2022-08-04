package com.jpmc.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello2")
public class HelloResource2 {

	@GET
	@Produces("text/plain")
	public String hello() {
		return "Hello2 everyone, welcome to JAX-RS session";
	}
}
