package com.fis.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {

	public static void main(String[] args) {
		FileInputStream inFile = null;
		FileOutputStream outFile = null;
		try {
			inFile = new FileInputStream("VirtualBox.dmg");
			outFile = new FileOutputStream("Copy-of-VirtualBox.dmg");
			
			long ms1 = System.currentTimeMillis();
			while(true) {
				int ch = inFile.read();
				if(ch == -1)
					break;
				outFile.write(ch);
			}
			long ms2 = System.currentTimeMillis();
			System.out.println("Copied successfully in approx " + (ms2 - ms1) + " ms..");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try { inFile.close(); } catch(Exception e) { }
			try { outFile.close(); } catch(Exception e) { }
		}
	}
}
