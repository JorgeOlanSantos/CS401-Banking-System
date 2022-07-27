package bankingsystempackage;

import java.util.Date;

public class Transaction {
	private Date date;
	private String description;
	private double amount;
	private TransactionType type;
	
	Transaction(TransactionType type, double amount, String description) {
		date = new Date();
		this.description = description;
		this.amount = amount;
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public double getAmount() {
		return amount;
	}

	public TransactionType getType() {
		return type;
	}
	
}
