import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		String input;
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
			
				ClientHandler clientSock = new ClientHandler(client);	
				
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

		// Constructor
		public ClientHandler(Socket socket)
		{
			this.clientSocket = socket;
		}

		public void run()
		{
			
			try {
				// input/output streams
				ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
				
				//Message clientMsg = new Message(), serverMsg = new Message();
				Request clientRequest;
				try {
					// get Messages from objectInputStream until a login is received
					while((clientRequest = (Request)objectInputStream.readObject()) != null) {
						
						switch (clientRequest.getType()) {
						case WITHDRAW:
							System.out.println(((RequestWithdraw)clientRequest).toString());
							break;
						case DEPOSIT:
							System.out.println(((RequestDeposit)clientRequest).toString());
							break;
						case TRANSFER:
							System.out.println(((RequestTransfer)clientRequest).toString());
							break;
						default:
							break;
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
