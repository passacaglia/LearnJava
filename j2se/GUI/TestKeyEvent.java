//

import java.awt.*;
import java.awt.event.*;

public class TestKeyEvent extends KeyAdapter{
	Frame f;
	public static void main(String[] args) {
		new TestKeyEvent();
	}
	
	TestKeyEvent() {
		f = new Frame("Key Event test");
		f.addKeyListener(this);
		f.setBounds(100, 100, 400, 300);
		f.setVisible(true);
	}
	
	public void keyPressed(KeyEvent e) {
		String str;
		
		System.out.println("Some key pressed...");
		System.out.println("The KeyCode is " + e.getKeyCode());
		
		str = KeyEvent.getKeyModifiersText(e.getModifiers());
		System.out.println("Modifier text : " + str);
	}
	
	public void keyTyped(KeyEvent e) {
		System.out.println("Some key typed... typed");
		System.out.println("The KeyChar is " + e.getKeyChar());
		System.out.println();
	}
}