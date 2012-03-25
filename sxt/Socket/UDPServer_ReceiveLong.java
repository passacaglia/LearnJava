/**
*����һ��long���͵�����
*
*
***/

import java.net.*;
import java.io.*;

public class UDPServer_ReceiveLong {
	public static void main(String[] args) {
		try {
			
			//׼��һ������ �ֽ����� �İ���
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			DatagramSocket ds = new DatagramSocket(5432);
			
			//���������������dp����
			ds.receive(dp);
			
			//���պ�Ĵ������ڴ��ж�ȡ�ֽ����飨��bais����
			//����һ�㣬����Ĵ��ֽ�������ֱ�Ӷ�ȡlong���͵�����
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