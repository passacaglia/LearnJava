/**
*接收一个long类型的数。
*
*
***/

import java.net.*;
import java.io.*;

public class UDPServer_ReceiveLong {
	public static void main(String[] args) {
		try {
			
			//准备一个接收 字节数组 的包。
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			DatagramSocket ds = new DatagramSocket(5432);
			
			//在这个插座，接收dp包。
			ds.receive(dp);
			
			//接收后的处理。从内存中读取字节数组（用bais）。
			//再套一层，方便的从字节数组中直接读取long类型的数。
			ByteArrayInputStream bais = new ByteArrayInputStream(buf, 0, dp.getLength());
			DataInputStream dis = new DataInputStream(bais);
			System.out.println(dis.readLong());			
			
		} catch (SocketException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}