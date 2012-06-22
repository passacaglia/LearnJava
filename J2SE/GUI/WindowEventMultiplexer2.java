/*多个对象同用一个事件处理类的范例。
 *貌似点击 关闭按钮的时候，两个窗口都被关闭了。
 *不论WindowEventHandlerM2对象重名与否。
 *原因很简单：关闭的时候 调用的是System.exit(0);
 */

import java.awt.*;
import java.awt.event.*;

public class WindowEventMultiplexer2 {
	public static void main(String[] args) {
		Frame f1 = new Frame("Main");
		//WindowEventHandlerM2 wehm = new WindowEventHandlerM2();
		f1.addWindowListener(new WindowEventHandlerM2());
		f1.setBounds(100, 100, 200, 200);
		
		Frame f2 = new Frame("Another");
		//WindowEventHandlerM2 wehm2 = new WindowEventHandlerM2();
		f2.addWindowListener(new WindowEventHandlerM2());
		f2.setBounds(300, 300, 200, 200);
		
		f1.setVisible(true);
		f2.setVisible(true);
	}
}


class WindowEventHandlerM2 extends WindowAdapter{
	public void windowActivated(WindowEvent e) {
		Frame f = (Frame)e.getSource();
		System.out.println(f.getTitle() + " activated.");
	}
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}