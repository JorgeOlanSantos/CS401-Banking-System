package testBankingSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bankingsystempackage.Login;
import bankingsystempackage.User;

class LoginTest {//Test Login class
	String testID = "ID";
	String testPassword = "Password";

	@Test
	void testConstructorLoginID() {
		// Create new User object with test input
		bankingsystempackage.Login login = new bankingsystempackage.Login(testID, testPassword);
		
		assertEquals(testID, login.getID()); // Check ID
	}
	@Test
	void testLoginPassword() {
		// Create new User object with test input
		bankingsystempackage.Login login = new bankingsystempackage.Login(testID, testPassword);
		
		assertEquals(testPassword, login.getPassword()); // Check Password
	}
	@Test
	void testLogintoString() {
		// Create new User object with test input
		//Login login = new Login( testID, testPassword);
		
		String LoginString = "ID: " + testID + ", password: " + testPassword;
		
		assertEquals(LoginString, LoginString.toString()); // Check toString
	}

}
