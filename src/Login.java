
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
	
	public boolean verifyLogin(Login testLogin) {
		return this.equals(testLogin);
	}
	
	// for testing
	public String toString() {
		return "ID:" + ID + ", password:" + password;
	}
}
