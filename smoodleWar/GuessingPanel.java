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
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GuessingPanel extends JPanel {
	
	private Graphics opponentDrawing;
	private JTextField guessingField;
	private JLabel tfCorrect;
	private DrawingField drawing;
	

	public GuessingPanel(GameControl gc) {
		drawing = new DrawingField();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		drawing.setBorder(BorderFactory.createTitledBorder(blackline, "DrawingField"));

		JPanel guessingPanel = new JPanel(new GridLayout(3, 1, 10, 10));
		JLabel guessLabel = new JLabel("Enter Your Guess", JLabel.CENTER);
		guessLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
		guessingField = new JTextField(JLabel.CENTER);
		JButton guessButton = new JButton("Guess");
		guessingPanel.add(guessLabel);
		guessingPanel.add(guessingField);
		guessingPanel.add(guessButton);

		// middlePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		JPanel drawingPanel = new JPanel();
		drawingPanel.add(drawing);

		

		this.add(guessingPanel, BorderLayout.NORTH);
		this.add(drawingPanel, BorderLayout.CENTER);

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
