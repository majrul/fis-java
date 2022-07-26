package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		
		CarPartsInventory cpInv = (CarPartsInventory) ctx.getBean("carPartsInv1");
		
		//few classes will still be left, whose object's we will only continue creating
		CarPart cp = new CarPart();
		cp.setPartNo(102);
		cp.setPartName("Mirror");
		cp.setCarModel("Maruti 800");
		cp.setPrice(1500);
		cp.setQuantity(50);
		
		cpInv.addNewPart(cp);
	}
}
