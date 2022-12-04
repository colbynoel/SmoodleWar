package smoodleWar;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;

public class GameControl implements ActionListener{
	
	private JPanel container;
	private GameClient client;
	private Graphics drawing;
	
	public GameControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		// If submit is pressed, get our drawing from the drawingPanel
		// Then send to server.
		if(command == "Submit") {
			
			//Grabs drawing panel out of the container to use it's methods 
			DrawingPanel drawingPanel = (DrawingPanel) container.getComponent(2);
			
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
	}

	public void recieveRandomPrompts(String[] wordList) {
		// TODO Auto-generated method stub
		
	}

	public void endGame() {
		// TODO Auto-generated method stub
		
	}

	public void endRound() {
		// TODO Auto-generated method stub
		
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
