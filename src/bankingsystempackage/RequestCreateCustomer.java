package bankingsystempackage;

@SuppressWarnings("serial")
public class RequestCreateCustomer extends Request {

	private Customer customer;
	
	public RequestCreateCustomer(Customer customer) {
		type = RequestType.CREATECUSTOMER;
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
}
