package smoodleWar;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DeleteAccountControl implements ActionListener {
	// Private data fields for the container and chat client.
	private JPanel container;
	private ChatClient client;

	// Constructor for the create account controller.
	public DeleteAccountControl(JPanel container, ChatClient client) {
		this.container = container;
		this.client = client;
	}

	// Handle button clicks.
	public void actionPerformed(ActionEvent ae) {
		// Get the name of the button clicked.
		String command = ae.getActionCommand();

		// The Cancel button takes the user back to the initial panel.
		if (command == "Cancel") {
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "1");
		}

		// The Submit button creates a new account.
		else if (command == "Submit") {
			// Get the text the user entered in the three fields.
			DeleteAccountPanel deleteAccountPanel = (DeleteAccountPanel) container.getComponent(2);
			String username = deleteAccountPanel.getUsername();
			String password = deleteAccountPanel.getPassword();
			String passwordVerify = deleteAccountPanel.getPasswordVerify();

			// Check the validity of the information locally first.
			if (username.equals("") || password.equals("")) {
				displayError("You must enter a username and password.");
				return;
			} else if (!password.equals(passwordVerify)) {
				displayError("The two passwords did not match.");
				return;
			}
			if (password.length() < 6) {
				displayError("The password must be at least 6 characters.");
				return;
			}

			// Submit the new account information to the server.
			DeleteAccountData data = new DeleteAccountData(username, password);
			try {
				client.sendToServer(data);
			} catch (IOException e) {
				displayError("Error connecting to the server.");
			}
		}
	}

	// After an account is created, set the User object and display the contacts
	// screen.
	public void deleteAccountSuccess() {
		DeleteAccountPanel deleteAccountPanel = (DeleteAccountPanel) container.getComponent(2);
		ClientGUI clientGUI = (ClientGUI) SwingUtilities.getWindowAncestor(deleteAccountPanel);
		// clientGUI.setUser(new User(createAccountPanel.getUsername(),
		// createAccountPanel.getPassword()));
		CardLayout cardLayout = (CardLayout) container.getLayout();
		cardLayout.show(container, "4");
	}

	// Method that displays a message in the error label.
	public void displayError(String error) {
		DeleteAccountPanel deleteAccountPanel = (DeleteAccountPanel) container.getComponent(3);
		deleteAccountPanel.setError(error);
	}
}