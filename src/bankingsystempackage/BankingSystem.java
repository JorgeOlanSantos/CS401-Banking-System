package bankingsystempackage;

import java.util.Vector;

public class BankingSystem {

	Vector<User> tellers;
	Vector<Customer> customers;
	Vector<Account> accounts;
	
	
	// Getters
	// --------------------
	
	public User getTeller(Login login) {
		return null;
	}
	
	public Customer getCustomer(Login login) {
		return null;
	}
	
	public Vector<User> getTellers() {
		return tellers;
	}
	
	public Vector<Customer> getCustomers() {
		return customers;
	}
	
	public Vector<Account> getAccounts() {
		return accounts;
	}
	
	
	// File Methods (Save/Read)
	// ----------
	
	public void readData() {
		
	}
	
	public void saveData() {
		
	}
	
	
	// Account/Customer Related Methods
	// --------------------
	public void createAccount() {
		
	}
	
	public void createCustomer() {
		
	}
	
	public void closeAccount() {
		
	}
	
	public void deleteCustomer() {
		
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
	
}
