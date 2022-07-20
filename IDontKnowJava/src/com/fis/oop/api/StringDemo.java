package com.fis.oop.api;

public class StringDemo {

	public static void main(String[] args) {
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";		
		
		String newStr = "";
		long ns1 = System.nanoTime();
		for(int i=0; i<str.length(); i++)
			for(int j=0; j<=i; j++)
				//newStr += str.charAt(j);
				newStr = newStr + str.charAt(j);
		long ns2 = System.nanoTime();
		
		System.out.println(newStr);
		System.out.println("Approx time taken : " + (ns2 - ns1) + " nonoseconds");


		StringBuffer sbuff = new StringBuffer();
		ns1 = System.nanoTime();
		for(int i=0; i<str.length(); i++)
			for(int j=0; j<=i; j++)
				sbuff.append(str.charAt(j));
		ns2 = System.nanoTime();

		System.out.println(sbuff);
		System.out.println("Approx time taken : " + (ns2 - ns1) + " nonoseconds");

		StringBuilder sbuild = new StringBuilder();
		ns1 = System.nanoTime();
		for(int i=0; i<str.length(); i++)
			for(int j=0; j<=i; j++)
				sbuild.append(str.charAt(j));
		ns2 = System.nanoTime();

		System.out.println(sbuild);
		System.out.println("Approx time taken : " + (ns2 - ns1) + " nonoseconds");

		/*double balance = 5000;
		double amount = 1000;
		
		//balance = balance - amount;
		//balance -= amount;*/
	}
}
