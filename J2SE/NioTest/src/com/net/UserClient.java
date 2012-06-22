package com.net;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserClient implements ActionListener {
	JFrame jf;
	JPanel jp;
	JLabel label_name;
	JLabel label_pswd;
	JTextField userName;
	JButton jb;
	JPasswordField paswrd;
	JLabel hintStr;

	public UserClient() {
		jf = new JFrame("XXX ��½ϵͳ");
		jp = new JPanel();
		jf.setContentPane(jp);
		jf.setPreferredSize(new Dimension(350, 220));
		jp.setPreferredSize(new Dimension(350, 220));
		jp.setBackground(Color.gray);
		label_name = new JLabel();
		label_name.setPreferredSize(new Dimension(150, 30));
		label_name.setText("�������ʻ�(���ֻ�Ӣ��):");
		userName = new JTextField();
		userName.setPreferredSize(new Dimension(150, 30));
		jp.add(label_name);
		jp.add(userName);
		label_pswd = new JLabel();
		label_pswd.setPreferredSize(new Dimension(150, 30));
		label_pswd.setText("����������:");
		jp.add(label_pswd);
		paswrd = new JPasswordField();
		paswrd.setPreferredSize(new Dimension(150, 30));
		jp.add(paswrd);
		jb = new JButton("OK");
		jb.setPreferredSize(new Dimension(150, 30));
		jb.setText("ȷ ��");
		jb.addActionListener(this);
		jp.add(jb);
		hintStr = new JLabel();
		hintStr.setPreferredSize(new Dimension(210, 40));
		hintStr.setText("");
		hintStr.setForeground(Color.RED);
		jp.add(hintStr);
		jf.pack();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private String name;
	private String pswd;

	public void actionPerformed(ActionEvent e) {
		name = userName.getText().trim();
		pswd = new String(paswrd.getPassword());
		if (pswd == null) {
			pswd = "";
		} else {
			pswd = pswd.trim();
		}
		if (name != null && name.length() > 0) {
			hintStr.setText("������֤�ͻ��ˣ����Ժ�...");
			start();
		}
	}

	OutputStream os;
	Socket s;
	InputStream is;

	public void start() {
		// ���������߳�
		new Thread(new Runnable() {
			public void run() {
				try {
					s = new Socket("127.0.0.1", 5555);
					// д
					os = s.getOutputStream();
					os.write(name.getBytes());
					os.write('|');// �û�����������"|"�ָ�
					os.write(pswd.getBytes());
					os.flush();
					// ������
					Thread.sleep(1000);
					is = s.getInputStream();
					int len = is.available();
					System.out.println("len:" + len);
					byte[] bytes = new byte[len];
					is.read(bytes);
					String resut = new String(bytes);
					System.out.println("resut:" + resut);
					// TODO ����ͨ�����ؽ������
					if (resut.equals("ACK")) {
						hintStr.setText("��֤�ɹ�����ӭ����!");
					} else {
						paswrd.setText(null);
						hintStr.setText("�û����������������������");
					}
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					// try {
					// os.close();
					// is.close();
					// s.close();
					// } catch (IOException e) {
					// e.printStackTrace();
					// }
				}
			}
		}).start();
	}

	public static void main(String[] args) {
		new UserClient();
	}

}