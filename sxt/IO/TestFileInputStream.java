/**
*字节型
*
*保证访问的到fin，先定义成null。
*
*while循环，是!= -1，不是 != 0哦。
*需不需要在while循环里面 fin.read()，而有的不需要，为何？
*
*乱码； 一个汉字 = 一个字符 = 两个字节；
*
*
**/

import java.io.*;

public class TestFileInputStream {
	public static void main(String[] args) {
		int b;
		File f = new File("./TestFileInputStream.java");
		FileInputStream fin = null;//在这里定义的目的是保证后面第二个try catch里能访问的到。
		
		try {
			fin = new FileInputStream(f);
		} catch (FileNotFoundException fte) {
			System.out.println("File not found!!");
			fte.printStackTrace();
			System.exit(-1);
		}
		
		try {
			long num = 0;
			b = fin.read();
			
			while(b != -1) {//是不等于-1，不是0哦
				System.out.print((char)b);
				b = fin.read();
				num ++;
			}
			
			/*
			*为什么这个不用再	b = fin.read();
			while((b=fin.read())!=-1){
        System.out.print((char)b); 
        num++;
      }
			*/
			
			fin.close();
			System.out.println("\n 共读取 " + num + " 个字节");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
}