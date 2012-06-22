import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


class TestFileFilter extends JFrame {
	JMenuItem openMI, exitMI;
	JFileChooser fileChooser;
	Container container;
	JLabel label;
	File file, selectedFile;
	
	TestFileFilter() {
		//1.To close the frame.
		this.addWindowListener(new FrameClosing());
		
		//2. Get a handle on the frame's content pane.
		container = this.getContentPane();
		
		//3. Create a label and add it to the container.
		label = new JLabel();
		container.add(label);
		
		//4. Create and add a menu bar.
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(BorderFactory.createEtchedBorder());
		container.add(menuBar, BorderLayout.NORTH);
		
		//5. Create and add the file menu and its menu items.
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		
		openMI = new JMenuItem("Open");
		openMI.addActionListener(new MIActionListener());
		fileMenu.add(openMI);
		
		fileMenu.addSeparator();
		
		//6. "Exit" menu item with an action listener.
		exitMI = new JMenuItem("Exit");
		exitMI.addActionListener(new MIActionListener());
		fileMenu.add(exitMI);
		
	}

	
	//7. Menu action listener.
	class MIActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JMenuItem menuItem = (JMenuItem)e.getSource();
			
			//8. if the "Open" menu item is selected.
			if (menuItem == openMI) {
				if (null == file) {
					//create a file chooser pointing to the home directory.
					fileChooser = new JFileChooser();
				} else {
					//create a file chooser pointing to the specified file path.
					fileChooser = new JFileChooser(file);
				}
				
				//9. Add a file filter (object of MyFileFilter)
				fileChooser.addChoosableFileFilter(new MyFileFilter());
				
				//The following statement will assign the new filter
				//discarding the other filters.
				//fileChooser.setFileFilter(new MyFileFilter());
				
				//10. Set a custom view for the files (using the object of MyFileview).
				fileChooser.setFileView(new MyFileView());
				
				//11. Show the dialog box (return the option selected).
				int selected = fileChooser.showOpenDialog(container);
				
				//12. if the Open button over the file chooser is pressed.
				if (selected == JFileChooser.APPROVE_OPTION) {
					//Get the selected file
					file = fileChooser.getSelectedFile();
					
					//Display the file name in the frame.
					label.setText("You have selected to open");
					file.getName();
					label.setHorizontalAlignment(JLabel.CENTER);
					
					return;
					
				} else if (fileChooser.CANCEL_OPTION == selected) {//13. if the Cancel button is pressed.
					label.setText("You have not selected any file to open!");
					label.setHorizontalAlignment(JLabel.CENTER);
					return;
				}
				
			} else if (menuItem == exitMI) {//14. If the Exit button is pressed.
				System.exit(0);
			}
		}
	
	}
	
	
	//15. Listener to close the frame.
	class FrameClosing extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
	
	//16. The main method.
	public static void main(String[] args) {
		TestFileFilter frame = new TestFileFilter();
		frame.setTitle("TestFileFilter Example");
		frame.setSize(450, 300);
		frame.setVisible(true);
	}
}



//17. Define a file filter class.
class MyFileFilter extends javax.swing.filechooser.FileFilter {

	@Override
	public boolean accept(File file) {
		if (file.isDirectory()) {//Accept if the file system member is a directory.
			return true;
		}
		
		//Retrieve the file name.
		String fileName = file.getName();
		//Note the index of "." in a file name.
		int periodIndex = fileName.lastIndexOf('.');
		
		//State of acceptence.
		boolean accepted = false;
		
		if (periodIndex > 0 && periodIndex < fileName.length()-1) {
			String extension = fileName.substring(periodIndex+1).toLowerCase();
			if (extension.equals("java")) {//Check if the extension is ".java"
				accepted = true;
			} else if (extension.equals("html")) {//Check if the extension is ".html"
				accepted = true;
			}
		}
		
		return accepted;
		
	}

	
	//Retrieve the description of the filter.
	@Override
	public String getDescription() {
		return "Java and HTML Files (*.java, *.html)";
	}
	
}


//18. Custom file view class .
class MyFileView extends javax.swing.filechooser.FileView {
	//Define the required icon objects.
	ImageIcon javaIcon = new ImageIcon("javaIcon.gif");
	ImageIcon htmlIcon = new ImageIcon("htmlIcon.gif");
	
	//Retrieve the file name.
	public String getName(File f) {
		return null;//L&FileView will find this out of use return f.getName();
	}
	
	//Retrieve the description of the 
	public String getDescription(File f) {
		return null;//L&FileView will find this out
	}
	
	//Returns the file type as Java.
	public String getTypeDescription(File f) {
		String extension = getExtension(f);
		String type = null;
		if (null != extension) {
			if (extension.equals("java")) {
				type = "Java File";
			}
			if (extension.equals("html")) {
				type = "Html File";
			}
		}
		return type;
	}
	
	//Retrieve the relevant icon for the file view.
	public Icon getIcon(File f) {
		String extension = getExtension(f);
		Icon icon = null;
		
		if (null != extension) {
			if (extension.equals("java")) {
				icon = javaIcon;
			}
			if (extension.equals("html")) {
				icon = htmlIcon;
			}
		}
		
		return icon;

	}
	
	//Whether a direction is traversable
	public Boolean isTraversable(File f) {
		return null;//L&FileView will find out
	}
	
	//Retrieve the extension of a file.
	private String getExtension(File f) {
		String fileName = f.getName();
		int periodIndex = fileName.lastIndexOf('.');
		String extension = null;
		if (periodIndex > 0 && periodIndex < fileName.length()-1) {
			extension = fileName.substring(periodIndex+1).toLowerCase();
		}
		return extension;
	}
	
}


























































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































