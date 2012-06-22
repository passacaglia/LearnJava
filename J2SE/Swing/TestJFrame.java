
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TestJFrame {
	
	public static void main(String[] args) {
		new TestJFrame().launch();
		try {
			while (1 < 100) {
				Thread.sleep(1000);
				System.out.println("It's still running!!");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void launch() {
		JFrame jf = new JFrame("Hello, Swing");
		Container c = jf.getContentPane();
		
		//是c,不是jf.
		//c.setBackground(Color.BLUE);
		c.setForeground(Color.BLACK);//为什么不行?
		
		JLabel jl = new JLabel("Hello", JLabel.CENTER);
		jl.setBounds(50, 50, 50, 50);
		jl.setBackground(Color.GREEN);
		c.add(jl);
		
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setBounds(200, 100, 200, 100);
		jf.setVisible(true);
	}
	
}
