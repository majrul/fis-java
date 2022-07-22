package com.fis.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Deserialize {

	public static void main(String[] args) {
		FileInputStream inFile = null;
		ObjectInputStream deserializer = null;
		
		try {
			inFile = new FileInputStream("cust.data");
			deserializer = new ObjectInputStream(inFile);
			
			Customer customer = (Customer) deserializer.readObject();
			System.out.println(customer.getName());
			System.out.println(customer.getEmail());
			System.out.println(customer.getMobileNumber());
		}
		catch(ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		finally {
			try { deserializer.close(); } catch(Exception e) { }
			try { inFile.close(); } catch(Exception e) { }
		}
	}

}
