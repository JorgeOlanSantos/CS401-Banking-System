import java.util.Vector;

// Request Accounts From Specific Customer

@SuppressWarnings("serial")
public class RequestGetCustomerAccounts extends Request {
	String customerID;
	Vector<Account> accounts;
	
	RequestGetCustomerAccounts(String customerID) {
		type = RequestType.GETCUSTOMERACCOUNTS;
		this.customerID = customerID;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	
	public Vector<Account> getAccounts() {
		return accounts;
	}
	
	public String toString() {
		return "[" + date + "] " + type + " - " + status + " - customerID:" + customerID + ", accounts:" + accounts;
	}
}
