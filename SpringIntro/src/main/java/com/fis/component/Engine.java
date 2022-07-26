package com.fis.component;

import org.springframework.stereotype.Component;

@Component("super-fast-engine")
public class Engine {

	public void start() {
		System.out.println("vroom, vroom..");
	}
	
	public void stop() {
		System.out.println("phoosh, phoosh..");
	}
}
