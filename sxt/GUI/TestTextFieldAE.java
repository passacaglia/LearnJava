//

import java.awt.*;
import java.awt.event.*;

public class TestTextFieldAE {
	
	TestTextFieldAE() {
		Frame f = new Frame("Text Field AE test");
		TextField tf = new TextField();
		tf.addActionListener(new TextFieldMonitor());
		
		f.add(tf);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		TestTextFieldAE ttfae = new TestTextFieldAE();
	}
}


class TextFieldMonitor implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		TextField tf = (TextField)e.getSource();
		System.out.println(tf.getText());
		tf.setText("");
	}
}