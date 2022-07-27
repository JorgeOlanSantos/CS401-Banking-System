package bankingsystempackage;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	String name;                    // User name
	//String ID;                      // User ID number   - within login
	//Vector<ActionType> permissions; // User permissions - within login
	public Login login;             // Login object
	
	public User(String name, String ID, String password) { // Constructor
		setName(name);               // Set user name
		//setID(ID);                   // Set user ID
		this.login = new Login(ID, password); // Initialize user Login object with ID, password
	}
	
	// Getters
	
	public String getName() { // get user name
		return name;
	}
	
	public Login getLogin() {
		return login;
	}
	
	public String getID() { // get user ID
		return login.getID();
	}
	
	public String getPassword() { // get login password
		return login.getPassword();
	}
	
	public String getLoginString() { // get login String
		return login.toString();
	}
	
	// Setters
	
	public void setName(String name) { // set user name
		this.name = name;
	}
	
	// Should ID be able to be changed after being set?
	
	//public void setID(String ID) { // set user ID
		//login.ID = ID;
	//}
}
