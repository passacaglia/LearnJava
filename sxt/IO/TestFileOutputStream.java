/**
*
********/

import java.io.*;

public class TestFileOutputStream {
	public static void main(String[] args) {
		int r, w;
 
		try {
			FileInputStream fin = new FileInputStream("./TestFileOutputStream.java");//����
			FileOutputStream fout = new FileOutputStream("./TestFileOutputStream_Copy.java");
			
			while((r = fin.read()) != -1) {
				fout.write(r);
			}
			
			fin.close();
			fout.close();
			System.out.println("Copy Succeed!");
		} catch (FileNotFoundException fne) {//ע�Ⲷ׽˳��
			fne.printStackTrace();
			System.exit(-1);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(-1);
		} 
	}
}