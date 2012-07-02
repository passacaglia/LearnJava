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
	
	
	public void addToTail() {
		Node node = null;
		switch(tail.dir) {
		case L :
			node = new Node(tail.row, tail.col+1, tail.dir);
			break;
		case U :
			node = new Node(tail.row+1, tail.col, tail.dir);
			break;
		case R :
			node = new Node(tail.row, tail.col-1, tail.dir);
			break;
		case D :
			node = new Node(tail.row-1, tail.col, tail.dir);
			break;
		}
		
		tail.next = node;
		node.prev = tail;
		tail = node;
		size ++;
	}
	
	
	public void addToHead() {
		Node node = null;
		switch(head.dir) {
		case L :
			node = new Node(head.row, head.col-1, head.dir);
			break;
		case U :
			node = new Node(tail.row-1, tail.col, head.dir);
			break;
		case R :
			node = new Node(head.row, head.col+1, head.dir);
			break;
		case D :
			node = new Node(head.row+1, head.col, head.dir);
			break;
		}
		
		node.next = head;
		head.prev = node;
		head = node;
		size ++;
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





















