package com.fis.oop.collection;

import java.util.HashMap;
import java.util.Map;

import com.fis.oop.api.Person;

public class Example4 {

	public static void main(String[] args) {
		//ip-address as the key, username as the value
		Map<String, String> map = new HashMap<>(); //LinkedHashMap
		map.put("192.168.1.1", "majrul");
		map.put("192.168.1.2", "afaq");
		map.put("192.168.1.3", "gokul");
		
		String user = map.get("192.168.1.1");
		System.out.println(user);
		
		for(Map.Entry<String, String> entry : map.entrySet()) {
			String ip = entry.getKey();
			String usr = entry.getValue();
			System.out.println(ip + " : " + usr);
		}
		
		//aadharcard no as the key, person details as the value
		Map<Integer, Person> map2 = new HashMap<>();
		map2.put(1234567890, new Person("Majrul", 40));
		map2.put(1122334455, new Person("Indrajeet", 22));
		map2.put(1234512345, new Person("Mohit", 23));
		map2.put(1321234545, new Person("Pragathi", 22));
		
		Person p = map2.get(1122334455);
		System.out.println(p);
		
		
	}
}
