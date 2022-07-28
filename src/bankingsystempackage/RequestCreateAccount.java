package bankingsystempackage;

@SuppressWarnings("serial")
public class RequestCreateAccount extends Request {
	Account account;
	
	public RequestCreateAccount(Account account) {
		type = RequestType.CREATEACCOUNT;
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}
	
	public String toString() {
		return "[" + date + "] " + type + " - " + status + " - newCustomer:" + account.toString();
	}
}
