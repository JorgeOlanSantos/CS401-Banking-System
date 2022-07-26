package bankingsystempackage;

@SuppressWarnings("serial")
public class RequestGetAccount extends Request {
	private String accountID;
	private Account account;
	
	RequestGetAccount(String accountID) {
		type = RequestType.GETACCOUNT;
		this.accountID = accountID;
		account = null;
	}
	
	public String getAccountID() {
		return accountID;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public String toString() {
		return "[" + date + "] " + type + " - " + status + " - accountID:" + accountID + ", account:" + account.toString();
	}
}
