//

import java.awt.*;
import java.awt.event.*;

public class WindowEventMultiplexer {
	public static void main(String[] args) {
		Frame f = new Frame("Window Evetn Multiplexer");
		f.addWindowListener(new WindowEventHandlerMul1());
		f.addWindowListener(new WindowEventHandlerMul2());
		f.setSize(200, 200);
		f.setVisible(true);
	}
}


class WindowEventHandlerMul1 extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.out.println("Handler Mul 1");
	}
}


class WindowEventHandlerMul2 extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.out.println("Handler Mul 2");
		System.exit(0);
	}
}