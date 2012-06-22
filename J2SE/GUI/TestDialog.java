import java.awt.*;
import java.awt.event.*;

public class TestDialog extends WindowAdapter implements ActionListener {
	
	Frame f; 
	Dialog d;
	Checkbox ch;
	Button b;
	
	
	public static void main(String[] args) {
		new TestDialog();
	}
	
	public TestDialog() {
		f = new Frame("Test Dialog");
		f.setLocation(300, 200);
		
		ch = new Checkbox("Modal");
		
		b = new Button("Show Dialog");
		b.addActionListener(this);
		
		f.add(ch, BorderLayout.NORTH);
		f.add(b, BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		d = new Dialog(f, "I'm a Dialog", ch.getState());
		d.addWindowListener(this);
		d.setSize(100, 100);
		b.setEnabled(false);
		d.show();
		System.out.println(d.isModal());
	}
	
	public void windowClosing(WindowEvent e) {
		d.dispose();
		b.setEnabled(true);
	}
	
	
}
