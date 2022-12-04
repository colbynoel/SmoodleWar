package smoodleWar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

// NOTE: Currently, having the MouseListener and Mouse MotionListener
// all in DrawingPanel is the only way I know to make this work.

public class DrawingPanel extends JPanel {
	private DrawingField drawingField;
	private JLabel prompt;
	private JLabel role;
	private JLabel score;
	
	// Pull the graphics object from the drawingField Panel.
	public Graphics getDrawing() {
		return drawingField.getGraphics();
	}
	
	public JLabel getRole() {
		return role;
	}

	public void setRole(JLabel role) {
		this.role = role;
	}
	
	public void setPromptWord(String promptWord)
	{
		prompt.setText(promptWord);
	}
	
	public void setScore(int scoreCT) {
		score.setText(Integer.toString(scoreCT));
	}
	
	public DrawingPanel(GameControl drawingControl) {
		
		JPanel labelPanel = new JPanel(new GridLayout(2, 1, 10, 10));
		prompt = new JLabel("", JLabel.CENTER);
		prompt.setForeground(Color.blue);
		
		drawingField = new DrawingField();
		
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
		JButton submit = new JButton("Submit");
		JButton clear = new JButton("Clear");
		submit.addActionListener(drawingControl);
		clear.addActionListener(drawingControl);
		
		buttonPanel.add(submit);
		buttonPanel.add(clear);
		
		JPanel grid = new JPanel(new GridLayout(3,1,0,10));
		
		grid.add(labelPanel);
		grid.add(drawingField);
		grid.add(buttonPanel);
		this.add(grid);
		
		
	}
}