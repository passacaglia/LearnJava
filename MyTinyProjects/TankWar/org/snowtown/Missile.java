package org.snowtown;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Missile {
	
	//Missile size
	public static final int MISSILE_WIDTH = 10, MISSILE_HEIGHT = 10;
	
	//Missile position
	int x, y;
	TankClient tc;
	
	//Missile move
	
	Direction missileDir;
	private static final int XSPEED = 10, YSPEED = 10;
	
	//live | good
	private boolean live = true;
	private boolean good;

	//img
	static Toolkit tk = Toolkit.getDefaultToolkit();
	static Image[] missileImg;
	static Map<Direction, Image> imgs = new HashMap<Direction, Image>();
	static {
		missileImg = new Image[] {
			tk.getImage(Missile.class.getClassLoader().getResource("images/missileL.gif")),
			tk.getImage(Missile.class.getClassLoader().getResource("images/missileLU.gif")),
			tk.getImage(Missile.class.getClassLoader().getResource("images/missileU.gif")),
			tk.getImage(Missile.class.getClassLoader().getResource("images/missileRU.gif")),
			tk.getImage(Missile.class.getClassLoader().getResource("images/missileR.gif")),
			tk.getImage(Missile.class.getClassLoader().getResource("images/missileRD.gif")),
			tk.getImage(Missile.class.getClassLoader().getResource("images/missileD.gif")),
			tk.getImage(Missile.class.getClassLoader().getResource("images/missileLD.gif")),
		};
		
		imgs.put(Direction.L, missileImg[0]);
		imgs.put(Direction.LU, missileImg[1]);
		imgs.put(Direction.U, missileImg[2]);
		imgs.put(Direction.RU, missileImg[3]);
		imgs.put(Direction.R, missileImg[4]);
		imgs.put(Direction.RD, missileImg[5]);
		imgs.put(Direction.D, missileImg[6]);
		imgs.put(Direction.LD, missileImg[7]);
	}
	
	
	
	public Missile(int x, int y, TankClient tc) {
		this.x = x + (Tank.TANK_WIDTH/2 - MISSILE_WIDTH/2);
		this.y = y + (Tank.TANK_WIDTH/2 - MISSILE_WIDTH/2);
		this.tc = tc;
	}
	
	public Missile(int x, int y, TankClient tc, Direction dir, boolean good) {
		this(x, y, tc);
		missileDir = dir;
		this.good = good;
	}
	
	public void draw(Graphics g) {
		if (!live) {
			tc.missileList.remove(this);
			return;
		}
		
		drawMissile(g);
		
		move();
		
	}

	private void drawMissile(Graphics g) {
		switch (missileDir) {
		case L:
			g.drawImage(missileImg[0], x, y, null);
			break;
		case LU:
			g.drawImage(missileImg[1], x, y, null);
			break;
		case U:
			g.drawImage(missileImg[2], x, y, null);
			break;
		case RU:
			g.drawImage(missileImg[3], x, y, null);
			break;
		case R:
			g.drawImage(missileImg[4], x, y, null);
			break;
		case RD:
			g.drawImage(missileImg[5], x, y, null);
			break;
		case D:
			g.drawImage(missileImg[6], x, y, null);
			break;
		case LD:
			g.drawImage(missileImg[7], x, y, null);
			break;
		}
	}

	private void move() {
		switch (missileDir) {
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
		}
		
		if (x < 0 || y < 0 || x >= TankClient.TANK_CLIENT_WIDTH || y >= TankClient.TANK_CLIENT_HEIGHT) {
			this.setLive(false);
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

	public Rectangle getRect() {
		return new Rectangle(this.x, this.y, MISSILE_WIDTH, MISSILE_HEIGHT);
	}
	
	public boolean hitTank(Tank t) {
		if (this.isLive() && t.isLive() && (this.isGood() != t.isGood()) && this.getRect().intersects(t.getRect())) {
			//Missile
			this.setLive(false);
			tc.missileList.remove(this);
			
			//Tank
			if (t.isGood()) {
				t.setLife(t.getLife() - Tank.LIFE_MAX/5);
				if (t.getLife() == 0) {
					t.setLive(false);
				}
			} else {
				t.setLive(false);
			}
			
			//Explode
			Explode e = new Explode(t.x, t.y, this.tc);
			tc.explodeList.add(e);
			
			return true;
		}
		
		return false;
	}

	public boolean hitTanks(ArrayList<Tank> enemyTanks) {
		for (int i=0; i<enemyTanks.size(); i++) {
			Tank t = (Tank)enemyTanks.get(i);
			if(this.hitTank(t)) {
				return true;
			}
		}
		return false;
	}

	public boolean hitWall(Wall w) {
		if (this.isLive() && this.getRect().intersects(w.getRect())) {
			this.setLive(false);
			
			return true;
		}
		
		return false;
	}
	
	
	
}






















