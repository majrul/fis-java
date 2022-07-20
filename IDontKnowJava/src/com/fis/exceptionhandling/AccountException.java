package com.fis.exceptionhandling;

//public class AccountException extends Exception { //checked
public class AccountException extends RuntimeException { //unchecked
	
	public AccountException(String msg) {
		super(msg);
	}
}
