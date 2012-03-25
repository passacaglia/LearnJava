import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

public class TestFrame {
	public static void main(String args[]) {
		Frame f1 = new Frame();
		Frame f2 = new Frame("My Frame 2");
		
		f1.setSize(160,200);
		f2.setSize(200,100);
		f1.setVisible(true);
		f2.setVisible(true);
		Image img = Toolkit.getDefaultToolkit().createImage("./icon.gif");
		f1.setIconImage(img);
		f2.setIconImage(img);
	}
}