package com.jpmc.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello1")
public class HelloResource {

	@GET
	@Produces("text/plain")
	public String hello() {
		return "Hello1 everyone, welcome to JAX-RS session";
	}
}
