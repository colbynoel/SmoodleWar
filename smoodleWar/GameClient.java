package smoodleWar;

import java.awt.Graphics;

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

	public void deleteAccountControl(DeleteAccountControl deleteAccountControl) {
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
			String serverResponse = (String) arg0;

			// Successful Login
			if (serverResponse.equals("LoginSucessful")) {
				user = loginControl.loginSuccess();
			}

			// Create Account Verification
			else if (serverResponse.equals("CreateAccountSuccessful")) {
				createAccountControl.createAccountSuccess();
			}

			// Delete Account Verification
			else if (serverResponse.equals("AccountDeletionSuccesful")) {
				deleteAccountControl.deleteAccountSuccess();
			}

			// ------------------------------------------------------//
			// Game Turn Related Response //
			// ------------------------------------------------------//

			// If a round is successfully over activate the roundover function
			else if (serverResponse.equals("RoundOver")) {
				gameControl.endRound();
			}

			// If the game is successfully over run the GameOverFunction
			else if (serverResponse.equals("GameOver")) {
				gameControl.endGame();
			}
			
		}

		// For word prompts, the server should return an array of strings. This response
		// is built
		// specifically to recieve that array.
		else if (arg0 instanceof String[]) {
			String[] wordList = (String[]) arg0;

			gameControl.recieveRandomPrompts(wordList);
		}
		
		//Recieves Graphics object from server and sends to client to update to Guessing round if not 
		else if (arg0 instanceof Graphics)
		{
			Graphics opponentDrawing = (Graphics)arg0;
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
