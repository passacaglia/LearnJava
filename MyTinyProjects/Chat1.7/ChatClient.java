/*
 * v1.7
 * 窗口中聊天内容前面加上名字。
 * 试图让TextArea滚动条随着文本输入滚动显示。
 * 
 * 
 * v1.6
 * 解决Client先于Server启动时报错，并且关不掉窗口。
 * 
 * 
 * v1.5
 * 继续：
 * 	Client监视线程隔一段时间给Server发消息，确定连接还活。
 * 	Server监视线程隔一段时间给Client发消息，确定Client还在连接着。【这个貌似比较麻烦，暂不实现】
 * 
 * 
 * v1.4
 * 优化Server:  从clientList里去除退掉的客户端：
 *	    1.监视线程使用另外的端口B。
 *      2.在监视线程里面实现remove。
 *           客户端退出时，给服务器端发送个信息到端口B。
 *           服务器端 就受到做出响应。
 * 
 * 
 * v1.3
 * 继续bug fix：
 * （多个客户端打开，其中某个先关闭了，应该把这个先关闭的从clientList中移除。） 
 * 
 * 
 * v1.2
 * 服务器端发送（sendToClient）；
 * 在客户端接收Server端   转发过来的数据：
 * (用新的  线程  不断接受信息。)；
 * bug fix(SocketException 鉴于水平，只能在Exception里面处理);
 * 
 * 
 * v1.1
 * 给server端添加  初步的转发功能
 * 
 * 
 * v1.0
 * 实现多个客户端连接：
 * Server端   accept之后，交给单独的线程来处理C/S之间的通信。
 * 
 * 
 * v0.9
 * 修正：关闭客户端导致的Sever端   Exception  引起Server停止运行的问题；
 * 
 * 
 * v0.8
 * Client disconnect
 * 
 * 
 * v0.7
 * 客户端输入一句话（after enter），Server端能收到并打印出来；
 * 
 * 
 * v0.6
 * 让客户端连接服务器端；
 * 为了简单起见，客户端一打开就自动连接服务器；
 * 很好的连接方式：给这个类建立一个方法，用来连接服务器。
 * 
 * 
 * v0.5
 * 建立服务器端并运行之;
 * 
 * 
 * v0.4
 * 响应TextField之ActionEvent事件。(还没有发送给服务器:D,别急)
 * 即：让 输入在TextField内部的文字   显示在  TextArea 中。
 * 
 * 
 * v0.3
 * 加入关闭窗口的功能；
 * 引入java.awt.event.*;
 * 
 * 
 * v0.2
 * 加入TextArea 和 TextField；
 * 
 * 
 * v0.1
 * 建立主窗口。
 */

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class ChatClient extends Frame {

	// 定义成类成员变量。
	//常用。
	// 将来要响应事件，响应事件的时候要访问  这两个变量。
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

		add(tfInput, BorderLayout.SOUTH);//先添加的会获得 输入光标的focus
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
		
		//给TextField tfInput添加的，不是给Frame.
		//这时用匿名类不合适了，因为将来会写很多代码在监听器里。
		//所以  内部了最合适。
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
			
			//在这里给dos做初始化最好.
			dos = new DataOutputStream(s.getOutputStream());
			dis = new DataInputStream(s.getInputStream());
			
			dos2 = new DataOutputStream(s2.getOutputStream());
			dis2 = new DataInputStream(s2.getInputStream());
			System.out.println("Server " + s.getInetAddress() + " # " + s.getPort() + " connected.");
			

//隔一段时间给服务器发条消息，确定连接还存在。
			new Thread(new ConnectionMonitorSend()).start();
//接收Server的反馈。
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
			String str = tfInput.getText().trim();//String's method "trim()"。去掉两边的字符串。
			//taContent.setText(taContent.getText() + "\n" + str);//Sever端 会发送回来
			tfInput.setText(null);
			
			//Send
			try {
				//发送  最好也是写到一个方法里。
				//但现在的水平，这样写很直观。 
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
			} catch (SocketException e) {//鉴于目前水平，采用这种方法。
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



















