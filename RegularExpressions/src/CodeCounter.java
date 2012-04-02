import java.util.*;
import java.io.*;

public class CodeCounter {

	static long commentLines = 0;
	static long whiteLines = 0;
	static long normalLines = 0;
	
	public static void main(String[] args) {
		File dir = new File("D:\\temp");
		find(dir);
		
		System.out.println("comment lines : " + commentLines);
		System.out.println("white lines : " + whiteLines);
		System.out.println("normal lines : " + normalLines);
	
	}
	
		

	private static void find(File dir) {
		File[] files = dir.listFiles();
		for (File f : files) {
			if (f.getName().matches(".*\\.java$")) {
				parse(f);
			}
			if (f.isDirectory()) {
				find(f);
			}
		}
	}



	private static void parse(File f) {
		BufferedReader br = null;
		boolean comment = false;
		long wl = 0;
		long cl = 0;
		long nl = 0;
		try {
			br = new BufferedReader(new FileReader(f));
			String line = "";
			while ((line=br.readLine()) != null) {
				line.trim();
				if (line.matches("^[\\s&&[^\\n]]*$")) {  //white lines
					whiteLines++;
					wl++;
				} else if (line.startsWith("/*")) {
					commentLines++;
					cl++;
					comment = true;
				} else if (true == comment) {
					commentLines++;
					cl++;
					if (line.endsWith("*/")) {
						comment = false;
					}
				} else if (line.startsWith("//")) {
					commentLines++;
					cl++;
				} else if (line.startsWith("/*") && line.endsWith("*/")) {
					commentLines++;
					cl++;
				} else {
					normalLines++;
					nl++;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
					br = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(f + "\n white lines : " + wl + ", comment lines : " + cl + ", normal lines : " + nl + "\n");
		
	}
}


































