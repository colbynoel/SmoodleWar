package smoodleWar;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class Database {
	private java.sql.Connection conn;

	public Database() throws SQLException {
		try {
			FileInputStream fis = new FileInputStream("smoodlewar/db.properties");
			Properties prop = new Properties();
			String user = "";
			String url = "";
			String password = "";

			try {
				prop.load(fis);
				user = prop.getProperty("user");
				url = prop.getProperty("url");
				password = prop.getProperty("password");
				conn = DriverManager.getConnection(url, user, password);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<String> query(String query) throws SQLException {
		// Add your code here
		ArrayList<String> list = new ArrayList<String>();
		String username = "";
		String password = "";
		// create a statement from the connection
		Statement statement = conn.createStatement();

		// Create Result Set
		ResultSet rs = statement.executeQuery(query);

		String row = new String();
		while (rs.next()) {
			username = rs.getString("username");
			password = rs.getString("password");
			row = username + ", " + password;
			list.add(row);
		}
		return list;

	}

	public void executeDML(String dml) throws SQLException {
		Statement statement = conn.createStatement();
		statement.executeUpdate(dml);
	}

	public boolean createNewAccount(String username, String password) {
		String dml = String.format(
				"insert into users(username, password, win) values ('%s', AES_ENCRYPT('%s', 'key'), %d)", username,
				password, 0);
		try {
			this.executeDML(dml);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean verifyAccount(String username, String password) {
		ArrayList<String> list = new ArrayList<String>();
		String[] row;
		try {
			list = this.query("SELECT username, aes_decrypt(password, \"key\") as password from users");
			for (int i = 0; i < list.size(); i++) {
				row = list.get(i).split(", ", 2);
				if (row[0].equals(username) && row[1].equals(password)) {
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}
	
	public void deleteAccount(String username, String password) {
		try {
			this.executeDML(String.format("delete from users where username = '%s' and AES_DECRYPT(password, 'key') = '%s'", username, password));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getPrompt() throws SQLException {
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("SELECT * FROM prompts");
		ArrayList<String> prompts = new ArrayList<String>();
		while(rs.next()) {
			prompts.add(rs.getString("prompt"));
		}
		return prompts;
	}

}
