package com.fis.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class AppConfig extends ResourceConfig {

	public AppConfig() {
		packages("com.fis.resource");
	}
}
