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
	private Graphics drawing;
	private JLabel prompt;
	private JLabel role;
	
	public Graphics getDrawing() {
		return drawing;
	}
	
	public void setDrawing(Graphics drawing) {
		this.drawing = drawing;
	}
	public JLabel getRole() {
		return role;
	}

	public void setRole(JLabel role) {
		this.role = role;
	}
	
	public DrawingPanel(DrawingControl drawingControl) {
		
		JPanel labelPanel = new JPanel(new GridLayout(2, 1, 10, 10));
		prompt = new JLabel("", JLabel.CENTER);
		prompt.setForeground(Color.blue);
		
		DrawingField drawingField = new DrawingField();
		
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