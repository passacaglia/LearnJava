import javax.swing.*;

public class Test extends JFrame {
	public static void main(String[] args) {
		new Test().launch();
	}
	
	public void launch() {
		setBounds(300, 200, 400, 300);
		JButton jb = new JButton();
		
		add(jb);
		pack();
		
		setVisible(true);
	}
	
}