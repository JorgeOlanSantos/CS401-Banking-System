package testBankingSystem; // Part of testBankingSystem package

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class BankingTestRunner {
	public static void main(String[] args) {
		System.out.println("Running BankingTestRunner");
		
		Result result = JUnitCore.runClasses(AllBankingTests.class);

		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}

		System.out.println("If all tests succeeded: " + result.wasSuccessful());
	}
}

