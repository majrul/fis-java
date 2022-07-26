package com.fis.component;

public class HelloWorld {
	
	public HelloWorld() {
		System.out.println("HelloWorld constructor..");
	}

	public String sayHello(String name) {
		return "Hello " + name;
	}

	public String sayHi(String name) {
		return "Hi " + name;
	}
	
}
