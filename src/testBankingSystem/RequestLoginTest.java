package testBankingSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import bankingsystempackage.Account;
import bankingsystempackage.Login;
import bankingsystempackage.RequestLogin;
import bankingsystempackage.User;

class RequestLoginTest {

	private Login testLogin;
	private User testUser;
	private ArrayList<Account> testAccounts;
	
	@Test
	void testGetLogin() {
		// Create new User object with test input
		RequestLogin login = new RequestLogin(testLogin);
		assertEquals(testLogin, login.getLogin()); // Check login
	}

	@Test
	void testGetStatus() {
		// Create new User object with test input
		RequestLogin login = new RequestLogin(testLogin);
		assertEquals(testUser, login.getUser()); // Check login
	}
}
