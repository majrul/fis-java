package com.fis.oop.api;

public class Person /*extends Object*/ {

	private String name;
	private int age;
	
	public Person() {
		
	}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
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
	
	@Override
	public String toString() {
		return name + " , " + age;
	}
	
	public static void main(String[] args) {
		Person p1 = new Person("Majrul", 40);
		System.out.println(p1.getName() + " , " + p1.getAge());
		System.out.println(p1);
	}
}
