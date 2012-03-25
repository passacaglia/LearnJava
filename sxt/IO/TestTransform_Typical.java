/**
*很典型的用法『先把用 读字节的方式 转换成 读读字符的方式，外面再套一层Buffered』
*
*****/

import java.io.*;

public class TestTransform_Typical {
	public static void main(String[] args) {
		try {
			//System.in：接收键盘输入
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
