package com.fis.io;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteFile {

	public static void main(String[] args) {
		//FileOutputStream outFile = null;
		FileWriter outFile = null;
		try {
			//outFile = new FileOutputStream("somefile.txt");
			outFile = new FileWriter("somefile.txt", true);
			
			Scanner s = new Scanner(System.in);
			System.out.println("Enter some data");
			String data = s.nextLine();
			
			//outFile.write(data.getBytes());		
			outFile.write(data.toCharArray());
			outFile.write("\n");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try { outFile.close(); } catch(Exception e) { }
		}
	}
}
