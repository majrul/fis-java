package com.fis.oop.abstractmethods;

public class MyCalculator implements Calculator {

	@Override
	public void add(int x, int y) {
		System.out.println(x + y);
	}

	@Override
	public void sub(int x, int y) {
		System.out.println(x - y);
	}
	
}
