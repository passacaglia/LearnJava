/**
*Usage: java MyNotepad yourFileName.txt
*must be *.txt
**/

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyNotepad extends WindowAdapter implements ActionListener {
	Frame f;
	Button btn;
	TextArea ta;
	String fileName;
	public static void main(String[] args) {
		new MyNotepad (args[0]);
	}
		
	public MyNotepad(String fileName) {
		this.fileName = fileName;
		f = new Frame(fileName);
		f.addWindowListener(this);
		
		btn = new Button("Save File");
		btn.addActionListener(this);
		
		ta = new TextArea(10, 40);
		
		f.add(ta, BorderLayout.CENTER);
		f.add(btn, BorderLayout.SOUTH);
		
		f.pack();
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			FileOutputStream fout = new FileOutputStream(fileName);
			byte buf[] = ta.getText().getBytes();
			fout.write(buf);
			fout.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
}