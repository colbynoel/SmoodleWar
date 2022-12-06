package smoodleWar;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LobbyControl implements ActionListener{
	// Private data fields for the container and chat client.
	// Private data fields for the container and chat client.
	private JPanel container;
	private GameClient client;

	// Constructor for the create account controller.

	public LobbyControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}

	// Handle button clicks.
	public void actionPerformed(ActionEvent ae) {
		// Get the name of the button clicked.
		String command = ae.getActionCommand();

		// The Cancel button takes the user back to the initial panel.
		if (command == "Join a Game") {
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "1");
		}

		// The Submit button creates a new account.
		else if (command == "Logout") {
			// Get the text the user entered in the three fields.
			LobbyPanel lobbyPanel = (LobbyPanel) container.getComponent(2);
		}
//		// Submit the new account information to the server.
//		CreateAccountData data = new CreateAccountData(username, password);
//		try {
//			client.sendToServer(data);
//		} catch (IOException e) {
//			displayError("Error connecting to the server.");
//		}
	}

	// After an account is created, set the User object and display the contacts
	// screen.
	// public void LobbySuccess() {
	// LobbyPanel lobbyPanel = (LobbyPanel) container.getComponent(2);
	// ClientGUI clientGUI = (ClientGUI)
	// SwingUtilities.getWindowAncestor(lobbyPanel);
	// // clientGUI.setUser(new User(createAccountPanel.getUsername(),
	// // createAccountPanel.getPassword()));
	// CardLayout cardLayout = (CardLayout) container.getLayout();
	// cardLayout.show(container, "1");
	// }

	// Method that displays a message in the error label.
	public void displayError(String error) {
		LobbyPanel lobbyPanel = (LobbyPanel) container.getComponent(2);
		lobbyPanel.setError(error);
	}
}
