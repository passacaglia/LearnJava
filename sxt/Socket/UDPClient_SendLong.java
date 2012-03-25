/**
*����һ��long���͵�����
*
*
***/

import java.net.*;
import java.io.*;

public class UDPClient_SendLong {
	public static void main(String[] args) {
		try {
			
			//����long���͵�����������д���ֽ����� �� �������ֽ������Ƿ����ڴ�����ģ�
			long l = 10000L;
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			DataOutputStream dos = new DataOutputStream(baos);
			dos.writeLong(l);
			
			//���� ת���� �ֽ����顣 ��װ��dp��
			byte[] buf = baos.toByteArray();
			DatagramPacket dp = new DatagramPacket(buf, 0, buf.length,
																						new InetSocketAddress("127.0.0.1", 5432));
			DatagramSocket ds = new DatagramSocket();
			
			//����
			ds.send(dp);
			ds.close();			
			
		} catch (SocketException se) {
			se.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}