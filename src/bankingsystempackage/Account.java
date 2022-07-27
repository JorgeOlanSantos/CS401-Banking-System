package bankingsystempackage;

import java.util.ArrayList;

public class Account {
	
	String accountID;
	double balance;
	ArrayList<String> customerIDS;

	
	public Account(String customerAcc, double customerBal)
	{
		accountID = customerAcc;
		balance = customerBal;
	}
	
	public Account(ArrayList<String> IDS, double amount)
	{
		customerIDS = IDS;
		this.balance = amount;
	}
	
	// Getter method for account ID.
	String getAccountID()
	{
		return accountID;
	}
	
	// Getter method for balance.
	double getBalance()
	{
		return balance;
	}
	
	// Getter method for Customers as a vector of type String.
	ArrayList<String> getCustomerIDS()
	{
		return customerIDS;
	}
	
	// Method should allow users to make a deposit.
	void deposit(double amount)
	{
		balance += amount;
	}
	
	// Method should allow users to make a withdraw
	boolean withdraw(double amount)
	{
		if (balance >= amount) {
			balance -= amount;
			return true;
		}
		return false;
	}
	
	// The purpose of this method is to add a customer to a pre-existing account.
	void addCustomerID(String customerID)
	{
		customerIDS.add(customerID);
	}
	
	
	// Method is designed to remove a customer from an account.
	boolean removeCustomer(String customerID)
	{
		boolean removedCustomer = customerIDS.remove(customerID);

		return removedCustomer;
	}
}
