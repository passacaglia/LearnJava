//

import java.awt.*;
import java.awt.event.*;

public class TestWindowEvent {
	public static void main(String[] args) {
		Frame f = new Frame("WindowEventTest");
		f.addWindowListener(new WindowEventHandler());
		f.setSize(200, 200);
		f.setVisible(true);
	}
}

class WindowEventHandler implements WindowListener {
	public void windowClosing(WindowEvent e) {
		System.out.println("Window Closing event");
		System.exit(0);
	}
	
	public void windowIconified(WindowEvent e) {
		System.out.println("Window Iconified event");
	}
	
	public void windowActivated(WindowEvent e) {
		System.out.println("Window Activated event");
	}
	
	public void windowOpened(WindowEvent e) {
	}
	public void windowDeiconified(WindowEvent e) {
	}
	public void windowClosed(WindowEvent e) {
	}
	public void windowDeactivated(WindowEvent e) {
	}
}

//¼Ì³ÐµÄÐ´·¨
/*
class WindowEventHandler extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
*/