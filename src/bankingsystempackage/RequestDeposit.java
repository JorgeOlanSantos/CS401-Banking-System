package bankingsystempackage;

@SuppressWarnings("serial")
public class RequestDeposit extends Request {
	double amount;
	String accountID;
	String description;
	
	public RequestDeposit(double amount, String accountID, String description) {
		this.type = RequestType.DEPOSIT;
		this.amount = Math.abs(amount);
		this.accountID = accountID;
		this.description = description;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getAccountID() {
		return accountID;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String toString() {
		return "[" + date + "] " + type + " - " + status + " - amount:" + amount + ", accountID:" + accountID + ", description:" + description;
	}
}
