package com.fis.component;


import org.springframework.stereotype.Component;

@Component("currConv") //alternative to <bean id="currConv" class="com.fis.component.CurrencyConverter" />
public class CurrencyConverter {

	public double convert(String from, String to, double amount) {
		if(from.equals("USD") && to.equals("INR"))
			return amount * 79.78;
		else if(from.equals("GBP") && to.equals("INR"))
			return amount * 96.30;
		else
			return 0; //rather we should have thrown an exception that conversion not supported
	}
}
