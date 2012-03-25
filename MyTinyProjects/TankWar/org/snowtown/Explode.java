package org.snowtown;

import java.awt.*;

public class Explode {
	
	private int x, y;
	TankClient tc;
	
	//image
	private Toolkit tk = Toolkit.getDefaultToolkit();
	private Image[] explodeImg = new Image[] {
		tk.getImage(Explode.class.getClassLoader().getResource("images/0.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/1.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/2.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/3.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/4.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/5.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/6.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/7.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/8.gif")),
		tk.getImage(Explode.class.getClassLoader().getResource("images/9.gif"))
	};
	private static boolean initial = false;
	
	private int step = 0;
	
	private boolean live = true;
	
	public Explode(int x, int y, TankClient tc) {
		this.x = x;
		this.y = y;
		this.tc = tc;
	}
	
	public void draw(Graphics g) {
		if (!initial) {
			for (int i=0; i<explodeImg.length; i++) {
				g.drawImage(explodeImg[i], -100, -100, null);
			}
			initial = true;
		}
		
		if (!live) {
			tc.explodeList.remove(this);
			return;
		}
		
		
		if (step == explodeImg.length) {
			this.setLive(false);
			step = 0;
			return;
		}
		
		g.drawImage(explodeImg[step], x, y, null);
		
		step ++;
		
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
	
}
