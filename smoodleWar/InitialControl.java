package smoodleWar;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//COPIED FROM LAB5OUT

public class InitialControl implements ActionListener {
	// Private data field for storing the container.
	private JPanel container;
	private GameClient client;

	// Constructor for the initial controller.
	public InitialControl(JPanel container, GameClient client)
	{
		this.container = container;
		this.client = client;
	}

	// Handle button clicks.
	public void actionPerformed(ActionEvent ae) {
		// Get the name of the button clicked.
		String command = ae.getActionCommand();

		// The Login button takes the user to the login panel.
		if (command.equals("Login")) {
			LoginPanel loginPanel = (LoginPanel) container.getComponent(1);
			loginPanel.setError("");
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "2");

		}

		// The Create button takes the user to the create account panel.
		else if (command.equals("Create Account")) {
			CreateAccountPanel createAccountPanel = (CreateAccountPanel) container.getComponent(2);
			createAccountPanel.setError("");
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "3");
		}

		// The Delete button takes the user to the delete account panel.
		else if (command.equals("Delete Account")) {
			DeleteAccountPanel deleteAccountPanel = (DeleteAccountPanel) container.getComponent(3);
			deleteAccountPanel.setError("");
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "4");
		}
	}
}
