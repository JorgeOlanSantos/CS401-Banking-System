package bankingsystempackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.EOFException;

public class BankingSystem {

	ArrayList<User> tellers;
	ArrayList<Customer> customers;
	ArrayList<Account> accounts;
	
	public BankingSystem() {
		tellers = new ArrayList<User>();
		customers = new ArrayList<Customer>();
		accounts = new ArrayList<Account>();
	}
	
	// Fills tellers, customers, and accounts with dummy data for initial testing
	public void dummyData() {
		tellers = new ArrayList<User>();
		customers = new ArrayList<Customer>();
		accounts = new ArrayList<Account>();
		
		customers.add(new Customer("Example User", "exampleuser", "password", (short)1234, "1234 Fake Road"));
		customers.add(new Customer("John Doe", "johnD56", "password", (short)7833, "4699 New York Avenue"));
		customers.add(new Customer("Thomas Jones", "racecarTom234", "password", (short)9573, "4480 Lyon Avenue"));
		customers.add(new Customer("Ana Brown", "Ana042banana", "password", (short)2364, "1541 Brookside Drive"));
		
		tellers.add(new User("Example Teller", "exampleteller", "password"));
		
		ArrayList<String> tempIDList = new ArrayList<String>();
		tempIDList.add(customers.get(0).getID());
		tempIDList.add(customers.get(1).getID());
		
		accounts.add(new Account("exampleaccount", tempIDList, 3456));
	}
	
	// Getters
	// --------------------
	
	// Finds and returns teller with given login ID if they exist
	public User getTeller(Login login) {
		// Search tellers array
		for(User teller : tellers) {
			if(teller.getID() == login.getID()) {
				return teller;
			}
		}
		
		return null;
	}
	
	// Finds and returns customer with given login ID if they exist
	public Customer getCustomer(Login login) {
		// Search customers array
		for(Customer customer : customers) {
			if(customer.getID() == login.getID()) {
				return customer;
			}
		}
		
		return null;
	}
	
	public ArrayList<User> getTellers() {
		return tellers;
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	public ArrayList<Account> getCustomerAccounts(String customerID) {
		ArrayList<Account> customerAccounts = new ArrayList<Account>();
		
		for (int i = 0; i < customerAccounts.size(); i++) {
			if (customerAccounts.get(i).getCustomerIDS().contains(customerID)) {
				customerAccounts.add(customerAccounts.get(i));
			}
		}
		
		return customerAccounts;
	}
	
	
	// File Methods (Save/Read)
	// ----------
	
	@SuppressWarnings("unchecked")
	public void readData() throws EOFException {
		try {
			// read from customer file
			FileInputStream fileInputStream = new FileInputStream(new File("CustomerData.txt"));
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			customers = (ArrayList<Customer>) inputStream.readObject();
			fileInputStream.close();
			inputStream.close();
			
			// read from teller file
			fileInputStream = new FileInputStream(new File("TellerData.txt"));
			inputStream = new ObjectInputStream(fileInputStream);
			tellers = (ArrayList<User>) inputStream.readObject();
			fileInputStream.close();
			inputStream.close();
			
			// Read from account file
			fileInputStream = new FileInputStream(new File("AccountData.txt"));
			inputStream = new ObjectInputStream(fileInputStream);
			accounts = (ArrayList<Account>) inputStream.readObject();
			fileInputStream.close();
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveData() {
		try {
			// save customer file
			FileOutputStream fileOutputStream = new FileOutputStream(new File("CustomerData.txt"));
			ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
			outputStream.writeObject(customers);
			fileOutputStream.close();
			outputStream.close();
			
			// save teller file
			fileOutputStream = new FileOutputStream(new File("TellerData.txt"));
			outputStream = new ObjectOutputStream(fileOutputStream);
			outputStream.writeObject(tellers);
			fileOutputStream.close();
			outputStream.close();
			
			// save account file
			fileOutputStream = new FileOutputStream(new File("AccountData.txt"));
			outputStream = new ObjectOutputStream(fileOutputStream);
			outputStream.writeObject(accounts);
			fileOutputStream.close();
			outputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// Account/Customer Related Methods
	// --------------------
	public boolean createAccount(Account newAccount) {
		
		accounts.add(newAccount);
		
		return true;
	}
	
	public boolean createCustomer(Customer newCustomer) {
		customers.add(newCustomer);
		
		return true;
	}
	
	public boolean addCustomerToAccount(String customerID, Account account) {
		try {
			// Add customer to account if it exists
			account.addCustomerID(customerID);
			
			return true;
		}
		catch(Exception e) {
			// Account does not exist
			
			return false;
		}
	}
	
	public boolean closeAccount(String accountID) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountID().equals(accountID)) {
				
				// First withdraw or transfer remaining balance
				
				// Delete account instead of just removing?
				// Account acct = accounts.get(i);
				// accounts.remove(i);
				// acct = null
				
				accounts.remove(i); // Remove found account
				
				return true;
			}
		}
		return false;
	}
	
	// Removes customer from bank system
	public boolean removeCustomer(String customerID) {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().equals(customerID)) {
				
				// Remove customer's ID from their accounts
				
				// Close customer's non-joint accounts first
				
				customers.remove(i); // Remove found customer
				return true;
			}
		}
		return false;
	}
	
