//UDP没有技术意义上的Server和Client。只是为了说明发送和接收的问题。
/**
	Server: 
	new DatagramSocket & Byte[] & DatagramPacket; 
	通过DatagramSocket的receive方法接收； 
	DatagramPacket接收到的任何东西放到Byte[]。 （ds.receive(dp)；放到dp，dp又放到Byte[]） 
	字节数组 最后转成 想要的东西。
	Client: 
	new DatagramSocket & Byte[] & DatagramPacket; 
	各种数据转换成字节数组，写好IP，放到包里； 
	扔出去。send方法。 
	close。
 */

import java.net.*;

public class UDPServer {
	public static void main(String[] args) throws Exception {
		byte[] buf = new byte[1024];//如果小于 发送者的包  的大小，消息将会被裁减。是不完整的。
		//DatagramSocket【用来建立UDP的Socket】（用来接收数据包的 插座） 
		//DatagramPacket【负责传送UDP数据】
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		DatagramSocket ds = new DatagramSocket(4321);
		
		while(true) {
			ds.receive(dp);
			//System.out.println(new String(buf, 0, buf.length));//这种方式会把buf数组的所有东西打印出来。
			System.out.println(buf.length + " " + dp.getLength());//数组的长度：1024. 	拿到的长度是dp.getLength():11.
			System.out.println(new String(buf, 0, dp.getLength()));
		}
	}
}