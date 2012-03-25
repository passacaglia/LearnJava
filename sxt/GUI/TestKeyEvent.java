//按下键盘上某个键，Frame中有反应。

import java.awt.*;
import java.awt.event.*;

public class TestKeyEvent {
	public static void main(String[] args) {
		FrameKeyEvent fke = new FrameKeyEvent("Key Event test");
	}
}


class FrameKeyEvent extends Frame {
	
	int kt = 0;
	
	FrameKeyEvent(String s) {
		super(s);
		setLocation(100, 80);
		setSize(300, 200);
		setVisible(true);

		addKeyListener(new KeyMonitor());
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}
	
	public void paint(Graphics g) {
		if (kt != 0) {
			System.out.println("kt = " + kt);
			Color c = g.getColor();
			g.setColor(Color.BLUE);
			
			if (kt == KeyEvent.VK_Z) {
				g.drawLine(40, 40, 100, 40);
				g.drawLine(100, 40, 40, 100);
				g.drawLine(40, 100, 100, 100);
			}
			if (kt == KeyEvent.VK_L) {
				g.drawLine(40, 40, 40, 100);
				g.drawLine(40, 100, 80, 100);
			}
					
		} else {
			System.out.println("kt = 0");
		}
	}
	
	private class KeyMonitor extends KeyAdapter {
		//keyTyped不能画出东西，keyTyped返回的e.getKeyCode()都是0，为啥？
		//
		/*
		public void keyPressed(KeyEvent e) {
			System.out.println("Key Typed");
			System.out.println(e.getKeyCode() + "\n");
		  kt = e.getKeyCode();
		  repaint();
		}*/

	}
}