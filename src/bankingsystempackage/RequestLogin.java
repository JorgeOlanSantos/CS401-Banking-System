package bankingsystempackage;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class RequestLogin extends Request {
	private Login login;
	
	// used to return data back to the user
	private User user;
	private ArrayList<Account> accounts;
	
	public RequestLogin(Login login) {
		this.type = RequestType.LOGIN;
		this.login = login;
		user = null;
		accounts = new ArrayList<Account>();
	}
	
	public Login getLogin() {
		return login;
	}
	
	public User getUser() {
		return user;
	}
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void addAccount(Account newAccount) {
		accounts.add(newAccount);
	}
	
	public String toString() {
		return "[" + date + "] " + type + " - login:{" + login.toString() + "} - customer:{" + user.toString() + "}, accounts:" + accounts;
	}
}
