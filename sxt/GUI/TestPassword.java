import java.awt.*;
import java.awt.event.*;

public class TestPassword {
	
	TestPassword() {
		Frame f = new Frame("Text Field AE test");
		TextField tf = new TextField();
		tf.addActionListener(new TextFieldMonitor());
		tf.setEchoChar('*');
		
		f.add(tf);
		f.pack();
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		TestPassword tp = new TestPassword();
	}
}


class PasswordMonitor implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		TextField tf = (TextField)e.getSource();
		System.out.println(tf.getText());
		tf.setText("");
	}
}