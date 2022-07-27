package bankingsystempackage;

@SuppressWarnings("serial")
public class RequestRemoveCustomer extends Request {
	String customerID;
	
	RequestRemoveCustomer(String ID) {
		type = RequestType.REMOVECUSTOMER;
		customerID = ID;
	}
	
	public String getCustomerID() {
		return customerID;
	}
	
	public String toString() {
		return "[" + date + "] " + type + " - customerID:" + customerID ;
	}
}
