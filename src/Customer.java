import java.util.Vector;

public class Customer extends User { // Class for banking system customer
	// Inherited attributes
//	String name;                    // Customer name
//	String ID;                      // Customer ID number
//	Vector<ActionType> permissions; // Customer permissions
	
	// Class attributes
	String address;   // Customer's address(?)
	short pin;        // Customer pin(?)
	boolean loggedIn; // Whether customer is logged into ATM/bank system(?)
	
	// Constructors
	
	public Customer(Login login, String name, short pin) { // Parameterized constructor
		
		// Do something with Login object (for logging in as customer?)
		setName(name); // Set name ? 
		setPin(pin);   // Set pin ?
	}
	
	public Customer(String ID, String password, String name, short pin) { // Parameterized constructor
		
		setID(ID);     // Set ID ? // Use in Login object?
		                           // Use password in Login object?
		
		setName(name); // Set name ? 
		setPin(pin);   // Set pin ?
	}
	
	// Getters
	
	public String getAddress() { // get customer address
		return address;
	}
	
	public short getPin() { // get customer pin
		return pin;
	}
	
	public boolean getloggedIn() { // get customer loggedIn
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
}
