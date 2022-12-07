package smoodleWar.Tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;

import smoodleWar.Database;

public class DatabaseTest {
	Database db;
	String[] users = {"cnoel", "bcavin", "dvarnell", "ianFields", "landon"};
	String[] passwords = {"something", "marksmith", "dakota", "password", "landon"};
	String[] prompts = {"alligator", "ball", "chicken", "city", "dog", "dolphin", "elephant", "fish",
						"flower", "pumpkin", "santa", "shark", "snowman", "tiger", "tree"};
	
	@Before
	public void setup() throws SQLException{
		 db = new Database();
	}
	
	@Test
	public void testQuery() {
		ArrayList<String> line = new ArrayList<String>();
		int random = ((int)Math.random() * users.length);
		
		String user = users[random];
		String expectedPassword = passwords[random];
		
		try {
			line = db.query(String.format("SELECT username, aes_decrypt(password, \"key\") as password from users where username = '%s'", user));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] row = line.get(0).split(", ", 2);	
		String password = row[1];

		assertEquals("Testing if password is equal to expected password", expectedPassword, password);
	}
	
	@Test
	public void testExecuteDML() {
		try {
			db.executeDML("insert into users(username, password) values ('notnoel1', AES_ENCRYPT('password', 'key'))");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			fail("Duplicate entry");
		}
	}
	
	//Have to test both methods together has junit doesn't do testing sequentially. 
	@Test
	public void testCreateNewAccountVerifyAccount() {
		if(!(db.createNewAccount("test", "test"))) {
			fail("Username or password already exists.");
		}
		
		if(!(db.verifyAccount("test", "test"))) {
			fail("Username or password does not exist.");
		}
	}
	
	
	
	@Test
	public void testGetPrompt() throws SQLException {
		ArrayList<String> promptsList = db.getPrompt();
		for(int i = 0; i < prompts.length; i++) {
			if(!(promptsList.get(i).equals(prompts[i]))) {
				fail("Expected prompts list is not what the actual prompt list is");
			}
		}
	}
	
	@Test
	public void testDeleteAccount() throws SQLException{
		if(!(db.deleteAccount("test", "test"))){
			fail("Cannot delete an account that doesn't exist");
		}
	}

}
