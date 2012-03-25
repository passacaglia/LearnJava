//在窗口中单击 或 同时按下ALT SHIFT CTRL单击。查看Frame 的Title。
//e.getModifiers()取得掩码值
//InputEvent提供各种掩码（int型的值）

import java.awt.*;
import java.awt.event.*;

public class TestMouseEventMask extends MouseAdapter implements MouseMotionListener{
	Frame f;
	
	public static void main(String[] args) {
		new TestMouseEventMask();
	}
	
	TestMouseEventMask() {
		f = new Frame("Mouse Event Mask test");
		f.setBounds(100, 100, 500, 400);
		f.addMouseListener(this);
		f.addMouseMotionListener(this);
		f.setVisible(true);
	}
	
	public void mouseClicked(MouseEvent e) {
		String str = null;
		switch(e.getModifiers()) {
			case InputEvent.BUTTON1_MASK:
					str = "BUTTON1"; 
					break;
					
			case InputEvent.BUTTON3_MASK:
					str = "BUTTON3"; 
					break;		
			
			case InputEvent.BUTTON1_MASK + InputEvent.CTRL_MASK:
					str = "BUTTON3 + CTRL"; 
					break;
					
			case InputEvent.BUTTON1_MASK + InputEvent.ALT_MASK:
					str = "BUTTON3 + ALT"; 
					break;
			
			case InputEvent.BUTTON1_MASK + InputEvent.SHIFT_MASK:
					str = "BUTTON3 + SHIFT"; 
					break;	
		}
		
		f.setTitle(str);
	}
	
	public void mouseDragged(MouseEvent e) {
	}
	
	public void mouseMoved(MouseEvent e) {
	}
}