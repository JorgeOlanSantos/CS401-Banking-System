package testBankingSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import bankingsystempackage.Transaction;
import bankingsystempackage.TransactionType;

class TransactionTest {
	Date testDate = new Date();
	String testDescription = "Description";
	double testAmount = 0;
	TransactionType testType;
	@Test
	void testGetDescription() {
		Transaction tr = new Transaction( testType, testAmount, testDescription);
		assertEquals(testDescription, tr.getDescription());

	}
	@Test
	void testGetAmount() {
		Transaction tr = new Transaction( testType, testAmount, testDescription);
		assertEquals(testAmount, tr.getAmount());

	}
	
	@Test
	void testGetType() {
		Transaction tr = new Transaction( testType, testAmount, testDescription);
		assertEquals(testType, tr.getType());

	}
	
	@Test
	void testGetDate() {
		Transaction tr = new Transaction( testType, testAmount, testDescription);
		assertEquals(testDate, tr.getDate());

	}
}
