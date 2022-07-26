package com.fis.component.banking.copy;

import org.springframework.stereotype.Component;

@Component("icici-bank-v2")
public class IciciBank implements Bank {

	public boolean isAccountPresent(int acno) {
		if(acno == 1010101010)
			return true;
		return false;
	}
	
	public void withdraw(int atmId, int acno, double amount) {
		System.out.println("Customer of IciciBank wants to withdraw money..");
	}

}
