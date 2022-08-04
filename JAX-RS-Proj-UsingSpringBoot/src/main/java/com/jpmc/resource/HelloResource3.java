package com.jpmc.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello3")
public class HelloResource3 {

	@GET
	@Produces("text/plain")
	public String hello() {
		return "Hello3 everyone, welcome to JAX-RS session";
	}
}
