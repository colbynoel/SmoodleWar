package smoodleWar;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameControl implements ActionListener{
	
	private JPanel container;
	private GameClient client;
	private ArrayList<Point> coordinates;
	private GameData gameData;
	private String roundWord;
	private int incorrectGuesses;
	
	public GameControl(JPanel container, GameClient client, GameData gameData) {
		this.container = container;
		this.client = client;
		this.gameData = gameData;
	}
	
	public void setWordList(String[] wordlist) {
		gameData.setWordList(wordlist);
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		// If submit is pressed, get our drawing from the drawingPanel
		// Then send to server.
		if(command == "submit drawing") {
			
			//Grabs drawing panel out of the container to use it's methods 
			DrawingPanel drawingPanel = (DrawingPanel) container.getComponent(4);
			
			//Get drawing out of the drawing panel. 
			coordinates = drawingPanel.getDrawing();
			
			try {
				client.sendToServer(roundWord);
				client.sendToServer(coordinates);
			}
			catch (IOException ex) {
				ex.printStackTrace();
				System.err.println("Couldn't send drawing");
			}
		}
		else if (command == "clear drawing") {
			// Let's clear the drawing field to reset on player request
		}
		else if (command == "Guess") {
			//Grabs drawing guessing out of the container to use it's methods 
			GuessingPanel guessingPanel = (GuessingPanel) container.getComponent(5);
			
			//Grabs drawing panel out of the container to use it's methods 
			DrawingPanel drawingPanel = (DrawingPanel) container.getComponent(4);
			
			//Receives entered users guess
			String playerGuess = guessingPanel.getGuess();
			
			if (playerGuess.equals(roundWord)) {
				//Get the current score from game data and increment it
				int score = gameData.getCurrentScore();
				score++;
				
				//Let's Player Know their guess was correct
				int input = JOptionPane.showConfirmDialog(guessingPanel, "You Guessed Correctly! Your score is " + score + "/3", "Lucky Guess", JOptionPane.DEFAULT_OPTION);
				
				//Update gameDatas current score
				gameData.setCurrentScore(score);
				
				//If current score is 3, end the game
				if (input == 0 && gameData.getCurrentScore() == 3)
				{
					try {
						client.sendToServer("GameOver");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					endGame();
				}
				else 
				{
					if (input == 0) {
						endRound("Opponent Guessed Correctly");
					}
				}
			}
			else if (!playerGuess.equals(roundWord)) {
				incorrectGuesses++;
				
				//Let's Player Know their guess was correct
				int input = JOptionPane.showConfirmDialog(guessingPanel, "Whoops, you were wrong. Try again! Incorrect Guesses: " 
				+ incorrectGuesses + "/3", "Tough Break", JOptionPane.DEFAULT_OPTION);
				
				if (incorrectGuesses == 3) {
					endRound("Opponent Failed");
				}
				
			}
		}
		else if (command == "Next Drawing") {
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "5");
		}
		else if (command == "get prompt") {
			try {
				client.sendToServer("getPrompt");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public void recieveRandomPrompt(String prompt) {
		//Set prompt
		roundWord = prompt;
		
		//Grabs drawing panel out of the container to use it's methods 
		DrawingPanel drawingPanel = (DrawingPanel) container.getComponent(4);
		
		//Sets prompt word to be the randomly selected word
		drawingPanel.setPromptWord(prompt);
		drawingPanel.update(drawingPanel.getGraphics());
	}
	

	//If user has guessed correctly 3 times, send gameData object to server to end game
	public void endGame() {
	 	int input = 999;
		
		if (gameData.getCurrentScore() == 3) {
			input = JOptionPane.showConfirmDialog(null, "You Win!", "Winner!", JOptionPane.DEFAULT_OPTION);
		}
		else {
			input = JOptionPane.showConfirmDialog(null, "Your Opponent Won! :(", "Loser!", JOptionPane.DEFAULT_OPTION);
		}
		
		if (input == 0) {
			//Show lobby screen
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "7");
		}
		
		//Reset Game Data
		gameData.setCurrentScore(0);
	}

	public void endRound(String roundOverText) {
		
		try {
			client.sendToServer(roundOverText);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void recieveDrawerRoundWord(String drawerRoundWord) {
		roundWord = drawerRoundWord;
	}

	public void switchToDrawingView() {
		CardLayout cardLayout = (CardLayout) container.getLayout();
		cardLayout.show(container, "5");
	}
	
	public void sendDrawing(ArrayList<Point> opponentDrawing) {
		//Server always sends submitted drawing objects (including clients), game will only update to guessing screen if opponent drawing is 
        //recieved.
        if (!opponentDrawing.equals(coordinates))
        {
            GuessingPanel guessingPanel = (GuessingPanel) container.getComponent(5);
            guessingPanel.setOpponentDrawing(opponentDrawing);
            CardLayout cardLayout = (CardLayout) container.getLayout();
            cardLayout.show(container, "6");
        }
	}
	
	public void switchPlayerRoles(String serverResponse) {
		GuessingPanel guessingPanel = (GuessingPanel) container.getComponent(5);
		DrawingPanel drawingPanel = (DrawingPanel) container.getComponent(4);
		
		CardLayout cardLayout = (CardLayout) container.getLayout();
		
		if (guessingPanel.isShowing()) {
			cardLayout.show(container, "5");
		}
		else if (drawingPanel.isShowing()) {
			int input = JOptionPane.showConfirmDialog(guessingPanel, serverResponse, "Round Info", JOptionPane.DEFAULT_OPTION);
			
			if (input == 0) {
				cardLayout.show(container, "6");
			}
		}
		
	}

}
