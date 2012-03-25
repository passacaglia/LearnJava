/**
*
*
****/

import java.awt.*;

public class TestFrame {
	public static void main(String[] args) {
		Frame f = new Frame("My Frame");
		f.setSize(160, 90);
		f.setLocation(100,100);
		f.setVisible(true);
		f.setResizable(false);
	}
}