package testBankingSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bankingsystempackage.Account;
import bankingsystempackage.Customer;
import bankingsystempackage.RequestCreateAccount;
import bankingsystempackage.RequestCreateCustomer;

class RequestCreateCustomerTest {

	@Test
	void testCreateCustomer() {
		// Create new RequestCreateCustomer object with test unit
		Customer customer = null;
		RequestCreateCustomer testCustomer = new RequestCreateCustomer(customer);
		customer = testCustomer.getCustomer();
		assertEquals(customer,testCustomer.getCustomer()); //Check Create Customer request
	}

}
