package com.fis.oop.collection;

import java.util.HashSet;
import java.util.Set;

import com.fis.oop.api.Person;

public class Example3 {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>(); //LinkedHashSet
		set.add("Java");
		set.add("Oracle");
		set.add("Python");
		set.add("JavaScript");
		set.add("Java");
		set.add("C#");

		for(String str : set)
			System.out.println(str);
		
		Set<Person> set2 = new HashSet<>();
		set2.add(new Person("Mayur", 22));
		set2.add(new Person("Manasa", 22));
		set2.add(new Person("Siddharth", 23));
		set2.add(new Person("Prashant", 23));
		set2.add(new Person("Mayur", 22));

		for(Person p : set2)
			System.out.println(p);
		
		Person p1 = new Person("Mayur", 22);
		Person p2 = new Person("Mayur", 22);
		System.out.println(p1 == p2); //reference comparison
		System.out.println(p1.equals(p2)); //value comparison
		
		String s1 = new String("Java");
		String s2 = new String("Java");
		System.out.println(s1 == s2); //reference comparison
		System.out.println(s1.equals(s2)); //value comparison
	}
}
