package smoodleWar;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawingPanel {
	private Graphics drawing;
	private JLabel prompt;
	private JLabel role;

	public Graphics getDrawing() {
		return drawing;
	}

	public void setDrawing(Graphics drawing) {
		this.drawing = drawing;
	}
	
	public DrawingPanel(DrawingControl drawingControl) {
		
		JPanel labelPanel = new JPanel(new GridLayout(2, 1, 10, 10));
		prompt = new JLabel("", JLabel.CENTER);
	}
}
