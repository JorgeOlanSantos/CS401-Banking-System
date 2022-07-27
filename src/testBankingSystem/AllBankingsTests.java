package testBankingSystem; // Part of testBankingSystem package

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import bankingsystempackage.*;

@RunWith(Suite.class)

@SuiteClasses({
	UserTest.class, CustomerTest.class, LoginTest.class, TransactionTest.class
	})
public class AllBankingsTests {
}
