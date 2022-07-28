package testBankingSystem;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import bankingsystempackage.Login;
import bankingsystempackage.RequestCreateCustomer;
import bankingsystempackage.RequestDeposit;

class RequestDepositTest {
	double testAmount;
	String testAccountID;
	String testDescription;
	
	@Test
	void testGetAmount() {
		// Create new RequestDeposit object with test unit
		RequestDeposit dp = new RequestDeposit(testAmount,testAccountID,testDescription);
		assertEquals(testAmount,dp.getAmount()); //get the amount variable
	}
	
	@Test
	void testGetAccountID() {
		// Create new RequestDeposit object with test unit
		RequestDeposit dp = new RequestDeposit(testAmount,testAccountID,testDescription);
		assertEquals(testAccountID,dp.getAccountID()); //get the accountID variable
	}
	
	@Test
	void testGetDescription() {
		// Create new RequestDeposit object with test unit
		RequestDeposit dp = new RequestDeposit(testAmount,testAccountID,testDescription);
		assertEquals(testDescription,dp.getDescription()); //get the description variable
	}
	@Test
	public void testRequestDepositToString() {
		// Create new User object with test input
		RequestDeposit dp = new RequestDeposit(testAmount,testAccountID,testDescription);
		
		String DepositString =  " amount:" + testAmount + ", accountID:" + testAccountID + ", description:" + testDescription;
		
		assertEquals(DepositString, dp.toString()); // Check toString
	}
}
