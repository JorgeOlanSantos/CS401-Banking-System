package testBankingSystem; // Package all test cases together?

import static org.junit.jupiter.api.Assertions.*; // To use assertions
//import org.junit.jupiter.api.Test;              // "No runnable methods" issue with test runner
import org.junit.Test;                            // To code @Test methods


import bankingsystempackage.*;

public class UserTest { // Test Customer class
	// Test input
	String testName = "Name";
	String testID = "ID";
	String testPassword = "Password";
	
	@Test
	public void testConstructorName() {
		// Create new User object with test input
		bankingsystempackage.User user = new bankingsystempackage.User(testName, testID, testPassword);
		
		assertEquals(testName, user.getName()); // Check name
	}
	
	@Test
	public void testConstructorLoginID() {
		// Create new User object with test input
		bankingsystempackage.User user = new bankingsystempackage.User(testName, testID, testPassword);
		
		assertEquals(testID, user.getID()); // Check ID
	}
	
	@Test
	public void testConstructorLoginPassword() {
		// Create new User object with test input
		bankingsystempackage.User user = new bankingsystempackage.User(testName, testID, testPassword);
		
		assertEquals(testPassword, user.getPassword()); // Check password
	}
	
	@Test
	public void testConstructorLoginToString() {
		// Create new User object with test input
		User user = new User(testName, testID, testPassword);
		
		String LoginString = "ID: " + testID + ", password: " + testPassword;
		
		assertEquals(LoginString, user.getLoginString()); // Check password
	}
}
