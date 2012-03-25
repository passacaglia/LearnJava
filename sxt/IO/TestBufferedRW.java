/**
*
*****/

import java.io.*;

public class TestBufferedRW {
	public static void main(String[] args) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("./test002.txt"));
			BufferedReader br = new BufferedReader(new FileReader("./test.txt"));
			
			//bw
			String s = null;
			for (int i=1; i<=100; i++) {
				s = String.valueOf(Math.random());//String��valueOf������	�Ѻ����ת�����ַ���
				bw.write(s);
				bw.newLine();
			}
			bw.flush();//���� Ͱ�������
			
			//br
			while((s=br.readLine()) != null) {
				System.out.println(s);
			}
			
			bw.close();
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}