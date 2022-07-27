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

public class GetAmountGUI implements ActionListener{
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
	
	private int amount = 0;
	private String input = "";

	
	GetAmountGUI(){
		
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
	
	public double getAmount() {
		return amount;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
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
			amount = Integer.parseInt(input);
			pin.dispose();
			
		
		}

		
		
	}

}
