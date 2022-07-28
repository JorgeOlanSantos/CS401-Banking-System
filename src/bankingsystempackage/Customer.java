package bankingsystempackage;

public class Customer extends User { // Class for banking system customer
	// Inherited attributes
	//	String name;                    // Customer name
	//	String ID;                      // Customer ID number
	//	Vector<ActionType> permissions; // Customer permissions
	//	Login login;                    // Login object
	
	private static final long serialVersionUID = 1L;
	// Class attributes
	String address;   // Customer's home address(?)
	short pin;        // Customer pin(?)
	boolean loggedIn; // Whether customer is logged into ATM/bank system(?)
	
	// Constructors
	
	public Customer(Login login, String name, short pin) { // Parameterized constructor
		
		super(name, login.getID(), login.getPassword()); // Sets customer name, ID, password
		
		//setName(name); // Set name ? 
		setPin(pin);   // Set pin ?
		
		// Set address also ?
	}
	
	// User constructor initialized
	public Customer(String name, String ID, String password, short pin, String address) { // Parameterized constructor
		
		super(name, ID, password); // Sets customer name, ID, password, login
		
		//setName(name);       // Set customer name ? 
		//setID(ID);           // Set customer ID
		//this.login = super.login(ID, password); // Initialize login object
		
		setPin(pin);         // Set customer pin ?
		setAddress(address); // Set customer address
		
	}
	
	// Getters
	
	public String getAddress() { // get customer address
		return address;
	}
	
	public short getPin() { // get customer pin
		return pin;
	}
	
	public boolean getLoggedIn() { // get customer loggedIn
		return loggedIn;
	}
	
	// Setters
	
	public void setAddress(String address) { // set customer address
		this.address = address;
	}
	
	public void setPin(short pin) { // set customer pin
		this.pin = pin;
	}
	
	public void setLoggedIn(boolean loggedIn) { // set customer loggedIn
		this.loggedIn = loggedIn;
	}
	
	// Inherited methods
	// Getters
	//	public String getName() { return name; } // get user name
	//	public String getID() { return ID; }     // get user ID
		
	// Setters
	//	public void setName(String name) { this.name = name; } // set user name
	//	public void setID(String ID) { this.ID = ID; }         // set user ID
	
	public String toString() {
		String output = "";
		output += "name:" + name + ", login:{" + login.toString() + "}, address:" + address + ", pin:" + pin;
		return output;
	}
}
