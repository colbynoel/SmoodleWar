package smoodleWar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class GuessingPanel extends JPanel {
	
	private ArrayList<Point> opponentDrawing;
	
	private DrawingField drawingField;
	private JTextField guessingField;
	private JLabel tfCorrect;
	

	public GuessingPanel(GameControl gc) {
		
		drawingField = new DrawingField();
		Border blackline = BorderFactory.createLineBorder(Color.black);
		drawingField.setBorder(BorderFactory.createTitledBorder(blackline, "Guess the Image!"));
		

		JPanel guessingPanel = new JPanel(new GridLayout(3, 1, 10, 10));
		JLabel guessLabel = new JLabel("Enter Your Guess", JLabel.CENTER);
		guessLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
		
		guessingField = new JTextField(JLabel.CENTER);
		JButton guessButton = new JButton("Guess");
		
		guessingPanel.add(guessLabel);
		guessingPanel.add(guessingField);
		guessingPanel.add(guessButton);

		
		JPanel middlePanel = new JPanel();
		middlePanel.add(drawingField);

		

		this.add(guessingPanel, BorderLayout.NORTH);
		this.add(middlePanel, BorderLayout.CENTER);

	}

	public ArrayList<Point> getOpponentDrawing(){
		return opponentDrawing;
	}

	// Locally sets the opponent Drawing in guessingPanel
	// then sets the drawing panel's drawingField to the specified
	// coordinates to be redrawn.
	public void setOpponentDrawing(ArrayList<Point> opponentDrawing) {
		this.opponentDrawing = opponentDrawing;
		drawingField.setDrawingCoords(opponentDrawing);
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
