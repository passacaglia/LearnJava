package org.snowtown;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.*;

public class Blood {
	
	private static int x = 600, y = 300;
	
	private static final int BLOOD_WIDTH = 20, BLOOD_HEIGHT = 20;
	
	Random r = new Random();
	private int[][] pos = {
	    {x + r.nextInt(10), y + r.nextInt(10)},
	    {x + r.nextInt(10), y + r.nextInt(10)},
	    {x + r.nextInt(10), y + r.nextInt(10)},
	    {x + r.nextInt(10), y + r.nextInt(10)},
	    {x + r.nextInt(10), y + r.nextInt(10)},
	    {x + r.nextInt(10), y + r.nextInt(10)},
	    {x + r.nextInt(10), y + r.nextInt(10)},
	    {x + r.nextInt(10), y + r.nextInt(10)},
	    {x + r.nextInt(10), y + r.nextInt(10)},
	    {x + r.nextInt(10), y + r.nextInt(10)}
	};
	private int step = 0;
	
	TankClient tc;
	
	private boolean live = true;
	
	public Blood(TankClient tc) {
		this.tc = tc;
	}

	public void draw(Graphics g) {
		if (!live) {
			return;
		}
		Color c = g.getColor();
		g.setColor(Color.MAGENTA);
		
		step ++;
		if (step == pos.length) {
			step = 0;
		}
		int posX = pos[step][0];
		int posY = pos[step][1];
		g.fill3DRect(posX, posY, BLOOD_WIDTH, BLOOD_HEIGHT, true);
		
		
		g.setColor(c);
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}

	public Rectangle getRect() {
		return new Rectangle(pos[step][0], pos[step][1], BLOOD_WIDTH, BLOOD_HEIGHT);
	}

	
}






















