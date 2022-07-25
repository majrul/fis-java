package com.fis.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		//Loading IoC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		
		//Accessing a bean
		HelloWorld hw =  (HelloWorld) ctx.getBean("hello");
		//But why are we using Spring? I've could have created HelloWorld object like this:
		//HelloWorld hw = new HelloWorld();
		System.out.println(hw.sayHello("Majrul"));
		System.out.println(hw.sayHi("Majrul"));
		
		Calculator c = (Calculator) ctx.getBean("calc");
		System.out.println(c.add(10, 20));
		
		CurrencyConverter cc = (CurrencyConverter) ctx.getBean("currConv");
		System.out.println(cc.convert("USD", "INR", 75));
	}
}
