import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

public class BankingSystem {

	Vector<Teller> tellers;
	Vector<Customer> customers;
	Vector<Account> accounts;
	
	
	// Getters
	// --------------------
	
	public Teller getTeller(Login login) {
		return null;
	}
	
	public Customer getCustomer(Login login) {
		return null;
	}
	
	public Vector<Teller> getTellers() {
		return tellers;
	}
	
	public Vector<Customer> getCustomers() {
		return customers;
	}
	
	public Vector<Account> getAccounts() {
		return accounts;
	}
	
	
	// File Methods (Save/Read)
	// ----------
	
	public void readData() {
		//Load the contents of the text file
//		 Server base = new Server();
//		
//		try {
//			ObjectInputStream input = new ObjectInputStream(new FileInputStream("placeholder.txt"));
//			base = (Server) input.readObject();
//			input.close();
//		} catch(Exception e) {
//			
//		}
	}
	
	public void saveData() {
//		try {
//			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("database.txt"));
//			Object base;
//			output.writeObject(base);
//			output.flush();
//			output.close();
//			JOptionPane.showMessageDialog(null, "Saved!");
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
	}
	
	
	// Account/Customer Related Methods
	// --------------------
	public void createAccount() {
		//Account newAccount = new Account(accounts);
//		Vector<Account> accounts = new Account();
//		accounts.addCustomerID();
	}
	
	public void createCustomer() {
//		Vector<Customer> customer = new Customer();
		
	}
	
	public void closeAccount() {
//		Vector<Account>accounts.removeCustomer();
	}
	
	public void deleteCustomer() {
//		Vector<Customer>customers = new Customer();
//		customers.removeCustomer();
	}
	
	
	// Request Methods
	
	public User login(Login testLogin) {
		// check if testLogin is a teller
		for (int i = 0; i < tellers.size(); i++) {
			if (tellers.at(i).getLogin().verifyLogin(testLogin)) {
				return tellers.at(i);
			}
		}
		
		// check if testLogin is
		for (int i = 0; i < customers.size(); i++) {
			if (customers.at(i).getLogin().verifyLogin(testLogin)) {
				return customers.at(i);
			}
		}
		
		return null;
	}
	
	
}
