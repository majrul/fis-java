package com.fis.component.banking.copy;

import org.springframework.stereotype.Component;

@Component("citi-bank-v2")
public class CitiBank implements Bank {

	public boolean isAccountPresent(int acno) {
		if(acno == 2020202020)
			return true;
		return false;
	}
	
	public void withdraw(int atmId, int acno, double amount) {
		System.out.println("Customer of CitiBank wants to withdraw money..");
	}

}
