/**
*输入内容后会在屏幕上显示一次。同时还会把内容记录到log文件中（使用的是PrintWriter，它提供了更多的打印方法，而且出错时不会报异常）。
*
*s.equalsIgnoreCase("exit")忽略大小写
*获取日期的方法
**/

import java.io.*;
import java.util.Date;

public class TestPrintWriter {
	public static void main(String[] args) {
		//read
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//write
		FileWriter  fw = null;
		String s = null;
		
		try {
			fw = new FileWriter("./TestPrintWriter.log", true);
			PrintWriter log = new PrintWriter(fw);
			
			while((s=br.readLine()) != null) {
					if (s.equalsIgnoreCase("exit")) {
						break;
					} else {
						System.out.println(s.toUpperCase());
						log.println(s.toUpperCase());
					}
			}
			
			log.println("- - -" + new Date() + "- - -\n");
			log.close();
			br.close();			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}  