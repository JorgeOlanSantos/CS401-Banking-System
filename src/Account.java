import java.util.Vector;
import java.util.Scanner;
import java.util.*;
import java.math.*;

public class Account extends Customer {
	
	String accountID;
	double balance;

	
	public Account(String customerAcc, double customerBal)
	{
		accountID = customerAcc;
		balance = customerBal;
	}
	
	public Account(Vector<Customer> thisVector, double thisBalance)
	{
		Vector<Customer> currVector = thisVector;
		balance = thisBalance;
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
	Vector<String> getCustomers()
	{
		Vector mainVector = new Vector();
		return mainVector;
	}
	
	// Method should allow users to make a deposit.
	void deposit(double balance)
	{
	
		double depositAmount = 0;															// Initializing input deposit to zero.
		double currBalance = balance;														// Setting the temporary balance to the inserted balance.
		
		Scanner sc = new Scanner(System.in);												// Scanner declaration.
		
		System.out.println("Enter an amount to deposit: ");									// Output for user input.
		depositAmount = sc.nextDouble();													// Read in input.
		
		currBalance = Math.round(currBalance * 100.00) / 100.00;							// Variable rounding.
		depositAmount = Math.round(depositAmount * 100.00) / 100.00;						// Variable rounding.
		
		balance = currBalance + depositAmount;	
		sc.close();																			// Closing scanner
	}
	
	// Method should allow users to make a withdraw
	boolean withdraw(double balance)
	{
		
		double withdrawAmount = 0;															// Initializing input withdraw to zero.											
		double currBalance = balance;														// Setting the temporary balance to the inserted balance.
		
		Scanner sc = new Scanner(System.in);												// Scanner declaration.
		
		System.out.println("Enter an amount to withdraw: ");								// Output for user input.
		withdrawAmount = sc.nextDouble();													// Read in input.
		
		withdrawAmount = Math.round(withdrawAmount * 100.00) / 100.00;						// Variable rounding.
		currBalance = Math.round(currBalance * 100.00) / 100.00;							// Variable rounding.
		sc.close();																			// Closing scanner.
		
		// If/else cases to test if the withdraw amount is greater than the current balance.
		if(withdrawAmount > currBalance)
		{
			System.out.println("Error. Withdraw amount cannot exceed you current balance.");
			return false;
		}
		// Case to test if the withdraw amount exceeds a withdraw limit.
		else if(withdrawAmount > 500.00) 
		{
			System.out.println("Error. Withdraw amount cannont exceed the withdraw limit.");
			return false;
		}
		// Case if withdraw amount is somehow in the negatives.
		else if(withdrawAmount < 0.00)
		{
			System.out.println("Error. Invalid request.");
			return false;
		}
		else
		{
			// Changes to main balance occurs.
			balance = currBalance - withdrawAmount;
			return true;
		}
	}
	
	// The purpose of this method is to add a customer to a pre-existing account.
	void addCustomer(Vector<Customer> mainVector)
	{
		
		String name;																		// String variable declaration.
		boolean isAdded = false;															// Boolean variable declaration.
		
		Vector tempVector = new Vector();													// Temporary vector declaration.
		tempVector = mainVector;															// Setting the temporary vector to the main vector.
		
		Scanner sc = new Scanner(System.in);												// Scanner declaration.
		
		System.out.println("Please insert name of customer you wish to add: ");				// System outputs a prompt for the user.
		name = sc.nextLine();																// name takes in user input.
		name.toUpperCase();																	// The name gets upper cased.
		
		// For loop steps through the vector and searches for if the inputed name matches any names already in the vector.
		for(int i = 0; i < mainVector.size(); i++)
		{
			// If statement to catch if the inputed name already exists.
			if(name.equals(tempVector.get(i)))												
			{
				
				System.out.println("Error. This customer already exsists in the account.\n");
				break;
				
			}
			
		}
		
		tempVector.add(name);																// Add the inputed name to the vector.
		isAdded = true;																		// Setting the boolean variable to true.
		
		mainVector = tempVector;															// Setting the main vector to the updated vector.
		
	}
	
	
	// Method is designed to remove a customer from an account.
	void removeCustomer(Vector<Customer> mainVector)
	{
		
		String text;																		// String variable declaration.
		boolean isRemoved = false;															// Boolean variable to keep track of removal status.
		
		Vector tempVector = new Vector();													// Temporary vector declaration.
		tempVector = mainVector;															// Setting temporary vector equal to the main vector.
	
		Scanner sc= new Scanner(System.in);													// Scanner declaration.
		
		System.out.println("Please insert name of customer you wish to remove: ");			// System outputs a prompt for the user.
		text = sc.nextLine();																// Scanner reads in user input.
		text.toUpperCase();																	// Set input to all upper case.
		
		// For loop to trace through the vector and search for what the user input.
		for(int i = 0; i < mainVector.size(); i++)
		{
			
			if(text.equals(tempVector.get(i)))												// Case user input is found in the vector.
			{
				tempVector.remove(i);														// Remove the element that matched user input.
				mainVector = tempVector;													// Setting the main vector to the new temporary vector.
				isRemoved = true;															// Set the boolean variable to true.
				
			}
		}
		
		// If/else statement to output whether the removal of a customer was a success or not.
		if(isRemoved)
		{
			System.out.println("Successful removal of customer: " + text);					// System output of successful removal.
		}
		else
		{
			System.out.println("Error. Customer not found.\n");								// System output of unsuccessful removal.
		}
		
	}
}
