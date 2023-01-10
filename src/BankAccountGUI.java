
import java.awt.event.*;
import javax.swing.*;

import java.awt.BorderLayout;


//This class should extend JFrame and implement the ActionListener Interface
public class BankAccountGUI extends JFrame implements ActionListener{
	//complete the implementation of the different user interface components  
	private JLabel amountLabel = new JLabel("Amount");
	private JTextField amountField = new JTextField(5);
	private JButton depositButton = new JButton("DEPOSIT");
	private JButton withdrawButton = new JButton("WITHDRAW");
	private JLabel startBalance = new JLabel("Starting Balance = 0");
	
	//create the three panels topPanel, middlePanel and bottomPanel 
	private JPanel topPanel = new JPanel();
	private JPanel centrePanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	
	
	// declare a new BankAccount object (myAccount) with account number and name of your choice here
	BankAccount myAccount = new BankAccount("12345678", "VishaljiODEDRA");
	
	public BankAccountGUI(){
		
		//set the title for the frame
		setTitle("Bank Account GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exists the application when frame is closed
	
		//set the frame size and location
		this.setSize(400, 200);
		setLocationRelativeTo(null);
		
		//add the action listeners for your buttons 
		depositButton.addActionListener(this);
		withdrawButton.addActionListener(this);
		
		//add the Label to the Top here
		topPanel.add(amountLabel);
		topPanel.add(amountField);
		
		//add the buttons to the middlePanel here
		centrePanel.add(depositButton);
		centrePanel.add(withdrawButton);
		
		//add the balanceLabel to the bottom Panel 
		bottomPanel.add(startBalance);
		
		add (BorderLayout.NORTH, topPanel);
		// add the middlePanel to the CENTER of the frame here
		add (BorderLayout.CENTER, centrePanel);
		//add the bottomPanel to the bottom of the frame here
		add (BorderLayout.SOUTH,bottomPanel);
			
		// set the fame visibility to true
		setVisible(true);
	}
	
 
	public void actionPerformed(ActionEvent e){
		
	try{
		// write code to get text from amountField and convert to double here
		String amount = amountField.getText();
		Double dAmount = Double.parseDouble(amount);
		if (dAmount<0) {
			JOptionPane.showMessageDialog(null, "You can not deposite or withdraw negative ammount!!", "Warning Message!", JOptionPane.ERROR_MESSAGE);
		}
		
		// write event handler for deposit button here
		else {
			if (e.getSource() == depositButton) {
				myAccount.deposit(dAmount);
			}
			
			// write event handler for withdraw button here
			else if(e.getSource() == withdrawButton) {
				myAccount.withdraw(dAmount);
			}
		}
		startBalance.setText("New Balance is: "+myAccount.getBalance());	
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "The Amount can not be 0!!", "Warning Message!", JOptionPane.WARNING_MESSAGE);
			JOptionPane.showMessageDialog(null, "Enter amount!!", "Warning Message!", JOptionPane.INFORMATION_MESSAGE);
		}		
	}
}
