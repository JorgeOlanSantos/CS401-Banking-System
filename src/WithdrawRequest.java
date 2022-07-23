import java.util.Date;

@SuppressWarnings("serial")
public class WithdrawRequest extends Request {
	double amount;
	
	
	WithdrawRequest(double amount, String description) {
		this.type = RequestType.WITHDRAW;
		this.date = new Date();
		this.amount = amount;
		this.description = description;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String toString() {
		return "[" + date + "] " + type + " - amount:" + amount + " - description:" + description;
	}
}
