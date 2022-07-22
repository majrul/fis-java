package com.fis.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {
		//FileInputStream inFile = null;
		FileReader inFile = null;
		try {
			//inFile = new FileInputStream("sample.txt");
			inFile = new FileReader("sample.txt");
			while(true) {
				int ch = inFile.read();
				if(ch == -1) //EOF
					break;
				System.out.print((char) ch);
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Please check the no. of your glasses!");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try { inFile.close(); } catch(Exception e) { }
		}
	}
}
