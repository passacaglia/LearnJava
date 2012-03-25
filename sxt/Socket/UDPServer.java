//UDPû�м��������ϵ�Server��Client��ֻ��Ϊ��˵�����ͺͽ��յ����⡣
/**
	Server: 
	new DatagramSocket & Byte[] & DatagramPacket; 
	ͨ��DatagramSocket��receive�������գ� 
	DatagramPacket���յ����κζ����ŵ�Byte[]�� ��ds.receive(dp)���ŵ�dp��dp�ַŵ�Byte[]�� 
	�ֽ����� ���ת�� ��Ҫ�Ķ�����
	Client: 
	new DatagramSocket & Byte[] & DatagramPacket; 
	��������ת�����ֽ����飬д��IP���ŵ���� 
	�ӳ�ȥ��send������ 
	close��
 */

import java.net.*;

public class UDPServer {
	public static void main(String[] args) throws Exception {
		byte[] buf = new byte[1024];//���С�� �����ߵİ�  �Ĵ�С����Ϣ���ᱻ�ü����ǲ������ġ�
		//DatagramSocket����������UDP��Socket���������������ݰ��� ������ 
		//DatagramPacket��������UDP���ݡ�
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		DatagramSocket ds = new DatagramSocket(4321);
		
		while(true) {
			ds.receive(dp);
			//System.out.println(new String(buf, 0, buf.length));//���ַ�ʽ���buf��������ж�����ӡ������
			System.out.println(buf.length + " " + dp.getLength());//����ĳ��ȣ�1024. 	�õ��ĳ�����dp.getLength():11.
			System.out.println(new String(buf, 0, dp.getLength()));
		}
	}
}