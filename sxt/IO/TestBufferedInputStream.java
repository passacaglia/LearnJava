/**
*带小桶的
**/

import java.io.*;

public class TestBufferedInputStream {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("./test.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			int c = 0;
			System.out.println(bis.read());//读取下一个
			System.out.println(bis.read());//再读取一个
			
			bis.mark(100);//从第100个开始读。（不用细究此方法）
			for (int i=0; i<=10 && (c=bis.read()) != -1; i++) {
				System.out.print((char)c + " ");
			}
			System.out.println();
			
			bis.reset();//重置为标记位置，回到100。
			for (int i=0; i<=10 && (c=bis.read()) != -1; i++) {
				System.out.print(c + " ");
			}
			
			bis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}