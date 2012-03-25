/**
*OutputStreamWriter {writer套在stream上}
*****/

import java.io.*;

public class TestTransform {
	public static void main(String[] args) {
		try {
			OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream("osw.txt"));
			osr.write("OutputStreamWriter test");
			System.out.println(osr.getEncoding());
			osr.close();//这里如果不关闭。后面再写入时，会覆盖前面写的，即使你写了true让他 追加在文件后面。
			
			osr = new OutputStreamWriter((new FileOutputStream("osw.txt", true)), "ISO8859_1");
			osr.write("OutputStreamWriter test 2");
			System.out.println(osr.getEncoding());
			osr.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}