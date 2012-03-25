package org.snowtown;

import java.awt.*;

public class Wall {
	private int x, y, w, h;
	TankClient tc;
	
	public Wall(int x, int y, int w, int h, TankClient tc) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.tc = tc;
	}
	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.DARK_GRAY);
		g.fill3DRect(x, y, w, h, true);
		g.setColor(c);
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, w, h);
	}
}
