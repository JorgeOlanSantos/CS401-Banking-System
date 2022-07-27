package testBankingSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import bankingsystempackage.Account;
import bankingsystempackage.Request;
import bankingsystempackage.RequestCloseAccount;
import bankingsystempackage.RequestCreateAccount;
import bankingsystempackage.RequestCreateCustomer;
import bankingsystempackage.RequestType;
import bankingsystempackage.Status;
import bankingsystempackage.Transaction;

class RequestTest {
	private RequestType testType;
	private Date testDate;
	private Status testStatus;

	@Test
	void testgetType() {
		// Create new Request object with test unit

		Request rq = new Request();
		assertEquals(testType, rq.getType()); //Get type
	}
	@Test
	void testgetDate() {
		// Create new Request object with test unit
		
		Request rq = new Request();
		testDate = rq.getDate();
		assertEquals(testDate, rq.getDate()); //Get date
	}
	@Test
	void testgetStatus() {
		// Create new Request object with test unit

		Request rq = new Request();
		testStatus = rq.getStatus();
		assertEquals("PENDING", testStatus); //Get status
	}
	@Test
	void testgetAccountID() {
		// Create new RequestCloseAccount object with test unit
		String accountID="";
		RequestCloseAccount rq = new RequestCloseAccount(accountID);
		accountID = rq.getAccountID();
		assertEquals(accountID, ""); //Check Close Account request
	}
	@Test
	void testCreateAccount() {
		// Create new RequestCreateAccount object with test unit
		Account account = null;
		RequestCreateAccount acc = new RequestCreateAccount(account);
		account = acc.getAccount();
		assertEquals(account,acc.getAccount()); //Check Create Account request
	}


}
