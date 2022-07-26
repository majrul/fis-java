package com.fis.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("mycar")
public class Car {

	@Autowired
	private Engine engine;
	
	public void drive() {
		engine.start();
		//go to my destination
		engine.stop();
	}
}
