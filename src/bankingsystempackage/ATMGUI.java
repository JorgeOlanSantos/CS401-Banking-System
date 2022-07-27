import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ATMGUI implements ActionListener {
	JFrame frame = new JFrame();
	private static JButton login = new JButton("Login");
	
	private static JPanel north = new JPanel();
	private static JPanel south = new JPanel();
	private static JPanel east = new JPanel();
	private static JPanel west = new JPanel();
	private static JPanel center = new JPanel();
	
	private static JLabel label1 = new JLabel();
	private static JLabel label2 = new JLabel();
	private static JLabel label3 = new JLabel();
	
	JTextField userId;
	JPasswordField passText;
	
	ATMGUI(){
		
		//button
		login.setBounds(115,200,65,25);
		login.setFocusable(false);
		login.addActionListener(this);
		
		//text fields 
		userId = new JTextField(20);
		userId.setBounds(15,90,165,25);
		
		passText = new JPasswordField();
		passText.setBounds(15,145,165,25);		
		
		
		//labels
		label1.setText("ATM");								//text
		label1.setHorizontalAlignment(JLabel.CENTER);		//placement within panel 
		label1.setVerticalAlignment(JLabel.BOTTOM);
		label1.setForeground(Color.white);
		label1.setFont(new Font("Futura", Font.BOLD, 60));

		
		label2.setText("ID:");
		label2.setFont(new Font("Futura", Font.BOLD, 12));
		label2.setForeground(Color.white);
		label2.setBounds(175,90,80,25);
		
		label3.setText("Password:");
		label3.setFont(new Font("Futura", Font.BOLD, 12));
		label3.setForeground(Color.white);
		label3.setBounds(130,145,80,25);
		
		//frame
		frame.setSize(1000, 750); 					//sets frame size
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);  				//prevents frame from being resized 
		//frame.setUndecorated(true);   remove the title bar
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//exits program 
		frame.setBackground(new Color(0x006299));
		
		//set dimensions of panels
		north.setPreferredSize(new Dimension(1000,125));
		south.setPreferredSize(new Dimension(1000,125));
		east.setPreferredSize(new Dimension(225,750));
		west.setPreferredSize(new Dimension(225,750));
		center.setPreferredSize(new Dimension(550,500));
		
		//set color of panels
		north.setBackground(new Color(0x006299));
		south.setBackground(new Color(0x006299));
		east.setBackground(new Color(0x006299));
		west.setBackground(new Color(0x006299));
	
		frame.add(north,BorderLayout.NORTH);
		frame.add(south,BorderLayout.SOUTH);
		frame.add(east,BorderLayout.EAST);
		frame.add(west,BorderLayout.WEST);
		frame.add(center,BorderLayout.CENTER);
		
		//---------------subpanels----------------
		
		//create sub-panels
		JPanel subn = new JPanel();
		JPanel subw = new JPanel();
		JPanel subc = new JPanel();
		
		center.setLayout(new BorderLayout());
		
		//set dimensions of sub-panels
		subn.setPreferredSize(new Dimension(200,165));
		subw.setPreferredSize(new Dimension(200,335));
		subc.setPreferredSize(new Dimension(350,335));
		
		//set color of sub-panels
		subn.setBackground(new Color(0x123456));
		subw.setBackground(new Color(0x006299));
		subc.setBackground(new Color(0x006299));
		
		//add sub-panels to center panel
		center.add(subn,BorderLayout.NORTH);
		center.add(subw,BorderLayout.WEST);
		center.add(subc,BorderLayout.CENTER);
		
		//set layout 
		subn.setLayout(new BorderLayout());
		subw.setLayout(null);
		subc.setLayout(null);

		//Center panel's sub-panel top 
		subn.add(label1);		//adding ATM title
		
		//Center panel's sub-panel left side
		subw.add(label2);		//user id label
		subw.add(label3);		//password label 
		
		//Center panel's right side
		subc.add(userId);
		subc.add(passText);
		subc.add(login);
		
		
		
		//---------------subpanels----------------
			 
		
		frame.setVisible(true);	//makes frame visible
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == login) {
			String id = userId.getText();
			String password = passText.getText();
			
			//removes userId and password after pressing button
			userId.setText("");		
			passText.setText("");			
			
			//pass object here and wait for approval
			
		//if approved close this window and open OptionATMGUI
			frame.dispose();
			OptionATMGUI option = new OptionATMGUI("Matthew");
			
		//if not approved then send error message
			/*JOptionPane.showMessageDialog(
					null, 
					"The user ID or password is incorrect. This is easily corrected by typing the correct user name and password.", 
					"Failed Login", 
					JOptionPane.ERROR_MESSAGE);*/
			
		
		}
	}
	

}
