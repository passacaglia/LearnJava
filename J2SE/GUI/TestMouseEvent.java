//�������������ʵ���� Mouse�ĸ���Listener,ֱ�ӵ��ü��ɡ�

import java.awt.*;
import java.awt.event.*;

public class TestMouseEvent extends MouseAdapter implements MouseMotionListener {												
	Frame f;
	
	public static void main(String[] args) {
		new TestMouseEvent();
	}
	
	TestMouseEvent() {
		f = new Frame("Mouse Event test");
		f.addMouseListener(this);//static�������ܵ���this�����ڴ˹��췽���е��ã���ʼ����
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