//

import java.awt.*;
import java.awt.event.*;

public class TestPaint {
	public static void main(String[] args) {
		new PaintFrame().launchFrame();
	}
}


class PaintFrame extends Frame {
	
	public void launchFrame() {
		setBounds(200, 200, 640, 480);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(50, 50, 30, 30);//ָ��һ�����������Ͻǵĵ����ָ꣬�������εĿ�͸ߡ��������ľ��Ǵ˳����ε�������Բ
		g.setColor(Color.green);
		g.fillRect(80, 80, 40, 40);
		g.setColor(Color.blue);
		g.drawLine(80, 140, 150, 140);//�߶�֮ ����
		g.drawLine(80, 160, 150, 180);
		g.setColor(c);
	}
}