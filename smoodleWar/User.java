package smoodleWar;

import java.io.Serializable;

public class User{
	// Private data fields for the username and password.
	private String username;
	private int winCount;
	private String password;
	private String id;

	// Getters for the username and password.
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public int getWinCount() {
		return winCount;
	}
	
	public String getId() {
		return id;
	}

	// Setters for the username and password.
	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	// Constructor that initializes the username and password.
	public User(String username, String password, int winCount, String id) {
		setUsername(username);
		setPassword(password);
		setWinCount(winCount);
		setId(id);
	}
}