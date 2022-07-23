import java.util.Date;

@SuppressWarnings("serial")
public class TransferRequest extends Request {
	double amount;
	String account;
	
	
	TransferRequest(double amount, String account, String description) {
		this.type = RequestType.TRANSFER;
		this.date = new Date();
		this.amount = amount;
		this.account = account;
		this.description = description;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getAccount() {
		return account;
	}
	
	public String toString() {
		return "[" + date + "] " + type + " - amount:" + amount + ", account:" + account + ", description:" + description;
	}
}
