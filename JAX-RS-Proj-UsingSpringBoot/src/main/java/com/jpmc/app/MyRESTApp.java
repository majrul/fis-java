package com.jpmc.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.jpmc.exception.TradeExceptionMapper;
import com.jpmc.resource.ExploringRESTResource;
import com.jpmc.resource.HelloResource;
import com.jpmc.resource.HelloResource2;
import com.jpmc.resource.TradeResource;

@Component
@ApplicationPath("/1.0")
public class MyRESTApp extends ResourceConfig {

	public MyRESTApp() {
		packages("com.jpmc.resource,com.jpmc.exception");
	}
	/*@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<>();
		set.add(HelloResource.class);
		set.add(HelloResource2.class);
		set.add(TradeResource.class);
		set.add(TradeExceptionMapper.class);
		set.add(ExploringRESTResource.class);
		return set;
	}*/
}
