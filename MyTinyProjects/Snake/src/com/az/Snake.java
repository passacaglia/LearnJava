package com.az;

import java.awt.*;

public class Snake {
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	private Node n = new Node(20, 30, Dir.L);
	private Yard y;
	
	public Snake(Yard y) {
		head = n;
		tail = n;
		size = 1;
		this.y = y;
	}
	
	
	public void draw(Graphics g) {
		if (size <= 0) {
			return;
		}
		
		for (Node n = head; n != null; n = n.next) {
			n.draw(g);
		}
	}
	
	
	private class Node {
		int w = Yard.CELL_SIZE;
		int h = Yard.CELL_SIZE;
		
		int row, col;
		Dir dir = Dir.L;
		
		Node next = null;
		Node prev = null;
		
		Node(int row, int col, Dir dir) {
			this.row = row;
			this.col = col;
			this.dir = dir;
		}
		
		void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.BLACK);
			g.fillRect(Yard.CELL_SIZE*col, Yard.CELL_SIZE*row, w, h);
			g.setColor(c);
		}
	}


}





















