package com.az;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class EmailSpider_Swing {
	
	private static int posX = 400;
	private static int posY = 200;
	
	TextArea textArea  = null;
	

	public static void main(String[] args) {
		new EmailSpider_Swing().launch();
	}

	private void launch() {
		JFrame jf = new JFrame("Email Address Spider");
		
		textArea = new TextArea();
		jf.getContentPane().add(textArea, BorderLayout.CENTER);
		textArea.setText("Please paste the text here! \n " +
				         "Or you can load a text file that contains email address!");
		
		Panel panel = new Panel();
		jf.getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton open = new JButton("Open");
		open.setActionCommand("open");
		panel.add(open);
		open.addActionListener(new ActionMonitor());
		
		JButton button = new JButton("Find Email Address");
		button.setActionCommand("find");
		panel.add(button);
		button.addActionListener(new ActionMonitor());
		
		
		
				
		jf.pack();
		jf.setResizable(false);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setLocation(posX, posY);
		jf.setVisible(true);
		
	}

	private void parseFile() {
		JFileChooser jfc = new JFileChooser();
		jfc.setDialogType(JFileChooser.OPEN_DIALOG);
		jfc.setVisible(true);
		try {
			BufferedReader br = new BufferedReader(new FileReader("D:\\Temp\\douban.htm"));
			String line = "";
			while((line=br.readLine()) != null) {
				parse(line);
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private class ActionMonitor implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String source = e.getActionCommand();
			if ("open".equals(source)) {
				parseFile();
			} else if ("find".equals(source)) {
				String line = textArea.getText();
				String email = parse(line);
				textArea.setText(email);
			}
		}
		
	}

	
	private String parse(String line) {
		Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
		Matcher m = p.matcher(line);
		StringBuffer buf = new StringBuffer();
		String s = "";
		while(m.find()) {
			s = m.group();
			buf.append(s);
			buf.append("\n");
		}
		return buf.toString();
				
	}
}





















