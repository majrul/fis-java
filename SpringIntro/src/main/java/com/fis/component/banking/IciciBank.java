package com.fis.component.banking;

import org.springframework.stereotype.Component;

@Component
public class IciciBank implements Bank {

	public void withdraw(int atmId, int acno, double amount) {
		System.out.println("Customer of IciciBank wants to withdraw money..");
	}

}
