package com.fis.component.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SbiAtm implements Atm {

	@Autowired
	private Bank bank;
	//this is tight coupling -> private Bank bank = new IciciBank();
	
	public void withdraw(int acno, double amount) {
		System.out.println("Customer at SbiAtm wants to withdraw money..");
		bank.withdraw(12345, acno, amount);
	}

}
