package smoodleWar;

import java.awt.Graphics;

import javax.swing.JPanel;

public class GuessingPanel extends JPanel {
	
	private Graphics opponentDrawing;
	
	public GuessingPanel(GameControl gc) {
		
	}
	
	public Graphics getGetOpponentDrawing() {
		return opponentDrawing;
	}

	public void setOpponentDrawing(Graphics opponentDrawing) {
		this.opponentDrawing = opponentDrawing;
	}
}
