/**
*DataInputStream 	DataOutputStream
*
*
*ByteArrayInputStream [Stream中读到的字节放在  字节数组中]
*ByteArrayOutputStream [OutputStream接到 内存中的字节数组上]
**/

import java.io.*;

public class TestDataStream {
	public static void main(String[] args) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		
		try {
			//write
			dos.writeDouble(Math.random());//写进内存中的那个数组中。占Double类型的8个字节。比先转换成String的方法省空间。
			dos.writeBoolean(true);
			
			//read
			//通过toByteArray方法，可以拿到baos这个流的 输出内容  的引用。也就是说 以数组的形式 返回 此输出流的当前内容。
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			System.out.println("bais.available(): " + bais.available());
			
			DataInputStream dis = new DataInputStream(bais);
			System.out.println(dis.readDouble());//先写的先读出来。重要。//读出来后，会帮你自动转换成Double类型的数。
			System.out.println(dis.readBoolean());
			
			dos.close();
			dis.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}