package testBankingSystem;

import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;              // "No runnable methods" issue with test runner
import org.junit.Test;                            // To code @Test methods


import bankingsystempackage.Login;

public class LoginTest {//Test Login class
	String testID = "ID";
	String testPassword = "Password";

	@Test
	void testConstructorLoginID() {
		// Create new User object with test input
		Login login = new Login(testID, testPassword);
		
		assertEquals(testID, login.getID()); // Check ID
	}
	@Test
	void testLoginPassword() {
		// Create new User object with test input
		Login login = new Login(testID, testPassword);
		
		assertEquals(testPassword, login.getPassword()); // Check Password
	}
	@Test
	void testLoginToString() {
		// Create new User object with test input
		//Login login = new Login( testID, testPassword);
		
		String LoginString = "ID: " + testID + ", password: " + testPassword;
		
		assertEquals(LoginString, LoginString.toString()); // Check toString
	}

}
