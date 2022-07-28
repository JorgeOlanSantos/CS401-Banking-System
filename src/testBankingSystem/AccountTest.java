package testBankingSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import bankingsystempackage.Transaction;
import bankingsystempackage.Account;

public class AccountTest {
	private String testAccountID;
	private double testBalance;
	private ArrayList<String> testCustomerIDS;
	private ArrayList<Transaction> testHistory;


	@Test
	public void testGetAccountID() {
		// Create new Account object with test unit
		Account acc = new Account( testAccountID, testCustomerIDS, testBalance);
		assertEquals(testAccountID, acc.getAccountID()); //Get Account ID
	}
	
	@Test
	public void testGetBalance() {
		// Create new Account object with test unit

		Account acc = new Account( testAccountID, testCustomerIDS, testBalance);
		assertEquals(testBalance, acc.getBalance()); //Get Account Balance
	}
	
	@Test
	public void testGetHistory() {
		// Create new Account object with test unit

		Account acc = new Account( testAccountID, testCustomerIDS, testBalance);
		assertEquals(testHistory, acc.getHistory()); //Get Account History
	}
	
	@Test
	public void testGetCustomerIDS() {
		// Create new Account object with test unit

		Account acc = new Account( testAccountID, testCustomerIDS, testBalance);
		assertEquals(testCustomerIDS, acc.getCustomerIDS()); //Get Account ID
	}
	
	@Test
	public void testDeposit() {
		// Create new Account object with test unit

		Account acc = new Account( testAccountID, testCustomerIDS, testBalance);
		acc.deposit(testBalance);
		double testAmount = testBalance;
		assertEquals(testBalance, 0); //Check deposit amount
	}
	
	@Test
	public void testWithdraw() {
		// Create new Account object with test unit

		Account acc = new Account( testAccountID, testCustomerIDS, testBalance);
		acc.withdraw(testBalance);
		double testAmount = testBalance;
		assertEquals(testBalance, 0); //Check withdraw amount
	}
	
	@Test
	public void testAddCustomerID() {
		// Create new Account object with test unit

		String customerID = "ID";
		Account acc = new Account( testAccountID, testCustomerIDS, testBalance);
		acc.addCustomerID(customerID);
		testCustomerIDS.add(customerID);
		assertEquals(testCustomerIDS, "ID"); //Get Customer ID
	}
	
	@Test
	public void testRemoveCustomer() {
		// Create new Account object with test unit

		String customerID = "ID";
		Account acc = new Account( testAccountID, testCustomerIDS, testBalance);
		acc.removeCustomer(customerID);
		testCustomerIDS.remove(customerID);
		assertEquals(acc, false); //Remove Customer
	}
}
