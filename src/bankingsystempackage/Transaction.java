package bankingsystempackage;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date date;
	private String description;
	private double amount;
	private TransactionType type;
	
	public Transaction(TransactionType type, double amount, String description) {
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
