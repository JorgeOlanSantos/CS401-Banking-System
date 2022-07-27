package bankingsystempackage;

import java.io.Serializable;

public class Login implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ID;
	private String password;
	private User user;
	
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
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean verifyLogin(Login testLogin) { // To verify login
		return this.equals(testLogin);
	}
	
	// for testing
	public String toString() {
		return "ID: " + ID + ", password: " + password;
	}
}
