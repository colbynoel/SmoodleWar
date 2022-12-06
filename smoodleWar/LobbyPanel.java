package smoodleWar;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class LobbyPanel extends JPanel {
	
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField passwordVerifyField;
	private JLabel errorLabel;

	

	// Setter for the error text.
	public void setError(String error) {
		errorLabel.setText(error);
	}

	// Constructor for the create account panel.
	public LobbyPanel(LobbyControl lobc) {

		// Create a panel for the labels at the top of the GUI.
		JPanel labelPanel = new JPanel(new GridLayout(3, 1, 5, 5));
		errorLabel = new JLabel("", JLabel.CENTER);
		errorLabel.setForeground(Color.RED);
		JLabel instructionLabel = new JLabel("Welcome to Smoodle War!", JLabel.CENTER);
		JLabel instructionLabel2 = new JLabel("Please choose to join a game or leave in shame and dishonor.", JLabel.CENTER);
		labelPanel.add(errorLabel);
		labelPanel.add(instructionLabel);
		labelPanel.add(instructionLabel2);

		// Create a panel for the account information form.
		JPanel accountPanel = new JPanel(new GridLayout(3, 2, 5, 5));
		JLabel usernameLabel = new JLabel("Username:", JLabel.RIGHT);
		usernameField = new JTextField(10);
		JLabel passwordLabel = new JLabel("Password:", JLabel.RIGHT);
		passwordField = new JPasswordField(10);
		JLabel passwordVerifyLabel = new JLabel("Verify Password:", JLabel.RIGHT);
		passwordVerifyField = new JPasswordField(10);
		accountPanel.add(usernameLabel);
		accountPanel.add(usernameField);
		accountPanel.add(passwordLabel);
		accountPanel.add(passwordField);
		accountPanel.add(passwordVerifyLabel);
		accountPanel.add(passwordVerifyField);

		// Create a panel for the buttons.
		JPanel buttonPanel = new JPanel();
		JButton submitButton = new JButton("Join a Game");
		submitButton.addActionListener(lobc);
		JButton cancelButton = new JButton("Logout");
		cancelButton.addActionListener(lobc);
		buttonPanel.add(submitButton);
		buttonPanel.add(cancelButton);

		// Arrange the three panels in a grid.
		JPanel grid = new JPanel(new GridLayout(3, 1, 0, 10));
		grid.add(labelPanel);
		grid.add(accountPanel);
		grid.add(buttonPanel);
		this.add(grid);
	}
}
