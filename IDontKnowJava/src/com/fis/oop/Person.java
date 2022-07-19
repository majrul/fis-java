package com.fis.oop;

public class Person {

	private String name;
	private static int age;

	//private static int population;
	
	public Person() {
		//population ++;
		
	}
	public Person(String name, int age) {
		//population ++;
		this.name = name;
		this.age = age;
	}

	/*public static int getPopulation() {
		return population;
	}*/

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
