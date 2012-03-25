/**
*在命令行参数中键入  文件名， 程序会把这个文件中的内容打印出来
*
*
*****/

import java.io.*;

public class TestPrintStream {
	public static void main(String[] args) {
		String fileName = args[0];
		if (fileName != null) {
			list(fileName, System.out);
		} else {
			System.out.println("Please input a file name as cmd parameter.");
			System.exit(-1);
		}
	}
	
	static void list(String fileName, PrintStream ps) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String s = null;
			
			while((s = br.readLine()) != null) {
				ps.println(s);
			}
			
			ps.close();
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}