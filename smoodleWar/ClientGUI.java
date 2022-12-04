package smoodleWar;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ClientGUI extends JFrame {

	// Constructor that creates the client GUI.
	public ClientGUI() {
		// Set up the chat client.
		GameClient client = new GameClient();
		client.setHost("localhost");
		client.setPort(8300);
		try {
			client.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Set the title and default close operation.
		this.setTitle("SmoodleWar!!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create the card layout container.
		CardLayout cardLayout = new CardLayout();
		JPanel container = new JPanel(cardLayout);

		// Create the Controllers next
		// Next, create the Controllers
		InitialControl ic = new InitialControl(container, client);
		LoginControl lc = new LoginControl(container, client);
		CreateAccountControl cac = new CreateAccountControl(container, client);
		DeleteAccountControl dac = new DeleteAccountControl(container, client);
		GameControl gc = new GameControl(container, client);
		LobbyControl lobc = new LobbyControl(container, client);

		// Set the client info
		client.setLoginControl(lc);
		client.setCreateAccountControl(cac);
		client.setDeleteAccountControl(dac);
		client.setGameControl(gc);

		// Create the four views. (need the controller to register with the Panels
		JPanel view1 = new InitialPanel(ic);
		JPanel view2 = new LoginPanel(lc);
		JPanel view3 = new CreateAccountPanel(cac);
		JPanel view4 = new DeleteAccountPanel(dac);
		JPanel view5 = new DrawingPanel(gc);
		JPanel view6 = new GuessingPanel(gc);
		JPanel view7 = new LobbyPanel(lobc);

		// Add the views to the card layout container.
		//Initial
		container.add(view1, "1");
		//Login
		container.add(view2, "2");
		//Create Account
		container.add(view3, "3");
		//Delete Account
		container.add(view4, "4");
		//Drawing Panel
		container.add(view5, "5");
		//Guessing Panel
		container.add(view6, "6");
		//Lobby Panel
		container.add(view7, "7");

		// Show the initial view in the card layout.
		cardLayout.show(container, "1");

		// Add the card layout container to the JFrame.
		// GridBagLayout makes the container stay centered in the window.
		this.setLayout(new GridBagLayout());
		this.add(container);

		// Show the JFrame.
		this.setSize(750, 650);
		this.setVisible(true);
	}

	// Main function that creates the client GUI when the program is started.
	public static void main(String[] args) {
		new ClientGUI();
	}
}
