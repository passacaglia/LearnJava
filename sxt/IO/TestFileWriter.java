/**
*写入了地球上的文字
*
***/

import java.io.*;

public class TestFileWriter {
	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream("./fout.dat");
			for (int c=97; c<200; c++) {
				fout.write(c);
			}
			fout.close();
			System.out.println("Write Succeed!!");
		} catch (FileNotFoundException fne) {
			fne.printStackTrace();
			System.exit(-1);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(-1);
		}
	}
}