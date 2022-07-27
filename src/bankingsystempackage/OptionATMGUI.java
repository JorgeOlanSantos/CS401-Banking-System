package bankingsystempackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class OptionATMGUI implements ActionListener{
	
	//----------------------MAIN GUI----------------------------
	private static JFrame frame = new JFrame();
	private static JButton withdrawal = new JButton("Withdrawal");
	private static JButton deposit = new JButton("Deposit");
	private static JButton transfer = new JButton("Transfer");
	private static JButton switchAcc = new JButton("Switch Accounts");
	private static JButton cancel = new JButton("Cancel");
	
	private static JPanel north = new JPanel();
	//private static JPanel south = new JPanel();
	private static JPanel east = new JPanel();
	private static JPanel west = new JPanel();
	//private static JPanel center = new JPanel();
	
	private static JLabel label1 = new JLabel();		//title
	private static JLabel label2 = new JLabel();		//current account
	private static JLabel label3 = new JLabel();		//money 
	private static JLabel label4 = new JLabel();
	
	JTextField userId;
	JPasswordField passText;
	
	
	//-----------------GetAmountGUI--------------------------
	private static JFrame pin = new JFrame();
	
	private static JLabel dispamount = new JLabel();
	private static JLabel money = new JLabel("$");
	
	private static JPanel top = new JPanel();
	private static JPanel buttons = new JPanel();
	
	private static JButton one = new JButton("1");
	private static JButton two = new JButton("2");
	private static JButton three = new JButton("3");
	private static JButton four = new JButton("4");
	private static JButton five = new JButton("5");
	private static JButton six = new JButton("6");
	private static JButton seven = new JButton("7");
	private static JButton eight = new JButton("8");
	private static JButton nine = new JButton("9");
	private static JButton zero = new JButton("0");
	private static JButton delete = new JButton("<-");
	private static JButton enter = new JButton("Enter");
	
	private int withdrawalA = 0;
	private int depositA = 0;
	private int transferA = 0;
	private int type = 0;
	
	private String input = "";
	
	
public OptionATMGUI(String name) {
		
		//set up buttons and there settings
		withdrawal.setBounds(100,70,300,70);
		withdrawal.setBackground(new Color(0x4cbfff));
		withdrawal.setForeground(Color.WHITE);
		withdrawal.setFont(new Font("Futura", Font.PLAIN, 25));
		withdrawal.setFocusable(false);
		withdrawal.addActionListener(this);
		
		deposit.setBounds(100,210,300,70);
		deposit.setBackground(new Color(0x4cbfff));
		deposit.setForeground(Color.WHITE);
		deposit.setFont(new Font("Futura", Font.PLAIN, 25));
		deposit.setFocusable(false);
		deposit.addActionListener(this);
		
		transfer.setBounds(100,350,300,70);
		transfer.setBackground(new Color(0x4cbfff));
		transfer.setForeground(Color.WHITE);
		transfer.setFont(new Font("Futura", Font.PLAIN, 25));
		transfer.setFocusable(false);
		transfer.addActionListener(this);
		
		switchAcc.setBounds(100,70,300,70);
		switchAcc.setBackground(new Color(0x4cbfff));
		switchAcc.setForeground(Color.WHITE);
		switchAcc.setFont(new Font("Futura", Font.PLAIN, 25));
		switchAcc.setFocusable(false);
		switchAcc.addActionListener(this);
		
		cancel.setBounds(100,350,300,70);
		cancel.setBackground(Color.RED);
		cancel.setForeground(Color.WHITE);
		cancel.setFont(new Font("Futura", Font.PLAIN, 25));
		cancel.setFocusable(false);
		cancel.addActionListener(this);

		
		//set up labels, settings, and messages they hold
		label1.setText("Welcome " + name);				//insert name here
		label1.setBounds(150,50,500,25);
		//label1.setForeground(new Color(0x00FF00))
		label1.setForeground(Color.white);
		label1.setFont(new Font("Futura", Font.BOLD, 40));
		
		label2.setText("Account #1");					//insert account 1 name and money amount here
		label2.setBounds(50,100,200,25);
		label2.setForeground(Color.white);
		label2.setFont(new Font("Futura", Font.BOLD, 15));
		
		label3.setText("Account #2");					//insert account 2 name and money amount here
		label3.setBounds(400,100,200,25);
		label3.setForeground(Color.white);
		label3.setFont(new Font("Futura", Font.BOLD, 15));
		
		//3rd account could go here 
		
		label4.setText("Current Account: ");
		label4.setBounds(50,50,200,25);
		label4.setForeground(Color.orange);
		label4.setFont(new Font("Futura ", Font.BOLD, 15));
		
		//frame
		frame.setSize(1000, 750); 					//sets frame size
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);  				//prevents frame from being resized 
		//frame.setUndecorated(true);   remove the title bar
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//exits program 
		//frame.getContentPane().setBackground(new Color(0x123456));
		
		//color panel for visual placement
		north.setBackground(new Color(0x123456));
		east.setBackground(new Color(0x006299));
		west.setBackground(new Color(0x006299));
		
		
		north.setPreferredSize(new Dimension(1000,250));
		east.setPreferredSize(new Dimension(500,625));
		west.setPreferredSize(new Dimension(500,625));
		
		north.setLayout(new BorderLayout());
		east.setLayout(null);
		west.setLayout(null);
		
		frame.add(north,BorderLayout.NORTH);
		frame.add(east,BorderLayout.EAST);
		frame.add(west,BorderLayout.WEST);
		
		
		
		//--------Top Panel--------------
											
		JPanel subn1 = new JPanel();							//create sub-panels
		//JPanel subn2 = new JPanel();							//create sub-panels
		//JPanel subn3 = new JPanel();							//create sub-panels
		
		subn1.setPreferredSize(new Dimension(1000,150));		//set dimensions of sub-panel
		//subn2.setPreferredSize(new Dimension(1000,50));
		//subn3.setPreferredSize(new Dimension(1000,50));
		
		subn1.setLayout(null);
		
		//color panel for visual placement
		//subn.setBackground(Color.pink);
		subn1.setBackground(new Color(0x123456));
		
		north.add(subn1,BorderLayout.SOUTH);		//add bottom sub-panel to top panel
		north.add(label1);			
		
		subn1.add(label2);
		subn1.add(label3);
		subn1.add(label4);
		
		//--------Left Panel--------------
		west.add(withdrawal);
		west.add(deposit);
		west.add(transfer);
		
		
		//--------Right Panel--------------
		
		east.add(switchAcc);
		east.add(cancel);

		
		frame.setVisible(true);	//makes frame visible
		
		
		
		
	}

