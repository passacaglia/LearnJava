/**
*
********/

import java.io.*;

public class TestFileOutputStream {
	public static void main(String[] args) {
		int r, w;
 
		try {
			FileInputStream fin = new FileInputStream("./TestFileOutputStream.java");//×ÔÉí
			FileOutputStream fout = new FileOutputStream("./TestFileOutputStream_Copy.java");
			
			while((r = fin.read()) != -1) {
				fout.write(r);
			}
			
			fin.close();
			fout.close();
			System.out.println("Copy Succeed!");
		} catch (FileNotFoundException fne) {//×¢Òâ²¶×½Ë³Ðò
			fne.printStackTrace();
			System.exit(-1);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(-1);
		} 
	}
}