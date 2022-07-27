package testBankingSystem; // Part of testBankingSystem package

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

@SuiteClasses({
	UserTest.class, Customer.class
	})
public class AllBankingTests {
}
