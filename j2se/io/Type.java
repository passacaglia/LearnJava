import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Type {
	public static void main(String[] args) {
		//detect cmd parameters
		if (args.length == 0) {
			System.out.println("Usage: java Type yourfilename");
			System.exit(-1);
		}
		
		//read
		/*
		try {
			FileInputStream fin = new FileInputStream(args[0]);
			int i = fin.read();
			while (i != -1) {
				System.out.print((char)i);
				i = fin.read();//这里是重点，读取下一行
			}
			fin.close();
		} catch (IOException e) {
			System.out.println(e);
		}
		*/
		
		/*
		*method 2
		try {
			FileInputStream fin = new FileInputStream(args[0]);
			while (fin.available() > 0) {
				System.out.print((char)fin.read());
			}
			fin.close();//这里是重点，读取下一行
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		try {
			FileInputStream fin = new FileInputStream(args[0]);
			byte buf[] = new byte[64];
			int i = fin.read(buf);
			
			while (i == 64) {
				System.out.print(new String(buf));
				i = fin.read(buf);//这里是重点，读取下一行
			}
			
			System.out.print(new String(buf, 0, i));
			fin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}