package smoodleWar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

// NOTE: Currently, having the MouseListener and Mouse MotionListener
// all in DrawingPanel is the only way I know to make this work.

public class DrawingPanel extends JPanel {
	private DrawingField drawingField;
	private JLabel prompt = new JLabel();
	private JLabel role;
	private JLabel score;
	
	// Pull the graphics object from the drawingField Panel.
	public ArrayList<Point> getDrawing() {
		return drawingField.getDrawingCoords();
	}

	public JLabel getRole() {
		return role;
	}
	
	public String getPrompt() {
		return prompt.getText();
	}

	public void setRole(JLabel role) {
		this.role = role;
	}
	
	public void setPromptWord(String promptWord)
	{
		this.prompt.setText(promptWord);
	}
	
	public void setScore(int scoreCT) {
		score.setText(Integer.toString(scoreCT));
	}
	
	public DrawingPanel(GameControl drawingControl) {

		// drawingPanel = new DrawingPanel();
		drawingField = new DrawingField();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		drawingField.setBorder(BorderFactory.createTitledBorder(blackline, "DrawingField"));

		JPanel topPanel = new JPanel(new GridLayout(1, 1, 10, 10));
		prompt.setFont(new Font("Verdana", Font.PLAIN, 35));
		topPanel.add(prompt);

		// middlePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel middlePanel = new JPanel();
		middlePanel.add(drawingField);

		JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        JButton button1 = new JButton("submit drawing");
        JButton button2 = new JButton("clear screen");
        JButton button3 = new JButton("get prompt");
        button1.addActionListener(drawingControl);
        button2.addActionListener(drawingControl);
        button3.addActionListener(drawingControl);
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3); 
		

		this.add(topPanel, BorderLayout.NORTH);
		this.add(middlePanel, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);

	}
}