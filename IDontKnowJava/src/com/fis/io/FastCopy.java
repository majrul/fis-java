package com.fis.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FastCopy {

	public static void main(String[] args) {
		FileInputStream inFile = null;
		FileOutputStream outFile = null;
		BufferedInputStream inBuffer = null;
		BufferedOutputStream outBuffer = null;
		try {
			inFile = new FileInputStream("VirtualBox.dmg");
			outFile = new FileOutputStream("Copy2-of-VirtualBox.dmg");
			inBuffer = new BufferedInputStream(inFile);
			outBuffer = new BufferedOutputStream(outFile);
			
			long ms1 = System.currentTimeMillis();
			while(true) {
				int ch = inBuffer.read();
				if(ch == -1)
					break;
				outBuffer.write(ch);
			}
			long ms2 = System.currentTimeMillis();
			System.out.println("Copied successfully in approx " + (ms2 - ms1) + " ms..");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try { inBuffer.close(); } catch(Exception e) { }
			try { outBuffer.close(); } catch(Exception e) { }
			try { inFile.close(); } catch(Exception e) { }
			try { outFile.close(); } catch(Exception e) { }
		}
	}
}
