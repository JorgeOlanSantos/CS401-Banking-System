package bankingsystempackage;

import java.util.Date;

enum ActionType {
	DEPOSIT,
	TRANSFER,
	WITHDRAW
}

public class Action {
	private Date date;
	private String description;
	private double amount;
	private ActionType type;
	
	Action(ActionType type, double amount, String description) {
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

	public ActionType getType() {
		return type;
	}
	
}
