/**
	TCP: 
	Server�� 
	����һ��ServerSocket���󣬼�����ĳ���˿��ϣ� 
	����accept��������һ�����ӣ� 
	���յ����Ӻ���Input & Output����ͨ���� 
	�������˹ر� ��/Socket����
	Client�� 
	new Socket���������������ϣ� 
	�õ�Input & Output��ʼ����ͨ���� 
	�رա�


 */


import java.net.*;
import java.io.*;

public class TCPServer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(6666);
		while(true) {
			Socket serverS = ss.accept();//���ﲻ���½�һ��Socket�����ǰѼ������� ���� ����Ϊһ����Socket��
			System.out.println("A client connected.");
			
			InputStream is = serverS.getInputStream();//ȡ������ܵ���
			DataInputStream dis = new DataInputStream(is);//����
			System.out.println(dis.readUTF());//��ӡ�������Ķ�����
			
			//��ȡ ����� socket �����Ϣ��
			System.out.println(serverS.getInetAddress() + "#" + serverS.getPort());
			
		}
	}
}