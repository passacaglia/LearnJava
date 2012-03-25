//

import java.awt.*;

public class TestPanel {
	public static void main(String[] args) {
		Frame f = new Frame("My Frame");
		Panel p = new Panel(null);
		
		f.setLayout(null);
		f.setBounds(100, 100, 400, 300);
		f.setBackground(new Color(0,0,102));
		
		p.setBounds(100, 75, 200, 150);
		p.setBackground(new Color(204, 204, 255));
		
		f.add(p);
		f.setVisible(true);
	}
}