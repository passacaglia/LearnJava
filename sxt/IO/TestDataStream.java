/**
*DataInputStream 	DataOutputStream
*
*
*ByteArrayInputStream [Stream�ж������ֽڷ���  �ֽ�������]
*ByteArrayOutputStream [OutputStream�ӵ� �ڴ��е��ֽ�������]
**/

import java.io.*;

public class TestDataStream {
	public static void main(String[] args) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		
		try {
			//write
			dos.writeDouble(Math.random());//д���ڴ��е��Ǹ������С�ռDouble���͵�8���ֽڡ�����ת����String�ķ���ʡ�ռ䡣
			dos.writeBoolean(true);
			
			//read
			//ͨ��toByteArray�����������õ�baos������� �������  �����á�Ҳ����˵ ���������ʽ ���� ��������ĵ�ǰ���ݡ�
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			System.out.println("bais.available(): " + bais.available());
			
			DataInputStream dis = new DataInputStream(bais);
			System.out.println(dis.readDouble());//��д���ȶ���������Ҫ��//�������󣬻�����Զ�ת����Double���͵�����
			System.out.println(dis.readBoolean());
			
			dos.close();
			dis.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}