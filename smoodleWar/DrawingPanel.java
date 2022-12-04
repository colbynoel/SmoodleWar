package smoodleWar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

// NOTE: Currently, having the MouseListener and Mouse MotionListener
// all in DrawingPanel is the only way I know to make this work.

public class DrawingPanel extends JPanel {
	private DrawingField drawingField;
	private JLabel prompt;
	private JLabel role;

	// Pull the graphics object from the drawingField Panel.
	public Graphics getDrawing() {
		return drawingField.getGraphics();
	}

	public JLabel getRole() {
		return role;
	}
	
	public String getPrompt() {
		return prompt.getText();
	}
	
	public void setPrompt(String prompt) {
		this.prompt.setText(prompt);
	}

	public void setRole(JLabel role) {
		this.role = role;
	}

	public DrawingPanel(GameControl drawingControl) {

		// drawingPanel = new DrawingPanel();
		drawingField = new DrawingField();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		drawingField.setBorder(BorderFactory.createTitledBorder(blackline, "DrawingField"));

		JPanel topPanel = new JPanel(new GridLayout(1, 1, 10, 10));
		JLabel prompt = new JLabel("Fish", JLabel.CENTER);
		prompt.setFont(new Font("Verdana", Font.PLAIN, 35));
		topPanel.add(prompt);

		// middlePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel middlePanel = new JPanel();
		middlePanel.add(drawingField);

		JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
		JButton button1 = new JButton("Sussy");
		JButton button2 = new JButton("Bussy");
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		

		this.add(topPanel, BorderLayout.NORTH);
		this.add(middlePanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);

	}
}