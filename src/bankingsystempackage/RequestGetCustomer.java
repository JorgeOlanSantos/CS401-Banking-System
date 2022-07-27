package bankingsystempackage;

@SuppressWarnings("serial")
public class RequestGetCustomer extends Request {
	private String customerID;
	private Customer customer;
	
	public RequestGetCustomer(String customerID) {
		type = RequestType.GETCUSTOMER;
		this.customerID = customerID;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String toString() {
		return "[" + date + "] " + type + " - " + status + " - customerID:" + customerID + ", customer:" + customer;
	}
}
