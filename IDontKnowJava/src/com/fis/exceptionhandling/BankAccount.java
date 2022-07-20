package com.fis.exceptionhandling;

import java.util.Scanner;

public class BankAccount {

	int acno;
	String name;
	double balance;
	
	BankAccount(int acno, String name, double balance) {
		this.acno = acno;
		this.name = name;
		this.balance = balance;
	}
	
	//void withdraw(double amount) throws Exception {
	//void withdraw(double amount) throws RuntimeException {
	void withdraw(double amount) throws AccountException {
		if(amount > balance) {
			//Exception e = new Exception("Insufficient Balance!");
			AccountException e = new AccountException("Insufficient Balance!");
			throw e;
		}
		else {
			balance -= amount;
			System.out.println("Balance left : " + balance);
			//return balance;
		}
	}
	
	public static void main(String[] args) {
		BankAccount bankAcc = new BankAccount(101010, "Majrul", 5000);
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter amount to withdraw");
		double amount = s.nextDouble();
		
		//try {
			bankAcc.withdraw(amount);
		//}
		//catch(AccountException e) {
			//System.out.println(e.getMessage());
		//}
	}
}
