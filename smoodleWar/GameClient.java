package smoodleWar;

import java.awt.Graphics;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import ocsf.client.AbstractClient;

public class GameClient extends AbstractClient {
	
	public GameClient() {
		super("localhost", 8300);
	}

	// Private data fields for storing the GUI controllers.
	private LoginControl loginControl;
	private CreateAccountControl createAccountControl;
	private DeleteAccountControl deleteAccountControl;
	private GameControl gameControl;
	private String user;

	// Setters for the GUI controllers.
	public void setLoginControl(LoginControl loginControl) {
		this.loginControl = loginControl;
	}

	public void setCreateAccountControl(CreateAccountControl createAccountControl) {
		this.createAccountControl = createAccountControl;
	}

	public void setDeleteAccountControl(DeleteAccountControl deleteAccountControl) {
		this.deleteAccountControl = deleteAccountControl;
	}

	public void setGameControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}

	@Override
	protected void handleMessageFromServer(Object arg0) {

		// Check returned string to determine what actions need to be taken based on the
		// status
		// of the project
		if (arg0 instanceof String) {
			// Stringify the response
			String serverMessage = (String) arg0;
			// serverResponse[0] = actual response
			// serverResponse[1] = drawer/guesser
			String[] serverResponse = serverMessage.split(",");

			// Successful Login
			if (serverResponse[0].equals("LoginSuccessful")) {
				user = loginControl.loginSuccess(serverResponse[1], serverResponse[2]);
			}

			// Create Account Verification
			else if (serverMessage.equals("CreateAccountSuccessful")) {
				createAccountControl.createAccountSuccess();
			}

			// Delete Account Verification
			else if (serverMessage.equals("AccountDeletionSuccesful")) {
				deleteAccountControl.deleteAccountSuccess();
			}
			else if (serverResponse[0].equals("RoundWord")) {
				gameControl.recieveDrawerRoundWord(serverResponse[1]);
			}
			else if (serverMessage.equals("GetPrompt")) {
				gameControl.recieveRandomPrompts();	
			}
			else if (serverResponse[0].equals("WordList")) {
				
				String[] wordList = new String[serverResponse.length - 1];
				
				for(int i = 0; i < wordList.length; i++) {
		        	wordList[i] = serverResponse[i+1];
		        }
				
				gameControl.setWordList(wordList);
				
			}
			
		}

		// For word prompts, the server should return an array of strings. This response
		// is built
		// specifically to recieve that array.
//		else if (arg0 instanceof String[]) {
//			String[] wordList = (String[]) arg0;
//
//			gameControl.setWordList(wordList);
//		}
		
		//Recieves Graphics object from server and sends to client to update to Guessing round if not 
		else if (arg0 instanceof ArrayList<?>)
		{
			ArrayList<Point> opponentDrawing = (ArrayList<Point>)arg0;
			gameControl.switchGameScreen(opponentDrawing);
		}

		// If we received an Error, figure out where to display it.
		else if (arg0 instanceof Error) {
			// Get the Error object.
			Error error = (Error) arg0;

			// Display login errors using the login controller.
			if (error.getType().equals("Login")) {
				loginControl.displayError(error.getMessage());
			}

			// Display account creation errors using the create account controller.
			else if (error.getType().equals("CreateAccount")) {
				createAccountControl.displayError(error.getMessage());
			}
		}

	}

}
