package smoodleWar;

import javax.swing.JPanel;

public class LobbyControl {
	// Private data fields for the container and chat client.
	private JPanel container;
	private GameClient client;

	// Constructor for the login controller.
	public LobbyControl(JPanel container, GameClient client)
	{
		this.container = container;
		this.client = client;
	}
}
