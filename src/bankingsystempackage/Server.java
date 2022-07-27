package bankingsystempackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class Server {

	public static void main(String[] args) throws IOException {
		
		BankingSystem bankingSystem = new BankingSystem();
		bankingSystem.dummyData();
		bankingSystem.saveData();
		bankingSystem.readData();
		//System.out.println(bankingSystem.customersToString());
		
		//Scanner sc = new Scanner(System.in);
		//String input;
		int port = 7777;
		/*
		System.out.print("Enter server port (enter nothing for 7777): ");
		input = sc.nextLine();
		if (input.equals("")) {
			port = 7777;
		} else {
			port = Integer.parseInt(input);
		}
		sc.close();
		*/
		
		System.out.println("Starting Server...");
		ServerSocket ss = new ServerSocket(port);
		System.out.println("Server Address: " + InetAddress.getLocalHost().getHostAddress().trim() + ":" + port);
		System.out.println("Awaiting Connections...\n");
		
		try {
			ss.setReuseAddress(true);
			
			while (true) {
				Socket client = ss.accept();
				
				// output client connected
				//System.out.println("[" + client.getInetAddress().getHostAddress() + "](connected)");
				System.out.println("[" + client.getInetAddress().getHostAddress().trim() + "](connected)");
			
				ClientHandler clientSock = new ClientHandler(client, bankingSystem);	
				
				new Thread(clientSock).start();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		finally {
			if (ss != null) {
				try {
					ss.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static class ClientHandler implements Runnable {
		private final Socket clientSocket;
		private BankingSystem bankingSystem;

		// Constructor
		public ClientHandler(Socket socket, BankingSystem bankingSystem)
		{
			this.clientSocket = socket;
			this.bankingSystem = bankingSystem;
		}

		public void run()
		{
			
			try {
				// input/output streams
				ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
				
				User currentUser;
				
				//Message clientMsg = new Message(), serverMsg = new Message();
				Request clientRequest, serverResponse;
				try {
					// get Messages from objectInputStream until a login is received
					while((clientRequest = (Request)objectInputStream.readObject()) != null) {
						
						if (clientRequest.getType() == RequestType.LOGIN) {
							serverResponse = clientRequest;
							
							// verify login
							currentUser = bankingSystem.login(((RequestLogin)clientRequest).getLogin());
							((RequestLogin)serverResponse).setUser(currentUser);
							
							// if login is valid continue
							//	user is result after verifying login
							//	user may be customer or teller
							/*
							if (currentUser == null) {
								serverResponse.setStatus(Status.FAIL);
								objectOutputStream.writeObject(serverResponse);
							} else {
							*/
							if (true) {
								serverResponse.setStatus(Status.SUCCESS);
								if (currentUser instanceof Customer) {
									((RequestLogin)serverResponse).setAccounts(bankingSystem.getCustomerAccounts(currentUser.getID()));
								}
								objectOutputStream.writeObject(serverResponse);
								System.out.println("test");
								
								// loop for Requests once login is valid
								while((clientRequest = (Request)objectInputStream.readObject()) != null) {
									serverResponse = clientRequest;
									
									String accountID;
									double amount;
									String description;
									boolean statusResult = false;
									switch(clientRequest.getType()) {
									
									case CLOSEACCOUNT:
										statusResult = bankingSystem.closeAccount(((RequestCloseAccount)clientRequest).getAccountID());
										break;
										
									case CREATEACCOUNT:
										statusResult = bankingSystem.createAccount(((RequestCreateAccount)clientRequest).getAccount());
										break;
										
									case CREATECUSTOMER:
										statusResult = bankingSystem.createCustomer(((RequestCreateCustomer)clientRequest).getCustomer());
										break;
										
									case DEPOSIT:
										accountID = ((RequestDeposit)clientRequest).getAccountID();
										amount = ((RequestDeposit)clientRequest).getAmount();
										description = ((RequestDeposit)clientRequest).getDescription();
										statusResult = bankingSystem.deposit(accountID, amount);
										if (statusResult) {
											bankingSystem.addHistoryToAccount(accountID, new Action(ActionType.DEPOSIT, amount, description));
										}
										break;
										
									case GETACCOUNT:
										Account tempAccount = bankingSystem.getAccount(((RequestGetAccount)clientRequest).getAccountID());
										if (tempAccount != null) {
											((RequestGetAccount)serverResponse).setAccount(tempAccount);
											statusResult = true;
										}
										break;
										
									case GETCUSTOMER:
										Customer tempCustomer = bankingSystem.getCustomer(((RequestGetCustomer)clientRequest).getCustomerID());
										if (tempCustomer != null) {
											((RequestGetCustomer)serverResponse).setCustomer(tempCustomer);
											statusResult = true;
										}
										break;
										
									case GETCUSTOMERACCOUNTS:
										ArrayList<Account> tempAccounts = bankingSystem.getCustomerAccounts(((RequestGetCustomerAccounts)clientRequest).getCustomerID());
										if (tempAccounts.size() > 0) {
											((RequestGetCustomerAccounts)clientRequest).setAccounts(tempAccounts);
											statusResult = false;
										}
										break;
										
									case LOGOUT:
										statusResult = true;
										break;
										
									case REMOVECUSTOMER:
										statusResult = bankingSystem.removeCustomer(((RequestRemoveCustomer)clientRequest).getCustomerID());
										break;
										
									case TRANSFER:
										String accountID1 = ((RequestTransfer)clientRequest).getAccountID1();
										String accountID2 = ((RequestTransfer)clientRequest).getAccountID2();
										description = ((RequestWithdraw)clientRequest).getDescription();
										amount = ((RequestTransfer)clientRequest).getAmount();
										statusResult = bankingSystem.transfer(accountID1, accountID2, amount);
										if (statusResult) {
											bankingSystem.addHistoryToAccount(accountID1, 
													new Action(ActionType.TRANSFER, -1 * Math.abs(amount), description));
											bankingSystem.addHistoryToAccount(accountID2, 
													new Action(ActionType.TRANSFER, Math.abs(amount), description));
										}
										break;
										
									case WITHDRAW:
										accountID = ((RequestWithdraw)clientRequest).getAccountID();
										amount = ((RequestWithdraw)clientRequest).getAmount();
										description = ((RequestWithdraw)clientRequest).getDescription();
										statusResult = bankingSystem.withdraw(accountID, amount);
										if (statusResult) {
											bankingSystem.addHistoryToAccount(accountID, new Action(ActionType.WITHDRAW, amount, description));
										}
										break;
										
									default:
										break;
									}
									if (statusResult) {
										serverResponse.setStatus(Status.SUCCESS);
									} else {
										serverResponse.setStatus(Status.FAIL);
									}
									objectOutputStream.writeObject(serverResponse);
									
									if ((clientRequest.getType() == RequestType.LOGOUT) && (statusResult == true)) {
										break;
									}
								}
							}
						}
						
					} 
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						if (objectOutputStream != null) {
							objectOutputStream.close();
						}
						if (objectInputStream != null) {
							objectInputStream.close();
							clientSocket.close();
						}
					}
					catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
