package com.fis.oop.abstractmethods;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator c = new MyCalculator();
		c.add(10, 20);
		c.sub(10, 20);
	}
}
