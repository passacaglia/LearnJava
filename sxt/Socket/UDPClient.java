import java.net.*;

public class UDPClient {
	public static void main(String[] args) throws Exception {
		byte[] buf = (new String("Hello, UDP.")).getBytes();
		DatagramPacket dp = new DatagramPacket(buf, 0, buf.length, new InetSocketAddress("127.0.0.1", 4321));
		DatagramSocket ds = new DatagramSocket();//Client�ˣ�ûд�˿ںš�ϵͳ�������ָ��һ���˿ں�ʹ�á�
		
		ds.send(dp);
		ds.close();
	}
}