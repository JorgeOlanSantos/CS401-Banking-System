
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
	
	public String getPassword() {
		return password;
	}
	
	// for testing
	public String toString() {
		return "ID:" + ID + ", password:" + password;
	}
}
