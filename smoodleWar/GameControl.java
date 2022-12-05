package smoodleWar;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.swing.JPanel;

public class GameControl implements ActionListener{
	
	private JPanel container;
	private GameClient client;
	private Graphics drawing;
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
			DrawingPanel drawingPanel = (DrawingPanel) container.getComponent(5);
			
			//Get drawing out of the drawing panel. 
			drawing = drawingPanel.getDrawing();
			
			try {
				client.sendToServer(drawing);
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
			GuessingPanel guessingPanel = (GuessingPanel) container.getComponent(6);
			
			//Grabs drawing panel out of the container to use it's methods 
			DrawingPanel drawingPanel = (DrawingPanel) container.getComponent(5);
			
			//Recieves entered users guess
			String playerGuess = guessingPanel.getGuess();
			
			if (playerGuess.equals(roundWord)) {
				
				//Let's Player Know their guess was correct
				
				//Get the current score from game data and increment it
				int score = gameData.getCurrentScore();
				score++;
				
				//Update gameDatas current score
				gameData.setCurrentScore(score);
				
				//Update the visual "Player Score" in drawingPanel
				drawingPanel.setScore(score);
				
				//If current score is 3, end the game
				if (gameData.getCurrentScore() == 3)
				{
					try {
						endGame();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else 
				{
					incorrectGuesses = 0;
					endRound("Your Guess was Correct");
				}
			}
			else {
				incorrectGuesses++;
				endRound("Your Guess Was Incorrect");
			}
		}
		else if (command == "Next Drawing") {
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "5");
		}
		else if (command == "End Game") {
			//Reset Game Data
			gameData.setCurrentScore(0);
			gameData.setRoomCode("");
			
			//Show lobby screen
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "7");
		}
	}

	public void recieveRandomPrompts() {
		String[] wordList = gameData.getWordList();
		
		Random r = new Random();
		int randomWordIndex = r.nextInt(wordList.length);
		
		//Grabs drawing panel out of the container to use it's methods 
		DrawingPanel drawingPanel = (DrawingPanel) container.getComponent(6);
		
		//Set random word to be later checked during guessing round
		roundWord = wordList[randomWordIndex];
		
		//Sets prompt word to be the randomly selected word
		drawingPanel.setPromptWord(roundWord);
		
	}

	//If user has guessed correctly 3 times, send gameData object to server to end game
	public void endGame() throws IOException {
		client.sendToServer(gameData);
	}

	public void endRound(String tfCorrect) {
		//Grabs drawing guessing out of the container to use it's methods 
		GuessingPanel guessingPanel = (GuessingPanel) container.getComponent(6);
		
		guessingPanel.setTFCorrect(tfCorrect);
		
		//Get a new random word
		recieveRandomPrompts();
		
	}

	public void switchToDrawingView() {
		CardLayout cardLayout = (CardLayout) container.getLayout();
		cardLayout.show(container, "5");
	}
	
	public void switchGameScreen(Graphics opponentDrawing) {
		//Server always sends submitted drawing objects (including clients), game will only update to guessing screen if opponent drawing is 
		//recieved.
		if (opponentDrawing != drawing)
		{
			GuessingPanel guessingPanel = (GuessingPanel) container.getComponent(2);
			guessingPanel.setOpponentDrawing(opponentDrawing);
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "6");
		}
	}

}
