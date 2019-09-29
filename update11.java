import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class update11 implements ActionListener
{
	JFrame fr;
	JLabel lb1,lb2,lb3,lb4,lb5,lb6;
	JTextField t1,t2;		
	JButton b1,b2,b3,b4;
	int a;		
	String cc=" ";
	String xx=" ";
	String aa=" ";	
	public update11(String bb)
	{
		fr=new JFrame("Update");
		xx=new String(bb);
		lb2=new JLabel("1.Email");
		lb3=new JLabel("2. City");
		lb4=new JLabel("3. State");
		lb5=new JLabel("4. Pincode");
		lb6=new JLabel("choose your values....");
		t2=new JTextField(20);
		
		lb1=new JLabel(" ");	
		t1=new JTextField(20);
		
		b1=new JButton("ok");
		b2=new JButton("Exit");
		b3=new JButton("Show");
		b4=new JButton("Update");
		

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		

		lb1.setBounds(50,550,200,25);
		t1.setBounds(250,550,200,25);
		lb2.setBounds(50,50,200,25);
		lb3.setBounds(50,100,200,25);
		lb4.setBounds(50,150,200,25);
		lb5.setBounds(50,200,200,25);
		lb6.setBounds(50,250,200,25);
		t2.setBounds(250,350,200,25);
	
	
		b1.setBounds(250,400,100,25);
		b2.setBounds(400,600,100,25);
		b3.setBounds(600,600,100,25);
		b4.setBounds(250,600,100,25);

		fr.add(lb1);
		fr.add(lb2);
		fr.add(lb3);
		fr.add(lb4);
		fr.add(lb5);
		fr.add(lb6);
		fr.add(t2);
		
		fr.add(b1);
		fr.add(b2); 
		fr.add(b3);
		fr.add(b4); 
        

	fr.setLayout(null);
	fr.setSize(300,300);
	fr.setVisible(true);
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	public void actionPerformed(ActionEvent e) 
	{  
		if(e.getSource() == b1)
		{
			if(t2.getText().trim().isEmpty())
				JOptionPane.showMessageDialog(null, "Empty Entry!");     
		
         			else
			{
						
						a=Integer.parseInt(t2.getText());
						fr.add(t1);
						switch(a)
						{
							case 1: {	
								cc="Email";
								lb1.setText(cc);
							            }
								break;
							case 2: {	
								cc="City";
								lb1.setText(cc);
							            }
								break;
							case 3: {	
								cc="State";
								lb1.setText(cc);
							            }
								break;
							case 4: {	
								cc="Pincode";
								lb1.setText(cc);
							            }
								break;
							default: {	
								cc="Wrong Input*";
								lb1.setText(cc);
							            }	
							}
								
						JOptionPane.showMessageDialog(null, "Sucessfully Read!");
			}

						
		}

		if(e.getSource() == b2)
		{
			System.exit(0);
		}

		if(e.getSource() == b3)
		{
			new search();
		}
		
		if(e.getSource() == b4)
		{

				aa=t1.getText();
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				
						Connection con=DriverManager.getConnection("jdbc:mysql://118.185.43.122:3306/0537cs161006","0537cs161006","archit");
						
				Statement pit=con.createStatement();
				String qry="update arc set " +  cc + "='" + aa + "' where name ='" + xx +"';";
				//JOptionPane.showMessageDialog(null, pst);
				int res= pit.executeUpdate(qry);
					
				if(res>0)
					JOptionPane.showMessageDialog(null, "Sucessfully update!");
				else
					JOptionPane.showMessageDialog(null, "*********Error*************");     
			}

			catch(Exception except) { }
			
		
		}
	}


	public static void main(String args[])
	{
		int flag=0;
		if (flag!=0)
		new update11("Salman Khan");
		else
		JOptionPane.showMessageDialog(null, "Please Login First"); 
	}

}