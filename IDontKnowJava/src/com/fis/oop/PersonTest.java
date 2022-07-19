package com.fis.oop;

public class PersonTest {

	public static void main(String[] args) {
		Person p1 = new Person("Neelam", 22);
		Person p2 = new Person("Deepanjali", 23);
		Person p3 = new Person();
		p3.setName("Piyush");
		p3.setAge(22);

		System.out.println(p1.getName() + " , " + p1.getAge());
		System.out.println(p2.getName() + " , " + p2.getAge());
		System.out.println(p3.getName() + " , " + p3.getAge());

		System.out.println(Person.getPopulation());
	}
}
