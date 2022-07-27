package testBankingSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import bankingsystempackage.Account;
import bankingsystempackage.RequestGetCustomerAccounts;

class RequestGetCustomerAccountsTest {
	String testCustomerID;
	ArrayList<Account> accounts;
	
	@Test
	void testGetCustomerID() {
		// Create new RequestGetCustomerAccounts object with test input
		RequestGetCustomerAccounts getCustomer = new RequestGetCustomerAccounts(testCustomerID);
		assertEquals(testCustomerID, getCustomer.getCustomerID()); // Check customer ID
	}
	@Test
	void testGetAccounts() {
		// Create new RequestGetCustomerAccounts object with test input
		RequestGetCustomerAccounts getCustomer = new RequestGetCustomerAccounts(testCustomerID);
		assertEquals(accounts, getCustomer.getAccounts()); // Check customer accounts
	}


}
