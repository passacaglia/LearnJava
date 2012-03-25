

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ChatServer {

	ServerSocket ss = null;
	ServerSocket sscm = null;//monitor 
	boolean serverStarted = false;
	LinkedList<Client> clientList = new LinkedList<Client>();
	boolean clientConnected = false;
	
	public static void main(String[] args) {
		new ChatServer().start();		
	}
	
	
	public void start() {
						
		try {
			ss = new ServerSocket(3000);
			sscm = new ServerSocket(3001);
			serverStarted = true;
			System.out.println("Chat Server Started.");
		} catch (BindException e) {
			System.out.println("Port had been used.");
			System.exit(-1);
	    } catch (IOException e) {
			e.printStackTrace();			
		}
		
		try {
			while(serverStarted) {
				Socket s = ss.accept();
				Socket s2 = sscm.accept();
System.out.println("A client connected: " + "\n" + "   " + s.getInetAddress() + " # " + s.getPort());
				
				Client c = new Client(s, s2);
				clientList.add(c);
				new Thread(c).start();	
								
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	//Inner Class
	//Chat Server �ڲ������� ����ͻ������ݵ���
	private class Client implements Runnable {
		
		private Socket s = null;
		private Socket s2 = null;
		private DataInputStream dis = null;
		private DataOutputStream dos = null;
		
		//Client Monitor
		private DataInputStream dis2 = null;
		private DataOutputStream dos2 = null;
				
		Client(Socket s, Socket s2) {
			this.s = s;
			this.s2 = s2;
			try {
				dis = new DataInputStream(s.getInputStream());
				dos = new DataOutputStream(s.getOutputStream());
				
				//Client Monitor
				dis2 = new DataInputStream(s2.getInputStream());
				dos2 = new DataOutputStream(s2.getOutputStream());
				
				clientConnected = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//Client Monitor
			ClientMonitor cm = new ClientMonitor(this);
			new Thread(cm).start();
		}
		
		public void sendToClient(String str) {
			try {
				dos.writeUTF(str);
			} catch (IOException e) {
				System.out.println("Connection abort.");
				//e.printStackTrace();//ע�͵���һ���û��SocketException�ˡ�
			}
		}
		
		
		public void run() {
			try {
				while(clientConnected) {
//System.out.println(dis.readUTF());
					String str = dis.readUTF();
					System.out.println(str);
										
/*					//exit 3.141592654 					
					String exit = "EXIT3.141592654";
					if (str.equals(exit)) {
						str = "Client" + s.getInetAddress() + " # " + s.getPort() + " exited.";
						clientList.remove(this);
					}*/
					
					//send to clients 
					//��forѭ����Ч�ʸ�
					//iterator����  ������ ����ʹЧ�ʽ��ͣ����˴�û��Ҫ��������
					for (int i=0; i<clientList.size(); i++) {
						Client c = (Client)clientList.get(i);
						c.sendToClient(str);//send to c.
					}
				}
			} catch (EOFException e) {
				System.out.println("Client" + s.getInetAddress() + " # " + s.getPort() + " disconnected.");
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				try {
					//���Ϊ  ��, ��������û��ʼ��������������ԭ������Exception�����ù�.
					if (dis != null) {
						dis.close();
					}
					if (s != null) {
						s.close();
					}
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
		
	}

	
	/*
	 * ʹ�õ����Ķ˿ڣ�
	 * ���Ӳ���clientList����remove�Ͽ����ӵ�Client����
	 * ����Client������  ȷ�����ӵ���Ϣ�����ظ���
	 * 
	 */
	private class ClientMonitor implements Runnable {
		
		Client c = null;
				
		ClientMonitor(Client c) {
			this.c = c;
		}
		
		public void run() {
			try {
				while(clientConnected) {
					String str = c.dis2.readUTF();
					System.out.println(str);
					if (str.equals("exit")) {
						clientList.remove(c);
					} 
					if (str.equals("Are you there?")) {
						c.dos2.writeUTF(str);
					}
				}
			} catch (SocketException e) {
				System.out.println("Client connection abort.");
			} catch (EOFException e) {
				System.out.println("Client" + c.s2.getInetAddress() + " # " + c.s2.getPort() + " disconnected. EOFException 2");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}




















