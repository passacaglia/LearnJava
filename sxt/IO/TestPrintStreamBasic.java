/**
*
*
*
*****/

import java.io.*;

public class TestPrintStreamBasic {
	public static void main(String[] args) {
		PrintStream ps = null;
		
		try {
			//write
			FileOutputStream fos = new FileOutputStream("test2.txt");
			ps = new PrintStream(fos);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		if (ps != null) {
			System.out.println(ps + " ps !null \n");//Of course, Line 11 & Line 16 will tell you.
			System.setOut(ps);
		}
		
		int ln = 0;
		for (char c=0; c<=6000; c++) {
			System.out.print(c + " ");
			if (ln++ >= 100) {
				System.out.println();
				ln = 0;
			}
		}
	}
}