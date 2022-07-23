import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws ClassNotFoundException {
	
		Scanner sc = new Scanner(System.in);
		String input = "", IP = "localhost", fullIP = "";
		int port = 7777;
		
		/*
		System.out.print("Enter server IP (enter nothing for localhost): ");
		IP = sc.nextLine();
		if (IP.equals("")) {
			IP = "localhost";
		}
		System.out.print("Enter server port (enter nothing for 7777): ");
		input = sc.nextLine();
		if (input.equals("")) {
			port = 7777;
		} else {
			port = Integer.parseInt(input);
		}
		*/
		
		try (Socket socket = new Socket(IP, port)) {
			IP = socket.getInetAddress().getHostAddress().trim();
			fullIP = IP + ":" + port;
			
			System.out.println("[" + fullIP + "](connected): Successfully Connected");
			// input/output stream
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
	        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
	        
	        // messages
	        Message clientMsg = new Message(), serverMsg = new Message();
	        
	        // this is where you would have the user do something like input username/password,
	        // as an example I am just having the user enter 'login'
	        /*
	        do {
	        	System.out.print("Enter \'login\' to login: ");
	        	input = sc.nextLine();
	        } while (!input.equalsIgnoreCase("login"));
	        */
	        
	        
			// login message
			//clientMsg = new Message("login", "sent", "login message");
			//System.out.println("Senging Logging Request To Server...");
			
			// send login message
			//objectOutputStream.writeObject(clientMsg);
			
			//
			do {
				int option;
				boolean optionSelected = false;
				do {
					
					System.out.println("Options");
					System.out.println(" 1 - Withdraw");
					System.out.println(" 2 - Deposit");
					System.out.println(" 3 - Transfer");
					System.out.println(" 4 - Logout");
					//System.out.println("Select Option:");
					
					option = Integer.parseInt(sc.nextLine());
					
					if (option >= 1 && option <= 3) {
						optionSelected = true;
					}
					
				} while (!optionSelected);
				
				
				
				double amount;
				switch(option) {
				case 1:
					System.out.print("Enter withdraw amount: ");
					amount = Double.parseDouble(sc.nextLine());
					WithdrawRequest withdraw = new WithdrawRequest(amount, "test");
					objectOutputStream.writeObject(withdraw);
					break;
				case 2:
					System.out.print("Enter deposit amount: ");
					amount = Double.parseDouble(sc.nextLine());
					DepositRequest deposit = new DepositRequest(amount, "test");
					objectOutputStream.writeObject(deposit);
					break;
				case 3:
					System.out.print("Enter transfer amount: ");
					amount = Double.parseDouble(sc.nextLine());
					System.out.print("Enter account name: ");
					String account = sc.nextLine();
					TransferRequest transfer = new TransferRequest(amount, account, "test");
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
					break;
				}
				
			} while (!(serverMsg.getType().equals("logout") && serverMsg.getStatus().equals("success")));
			sc.close();
			
			socket.close();
		}
		catch (IOException e) {
			System.out.println("ERROR: failed to connect to server");
		}

	}

}
