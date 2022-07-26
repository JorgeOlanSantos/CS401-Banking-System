package bankingsystempackage;

import java.util.Vector;

@SuppressWarnings("serial")
public class RequestLogin extends Request {
	private Login login;
	
	// used to return data back to the user
	private Customer customer;
	private Vector<Account> accounts;
	
	RequestLogin(Login login) {
		this.type = RequestType.LOGIN;
		this.login = login;
	}
	
	public Login getLogin() {
		return login;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void setAccounts(Vector<Account> accounts) {
		this.accounts = accounts;
	}
	
	public String toString() {
		return "[" + date + "] " + type + " - login:{" + login.toString() + "} - customer:{" + customer.toString() + "}, accounts:" + accounts;
	}
}
