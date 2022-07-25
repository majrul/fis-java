package com.fis.lambda;


@FunctionalInterface
interface Printer {
	
	void print(String document);
}

//practice: 
//anonymous inner class
//lambda
interface Math {
	int calc(int x, int y);
}

class DotMatrixPrinter implements Printer {
	
	@Override
	public void print(String document) {
		System.out.println("DotMatrixPrinter printing " + document);
	}
}

public class Example {

	public static void main(String[] args) {
		//inner class implementing Printer interface
		class InkjetPrinter implements Printer {
			
			@Override
			public void print(String document) {
				System.out.println("InkjetPrinter printing " + document);
			}
		}
		
		Printer p1 = new DotMatrixPrinter();
		p1.print("abc.txt");
		
		Printer p2 = new InkjetPrinter();
		p2.print("xyz.txt");
		
		//anonymous inner class implements Printer interface
		/*class ... implements Printer {
			
		}
		Printer p3 = new ???();*/
		Printer p3 = new Printer() {
			
			@Override
			public void print(String document) {
				System.out.println("Anonymous Printer printing " + document);
			}
		};
		p3.print("def.txt");
		
		//using lambda expression for implementing Printer interface
		//rule: lambda expressions can be used with only those interfaces which have one abstract method only
		Printer p4 = doc -> {
			System.out.println("Lambda Printer printing " + doc);
		};
		p4.print("pqr.txt");
		
		Printer p5 = doc -> System.out.println("Lambda Printer printing " + doc);
		p5.print("tuv.txt");
		
		Math m1 = new Math() {
			
			@Override
			public int calc(int x, int y) {
				return x + y;
			}
		};
		System.out.println(m1.calc(10, 20));
		
		Math m2 = (x, y) -> x + y;
		System.out.println(m2.calc(100, 200));
	}
}
