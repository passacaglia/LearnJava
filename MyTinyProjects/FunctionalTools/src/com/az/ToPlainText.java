package com.az;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;

public class ToPlainText {

	private JFrame frame;

	TextArea textArea = null;
	ActionMonitor am = new ActionMonitor();
	MouseMonitor mm = new MouseMonitor();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ToPlainText window = new ToPlainText();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ToPlainText() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(5, 5, 0, 0));
		panel.addMouseListener(mm);
		
		JButton btnTransfer = new JButton("ToPlainText");
		btnTransfer.setToolTipText("干掉  剪切板  中的  'whitespace character'");
		btnTransfer.setActionCommand("btnTransfer");
		btnTransfer.addActionListener(am);
		
		JLabel label_4 = new JLabel("*********");
		panel.add(label_4);
		panel.add(btnTransfer);
		
		JLabel label_1 = new JLabel("左键：干掉  剪切板  中的  'whitespace character'");
		panel.add(label_1);
		
		JButton btnTptExceptn = new JButton("TPT except \"\\n\"");
		btnTptExceptn.setActionCommand("btnTptExceptn");
		btnTptExceptn.setToolTipText("干掉  剪切板  中的  'whitespace character'，除了换行符。");
		btnTptExceptn.addActionListener(am);
		panel.add(btnTptExceptn);
		
		JLabel label_2 = new JLabel("右键：干掉  剪切板  中的  'whitespace character'，除了换行符。");
		panel.add(label_2);
		
		String s = "";
		textArea = new TextArea(s, 80, 180, TextArea.SCROLLBARS_VERTICAL_ONLY);
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
	}
	
	private class ActionMonitor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			/*String s = textArea.getText();
			s = s.replaceAll("\\s", "");
			textArea.setText(s);*/
			String str = e.getActionCommand();
			
			Clipboard sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
			String s = getClipboardText(sysc);
			String s2 = null;
			if (str.equals("btnTransfer")) {
				s2 = s.replaceAll("\\s", "");
			} else if (str.equals("btnTptExceptn")) {
				s2 = s.replaceAll("[\\s&&[^\\n]]", "");
			}
			textArea.setText(s2);
			setClipboardText(sysc, s2);
			s2 = null;
		}

	}

	
	private class MouseMonitor extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			int i = e.getButton();
			
			Clipboard sysc = Toolkit.getDefaultToolkit().getSystemClipboard();
			String s = getClipboardText(sysc);
			String s2 = null;
			if (1 == i) {
				s2 = s.replaceAll("\\s", "");
			} else if (3 == i) {
				s2 = s.replaceAll("[\\s&&[^\\n]]", "");
			}
			textArea.setText(s2);
			setClipboardText(sysc, s2);
			s2 = null;
		}
	}
	
	
	private String getClipboardText(Clipboard clip){
		try {
			
			// 获取剪切板中的内容
			Transferable clipT = clip.getContents(null);
			if (clipT != null) {
				
			    // 检查内容是否是文本类型
				if (clipT.isDataFlavorSupported(DataFlavor.stringFlavor)) {
					return (String)clipT.getTransferData(DataFlavor.stringFlavor);
				}
			 }
			  
		} catch (UnsupportedFlavorException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;  
	}
	
	private void setClipboardText(Clipboard clip, String writeMe) {
		Transferable tText = new StringSelection(writeMe);
		clip.setContents(tText, null);
	}
}




















