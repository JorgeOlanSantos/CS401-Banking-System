package bankingsystempackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientATM {

	public static void main(String[] args) throws ClassNotFoundException {
	
		Scanner sc = new Scanner(System.in);
		String IP = "localhost", fullIP = "";
		int port = 7777;
		
		try (Socket socket = new Socket(IP, port)) {
			IP = socket.getInetAddress().getHostAddress().trim();
			fullIP = IP + ":" + port;
			
			System.out.println("[" + fullIP + "](connected): Successfully Connected");
			// input/output stream
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
	        //ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
	        
			objectOutputStream.writeObject(new RequestLogin(new Login("test", "test")));
			
			//
	        int option = 0; // Initialized to loop when receiving invalid option value
			do {
				boolean optionSelected = false;
				do {
					
					System.out.println("Options");
					System.out.println(" 1 - Withdraw");
					System.out.println(" 2 - Deposit");
					System.out.println(" 3 - Transfer");
					System.out.println(" 4 - Logout");
					//System.out.println("Select Option:");
					
					try {
						option = Integer.parseInt(sc.nextLine());
					}
					catch(Exception e) {
						System.out.println("Only enter numbers between 1 and 4.");
					}
					
					if (option >= 1 && option <= 3) {
						optionSelected = true;
					}
					
				} while (!optionSelected);
				
				
				
				double amount;
				switch(option) {
				case 1:
					System.out.print("Enter withdraw amount: ");
					amount = Double.parseDouble(sc.nextLine());
					RequestWithdraw withdraw = new RequestWithdraw(amount, "none", "test");
					objectOutputStream.writeObject(withdraw);
					break;
				case 2:
					System.out.print("Enter deposit amount: ");
					amount = Double.parseDouble(sc.nextLine());
					RequestDeposit deposit = new RequestDeposit(amount, "none", "test");
					objectOutputStream.writeObject(deposit);
					break;
				case 3:
					System.out.print("Enter transfer amount: ");
					amount = Double.parseDouble(sc.nextLine());
					System.out.print("Enter account name: ");
					String account = sc.nextLine();
					RequestTransfer transfer = new RequestTransfer(amount, account, "second account", "test");
					objectOutputStream.writeObject(transfer);
					break;
				case 4:
					/*
					clientMsg = new Message(input.equalsIgnoreCase("logout") ? input : "text", "sent", input);
					// send message
					objectOutputStream.writeObject(clientMsg);
					
					serverMsg = (Message)objectInputStream.readObject();
					
					if (serverMsg.getStatus().equals("success")) {
						System.out.println("[" + fullIP + "](" + serverMsg.getType() + "): " + serverMsg.getText());
					}
					*/
					System.out.print("Logging out.");           // Print feedback // Replace with GUI response
					RequestLogout logout = new RequestLogout(); // Create logout object
					objectOutputStream.writeObject(logout);     // Send logout object
					break;
				}
				
			} while (option != 4);
			sc.close();
			
			socket.close();
		}
		catch (IOException e) {
			System.out.println("ERROR: failed to connect to server");
		}

	}

}
