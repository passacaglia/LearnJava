import java.awt.*;

public class CenterPanel {
	public static void main(String[] args) {
		MyFP mfp = new MyFP("MyFP", 100, 100, 320, 180);
	}
}


class MyFP extends Frame {
	private Panel p; 
	
	MyFP(String s, int x, int y, int w, int h) {
		super(s);
		setLayout(null);
		setBounds(x, y, w, h);
		setBackground(Color.BLUE);
		setVisible(true);
		
		p = new Panel(null);
		p.setBounds(w/4, h/4, w/2, h/2);
		p.setBackground(Color.YELLOW);
		
		add(p);//dont  forget this
	}
}