/*
 * v1.7
 * ��������������ǰ��������֡�
 * ��ͼ��TextArea�����������ı����������ʾ��
 * 
 * 
 * v1.6
 * ���Client����Server����ʱ�������ҹز������ڡ�
 * 
 * 
 * v1.5
 * ������
 * 	Client�����̸߳�һ��ʱ���Server����Ϣ��ȷ�����ӻ��
 * 	Server�����̸߳�һ��ʱ���Client����Ϣ��ȷ��Client���������š������ò�ƱȽ��鷳���ݲ�ʵ�֡�
 * 
 * 
 * v1.4
 * �Ż�Server:  ��clientList��ȥ���˵��Ŀͻ��ˣ�
 *	    1.�����߳�ʹ������Ķ˿�B��
 *      2.�ڼ����߳�����ʵ��remove��
 *           �ͻ����˳�ʱ�����������˷��͸���Ϣ���˿�B��
 *           �������� ���ܵ�������Ӧ��
 * 
 * 
 * v1.3
 * ����bug fix��
 * ������ͻ��˴򿪣�����ĳ���ȹر��ˣ�Ӧ�ð�����ȹرյĴ�clientList���Ƴ����� 
 * 
 * 
 * v1.2
 * �������˷��ͣ�sendToClient����
 * �ڿͻ��˽���Server��   ת�����������ݣ�
 * (���µ�  �߳�  ���Ͻ�����Ϣ��)��
 * bug fix(SocketException ����ˮƽ��ֻ����Exception���洦��);
 * 
 * 
 * v1.1
 * ��server�����  ������ת������
 * 
 * 
 * v1.0
 * ʵ�ֶ���ͻ������ӣ�
 * Server��   accept֮�󣬽����������߳�������C/S֮���ͨ�š�
 * 
 * 
 * v0.9
 * �������رտͻ��˵��µ�Sever��   Exception  ����Serverֹͣ���е����⣻
 * 
 * 
 * v0.8
 * Client disconnect
 * 
 * 
 * v0.7
 * �ͻ�������һ�仰��after enter����Server�����յ�����ӡ������
 * 
 * 
 * v0.6
 * �ÿͻ������ӷ������ˣ�
 * Ϊ�˼�������ͻ���һ�򿪾��Զ����ӷ�������
 * �ܺõ����ӷ�ʽ��������ཨ��һ���������������ӷ�������
 * 
 * 
 * v0.5
 * �����������˲�����֮;
 * 
 * 
 * v0.4
 * ��ӦTextField֮ActionEvent�¼���(��û�з��͸�������:D,��)
 * ������ ������TextField�ڲ�������   ��ʾ��  TextArea �С�
 * 
 * 
 * v0.3
 * ����رմ��ڵĹ��ܣ�
 * ����java.awt.event.*;
 * 
 * 
 * v0.2
 * ����TextArea �� TextField��
 * 
 * 
 * v0.1
 * ���������ڡ�
 */

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class ChatClient extends Frame {

	// ��������Ա������
	//���á�
	// ����Ҫ��Ӧ�¼�����Ӧ�¼���ʱ��Ҫ����  ������������
	TextArea taContent = new TextArea();
	TextField tfInput = new TextField(1);
	Socket s;
	Socket s2;
	DataOutputStream dos = null;
	DataInputStream dis = null;
	Thread recTh = new Thread(new ReceiveThread());
	private boolean connectServer = false;
	DataOutputStream dos2 = null;
	DataInputStream dis2 = null;

	public static void main(String[] args) {
		new ChatClient().launchFrame();
	}

	public void launchFrame() {
		setLocation(300, 200);
		this.setSize(300, 200);

		add(tfInput, BorderLayout.SOUTH);//����ӵĻ��� �������focus
		add(taContent, BorderLayout.NORTH);
		taContent.setText("Please press ENTER to send text.");
		
		setVisible(true);
		pack();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (connectServer) disconnect();
				System.exit(0);
			}
		});
		
		//��TextField tfInput��ӵģ����Ǹ�Frame.
		//��ʱ�������಻�����ˣ���Ϊ������д�ܶ�����ڼ������
		//����  �ڲ�������ʡ�
		tfInput.addActionListener(new TFInputMonitor());
		
		connect();
		recTh.start();
		
	}

	public void connect() {
		
		try {
			s = new Socket("127.0.0.1", 3000);
			connectServer = true;
			
			//s2 Connection Monitor 
			s2 = new Socket("127.0.0.1", 3001);
			
			//�������dos����ʼ�����.
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			
			dos2 = new DataOutputStream(s2.getOutputStream());
			dis2 = new DataInputStream(s2.getInputStream());
			System.out.println("Server " + s.getInetAddress() + " # " + s.getPort() + " connected.");
			

//��һ��ʱ���������������Ϣ��ȷ�����ӻ����ڡ�
			new Thread(new ConnectionMonitorSend()).start();
//����Server�ķ�����
			new Thread(new ConnectionMonitorReceive()).start();
			
		} catch (ConnectException e) {
			System.out.println("Are you sure that the CHAT SERVER is started ?");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void disconnect() {
		
		try {
			
			dos2.writeUTF("exit");
			dos2.flush();
			dos2.close();
			
/*disconnect message	//exit 3.141592654
			String exit = "EXIT3.141592654";
			dos.writeUTF(exit);
			dos.flush();*/
			
			dis.close();
			dos.close();
			s.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*
		try {
			connectServer = false;
			
			recTh.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			try {
				dis.close();
				dos.close();
				s.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}*/
	}
	
	//Inner Class
	private class TFInputMonitor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Show
			String str = tfInput.getText().trim();//String's method "trim()"��ȥ�����ߵ��ַ�����
			//taContent.setText(taContent.getText() + "\n" + str);//Sever�� �ᷢ�ͻ���
			tfInput.setText(null);
			
			//Send
			try {
				//����  ���Ҳ��д��һ�������
				//�����ڵ�ˮƽ������д��ֱ�ۡ� 
				dos.writeUTF(str);
				dos.flush();
												
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

		}
		
	}

	//Thread for receive DATA
	private class ReceiveThread implements Runnable {

		public void run() {
			try {
				while(connectServer) {
					String str = dis.readUTF().trim();
					System.out.println(str);
					taContent.setText(taContent.getText() + "\n" + str);
				}
			} catch (SocketException e) {//����Ŀǰˮƽ���������ַ�����
				System.out.println("Client closed.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	private class ConnectionMonitorSend implements Runnable {
		public void run() {
			try {
				while(connectServer) {
					dos2.writeUTF("Are you there?");
					
					Thread.sleep(4000);
				}
			} catch (SocketException e) {
				System.out.println("Connection abort.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private class ConnectionMonitorReceive implements Runnable {
		public void run() {
			try {
				while(connectServer) {
					if (dis2.readUTF() != null) {
						System.out.println("Connection alive.");
					}
				}
			} catch (SocketException e) {
				System.out.println("Connection abort.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}



















