package bankingsystempackage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {

	public static void main(String[] args) throws IOException {
		
		BankingSystem bankingSystem = null;
		
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
							
							// if login is valid continue
							//	user is result after verifying login
							//	user may be customer or teller
							if (currentUser == null) {
								serverResponse.setStatus(Status.FAIL);
								objectOutputStream.writeObject(serverResponse);
							} else {
								serverResponse.setStatus(Status.SUCCESS);
								objectOutputStream.writeObject(serverResponse);
								
								// loop for Requests once login is valid
								while((clientRequest = (Request)objectInputStream.readObject()) != null) {
									serverResponse = clientRequest;
									switch(clientRequest.getType()) {
									case CLOSEACCOUNT:
										//(RequestCloseAccount)clientRequest;
										break;
									case CREATEACCOUNT:
										
										break;
									case CREATECUSTOMER:
										
										break;
									case DEPOSIT:
										
										break;
									case GETACCOUNT:
										
										break;
									case GETCUSTOMER:
										
										break;
									case GETCUSTOMERACCOUNTS:
										
										break;
									case LOGOUT:
										
										break;
									case REMOVECUSTOMER:
										
										break;
									case TRANSFER:
										
										break;
									case WITHDRAW:
										
										break;
									default:
										serverResponse.setStatus(Status.FAIL);
										break;
									}
									objectOutputStream.writeObject(serverResponse);
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
