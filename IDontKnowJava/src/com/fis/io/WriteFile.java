package com.fis.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {

	public static void main(String[] args) {
		FileOutputStream outFile = null;
		try {
			outFile = new FileOutputStream("somefile.txt");
			
			Scanner s = new Scanner(System.in);
			System.out.println("Enter some data");
			String data = s.nextLine();
			
			outFile.write(data.getBytes());			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try { outFile.close(); } catch(Exception e) { }
		}
	}
}
