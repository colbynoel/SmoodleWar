package smoodleWar;

import java.io.Serializable;

//COPIED FROM LAB5OUT

public class CreateAccountData implements Serializable {
	// Private data fields for the username and password.
	private String username;
	private String password;
	private String verifiedPassword;

	// Getters for the username and password.
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getVerifiedPassword() {
		return verifiedPassword;
	}

	// Setters for the username and password.
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setVerifiedPassword(String verifiedPassword) {
		this.verifiedPassword = verifiedPassword;
	}

	// Constructor that initializes the username and password.
	public CreateAccountData(String username, String password, String verifiedPassword) {
		setUsername(username);
		setPassword(password);
		setVerifiedPassword(verifiedPassword);
	}
}
