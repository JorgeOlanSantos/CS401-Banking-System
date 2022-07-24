
@SuppressWarnings("serial")
public class RequestCreateAccount extends Request {
	Customer newCustomer;
	
	RequestCreateAccount(Customer customer) {
		type = RequestType.CREATEACCOUNT;
		newCustomer = customer;
	}
	
	public Customer getCustomer() {
		return newCustomer;
	}
	
	public String toString() {
		return "[" + date + "] " + type + " - " + status + " - newCustomer:" + newCustomer.toString();
	}
}
