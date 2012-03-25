package org.snowtown;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Tank {
	
	public static final int TANK_WIDTH = 30, TANK_HEIGHT = 30;
	//Tank Position
	int x = 50, y = 50;
	//observer
	TankClient tc;
	
	//key --> dir --> move
	private static boolean L = false, U = false, R = false, D = false;
	Direction dir = Direction.STOP;
	private static final int XSPEED = 5, YSPEED = 5;
	Direction barrelDir = Direction.D;
		
	//ally | enemy tank
	private boolean good;
	
	//live
	private boolean live = true;
	
	//random dir
	private static Random r = new Random();
	Direction[] dirs = Direction.values();
	private int step = r.nextInt(12) + 3;
	
	//stay
	private int oldX, oldY;
	
	//life
	public static final int LIFE_MAX = 100;
	private int life = LIFE_MAX;
	TankBlood tb = new TankBlood();
	
	//load picture
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static Image[] tankImg;
	static Map<Direction, Image> imgs = new HashMap<Direction, Image>();
	static {
		tankImg = new Image[] {
				tk.getImage(Tank.class.getClassLoader().getResource("myImages/tankL.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("myImages/tankLU.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("myImages/tankU.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("myImages/tankRU.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("myImages/tankR.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("myImages/tankRD.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("myImages/tankD.gif")),
				tk.getImage(Tank.class.getClassLoader().getResource("myImages/tankLD.gif")),
		};
		
		imgs.put(Direction.L, tankImg[0]);
		imgs.put(Direction.LU, tankImg[1]);
		imgs.put(Direction.U, tankImg[2]);
		imgs.put(Direction.RU, tankImg[3]);
		imgs.put(Direction.R, tankImg[4]);
		imgs.put(Direction.RD, tankImg[5]);
		imgs.put(Direction.D, tankImg[6]);
		imgs.put(Direction.LD, tankImg[7]);
		
	}
	
	
	
	public Tank(int x, int y, TankClient tc) {
		this.x = x;
		this.y = y;
		this.tc = tc;
		
		oldX = x;
		oldY = y;
	}
	
	public Tank(int x, int y, TankClient tc, boolean good) {
		this(x, y, tc);
		this.good = good;
	}
	
	public Tank(int x, int y, TankClient tc, boolean good, Direction dir) {
		this(x, y, tc);
		this.good = good;
		this.dir = dir;
	}
	
	public void draw(Graphics g) {
		if (!live) {
			if (!good) {
				tc.enemyTanks.remove(this);
			}
			return;
		}
		
		if (good) {tb.draw(g);}
		drawTank(g);
				
		move();
					
	}
	
	private void drawTank(Graphics g) {
		//draw tank 根据炮筒方向

		switch (barrelDir) {
		case L:
			g.drawImage(tankImg[0], x, y, null);
			break;
		case LU:
			g.drawImage(tankImg[1], x, y, null);
			break;
		case U:
			g.drawImage(tankImg[2], x, y, null);
			break;
		case RU:
			g.drawImage(tankImg[3], x, y, null);
			break;
		case R:
			g.drawImage(tankImg[4], x, y, null);
			break;
		case RD:
			g.drawImage(tankImg[5], x, y, null);
			break;
		case D:
			g.drawImage(tankImg[6], x, y, null);
			break;
		case LD:
			g.drawImage(tankImg[7], x, y, null);
			break;
		}
		
	}

	private void move() {
		oldX = x;
		oldY = y;
		
		switch (dir) {
		case L:
			x -= XSPEED;
			break;
		case LU:
			x -= XSPEED;
			y -= YSPEED;
			break;
		case U:
			y -= YSPEED;
			break;
		case RU:
			x += XSPEED;
			y -= YSPEED;
			break;
		case R:
			x += XSPEED;
			break;
		case RD:
			x += XSPEED;
			y += YSPEED;
			break;
		case D:
			y += YSPEED;
			break;
		case LD:
			x -= XSPEED;
			y += YSPEED;
			break;
		case STOP:
			break;
		}
		
		if (dir != Direction.STOP) {
			barrelDir = dir;
		}
		
		if (x < 0) { x = 0; }
		if (y < 30) { y = 30; }
		if (x > TankClient.TANK_CLIENT_WIDTH - TANK_WIDTH) { x = TankClient.TANK_CLIENT_WIDTH - TANK_WIDTH; }
		if (y > TankClient.TANK_CLIENT_HEIGHT - TANK_HEIGHT) { y = TankClient.TANK_CLIENT_HEIGHT - TANK_HEIGHT; }
		
		
		//enemy | random
		if (!good) {
			if (step == 0) {
				step = r.nextInt(12) + 2;
				int randomNum = r.nextInt(dirs.length);
				dir = dirs[randomNum];
			}
			step --;
			
			//fire
			if (r.nextInt(40) > 38) {
				this.fire();
			}
		}
		
		
	}

	private void stay() {
		x = oldX;
		y = oldY;
	}

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			L = true;			
			break;
		case KeyEvent.VK_UP:
			U = true;
			break;
		case KeyEvent.VK_RIGHT:
			R = true;
			break;
		case KeyEvent.VK_DOWN:
			D = true;
			break;
		}
		
		detectDir();
	}
	
	public void keyRealeased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			L = false;
			break;
		case KeyEvent.VK_UP:
			U = false;
			break;
		case KeyEvent.VK_RIGHT:
			R = false;
			break;
		case KeyEvent.VK_DOWN:
			D = false;
			break;
		case KeyEvent.VK_CONTROL:
			fire();
			break;
		case KeyEvent.VK_F2:
			this.setLife(LIFE_MAX);
			this.setLive(true);
			break;
		case KeyEvent.VK_B:
			super_fire();
			break;
		}
		
		detectDir();
	}
	
	private void detectDir() {
		if (!L && !U && !R && !D) { dir = Direction.STOP; }
		else if (L && !U && !R && !D) { dir = Direction.L; }
		else if (L && U && !R && !D) { dir = Direction.LU; }
		else if (!L && U && !R && !D) { dir = Direction.U; }
		else if (!L && U && R && !D) { dir = Direction.RU; }
		else if (!L && !U && R && !D) { dir = Direction.R; }
		else if (!L && !U && R && D) { dir = Direction.RD; }
		else if (!L && !U && !R && D) { dir = Direction.D; }
		else if (L && !U && !R && D) { dir = Direction.LD; }
	}
	
	private Missile fire() {
		if (!live) { return null; }
		Missile m = new Missile(this.x, this.y, this.tc,  barrelDir, this.good);
		tc.missileList.add(m);
		return m;
	}
	
	private Missile fire(Direction dir) {
		if (!live) {
			return null;
		}
		Missile m = new Missile(this.x, this.y, this.tc,  dir, this.good);
		tc.missileList.add(m);
		return m;
	}
	
	private void super_fire() {
		//dirs.length-1，是为了保证访问不到Direction.STOP.
		for (int i=0; i<dirs.length-1; i++) {
			fire(dirs[i]);
		}
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public boolean isGood() {
		return good;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public Rectangle getRect() {
		return new Rectangle(this.x, this.y, Tank.TANK_WIDTH, Tank.TANK_HEIGHT);
	}
	
	public boolean collidesWithWall(Wall w) {
		if (this.getRect().intersects(w.getRect())) {
			this.stay();
			
			return true;
		}
		
		return false;
	}
	
	public boolean collidesWithTank(Tank t) {
		if (this.isLive() && t.isLive() && this.getRect().intersects(t.getRect())) {
			this.stay();
			t.stay();
			return true;
		}
		return false;
	}
	
	
	public boolean collidesWithTanks(ArrayList<Tank> enemyTanks) {
		for (int i=0; i<enemyTanks.size(); i++) {
			Tank t = (Tank)enemyTanks.get(i);
			if (this != t && this.collidesWithTank(t)) {
				this.stay();
				t.stay();
				return true;
			}
			
		}
		return false;
	}
	
	public boolean eatBlood(Blood b) {
		if (this.isLive() && b.isLive() && this.getRect().intersects(b.getRect())) {
			this.setLife(LIFE_MAX);
			b.setLive(false);
			return false;
		}
		return false;
	}
	
	
	/**
	 * Tank Blood
	 */
	private class TankBlood {
		
		private static final int BLOOD_HEIGHT = 10;
		
		public void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.GRAY);
			g.drawRect(x, y - 12, TANK_WIDTH, BLOOD_HEIGHT);
			g.setColor(Color.RED);
			g.fillRect(x + 2, y - 10, (TANK_WIDTH - 3)*getLife()/LIFE_MAX , BLOOD_HEIGHT - 3);
			g.setColor(c);
		}
		
	}
	
	
	
	
}
























