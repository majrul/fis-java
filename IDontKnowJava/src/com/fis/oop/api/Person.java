package com.fis.oop.api;

import java.util.Objects;

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
	public int hashCode() {
		System.out.println("hashCode called..");
		return Objects.hash(age, name);
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals called..");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	/*@Override
	public String toString() {
		return name + " , " + age;
	}*/
	
	public static void main(String[] args) {
		Person p1 = new Person("Majrul", 40);
		System.out.println(p1.getName() + " , " + p1.getAge());
		System.out.println(p1);
	}
}