	public boolean removeCustomerFromAccount(String customerID, Account account) {
		try {
			// Remove customer from account if it exists
			account.removeCustomer(customerID);
			
			return true;
		}
		catch(Exception e) {
			// Account does not exist
			
			return false;
		}
	}
	
	// Request Methods
	
	public User login(Login testLogin) {
		// check if testLogin is a teller
		for (int i = 0; i < tellers.size(); i++) {
			if (tellers.get(i).getLogin().verifyLogin(testLogin)) {
				return tellers.get(i);
			}
		}
		
		// check if testLogin is a customer
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getLogin().verifyLogin(testLogin)) {
				return customers.get(i);
			}
		}
		
		return null;
	}
	
	public boolean deposit(String accountID, double amount) {
		amount = Math.abs(amount);
		
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountID().equals(accountID)) {
				accounts.get(i).deposit(amount);
				return true;
			}
		}
		return false;
	}
	
	// Finds and returns teller with given ID if they exist
	public Account getAccount(String accountID) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountID().equals(accountID)) {
				return accounts.get(i);
			}
		}
		return null;
	}
	
	// Finds and returns customer with given ID if they exist
	public Customer getCustomer(String accountID) {
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getID().equals(accountID)) {
				return customers.get(i);
			}
		}
		return null;
	}
	
	public boolean transfer(String firstID, String secondID, double amount) {
		amount = Math.abs(amount);
		
		int firstIDpos = -1, secondIDpos = -1;
		for (int i = 0; i < accounts.size() && ((firstIDpos == -1) || secondIDpos == -1); i++) {
			if (accounts.get(i).getAccountID().equals(firstID)) {
				firstIDpos = i;
				if (accounts.get(i).getBalance() < amount) {
					return false;
				}
			}
			if (accounts.get(i).getAccountID().equals(secondID)) {
				secondIDpos = i;
			}
		}
		
		if ((firstIDpos >= 0) && (secondIDpos >= 0)) {
			accounts.get(firstIDpos).withdraw(amount);
			accounts.get(secondIDpos).deposit(amount);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean withdraw(String accountID, double amount) {
		amount = Math.abs(amount);
		
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountID().equals(accountID)) {
				accounts.get(i).withdraw(amount);
				return true;
			}
		}
		return false;
	}
	
	// other methods
	
	public boolean addHistoryToAccount(String accountID, Transaction action) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getAccountID().equals(accountID)) {
				accounts.get(i).addHistory(action);
				return true;
			}
		}
		return false;
	}
	
	public String customersToString() {
		String output = "";
		
		for (int i = 0; i < customers.size(); i++) {
			output += "customer[" + i + "] - " + customers.get(i).toString() + "\n";
		}
		
		return output;
	}	
}
