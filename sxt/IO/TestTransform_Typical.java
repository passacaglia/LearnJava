/**
*�ܵ��͵��÷����Ȱ��� ���ֽڵķ�ʽ ת���� �����ַ��ķ�ʽ����������һ��Buffered��
*
*****/

import java.io.*;

public class TestTransform_Typical {
	public static void main(String[] args) {
		try {
			//System.in�����ռ�������
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println(isr.getEncoding());
			
			String s = br.readLine();
			while(s != null) {
				if (s.equals("exit")) {
					break;
				} else {
					System.out.println(s.toUpperCase());
					s = br.readLine();
				}
			}
			
		} catch (FileNotFoundException fne) {
			fne.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
