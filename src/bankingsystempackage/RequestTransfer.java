
@SuppressWarnings("serial")
public class RequestTransfer extends Request {
	double amount;
	String accountID1, accountID2;
	String description;
	
	RequestTransfer(double amount, String accountID1, String accountID2, String description) {
		this.type = RequestType.TRANSFER;
		this.amount = Math.abs(amount);
		this.accountID1 = accountID1;
		this.accountID2 = accountID2;
		this.description = description;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getAccountID1() {
		return accountID1;
	}
	
	public String getAccountID2() {
		return accountID2;
	}
	
	public String toString() {
		return "[" + date + "] " + type + " - amount:" + amount + ", accountID1:" + accountID1 + ", accountID2:" + accountID2 + ", description:" + description;
	}
}
