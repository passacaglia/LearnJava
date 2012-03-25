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

public class TestRepaintInnerAnonymous {
	public static void main(String[] args) {
		FramePaint fp = new FramePaint("Repaint . Inner . Anonymous . test");
	}
}


class FramePaint extends Frame {
	
	ArrayList<Point> arrayPoint = new ArrayList<Point>();;
	 
	FramePaint(String s) {
		super(s);
		setBounds(100, 80, 400, 300);
		addMouseListener(new FramePaintMonitor());//��������ˡ�
		setVisible(true);
		
		//Anonymous Inner Class
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(-1);
			}
		});//����ط�
	}
	
	public void paint(Graphics g) {
		Iterator i = arrayPoint.iterator();
		int j = 0;
		while(i.hasNext()) {
			j ++;
			Point p = (Point)i.next();
			g.setColor(Color.BLUE);
			g.fillOval(p.x, p.y, 10, 10);//ֱ�ӵ���Point������ֵ��
		}
		System.out.println(j);
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