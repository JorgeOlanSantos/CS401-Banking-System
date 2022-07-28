package bankingsystempackage;

@SuppressWarnings("serial")
public class RequestLogout extends Request {
	
	public RequestLogout() {
		type = RequestType.LOGOUT;
	}
	
}
