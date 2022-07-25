import java.util.Vector;

public class User {

	String name;                    // User name
	String ID;                      // User ID number
	Vector<ActionType> permissions; // User permissions
	
	// Getters
	
	public String getName() { // get user name
		return name;
	}
	
	public String getID() { // get user ID
		return ID;
	}
	
	// Setters
	
	public void setName(String name) { // set user name
		this.name = name;
	}
	
	public void setID(String ID) { // set user ID
		this.ID = ID;
	}



}
