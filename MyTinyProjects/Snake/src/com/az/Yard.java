package com.az;
import java.awt.*;
import java.awt.event.*;


public class Yard extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int ROWS = 30;
	public static final int COLS = 50;
	public static final int CELL_SIZE = 15;
	
	private Snake s = new Snake(this);
	private Egg e = new Egg();
	
	PaintThread paintThread = new PaintThread();
	Image offScreenImage = null;

	private boolean gameOver = false;
	public static int score = 0;
	
	public static void main(String[] args) {
		Yard y = new Yard();
		y.launch();
	}


	private void launch() {
		this.setBounds(300, 50, COLS*CELL_SIZE, ROWS*CELL_SIZE);
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		this.setVisible(true);
		
		//thread
		this.addKeyListener(new KeyMonitor());
		new Thread(paintThread).start();
		
	}


	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.BLACK);
		
		//横线
		for (int i=0; i<ROWS; i++) {
			g.drawLine(0, CELL_SIZE*i, COLS*CELL_SIZE, CELL_SIZE*i);
		}
		//竖线
		for (int i=0; i<COLS; i++) {
			g.drawLine(CELL_SIZE*i, 0, CELL_SIZE*i, ROWS*CELL_SIZE);
		}
		
		//score
		g.setColor(Color.RED);
		this.setTitle("Egg: " + e.getRect().x/CELL_SIZE + ", " + e.getRect().y/CELL_SIZE + " " +
				       "      Snake: " + s.getRect().x/CELL_SIZE + ", " + s.getRect().y/CELL_SIZE);
		g.drawString("Score :   " + score, 30, 43);
		
		
		
		
		
		//snake  & egg
		s.eat(e);
		
		s.draw(g);
		e.draw(g);
		
		
		if (gameOver) {
			paintThread.pause();
			Yard.score = 0;
			g.drawString("GameOver", 30, 60);
			g.drawString("Press F2 to restart", 30, 75);
		}
		
		g.setColor(c);
	}
	
	
	@Override
	public void update(Graphics g) {
		if (null == offScreenImage) {
			offScreenImage = this.createImage(COLS*CELL_SIZE, ROWS*CELL_SIZE);
		}
		Graphics gOff = offScreenImage.getGraphics();
		gOff.clearRect(0, 0, COLS*CELL_SIZE, ROWS*CELL_SIZE);
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}


	private class PaintThread implements Runnable {

		private boolean pause = false;
		
		@Override
		public void run() {
			/**
			 * 如果用while(!pause) {}，pause()之后，没法再restart。
			 * 
			 */
			while(true) {
				if (pause) {
					continue;
				} else {
					repaint();
				}
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		public void pause() {
			this.pause  = true;
		}
		

		public void restart() {
			this.pause = false;
			s = new Snake(Yard.this);
			gameOver = false;
		}
	
	}


	private class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_F2) {
				paintThread.restart();
			}
			s.keyPressed(e);
		}
		
	}


	public void stop() {
		gameOver = true;
	}
	
	
	public int getScore() {
		return Yard.score;
	}
	public void setScore(int s) {
		Yard.score = s;
	}

}












