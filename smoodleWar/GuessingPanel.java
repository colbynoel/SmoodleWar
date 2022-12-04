package smoodleWar;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuessingPanel extends JPanel {
	
	private Graphics opponentDrawing;
	private JTextField guessingField;
	private JLabel tfCorrect;
	

	public GuessingPanel(GameControl gc) {
		
	}
	
	public Graphics getGetOpponentDrawing() {
		return opponentDrawing;
	}

	public void setOpponentDrawing(Graphics opponentDrawing) {
		this.opponentDrawing = opponentDrawing;
	}
	
	// Getter for the text in the guess field.
	public String getGuess() {
		return new String(guessingField.getText());
	}
	
	// Sets message whether or not guess was correct
	public void setTFCorrect(String tfGuess) {
		tfCorrect.setText(tfGuess);
	}
	
}
