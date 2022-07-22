package com.fis.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialize {

	public static void main(String[] args) {
		FileOutputStream outFile = null;
		ObjectOutputStream serializer = null;
		
		try {
			outFile = new FileOutputStream("cust.data");
			serializer = new ObjectOutputStream(outFile);
			
			Customer customer = new Customer();
			customer.setName("Yaman");
			customer.setEmail("yaman@gmail");
			customer.setMobileNumber(1234567890);
			
			serializer.writeObject(customer);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try { serializer.close(); } catch(Exception e) { }
			try { outFile.close(); } catch(Exception e) { }
		}
	}
}
