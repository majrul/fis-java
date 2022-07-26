package com.fis.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fis.component.banking.copy.Atm;

public class App {

	public static void main(String[] args) {
		//Loading IoC container
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		
		
		for(int i=0; i<5; i++) {
			//Accessing a bean
			HelloWorld hw =  (HelloWorld) ctx.getBean("hello");
			//But why are we using Spring? I've could have created HelloWorld object like this:
			//HelloWorld hw = new HelloWorld();
			System.out.println(hw.sayHello("Majrul"));
			System.out.println(hw.sayHi("Majrul"));
		}
		
		Calculator c = (Calculator) ctx.getBean("calc");
		System.out.println(c.add(10, 20));
		
		CurrencyConverter cc = (CurrencyConverter) ctx.getBean("currConv");
		System.out.println(cc.convert("USD", "INR", 75));
		
		LoginService loginServ = (LoginService) ctx.getBean("login");
		System.out.println(loginServ.isValid("majrul", "456"));
		
		TextEditor te = (TextEditor) ctx.getBean("txtEdtr");
		te.loadDocument("abc.txt");
		
		Car car = (Car) ctx.getBean("mycar");
		car.drive(); 
		
		Atm atm = (Atm) ctx.getBean("sbi-atm-v2");
		atm.withdraw(2020202020, 5000);
	}
}
