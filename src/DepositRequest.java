import java.util.Date;

@SuppressWarnings("serial")
public class DepositRequest extends Request {
	double amount;
	
	
	DepositRequest(double amount, String description) {
		this.type = RequestType.DEPOSIT;
		this.date = new Date();
		this.amount = amount;
		this.description = description;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String toString() {
		return "[" + date + "] " + type + " - amount:" + amount + " - description:" + description + " TEST";
	}
}
