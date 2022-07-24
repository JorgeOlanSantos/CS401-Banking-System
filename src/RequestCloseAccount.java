
@SuppressWarnings("serial")
public class RequestCloseAccount extends Request {
	private String accountID;
	
	RequestCloseAccount(String accountID) {
		this.type = RequestType.CLOSEACCOUNT;
		this.accountID = accountID;
	}
	
	public String getAccountID() {
		return accountID;
	}
	
	public String toString() {
		return "[" + date + "] " + type + " - " + status + " - accountID:" + accountID;
	}
}
