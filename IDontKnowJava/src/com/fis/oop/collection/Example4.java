package com.fis.oop.collection;

import java.util.HashMap;
import java.util.Map;

public class Example4 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("192.168.1.1", "majrul");
		map.put("192.168.1.2", "afaq");
		map.put("192.168.1.3", "gokul");
		
		String user = map.get("192.168.1.1");
		System.out.println(user);
	}
}
