/*********************************************************************** 
Program Name: JavaPizza.java 
Programmer's Name: Jonathan Barnette
Program Description: Allows the user to enter name and phone number, select pizza size and toppings, and view the order summary
***********************************************************************/

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JavaPizza extends JFrame {
	
	private final JTextField txtName = new JTextField(20);
	private final JTextField txtPhone = new JTextField(20);
	private final JRadioButton smallButton = new JRadioButton("Small", true);
	private final JRadioButton mediumButton = new JRadioButton("Medium", false);
	private final JRadioButton largeButton = new JRadioButton("Large", false);
	private final ButtonGroup radioGroup = new ButtonGroup();
	private final JCheckBox pepBox = new JCheckBox("Pepperoni");
	private final JCheckBox sauBox = new JCheckBox("Sausage");
	private final JCheckBox musBox = new JCheckBox("Mushroom");
	private final JCheckBox oniBox = new JCheckBox("Onion");
	private final JTextField txtTotal = new JTextField(20);

	
	JavaPizza()
	{
		super("Java Pizza");
		JTabbedPane tab = new JTabbedPane();
		
		// constructing the first panel
		JLabel l1 = new JLabel("Name:",SwingConstants.CENTER );
		JLabel l2 = new JLabel("Phone Number:",SwingConstants.CENTER);
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 1));
		p1.add(l1);p1.add(txtName);p1.add(l2);p1.add(txtPhone);
		tab.addTab("Customer",null, p1,"Panel #1");
		
		// constructing the second panel	
		JLabel l3 =new JLabel("What size pizza?",SwingConstants.CENTER);

		radioGroup.add(smallButton);
		radioGroup.add(mediumButton);
		radioGroup.add(largeButton);
		JPanel p2 =new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		p3.setLayout(new GridLayout(1,1));
		p4.setLayout(new GridLayout(1,3));
		p2.add(p3);
		p2.add(p4);
		p2.setLayout(new GridLayout(2, 1));
		p3.add(l3); p4.add(smallButton); p4.add(mediumButton); p4.add(largeButton);
		tab.addTab("Size",null, p2," Panel #2");
		
		
		// constructing the third panel	
		JLabel l4 =new JLabel("What toppings?",SwingConstants.CENTER);
		JPanel p5 =new JPanel();
		JPanel p6 = new JPanel();
		JPanel p7 = new JPanel();
		p5.setLayout(new GridLayout(2, 1)); //base panel
		p6.setLayout(new GridLayout(1,1));
		p7.setLayout(new GridLayout(2,2));
		p5.add(p6);
		p5.add(p7);
		p6.add(l4); p7.add(pepBox); p7.add(sauBox); p7.add(musBox); p7.add(oniBox);
		tab.addTab("Toppings",null, p5," Panel #3");
		
		// constructing the fourth panel	
		JLabel l5 =new JLabel("Total Due:");	
		JPanel p8 =new JPanel();
		JButton btnOrder = new JButton("Order Summary");
		p8.add(l5); p8.add(txtTotal); p8.add(btnOrder);
		txtTotal.setText("Click 'Order Summary' To View Total!");
		tab.addTab("Total",null, p8," Panel #4");
		
		//button handler
		
		ButtonHandlerOrder handlerOrder = new ButtonHandlerOrder();
		btnOrder.addActionListener(handlerOrder);
		
		
		// add JTabbedPane to container
		getContentPane().add( tab );
		setSize(350,250);
		setVisible(true);
		
		
	}
	
	
	
	private class ButtonHandlerOrder implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event)
		{
			String output = "", size = "";
			double total = 0;
			JTextArea textArea = new JTextArea();
			
			if (smallButton.isSelected())
			{
				size = "Small";
				total +=8;
			}
			if (mediumButton.isSelected())
			{
				size = "Medium";
				total += 10;
			}
			if(largeButton.isSelected())
			{
				size = "Large";
				total += 12;
			}
			
			output = "Customer Name: " + txtName.getText();
			output += "\nPhone Number: " + txtPhone.getText();
			output += "\nSize: " + size;
			output += "\nToppings: ";
			if (pepBox.isSelected())
			{
				output += "Pepperoni ";
				total += 2;
			}
			if (sauBox.isSelected())
			{
				output += "Sausage ";
				total += 2;
			}
			if (musBox.isSelected())
			{
				output += "Mushrooms ";
				total+= 2;
			}
			if (oniBox.isSelected())
			{
				output+= "Onions";
				total += 2;
			}
			output += "\nTotal: " +total;
			txtTotal.setText(String.valueOf(total));
			textArea.setText(output);
			JOptionPane.showMessageDialog(JavaPizza.this, textArea);
		}
	}
	
	public static void main(String args[])
	{
		JavaPizza demo =new JavaPizza();
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );}
	}



