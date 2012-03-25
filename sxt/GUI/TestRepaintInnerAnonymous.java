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
		addMouseListener(new FramePaintMonitor());//这个别忘了。
		setVisible(true);
		
		//Anonymous Inner Class
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(-1);
			}
		});//这个地方
	}
	
	public void paint(Graphics g) {
		Iterator i = arrayPoint.iterator();
		int j = 0;
		while(i.hasNext()) {
			j ++;
			Point p = (Point)i.next();
			g.setColor(Color.BLUE);
			g.fillOval(p.x, p.y, 10, 10);//直接调用Point的属性值。
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