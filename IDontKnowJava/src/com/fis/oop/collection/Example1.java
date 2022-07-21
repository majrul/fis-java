package com.fis.oop.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		//<> angular bracket notation in the above code is called as Generics in Java
		list.add("Java");
		list.add("Oracle");
		list.add("Python");
		list.add("JavaScript");
		list.add("Java");
		list.add("C#");
		list.add(2, "C/C++");	
		list.set(1, "GoLang");
		
		List<String> list2 = new ArrayList<>();
		list2.add("TypeScript");
		list2.add("Scala");
		list2.add("Ruby");
		
		list.addAll(list2);
		
		//System.out.println(list.size());
		//System.out.println(list.get(2));
		
		System.out.println("---- using traditional for loop ----");
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
		System.out.println("---- using enhanced for loop ----");
		for(String str : list)
			System.out.println(str);
		
		System.out.println("---- using lambda for each ----");
		list.forEach(str -> System.out.println(str));
		
		System.out.println("---- using traditional Iterator API ----");
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			String str = itr.next();
			System.out.println(str);
		}
		//Integer i = 10; //same like String, no need to use new keyword
		List<Integer> marks = new ArrayList<>();
		marks.add(15);
		marks.add(20);
		marks.add(10);
		marks.add(20);
		for(int i=0; i<marks.size(); i++) {
			Integer mark = marks.get(i);
			System.out.println(mark);
		}
	}
}
