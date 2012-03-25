/**
*OutputStreamWriter {writer����stream��}
*****/

import java.io.*;

public class TestTransform {
	public static void main(String[] args) {
		try {
			OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream("osw.txt"));
			osr.write("OutputStreamWriter test");
			System.out.println(osr.getEncoding());
			osr.close();//����������رա�������д��ʱ���Ḳ��ǰ��д�ģ���ʹ��д��true���� ׷�����ļ����档
			
			osr = new OutputStreamWriter((new FileOutputStream("osw.txt", true)), "ISO8859_1");
			osr.write("OutputStreamWriter test 2");
			System.out.println(osr.getEncoding());
			osr.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}