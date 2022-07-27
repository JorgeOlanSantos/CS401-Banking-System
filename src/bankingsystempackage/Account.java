package bankingsystempackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String accountID;
	private double balance;
	private ArrayList<String> customerIDS;
	private ArrayList<Action> history;

	public Account() {
		accountID = null;
		balance = 0;
		customerIDS = null;
		history = null;
	}
	
	public Account(String accountID, ArrayList<String> IDS, double balance)
	{
		this.accountID = accountID;
		this.balance = balance;
		//Collections.copy(customerIDS, IDS);
		customerIDS = IDS;
		this.history = new ArrayList<Action>();
	}
	
	// Getter method for account ID.
	public String getAccountID()
	{
		return accountID;
	}
	
	// Getter method for balance.
	public double getBalance()
	{
		return balance;
	}
	
	public ArrayList<Action> getHistory() {
		return history;
	}
	
	// Getter method for Customers as a vector of type String.
	public ArrayList<String> getCustomerIDS()
	{
		return customerIDS;
	}
	
	// Method should allow users to make a deposit.
	public void deposit(double amount)
	{
		balance += amount;
	}
	
	// Method should allow users to make a withdraw
	public boolean withdraw(double amount)
	{
		if (balance >= amount) {
			balance -= amount;
			return true;
		}
		return false;
	}
	
	// The purpose of this method is to add a customer to a pre-existing account.
	public void addCustomerID(String customerID)
	{
		customerIDS.add(customerID);
	}
	
	public void addHistory(Action newAction) {
		history.add(newAction);
	}
	
	// Method is designed to remove a customer from an account.
	public boolean removeCustomer(String customerID)
	{
		boolean removedCustomer = customerIDS.remove(customerID);

		return removedCustomer;
	}
}
