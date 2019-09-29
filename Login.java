import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class Login implements ActionListener
{
	JFrame fr;
	JLabel lb1,lb2;
	JTextField t1;
	JPasswordField p1;

	JButton b1,b2;
	int a,b,c,d,g,f;
	String p=" ",aa=" ";
	
	String bb=" ";
	String cc=" ";
	String ff=" ";
	String ee=" ";
	String gg=" ";
	String hh=" ";
	

	public Login()
	{	
		fr=new JFrame("Login");
		lb1=new JLabel("username*");
		t1=new JTextField(20);
		lb2=new JLabel("password*");
		p1=new JPasswordField(20);
		b1=new JButton("Login");
		b2=new JButton("Exit");
		b1.addActionListener(this);
		b2.addActionListener(this);
		

		
	

	lb1.setBounds(50,50,100,25);
	t1.setBounds(150,50,210,25);
	lb2.setBounds(50,100,100,25);
	p1.setBounds(150,100,210,25);
	b1.setBounds(100,150,100,25);
	b2.setBounds(200,150,100,25);
	
	
	
	

	fr.add(lb1);
	fr.add(t1);
	fr.add(b1);
	
	fr.add(b2);

	fr.add(lb2);
	fr.add(p1);
	       

	fr.setLayout(null);
	fr.setSize(300,300);
	fr.setVisible(true);
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	public void actionPerformed(ActionEvent e) 
	{  
		if(e.getSource() == b1)
		{
			if(t1.getText().trim().isEmpty() || (p1.getText().isEmpty()))
				JOptionPane.showMessageDialog(null, "Empty Entry!");     
         		else
			{ 
				p=t1.getText();
				aa=new String(p1.getPassword());
						try
						{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://118.185.43.122:3306/0537cs161006","0537cs161006","archit");
						//JOptionPane.showMessageDialog(null, "jdbc:mysql://localhost:3306/archit1");
						
						PreparedStatement pit=con.prepareStatement("select * from admin where username=? and password=?");
						pit.setString(1,p);
						pit.setString(2,aa);
										
						//JOptionPane.showMessageDialog(null, pit);
						ResultSet rs= pit.executeQuery();

						if(rs.next())
						{
							JOptionPane.showMessageDialog(null, "Login Sucessfully");
							bb=rs.getString(2);
							JOptionPane.showMessageDialog(null, "Name=>" + bb);
							new hii();
						}
						else
						JOptionPane.showMessageDialog(null, "Login Eror");
						}

						catch(Exception except) { }

					
			}		
			
		}

		if(e.getSource() == b2)
		{
			System.exit(0);
		}

		
	} 



	public static void main(String args[])  
	{  
   		new Login();  
	}
  
}  

 

	