public void GetAmountGUI(){
	
	//set up button
	zero.addActionListener(this);
	one.addActionListener(this);
	two.addActionListener(this);
	three.addActionListener(this);
	four.addActionListener(this);
	five.addActionListener(this);
	six.addActionListener(this);
	seven.addActionListener(this);
	eight.addActionListener(this);
	nine.addActionListener(this);
	delete.addActionListener(this);
	enter.addActionListener(this);
	
	//set up labels
	dispamount.setForeground(Color.BLACK);
	dispamount.setFont(new Font("Futura", Font.BOLD, 35));
	money.setForeground(Color.BLACK);
	money.setFont(new Font("Futura", Font.BOLD, 35));
	
	//set up panels
	top.setPreferredSize(new Dimension(400,150));
	top.setLayout(new BorderLayout());
	//top.setBackground(Color.GREEN);
	
	
	buttons.setPreferredSize(new Dimension(400,400));
	buttons.setLayout(new GridLayout(4,3));
	//buttons.setBackground(Color.RED);
	
	
	//set up frame 
	pin.setSize(400, 550); 					
	pin.setLayout(new BorderLayout());
	pin.setResizable(false);  								//prevents frame from being resized 
	pin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//exits program 
	
	//add elements to frame
	pin.add(buttons,BorderLayout.SOUTH);
	pin.add(top,BorderLayout.NORTH);
	
	
	//----------add elements to sub-panels--------------
	
	top.add(dispamount,BorderLayout.EAST);
	top.add(money,BorderLayout.WEST);
	buttons.add(one);
	buttons.add(two);
	buttons.add(three);
	buttons.add(four);
	buttons.add(five);
	buttons.add(six);
	buttons.add(seven);
	buttons.add(eight);
	buttons.add(nine);
	buttons.add(delete);
	buttons.add(zero);
	buttons.add(enter);
	
	pin.setVisible(true);	//makes frame visible
}







@Override
public void actionPerformed(ActionEvent e) {
	
	//----------------Main--------------------------
	if(e.getSource() == withdrawal) {
		GetAmountGUI();
		type = 1;

	}
	
	if(e.getSource() == deposit) {
		GetAmountGUI();
		type = 2;
	}

	if(e.getSource() == transfer) {
		GetAmountGUI();
		type = 3;
	}

	if(e.getSource() == switchAcc) {
	
	}
	
	if(e.getSource() == cancel) {
		System.out.print(withdrawalA);
		  System.exit(0);
	}
	
	//--------------GetAmountButton----------------
	
	if(e.getSource() == zero) {
		input = input + "0";
		dispamount.setText(input);
	}
	
	if(e.getSource() == one) {
		input = input + "1";
		dispamount.setText(input);
	}

	if(e.getSource() == two) {
		input = input + "2";
		dispamount.setText(input);
	}

	if(e.getSource() == three) {
		input = input + "3";
		dispamount.setText(input);
	}
	
	if(e.getSource() == four) {
		input = input + "4";
		dispamount.setText(input);
	}
	if(e.getSource() == five) {
		input = input + "5";
		dispamount.setText(input);
		
	}
	
	if(e.getSource() == six) {
		input = input + "6";
		dispamount.setText(input);
		
	}

	if(e.getSource() == seven) {
		input = input + "7";
		dispamount.setText(input);
	
	}

	if(e.getSource() == eight) {
		input = input + "8";
		dispamount.setText(input);
	
	}
	
	if(e.getSource() == nine) {
		input = input + "9";
		dispamount.setText(input);
		  
	}
	
	if(e.getSource() == delete) {
		input = input.substring(0, input.length() - 1);
		dispamount.setText(input);
		
	}

	if(e.getSource() == enter) {
		
		

		switch(type) {
		case 1: 
			withdrawalA = Integer.parseInt(input);
			break;
		case 2: 
			withdrawalA = Integer.parseInt(input);
			break;
		case 3:
			withdrawalA = Integer.parseInt(input);
			break;
		default: break;
			
		}
		
		pin.dispose();
		
	
	}
	
}
}
