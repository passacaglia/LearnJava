/**
*发送一个long类型的数。
*
*
***/

import java.net.*;
import java.io.*;

public class UDPClient_SendLong {
	public static void main(String[] args) {
		try {
			
			//定义long类型的数，并把它写进字节数组 流 里。（这个字节数组是放在内存里面的）
			long l = 10000L;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			DataOutputStream dos = new DataOutputStream(baos);
			dos.writeLong(l);
			
			//把流 转换成 字节数组。 包装到dp。
			byte[] buf = baos.toByteArray();
			DatagramPacket dp = new DatagramPacket(buf, 0, buf.length,
																						new InetSocketAddress("127.0.0.1", 5432));
			DatagramSocket ds = new DatagramSocket();
			
			//发送
			ds.send(dp);
			ds.close();			
			
		} catch (SocketException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}