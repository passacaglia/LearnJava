import java.awt.*;
import java.awt.event.*;

public class TestTextField extends Frame {
	
	Label label = null;
	TextField textField = null;
	
	public static void main(String[] args) {
		new TestTextField().launch();
	}
	
	public void launch() {
		setLocation(300, 200);
		setLayout(new GridLayout(2, 1));
		
		textField = new TextField("", 20);
		textField.addTextListener(new TextMonitor());
		textField.addActionListener(new ActionMonitor());
		
		textField.setEditable(false);
		
		label = new Label();
		if (textField.isEditable() == false) {
				label.setText("Sorry, it is not editable.");
		}
		
		
		add(textField);
		add(label);
		pack();
		setVisible(true);
	}
	
	private class TextMonitor implements TextListener {
		public void textValueChanged(TextEvent e) {
				label.setText(textField.getText());
		}
	}
	
	private class ActionMonitor implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			textField.setText("");
		}
	}
	
	
}