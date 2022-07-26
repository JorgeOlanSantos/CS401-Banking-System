
public class BankingSystem {

	Vector<Teller> tellers;
	Vector<Customer> customers;
	Vector<Account> accounts;
	
	
	// Getters
	// --------------------
	
	public Teller getTeller(Login login) {
		return null;
	}
	
	public Customer getCustomer(Login login) {
		return null;
	}
	
	public Vector<Teller> getTellers() {
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
			if (tellers.at(i).getLogin().verifyLogin(testLogin)) {
				return tellers.at(i);
			}
		}
		
		// check if testLogin is
		for (int i = 0; i < customers.size(); i++) {
			if (customers.at(i).getLogin().verifyLogin(testLogin)) {
				return customers.at(i);
			}
		}
		
		return null;
	}
	
	public void transfer(account1, account2, double amount) {	// need to decide if it would be better to just use accountID as the parameters
		
	}
	
}
