//

import java.awt.*;
import java.awt.event.*;

public class TestActionEvent {
	public static void main(String[] args) {
		Frame f = new Frame("Action Event test");
		Button b = new Button("BUTTON");
		b.addActionListener(new Monitor());
		
		f.add(b);
		f.pack();
		f.setVisible(true);
	}
}


class Monitor implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("A button has been pressed.");
	}
}