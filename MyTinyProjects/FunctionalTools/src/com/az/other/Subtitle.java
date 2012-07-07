/**
 * change the name of directory which contains the subtile file.
 * "ass" file only.
 */

package com.az.other;

import java.io.*;
import java.util.regex.*;


public class Subtitle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Subtitle sub = new Subtitle();
		//change the dir name here
		File dir = new File("D:\\Temp\\New folder");
		for (File f : dir.listFiles()) {
			if (f.toString().endsWith(".ass")) {
				sub.writeSub(f, sub.readSub(f));
			}
		}
		
		System.out.println("***DONE***");
	}

	public String readSub(File f) {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = null;
		String s;
		
		try {
			br = new BufferedReader(new FileReader(f));
			while((s=br.readLine()) != null) {
				sb.append(handle(s));
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("No file found!!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
System.out.println(f.toString());				
//System.out.println(sb.toString());		
		
		return sb.toString();
	}
	
	public String handle(String str) {
			
		if (str.startsWith("Dialogue:") && (str.indexOf("H00FFFF&}") != -1)) {
			str = str.substring(str.indexOf("0,0")+2, str.indexOf(".")) + " " +
					str.substring(str.indexOf("HFF8000&}")+9, str.indexOf("\\r}")-1) + "\n" + 
					str.substring(str.indexOf("H00FFFF&}")+9, str.length()-4) + "\n\n" ;
			
		} else {
			str = "";
		}
		

		
		
		return str;
	}
	
	
	public void writeSub(File f, String str) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(f.toString() + ".AZ.txt"));
			bw.write(str);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	
}
















