/**
*��СͰ��
**/

import java.io.*;

public class TestBufferedInputStream {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("./test.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			int c = 0;
			System.out.println(bis.read());//��ȡ��һ��
			System.out.println(bis.read());//�ٶ�ȡһ��
			
			bis.mark(100);//�ӵ�100����ʼ����������ϸ���˷�����
			for (int i=0; i<=10 && (c=bis.read()) != -1; i++) {
				System.out.print((char)c + " ");
			}
			System.out.println();
			
			bis.reset();//����Ϊ���λ�ã��ص�100��
			for (int i=0; i<=10 && (c=bis.read()) != -1; i++) {
				System.out.print(c + " ");
			}
			
			bis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}