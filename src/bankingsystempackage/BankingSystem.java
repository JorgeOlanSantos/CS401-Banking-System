package bankingsystempackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.EOFException;

public class BankingSystem {

	ArrayList<User> tellers;
	ArrayList<Customer> customers;
	ArrayList<Account> accounts;
	
	BankingSystem() {
		tellers = new ArrayList<User>();
		customers = new ArrayList<Customer>();
		accounts = new ArrayList<Account>();
		
		customers.add(new Customer("Example User", "exampleuser", "password", (short)1234, "1234 Fake Road"));
	}
	
	// Getters
	// --------------------
	
	public User getTeller(Login login) {
		return null;
	}
	
	public Customer getCustomer(Login login) {
		return null;
	}
	
	public ArrayList<User> getTellers() {
		return tellers;
	}
	
	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	public ArrayList<Account> getAccounts() {
		return accounts;
	}
	
	
	// File Methods (Save/Read)
	// ----------
	
	@SuppressWarnings("unchecked")
	public void readData() throws EOFException {
		try {
			FileInputStream fileInputStream = new FileInputStream(new File("CustomerData.txt"));
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			
			customers = (ArrayList<Customer>) inputStream.readObject();
			
			/*
			Customer customer = null;
			while ((customer = (Customer) inputStream.readObject()) != null) {
				System.out.println(customer.toString());
				customers.add(customer);
			}
			*/
			
			fileInputStream.close();
			inputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveData() {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(new File("CustomerData.txt"));
			ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
			
			outputStream.writeObject(customers);
			
			fileOutputStream.close();
			outputStream.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// Account/Customer Related Methods
	// --------------------
	public void createAccount() {
		
	}
	
	public void createCustomer() {
		
	}
	
	public void closeAccount() {
		
	}
	
	public void deleteCustomer() {
		
	}
	
	
	// Request Methods
	
	public User login(Login testLogin) {
		// check if testLogin is a teller
		for (int i = 0; i < tellers.size(); i++) {
			if (tellers.get(i).getLogin().verifyLogin(testLogin)) {
				return tellers.get(i);
			}
		}
		
		// check if testLogin is a customer
		for (int i = 0; i < customers.size(); i++) {
			if (customers.get(i).getLogin().verifyLogin(testLogin)) {
				return customers.get(i);
			}
		}
		
		return null;
	}
	
	// to string methods
	
	public String customersToString() {
		String output = "";
		
		for (int i = 0; i < customers.size(); i++) {
			output += "customer[" + i + "] - " + customers.get(i).toString() + "\n";
		}
		
		return output;
	}
	
}
