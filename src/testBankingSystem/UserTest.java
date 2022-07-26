package testBankingSystem; // Package all test cases together?

import static org.junit.jupiter.api.Assertions.*; // To use assertions
import org.junit.jupiter.api.Test;                // To code @Test methods

import bankingsystempackage.*;

class UserTest { // Test Customer class
	// Test input
	String testName = "Name";
	String testID = "ID";
	String testPassword = "Password";
	
	@Test
	void testConstructorName() {
		// Create new User object with test input
		bankingsystempackage.User user = new bankingsystempackage.User(testName, testID, testPassword);
		
		assertEquals(testName, user.getName()); // Check name
	}
	
	@Test
	void testConstructorLoginID() {
		// Create new User object with test input
		bankingsystempackage.User user = new bankingsystempackage.User(testName, testID, testPassword);
		
		assertEquals(testID, user.getID()); // Check ID
	}
	
	@Test
	void testConstructorLoginPassword() {
		// Create new User object with test input
		bankingsystempackage.User user = new bankingsystempackage.User(testName, testID, testPassword);
		
		assertEquals(testPassword, user.getPassword()); // Check password
	}
	
	@Test
	void testConstructorLogintoString() {
		// Create new User object with test input
		User user = new User(testName, testID, testPassword);
		
		String LoginString = "ID: " + testID + ", password: " + testPassword;
		
		assertEquals(LoginString, user.getLoginString()); // Check password
	}
}
