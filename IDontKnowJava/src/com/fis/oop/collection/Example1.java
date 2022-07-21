package com.fis.oop.collection;

import java.util.ArrayList;
import java.util.List;

public class Example1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>(5);
		//<> angular bracket notation in the above code is called as Generics in Java
		list.add("Java");
		list.add("Oracle");
		list.add("Python");
		list.add("JavaScript");
		list.add("Java");
		list.add("C#");
		
		//System.out.println(list.size());
		//System.out.println(list.get(2));
		
		for(int i=0; i<list.size(); i++) {
			String str = list.get(i);
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
