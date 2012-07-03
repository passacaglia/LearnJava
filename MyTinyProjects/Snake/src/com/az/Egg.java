package com.az;

import java.awt.*;
import java.util.Random;

public class Egg {
	private static Point p = new Point();
	private static int w = Yard.CELL_SIZE;
	private static int h = w;
	private static Random r = new Random();
	
	Egg(Point p) {
		this.p = p;
		System.out.println(p);
	}
	
	Egg() {
		this(nextPos());
	}
	
	
	static int x, y;
	private static Point nextPos() {
		x = r.nextInt(Yard.COLS);
		y = r.nextInt(Yard.ROWS);
		while(30 > x*Yard.CELL_SIZE) {
			x = r.nextInt(Yard.COLS); 
		}
		
		return new Point(x, y);
	}

	
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(Yard.CELL_SIZE*p.x, Yard.CELL_SIZE*p.y, w, h);
		g.setColor(c);
	}
}

























