//这个测试类自身实现了 Mouse的各种Listener,直接调用即可。

import java.awt.*;
import java.awt.event.*;

public class TestMouseEvent extends MouseAdapter implements MouseMotionListener {												
	Frame f;
	
	public static void main(String[] args) {
		new TestMouseEvent();
	}
	
	TestMouseEvent() {
		f = new Frame("Mouse Event test");
		f.addMouseListener(this);//static方法不能调用this。故在此构造方法中调用，初始化。
		f.addMouseMotionListener(this);
		f.setBounds(300, 200, 300, 200);
		f.setVisible(true);
	}
	
	public void mouseClicked(MouseEvent e) {
		f.setTitle("Mouse Clicked.");
	}
	
	public void mouseExited(MouseEvent e) {
		f.setTitle("Mouse Exited.");
	}
	
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		f.setTitle("Mouse at " + "(" + x + " , " + y + ")");
	}
}