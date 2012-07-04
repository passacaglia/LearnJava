/**
 * F2 to pause;
 * F3 to go on;
 */


package com.az;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Circles extends JFrame {
	private static final int X = 400;
	private static final int Y = 100;
	private static final int WW = 300;//window width
	private static final int WH = 300;//window height
	
	
	MyCanvas canvas = null;
	private static int startsD = 0;
	private static int d = startsD-1;
	
	
	//paint thread
	PaintThread paintThread = new PaintThread();
	
	
	
	//
	private static final int arcAngle = 3;//degree
	private int arc = -1;//控制，画下一个圆。
	private static double alphaStarts = (Math.PI/180)*15;//PI
	private static double alpha = alphaStarts;//画下一个圆的时候，偏转的角度
	
	
	//coordinate
	private int baseLen = WW - 50;
	private Point base = new Point(0, 0);
	private int mLen = baseLen / 3;
	private Point mp = null;// movable point
		
	
	
	// buffer : do not clear the canvas.
	private Image offScreenImage = null;
	
	
	public static void main(String[] args) {
		Circles cir = new Circles();
		cir.launch();
	}
	
	
	void launch() {
		Container c = this.getContentPane();
		
		canvas = new MyCanvas();
		c.add(canvas, BorderLayout.CENTER);
		
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(X, Y, WW, WH);
		this.setVisible(true);
		
		
		this.addKeyListener(new KeyMonitor());
		new Thread(paintThread).start();
	}
	
	
	private class MyCanvas extends Canvas {
		
		@Override
		public void paint(Graphics g) {
			Color c = g.getColor();
			
			g.setColor(Color.BLACK);
			g.drawOval(base.x, base.y, baseLen, baseLen);
			
			g.setColor(Color.RED);
//System.out.println(mp + " " + movLen);
			d = d - arcAngle;
			if (null == mp) {
				nextCircle();
			}
			g.drawArc(mp.x, mp.y, mLen, mLen, d, arcAngle);
			arc ++;
			
			
			
			g.setColor(c);
		}

		
		
		@Override
		public void update(Graphics g) {
			if (null == offScreenImage) {
				offScreenImage = createImage(getWidth(), getHeight());
			}
			Graphics gOff = offScreenImage.getGraphics();
			paint(gOff);
			
			g.drawImage(offScreenImage, 0, 0, null);
			
		}
			
	}
	
	
	private void nextCircle() {
		double x = ( baseLen/2 - (baseLen/2 - mLen/2)*Math.cos(alpha) ) - mLen/2;
		double y = ( baseLen/2 - (baseLen/2 - mLen/2)*Math.sin(alpha) ) - mLen/2;
		mp = new Point((int)x, (int)y);
	}


	
	
	private class PaintThread implements Runnable {

		private boolean flag = true;
		@Override
		public void run() {
			while(true) { 
				if (!flag) {
					continue;//如果不用continue这种方式，那么while循环就会结束。
				}
				
				if (360/arcAngle < arc) {
					/**
					 * next circle
					 * 1.reset arc
					 * 2.bigger angle
					 */
					
					
					arc = 0;
					alpha += alphaStarts;//not an integer
					
					nextCircle();
				}
				
				canvas.repaint();
								
				try {
					Thread.sleep(10);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				
				
			}
		}
		
		public void pause() {
			flag = false;
		}
		
		public void goOn() {
			flag = true;
		}
	}
	
	
	private class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			
			if (KeyEvent.VK_F2 == key) {
				paintThread.pause();
			}
			if (KeyEvent.VK_F3 == key) {
				paintThread.goOn();
			}
		}
		
	}
	
}












