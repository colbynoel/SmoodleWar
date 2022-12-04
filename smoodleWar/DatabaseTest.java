package smoodleWar;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DatabaseTest {
	Database db;
	@Before
	public void setup() throws SQLException{
		 db = new Database();
	}
	
	public void testVerifyAccount() {
		if(!(db.verifyAccount("test", "test"))) {
			fail("Username or password does not exist.");
		}
		
	}

}
