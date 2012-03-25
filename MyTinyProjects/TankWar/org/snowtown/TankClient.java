package org.snowtown;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TankClient extends Frame {

	//TankClient & Screen size
	public static final int TANK_CLIENT_WIDTH = 800, TANK_CLIENT_HEIGHT = 600;
	public static final int SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
	public static final int SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
	
	private Color background = Color.DARK_GRAY;//new Color(199, 237, 204)
	
	//flag to control move thread | move thread
	private static boolean flag = true;
	private Thread t;
	private Image offScreenImage;
	
	//Tank | Missile | enemy | explode | wall | Blood
	Tank myTank = new Tank(50, 500, this, true);
	ArrayList<Missile> missileList = new ArrayList<Missile>();
	ArrayList<Tank> enemyTanks = new ArrayList<Tank>();
	ArrayList<Explode> explodeList = new ArrayList<Explode>();
	Wall w = new Wall(400, 300, 30, 200, this);
	Blood b = new Blood(this);
	
	
	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.launchFrame();
	}

	public void launchFrame() {
		addEnemyTanks();
		
		int l = (SCREEN_WIDTH - TANK_CLIENT_WIDTH) / 2;
		int u = (SCREEN_HEIGHT - TANK_CLIENT_HEIGHT) / 2;
		setBounds(l, u, TANK_CLIENT_WIDTH, TANK_CLIENT_HEIGHT);
		
		setTitle("Tank War");
		setBackground(background);
		setResizable(false);
		
		addKeyListener(new KeyboardMonitor());
				
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				flag = false;
				
				try {
					t.join();
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
				
				System.exit(0);
			}
			
		});
		
		t = new Thread(new MoveThread());
		t.start();
		setVisible(true);
		
	}

	
	public void addEnemyTanks() {
		int posX = 70;
		int posY = 70;
		int enemyTankCount = Integer.parseInt(PropertyMgr.getProperty("enemyTankCount"));
		for (int i=0; i<enemyTankCount; i++) {
			Tank t = new Tank(posX + 40*(i+1), posY, this, false, Direction.D);
			enemyTanks.add(t);
		}
	}
	
	
	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.GRAY);
		g.drawString("Missile count : " + missileList.size(), 10, 50);
		g.drawString("Explode count : " + explodeList.size(), 10, 70);
		g.drawString("Enemy    Tank : " + enemyTanks.size(), 10, 90);
		g.drawString("myTank   life : " + myTank.getLife(), 10, 110);
		g.drawString("Blood is alive: " + b.isLive(), 10, 130);
		g.setColor(c);
		
		if (enemyTanks.size() == 0) {
			this.addEnemyTanks();
		}
		
		//wall | blood
		w.draw(g);
		b.draw(g);
		

		for (int i=0; i<missileList.size(); i++) {
			Missile m = (Missile)missileList.get(i);
			m.hitWall(w);
			m.hitTank(myTank);
			m.hitTanks(enemyTanks);
			m.draw(g);
		}
		
		
		
		myTank.draw(g);
		myTank.collidesWithWall(w);
		myTank.eatBlood(b);
		
		for (int i=0; i<enemyTanks.size(); i++) {
			Tank t = (Tank)enemyTanks.get(i);
			t.collidesWithWall(w);
			t.collidesWithTanks(enemyTanks);
			t.collidesWithTank(myTank);
			t.draw(g);
		}
		
		for (int i=0; i<explodeList.size(); i++) {
			Explode e = (Explode)explodeList.get(i);
			e.draw(g);
		}
		
	}

	
	//double buffer
	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(TANK_CLIENT_WIDTH, TANK_CLIENT_HEIGHT);
		}
		Graphics gOffScreenImage = offScreenImage.getGraphics();
		
		/*
		Color c = gOffScreenImage.getColor();
		gOffScreenImage.setColor(background);
		gOffScreenImage.fillRect(0, 0, TANK_CLIENT_WIDTH, TANK_CLIENT_HEIGHT);
		gOffScreenImage.setColor(c);
		*/
		gOffScreenImage.clearRect(0, 0, TANK_CLIENT_WIDTH, TANK_CLIENT_HEIGHT);
		
//System.out.println(x + " " + y);

		paint(gOffScreenImage);
		
		g.drawImage(offScreenImage, 0, 0, null);
		
	}
	

	private class KeyboardMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			myTank.keyRealeased(e);
		}
		
		
		
		
	}


	/**
	 * Inner Class for Move Thread
	 * 
	 * @author zxc
	 *
	 */
	private class MoveThread implements Runnable {

		@Override
		public void run() {
			try {
				while(flag) {
					Thread.sleep(30);
					repaint();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}





















