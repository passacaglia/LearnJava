package com.az;
import java.awt.*;
import java.awt.event.*;


public class Yard extends Frame {

	public static final int ROWS = 30;
	public static final int COLS = 50;
	public static final int CELL_SIZE = 15;
	
	private Snake s = new Snake(this);

	public static void main(String[] args) {
		Yard y = new Yard();
		y.launch();
	}


	private void launch() {
		MyCanvas c = new MyCanvas();
		this.add(c);
		this.setBounds(300, 50, COLS*CELL_SIZE, ROWS*CELL_SIZE);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		this.setVisible(true);
	}


	
	private class MyCanvas extends Canvas {
		@Override
		public void paint(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.BLACK);
			
			//∫·œﬂ
			for (int i=0; i<ROWS; i++) {
				g.drawLine(0, CELL_SIZE*i, COLS*CELL_SIZE, CELL_SIZE*i);
			}
			// ˙œﬂ
			for (int i=0; i<COLS; i++) {
				g.drawLine(CELL_SIZE*i, 0, CELL_SIZE*i, ROWS*CELL_SIZE);
			}
			
			g.setColor(c);
			
			//snake 
			s.draw(g);
		}
	}
	

}












