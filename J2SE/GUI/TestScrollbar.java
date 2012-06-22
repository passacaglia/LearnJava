import java.awt.*;
import java.awt.event.*;

public class TestScrollbar extends Frame {
	
	Button b = null;
	Button b2 = null;
	Panel p = null;
	Scrollbar HScrollbar, VScrollbar;
	int x=0, y=0;
	
	AdjustmentMonitor am = new AdjustmentMonitor();
	
	public static void main(String[] args) {
		new TestScrollbar().launch();
	}
	
	public void launch() {
		setLocation(300, 200);
		
		p = new Panel(null);
		
		b = new Button("Button");
		b2 = new Button("back");
		b.setSize(50, 20);
		b2.setSize(50, 20);
		b.setLocation(x, y);
		b2.setLocation(x + 70, y + 40);
		b2.addActionListener(new ActionMonitor());
		
		HScrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 0, 10, 0, 200); 
		VScrollbar = new Scrollbar(Scrollbar.VERTICAL, 0, 10, 0, 200 );
		HScrollbar.addAdjustmentListener(am);
		VScrollbar.addAdjustmentListener(am);
		
		p.add(b);
		p.add(b2);
		
		this.add(p, BorderLayout.CENTER);
		this.add(HScrollbar, BorderLayout.SOUTH);
		this.add(VScrollbar, BorderLayout.EAST);
		
		setSize(300, 300);
		setVisible(true);
	}
	
	private class AdjustmentMonitor implements AdjustmentListener {
		public void adjustmentValueChanged(AdjustmentEvent e) {
			Scrollbar scrollbar = (Scrollbar)e.getSource();
			
			if (scrollbar.getOrientation() == Scrollbar.HORIZONTAL) {
				x = scrollbar.getValue();
			} else {
				y = scrollbar.getValue();
			}
			
			b.setLocation(x, y);
			b2.setLocation(x + 70, y + 40);
		}
	}
	
	private class ActionMonitor implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			b.setLocation(0, 0);
			b2.setLocation(70, 40);
			
			HScrollbar.setValue(0);
			VScrollbar.setValue(0);
			y = HScrollbar.getValue();
			x = VScrollbar.getValue();
		}
	}
	
	
}