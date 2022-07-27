package testBankingSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import bankingsystempackage.Transaction;
import bankingsystempackage.TransactionType;

public class TransactionTest {
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
		Date testDate = new Date(); // Get Date as soon as test runs for accuracy
		
		Transaction tr = new Transaction( testType, testAmount, testDescription);
		assertEquals(testDate, tr.getDate());

	}
}
