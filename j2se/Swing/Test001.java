
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Test001 extends JFrame implements ActionListener {

	public static void main(String[] args) {
		Test001 t = new Test001();
		t.launch();
	}

	void launch () {
		Container container = this.getContentPane();
		JButton b = new JButton("beep");
		b.addActionListener(this);
		this.add(b);
		this.setLocation(100, 200);
		this.pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		int i = 0;
		while(i<10) {
			Toolkit.getDefaultToolkit().beep();
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException ei) {
				ei.printStackTrace();
			}
			i++;
		}
	}

	

}

























