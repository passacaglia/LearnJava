import java.applet.Applet;
import java.awt.Graphics;

public class Paint extends Applet {
	public void paint(Graphics g) {
		g.drawString("Hello Java", 0, 10);
	}
}

/**
*坐标，不要(0,0)。那样的话就看不到"Hello Java"了。
*因为系统坐标不是从“Hello  Java”字母左上角开始的，而是下划线位置。
**/