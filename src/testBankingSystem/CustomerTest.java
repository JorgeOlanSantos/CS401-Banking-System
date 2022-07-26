//package testBankingSystem; // Package all test cases together?

import static org.junit.jupiter.api.Assertions.*; // To use assertions
import org.junit.jupiter.api.Test;                // To code @Test methods

class CustomerTest { // Test Customer class
	// Test input
	String testName = "Name";
	String testID = "ID";
	String testPassword = "Password";
	short testPin = 1234;
	String testAddress = "Address";
	boolean testLoggedIn = true;
	
	@Test
	void testConstructorName() {
		// Create new Customer object with test input
		Customer customer = new Customer(testName, testID, testPassword, testPin, testAddress);
		
		assertEquals(testName, customer.getName()); // Check name
	}
	
	@Test
	void testConstructorID() {
		// Create new Customer object with test input
		Customer customer = new Customer(testName, testID, testPassword, testPin, testAddress);
		
		assertEquals(testID, customer.getID()); // Check ID
	}
	
	@Test
	void testConstructorPassword() {
		// Create new Customer object with test input
		Customer customer = new Customer(testName, testID, testPassword, testPin, testAddress);
		
		assertEquals(testPassword, customer.getPassword()); // Check password
	}
	
	@Test
	void testConstructorPin() {
		// Create new Customer object with test input
		Customer customer = new Customer(testName, testID, testPassword, testPin, testAddress);
		
		assertEquals(testPin, customer.getPin()); // Check password
	}
	
	@Test
	void testConstructorAddress() {
		// Create new Customer object with test input
		Customer customer = new Customer(testName, testID, testPassword, testPin, testAddress);
		
		assertEquals(testAddress, customer.getAddress()); // Check password
	}
	
	@Test
	void testConstructorLoggedIn() {
		// Create new Customer object with test input
		Customer customer = new Customer(testName, testID, testPassword, testPin, testAddress);
		
		customer.setLoggedIn(true); // Set loggedIn
		
		assertEquals(testLoggedIn, customer.getLoggedIn()); // Check password
	}
}
