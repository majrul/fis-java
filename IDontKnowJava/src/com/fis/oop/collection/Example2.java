package com.fis.oop.collection;

import java.util.ArrayList;
import java.util.List;

import com.fis.oop.api.Person;

public class Example2 {

	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		Person p1 = new Person("Mayur", 22);
		Person p2 = new Person("Manasa", 22);
		list.add(p1);
		list.add(p2);
		list.add(new Person("Siddharth", 23));
		list.add(new Person("Prashant", 23));
		
		//practice for loop now
		for(Person p : list)
			System.out.println(p);
	}
}
