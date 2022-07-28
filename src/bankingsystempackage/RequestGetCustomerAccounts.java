package bankingsystempackage;

import java.util.ArrayList;

// Request Accounts From Specific Customer

@SuppressWarnings("serial")
public class RequestGetCustomerAccounts extends Request {
	String customerID;
	ArrayList<Account> accounts;
	
	public RequestGetCustomerAccounts(String customerID) {
		type = RequestType.GETCUSTOMERACCOUNTS;
		this.customerID = customerID;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}
	
	public String toString() {
		return "[" + date + "] " + type + " - " + status + " - customerID:" + customerID + ", accounts:" + accounts;
	}
}
