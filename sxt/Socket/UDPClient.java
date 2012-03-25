import java.net.*;

public class UDPClient {
	public static void main(String[] args) throws Exception {
		byte[] buf = (new String("Hello, UDP.")).getBytes();
		DatagramPacket dp = new DatagramPacket(buf, 0, buf.length, new InetSocketAddress("127.0.0.1", 4321));
		DatagramSocket ds = new DatagramSocket();//Client端，没写端口号。系统将会随机指定一个端口号使用。
		
		ds.send(dp);
		ds.close();
	}
}