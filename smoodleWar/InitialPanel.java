package smoodleWar;

import java.awt.*;
import javax.swing.*;

//COPIED FROM LAB5OUT

public class InitialPanel extends JPanel {
	// Constructor for the initial panel.
	public InitialPanel(InitialControl ic) {
		// Create the controller.
		// InitialControl controller = new InitialControl(container);

		// Create the information label.
		JLabel label = new JLabel("Account Information", JLabel.CENTER);

		// Create the login button.
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(ic);
		JPanel loginButtonBuffer = new JPanel();
		loginButtonBuffer.add(loginButton);

		// Create the create account button.
		JButton createButton = new JButton("Create Account");
		createButton.addActionListener(ic);
		JPanel createButtonBuffer = new JPanel();
		createButtonBuffer.add(createButton);

		// Create the create account button.
		JButton deleteButton = new JButton("Delete Account");
		deleteButton.addActionListener(ic);
		JPanel deleteButtonBuffer = new JPanel();
		deleteButtonBuffer.add(deleteButton);

		// Arrange the components in a grid.
		JPanel grid = new JPanel(new GridLayout(3, 1, 5, 5));
		grid.add(label);
		grid.add(loginButtonBuffer);
		grid.add(createButtonBuffer);
		grid.add(deleteButtonBuffer);
		this.add(grid);
	}
}
