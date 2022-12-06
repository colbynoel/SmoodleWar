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
	private String username;
	private String role;

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
		
	}

	// Setter for the error text.
	public void setError(String error) {
		errorLabel.setText(error);
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

	// Constructor for the create account panel.
	public LobbyPanel(LobbyControl lobc) {

		
		// Create a panel for the labels at the top of the GUI.
		JPanel labelPanel = new JPanel(new GridLayout(3, 1, 5, 5));
		errorLabel = new JLabel("", JLabel.CENTER);
		errorLabel.setForeground(Color.RED);
		JLabel instructionLabel = new JLabel("Welcome to Smoodle War!", JLabel.CENTER);
		
		
		//JLabel instructionLabel = new JLabel(username, JLabel.CENTER);
		JLabel instructionLabel2 = new JLabel("Please choose to join a game or leave in shame and dishonor.", JLabel.CENTER);
		labelPanel.add(errorLabel);
		labelPanel.add(instructionLabel);
		labelPanel.add(instructionLabel2);

		// Create a panel for the account information form.
		JPanel accountPanel = new JPanel(new GridLayout(3, 2, 5, 5));
		JLabel usernameLabel = new JLabel("Welcome " + this.username, JLabel.CENTER);
//		
		accountPanel.add(usernameLabel);
//		

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
