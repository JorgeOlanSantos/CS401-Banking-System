package bankingsystempackage;

@SuppressWarnings("serial")
public class RequestTransfer extends Request {
	private double amount;
	private String accountID1, accountID2;
	private String description;
	private Account account1, account2;
	
	public RequestTransfer(double amount, String accountID1, String accountID2, String description) {
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
	
	public Account getAccount1() {
		return account1;
	}
	
	public Account getAccount2() {
		return account2;
	}
	
	public void setAccount1(Account account) {
		account1 = account;
	}
	
	public void setAccount2(Account account) {
		account2 = account;
	}
	
	public String toString() {
		return "[" + date + "] " + type + " - amount:" + amount + ", accountID1:" + accountID1 + ", accountID2:" + accountID2 + ", description:" + description;
	}
}
