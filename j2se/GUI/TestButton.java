import java.awt.*;
import java.awt.event.*;

public class TestButton extends Frame{
	
	Button b1 = null;
	Button b2 = null;
	
	public static void main(String[] args) {
		new TestButton().launchFrame();
	}
	
	public void launchFrame() {
		setLocation(400, 200);
		
		b1 = new Button("Hello");
		b2 = new Button("Hello");
		b1.setActionCommand("b1");
		b2.setActionCommand("b2");
		b1.setForeground(Color.BLUE);
		b2.setBackground(Color.RED);
		b1.addActionListener(new ButtonMonitor());
		b2.addActionListener(new ButtonMonitor());
		
		b2.setEnabled(false);
		
		add(b1, BorderLayout.NORTH);
		add(b2, BorderLayout.SOUTH);
		pack();
		setVisible(true);
	}
	
	private class ButtonMonitor implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			b1.setEnabled( !b1.isEnabled() );
			b2.setEnabled( !b2.isEnabled() );
		}
		
	}
	
}
