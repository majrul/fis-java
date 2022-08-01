package com.fis.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloResource {

	@GET
	public String hello() {
		return "Welcome to REST API Development using JAX-RS";
	}
}
