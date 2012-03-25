
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class TestJLayeredPane extends JFrame implements ActionListener {

	JButton button = null;
	JLayeredPane layeredPane = null;
	
	static int frameCount = 0;
	static final int xOffSet = 25;
	static final int yOffSet = 25;//each layer pane y offset
	
	int numFrames = 1;
	//Define arrays for the layered pane constants and their names.
	Integer[] layerConstants = { JLayeredPane.DEFAULT_LAYER,
								 JLayeredPane.PALETTE_LAYER,
								 JLayeredPane.MODAL_LAYER,
								 JLayeredPane.POPUP_LAYER,
								 JLayeredPane.DRAG_LAYER };
	String[] layerNames = { "Default Layer",
							"Palette Layer",
							"Modal Layer",
							"Popup Layer",
							"Drag Layer" };
	Vector<JInternalFrame> framesVector = new Vector<JInternalFrame>();
	
	public TestJLayeredPane() {
		super("TestJLayeredPane");//assign a title
		//1.Create a panel and assign grid layout with 3 row and 3 columns.
		JPanel panel = new JPanel(new GridLayout(3, 3));
		panel.setBorder(BorderFactory.createTitledBorder(
										"Click the specific Button to Add Frames or Clear Frames"));
		//2.Add the following control buttons to the panel.
		for (int i=0; i<layerNames.length+1; i++) {
			if (i < layerNames.length) {
				button = new JButton("Add to " + layerNames[i]);
				button.setActionCommand(layerNames[i]);
			} else {
				button = new JButton("Clear the Frames");
				button.setActionCommand("Clear");
				button.setForeground(Color.RED);
			}
			button.addActionListener(this);
			panel.add(button);
		}
		
		//3. Add the panel at the bottom portion of the frame
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		//4. Obtain a handle on the layered pane of the frame.
		layeredPane = getLayeredPane();
		
		//5. Code to configure the frame.
		addWindowListener(new WindowEventHandler());
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(400, 400);
		setVisible(true);
	}
	
	//6. Whenever a button is clicked
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton tempButton = (JButton)e.getSource();
		
		if (tempButton.getActionCommand() == layerNames[0]) {// for default layer
			addInternalFrame(0);
		} else if (tempButton.getActionCommand() == layerNames[1]) {// for palette layer.
			addInternalFrame(1);
		} else if (tempButton.getActionCommand() == layerNames[2]) {// for Modal layer.
			addInternalFrame(2);
		} else if (tempButton.getActionCommand() == layerNames[3]) {// for popup layer.
			addInternalFrame(3);
		} else if (tempButton.getActionCommand() == layerNames[4]) {// for drag  layer.
			addInternalFrame(4);
		} else if (tempButton.getActionCommand() == "Clear") {
			//Enumerate the vector elements and dispose all of them.
			for (Enumeration<JInternalFrame> e1 = framesVector.elements(); 
							e1.hasMoreElements();) {
				((JInternalFrame)e1.nextElement()).dispose();
			}
		}
	}
	
	
	//7. Adds an internal frame to the specified layer
	public void addInternalFrame(int index) {
		JInternalFrame iFrame  = new JInternalFrame(
										"In " + layerNames[index],
										true,//can be resized
										true,//can be closed
										true,//can be maximized
										true);//can be iconfied
		
		//8. Register the new Frame in a vector
		framesVector.addElement(iFrame);
		
		//9. Set the location of the frame.
		iFrame.setLocation(xOffSet*(frameCount), yOffSet*(frameCount++));
		iFrame.setSize(200, 150);//Assign suitable size
		iFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		//iFrame.setFrameIcon(new ImageIcon("smiley.gif"));
		layeredPane.add(iFrame, layerConstants[index]);
		iFrame.show();
	}
	
	//10. The listener class to handle closing of the frame.
	class WindowEventHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	//11. the main method
	public static void main(String[] args) {
		new TestJLayeredPane();
	}

}













































































