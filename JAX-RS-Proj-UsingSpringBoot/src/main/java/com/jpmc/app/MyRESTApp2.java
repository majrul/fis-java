package com.jpmc.app;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.jpmc.resource.HelloResource;
import com.jpmc.resource.HelloResource2;
import com.jpmc.resource.HelloResource3;

@ApplicationPath("/1.1")
public class MyRESTApp2 extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<>();
		set.add(HelloResource.class);
		set.add(HelloResource3.class);
		
		return set;
	}

}
