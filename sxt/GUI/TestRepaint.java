/**
*
*
*
*
*
*
**/

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TestRepaint {
	public static void main(String[] args) {
		new FramePaint().launchFrame();
	}
}


class FramePaint extends Frame {
	
	ArrayList<Point> arrayPoint = new ArrayList<Point>();;
	 
	public void launchFrame() {
		setBounds(100, 80, 400, 300);
		addMouseListener(new FramePaintMonitor());//��������ˡ�
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		Iterator i = arrayPoint.iterator();
		while(i.hasNext()) {
			System.out.println("ok");
			Point p = (Point)i.next();
			g.setColor(Color.BLUE);
			g.fillOval(p.x, p.y, 10, 10);//ֱ�ӵ���Point������ֵ��
		}
	}
	
	public void addPoint(Point p) {
		arrayPoint.add(p);
	}
	
	//Inner class
	private class FramePaintMonitor extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			Point p = new Point(e.getX(), e.getY());
			addPoint(p);
			repaint();
		}
	}
}