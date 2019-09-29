import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class hii implements ActionListener 
{
	JFrame fr;
	JButton b1,b2,b3;
	public hii()
	{	
		fr=new JFrame("Front Page");
		b1=new JButton("Insert");
		b2=new JButton("Search");
		b3=new JButton("Exit");
		

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	
		b1.setBounds(50,100,80,25);
		b2.setBounds(100,130,80,25);
		b3.setBounds(150,100,80,25);

		fr.add(b1);
		fr.add(b2);
		fr.add(b3);
	
		fr.setLayout(null);
		fr.setSize(300,300);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	public void actionPerformed(ActionEvent e) 
	{  
		if(e.getSource() == b1)
		{
			new form11();
		}
		
	  
		if(e.getSource() == b2)
		{
			new search();  
		}

		if(e.getSource() == b3)
		{
			System.exit(0);
		}
	}

	public static void main(String ars[])
	{	
		int flag=0;
		if (flag!=0)
			new hii();
		else
		JOptionPane.showMessageDialog(null, "Please Login First");
	}
}

