package bankingsystempackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class BankTellerUserGUI implements ActionListener {
	JFrame frame = new JFrame();
	private static JButton login = new JButton("Login");
	private static JButton newCust = new JButton("New Customer");
	private static JButton signOut = new JButton("Sign Out");
	
	private static JPanel north = new JPanel();
	private static JPanel south = new JPanel();
	private static JPanel center = new JPanel();
	
	private static JLabel label1 = new JLabel();
	private static JLabel label2 = new JLabel();
	private static JLabel label3 = new JLabel();
	private static JLabel label4 = new JLabel();
	
	JTextField userId;
	JPasswordField passText;
	
	User currentUser;
	
	private Socket socket;
	private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;
	
	public BankTellerUserGUI(RequestLogin requestLogin) throws UnknownHostException, IOException{
		
		currentUser = requestLogin.getUser();
		
		//button set up: dimensions, placement, color
		login.setBounds(600,150,100,40);
		login.setFont(new Font("Futura", Font.BOLD, 15));
		login.setBackground(Color.LIGHT_GRAY);
		login.setForeground(Color.WHITE);
		login.setFocusable(false);
		login.addActionListener(this);
		
		newCust.setBounds(50,40,150,50);
		newCust.setBackground(Color.GREEN);
		newCust.setForeground(Color.WHITE);
		newCust.setFont(new Font("Futura", Font.BOLD, 15));
		newCust.setFocusable(false);
		newCust.addActionListener(this);
		
		signOut.setBounds(800,40,150,50);
		signOut.setBackground(Color.RED);
		signOut.setForeground(Color.WHITE);
		signOut.setFont(new Font("Futura", Font.BOLD, 15));
		signOut.setFocusable(false);
		signOut.addActionListener(this);
		
		//text fields 
		userId = new JTextField(20);
		userId.setBounds(200,90,300,25);
		
		passText = new JPasswordField();
		passText.setBounds(200,145,300,25);		
		
		
		//labels
		label1.setText("Welcome " + currentUser.getName());								//text
		label1.setHorizontalAlignment(JLabel.LEFT);			//placement within panel 
		label1.setVerticalAlignment(JLabel.CENTER);
		label1.setForeground(Color.white);
		label1.setFont(new Font("Futura", Font.BOLD, 50));
		
		label2.setText("Sign in Existing User");
		label2.setBounds(50,5,300,50);
		label2.setForeground(Color.white);
		label2.setFont(new Font("Futura", Font.PLAIN, 25));
		
		label3.setText("User ID:");
		label3.setBounds(115,90,80,25);
		label3.setForeground(Color.white);
		label3.setFont(new Font("Futura", Font.BOLD, 15));
		
		label4.setText("Password:");
		label4.setBounds(100,145,80,25);
		label4.setForeground(Color.white);
		label4.setFont(new Font("Futura", Font.BOLD, 15));
		
		//frame
		frame.setSize(1000, 750); 					//sets frame size
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);  				//prevents frame from being resized 
		frame.setUndecorated(true);   //remove the title bar
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//exits program 
		frame.setBackground(new Color(0x006299));
		
		//set color of background
		north.setBackground(new Color(0x123456));
		south.setBackground(new Color(0x006299));
		center.setBackground(new Color(0x006299));
		
		
		north.setPreferredSize(new Dimension(1000,125));
		south.setPreferredSize(new Dimension(1000,125));
		center.setPreferredSize(new Dimension(1000,500));
		
		frame.add(north,BorderLayout.NORTH);
		frame.add(south,BorderLayout.SOUTH);
		frame.add(center,BorderLayout.CENTER);
		
		north.setLayout(new BorderLayout());
		south.setLayout(null);
		center.setLayout(null);
		
		//add external labels and buttons; 1st layer
		north.add(label1);
		center.add(label2);
		south.add(newCust);
		south.add(signOut);
		
		
		//---------------subpanels----------------
		
		//create sub-panels
		JPanel subp = new JPanel();
		
		//set up panel
		subp.setBounds(50,50,750,250);
		subp.setBackground(new Color(0x4cbfff));
		subp.setLayout(null);
		center.add(subp);
	
		//add elements to subpanel
		subp.add(label3);
		subp.add(label4);
		subp.add(userId);
		subp.add(passText);
		subp.add(login);


		//---------------subpanels----------------
			 
		
		frame.setVisible(true);	//makes frame visible
		
		
		//-----------------socket-----------------
		socket = new Socket("localhost", 7777);
		objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
	    objectInputStream = new ObjectInputStream(socket.getInputStream());
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login) {
			String id = userId.getText();
			String password = passText.getText();
			Login login = new Login(id, password);
			
			//removes userId and password after pressing login button
			userId.setText("");		
			passText.setText("");			
			
			Request request = new RequestLogin(login);
			try {
				objectOutputStream.writeObject(request);
				RequestLogin response = (RequestLogin)objectInputStream.readObject();
				if (response.getStatus() == Status.SUCCESS) {
					if (response.getUser() instanceof Customer) {
						frame.dispose();
						System.out.println(((RequestLogin)response).getUser().getName());
						OptionATMGUI usersignin = new OptionATMGUI(response);
						socket.close();
					} else {
						JOptionPane.showMessageDialog(
			                    null, 
			                    "Login Failed", 
			                    "The user ID or password is incorrect. This is easily corrected by typing the correct user name and password.", 
			                    JOptionPane.ERROR_MESSAGE);
					}
				}
			} catch (IOException | ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		if(e.getSource() == newCust) {
			
		}
		
		if(e.getSource() == signOut) {
			System.exit(0);
		}

	
		
	}
	

}
