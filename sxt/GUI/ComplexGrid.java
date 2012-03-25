//

import java.awt.*;

public class ComplexGrid {
	public static void main(String[] args) {
		Frame f = new Frame("Complex Grid");
		f.setLayout(new GridLayout(2, 1));
		f.setSize(500, 400);
		f.setVisible(true);
		
		//above
		Panel p1 = new Panel(new BorderLayout());
		Panel p1p1 = new Panel(new GridLayout(2, 1));
		f.add(p1);
		p1.add(p1p1, BorderLayout.CENTER);
		
		Button p1west = new Button("BUTTON ABOVE WEST");
		Button p1east = new Button("BUTTON ABOVE EAST");
		p1.add(p1west, BorderLayout.WEST);
		p1.add(p1east, BorderLayout.EAST);
		
		//above center
		Button p1p1above = new Button("BUTTON ABOVE");
		Button p1p1down = new Button("BUTTON DOWN");
		p1p1.add(p1p1above);
		p1p1.add(p1p1down);
		
		//down
		Panel p2 = new Panel(new BorderLayout());
		Panel p2p2 = new Panel(new GridLayout(2, 2));
		f.add(p2);
		p2.add(p2p2, BorderLayout.CENTER);
		
		Button p2west = new Button("BUTTON DOWN WEST");
		Button p2east = new Button("BUTTON DOWN EAST");
		p2.add(p2west, BorderLayout.WEST);
		p2.add(p2east, BorderLayout.EAST);
		
		Button p2p2a = new Button("BUTTON A");
		Button p2p2b = new Button("BUTTON B");
		Button p2p2c = new Button("BUTTON C");
		Button p2p2d = new Button("BUTTON D");
		p2p2.add(p2p2a);
		p2p2.add(p2p2b);		
		p2p2.add(p2p2c);
		p2p2.add(p2p2d);
		
	}
}