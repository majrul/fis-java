package com.fis.oop;

public class Calculator {

	public void add(int x, int y) {
		System.out.println(x + y);
	}

	public static void sub(int x, int y) {
		System.out.println(x - y);
	}
	
	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.add(10, 20);
		
		Calculator.sub(10, 20);
	}
}
