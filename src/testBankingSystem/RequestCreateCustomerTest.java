package testBankingSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bankingsystempackage.Account;
import bankingsystempackage.Customer;
import bankingsystempackage.RequestCreateAccount;
import bankingsystempackage.RequestCreateCustomer;

class RequestCreateCustomerTest {
	private Customer testCustomer;
	@Test
	void testCreateCustomer() {
		// Create new RequestCreateCustomer object with test unit
		RequestCreateCustomer customer = new RequestCreateCustomer(testCustomer);
		assertEquals(testCustomer,customer.getCustomer()); //Check Create Customer request
	}

}
