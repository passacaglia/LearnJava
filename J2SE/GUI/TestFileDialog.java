import java.awt.*;
import java.awt.event.*;

public class TestFileDialog implements ActionListener {
	
	Frame f;
	FileDialog fd;
	Checkbox chLoad, chSave;
	CheckboxGroup cg;
	Button b;
	Label lbDir, lbFile;
	
	public static void main(String[] args) {
		new TestFileDialog();
	}
	
	public TestFileDialog() {
		f = new Frame("FileDialog Example");
		fd = new FileDialog(f);
		
		cg = new CheckboxGroup();
		chLoad = new Checkbox("LOAD", true, cg);
		chSave = new Checkbox("SAVE", false, cg);
		
		Panel p1 = new Panel();
		p1.add(chLoad);
		p1.add(chSave);
		
		lbDir = new Label("Directory: ");
		lbFile = new Label("File Name: ");
		
		Panel p2 = new Panel(new GridLayout(2, 1));
		p2.add(lbDir);
		p2.add(lbFile);
		
		b = new Button("Show");
		b.addActionListener(this);
		
		f.add(p1, BorderLayout.NORTH);
		f.add(p2, BorderLayout.CENTER);
		f.add(b, BorderLayout.SOUTH);
		
		f.pack();
		f.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (chLoad.getState()) {
			fd.setMode(FileDialog.LOAD);
		} else {
			fd.setMode(FileDialog.SAVE);
		}
		fd.show();
		
		lbDir.setText("Directory: " + fd.getDirectory());
		lbFile.setText("File Name: " + fd.getFile());
		f.pack();
		
	}
	
	
	
}