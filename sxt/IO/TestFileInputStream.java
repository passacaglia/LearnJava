/**
*�ֽ���
*
*��֤���ʵĵ�fin���ȶ����null��
*
*whileѭ������!= -1������ != 0Ŷ��
*�費��Ҫ��whileѭ������ fin.read()�����еĲ���Ҫ��Ϊ�Σ�
*
*���룻 һ������ = һ���ַ� = �����ֽڣ�
*
*
**/

import java.io.*;

public class TestFileInputStream {
	public static void main(String[] args) {
		int b;
		File f = new File("./TestFileInputStream.java");
		FileInputStream fin = null;//�����ﶨ���Ŀ���Ǳ�֤����ڶ���try catch���ܷ��ʵĵ���
		
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
			
			while(b != -1) {//�ǲ�����-1������0Ŷ
				System.out.print((char)b);
				b = fin.read();
				num ++;
			}
			
			/*
			*Ϊʲô���������	b = fin.read();
			while((b=fin.read())!=-1){
        System.out.print((char)b); 
        num++;
      }
			*/
			
			fin.close();
			System.out.println("\n ����ȡ " + num + " ���ֽ�");
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	}
}