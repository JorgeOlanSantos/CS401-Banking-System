
public class Login {
	private String ID;
	private String password;
	
	Login(String ID, String password) {
		this.ID = ID;
		this.password = password;
	}
	
	public String getID() {
		return ID;
	}
	
	public String getPassword() { // get password
		return password;
	}
	
	public boolean verifyLogin(Login testLogin) { // To verify login
		return this.equals(testLogin);
	}
	
	// for testing
	public String toString() {
		return "ID: " + ID + ", password: " + password;
	}
}
