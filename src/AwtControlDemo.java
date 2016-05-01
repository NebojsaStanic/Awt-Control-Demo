import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class AwtControlDemo {

	private Frame myFrame;
	private Label headerlabel;
	private Label  statusLabel;
	private Panel controlPanel;
	
	public AwtControlDemo(){
		prepareGUI();
	}
	
	public static void main(String[] args) {
		
		AwtControlDemo awtControlDemo = new AwtControlDemo();
		awtControlDemo.showEventDemo();
	}
	
	private void prepareGUI(){
		myFrame = new Frame("Java AWT examples");
		myFrame.setSize(400,400);
		myFrame.setLayout(new GridLayout(3, 1));
		myFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent){
				System.exit(0);
			}
		});
		headerlabel = new Label();
		headerlabel.setAlignment(Label.CENTER);
		statusLabel = new Label();
		statusLabel.setAlignment(Label.CENTER);
		statusLabel.setSize(350,100);
		
		controlPanel = new Panel();
		controlPanel.setLayout(new FlowLayout());
		
		myFrame.add(headerlabel);
		myFrame.add(controlPanel);
		myFrame.add(statusLabel);
		myFrame.setVisible(true);
	}
	
	public void showEventDemo(){
		headerlabel.setText("Control in action: Button");
		
		Button okButton = new Button("OK");
		Button submitButton = new Button("Submit");
		Button cancelButton = new Button("Cancel");
		
		okButton.setActionCommand("OK");
		submitButton.setActionCommand("Submit");
		cancelButton.setActionCommand("Cancel");
		
		okButton.addActionListener(new ButtonClickListener());
		submitButton.addActionListener(new ButtonClickListener());
		cancelButton.addActionListener(new ButtonClickListener());
		
		controlPanel.add(okButton);
		controlPanel.add(submitButton);
		controlPanel.add(cancelButton);
		
		myFrame.setVisible(true);
	}
	
	private class ButtonClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if(command.equals("OK")){
				statusLabel.setText("OK Button clicked");
			}
			else if(command.equals("Submit")){
				statusLabel.setText("Submit Button clicked");
			}
			else{
				statusLabel.setText("Cancel Button clicked");
			}
			
		}
		
	}
	

}
