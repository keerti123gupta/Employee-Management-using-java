import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class form11 implements ActionListener
{
	JFrame fr;
	JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9;
	JTextField t1,t2,t5,t6,t7;		/*t3,t4*/
	JButton b1,b2,b3;
	JPasswordField p1,p2;
	Choice c1,c2,c3;
	JRadioButton r1,r2;
	ButtonGroup bg;
	int a,b,c,d,g,f,i=0,j=0,xx,dd,yy,vb=0;		//dd-mm-yy= Date of birth
	String p=" ";
	String aa=" ";
	String bb;
	String cc=" ";
	String ff=" ";
	String ee=" ";
	String gg=" ";
	String hh;
	String ii;
	String jj=" ";
	String mm=" ";	
	String str=" ";

	public form11()
	{	
		fr=new JFrame("Personal Details");
		lb1=new JLabel("Name*");
		lb2=new JLabel("Email*");
		lb3=new JLabel("Password*");
		lb4=new JLabel("Confirm Password*");
		lb5=new JLabel("Gender*");
		lb6=new JLabel("Date of Birth*");
		lb7=new JLabel("City*");
		lb8=new JLabel("State*");
		lb9=new JLabel("Pincode*");
		t1=new JTextField(20);
		t2=new JTextField(20);
		//t3=new JTextField(20);
		//t4=new JTextField(20);
		t5=new JTextField(20);
		t6=new JTextField(20);
		t7=new JTextField(20);
		p1=new JPasswordField();
		p2=new JPasswordField();
		c1=new Choice();
		c2=new Choice();
		c3=new Choice();
		r1 = new JRadioButton("Male");
		r2 = new JRadioButton("Female");
		b1=new JButton("Submit");
		b2=new JButton("Exit");
		b3=new JButton("Show");
		

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		bg = new ButtonGroup();
        	bg.add(r1);
        	bg.add(r2);

		c3.add("-");   
        	for(int xz=2019; xz>1939; xz--)
		{	str=String.valueOf(xz);	
			c3.add(str);
		}
		
		
			c2.add("-");   
        		c2.add("January");  
        		c2.add("February");  
        		c2.add("March");  
        		c2.add("April");  
        		c2.add("May");
			c2.add("June");
			c2.add("July"); 
			c2.add("August"); 
			c2.add("September"); 
			c2.add("October"); 
			c2.add("November"); 
			c2.add("December"); 
		



		
			c1.add("-");   
        		for(int xz=1; xz<32; xz++)
		{	str=String.valueOf(xz);	
			c1.add(str);
		}
        

	lb1.setBounds(50,100,200,25);
	t1.setBounds(250,100,200,25);
	lb2.setBounds(50,150,200,25);
	t2.setBounds(250,150,200,25);
	lb3.setBounds(50,200,200,25);
	//t3.setBounds(250,200,200,25);
	p1.setBounds(250,200,200,25);
	lb4.setBounds(50,250,200,25);
	p2.setBounds(250,250,200,25);
	//t4.setBounds(250,250,200,25);
	lb5.setBounds(50,300,200,25);
	r1.setBounds(250,300,100,25);
	r2.setBounds(350,300,100,25);
	lb6.setBounds(50,350,200,25);
	c1.setBounds(250,350,80,0);
	c2.setBounds(340,350,80,0);
	c3.setBounds(430,350,80,0);
	lb7.setBounds(50,400,200,25);
	t5.setBounds(250,400,200,25);
	lb8.setBounds(50,450,200,25);
	t6.setBounds(250,450,200,25);
	lb9.setBounds(50,500,200,25);
	t7.setBounds(250,500,200,25);

	b1.setBounds(250,600,100,25);
	b2.setBounds(400,600,100,25);
	b3.setBounds(600,600,100,25);

	fr.add(lb1);
	fr.add(t1);
	fr.add(lb2);
	fr.add(t2);
	fr.add(lb3);
	fr.add(p1);
	//fr.add(t3);
	fr.add(lb4);
	//fr.add(t4);
	fr.add(p2);
	fr.add(lb5);
	fr.add(r1);
        	fr.add(r2);
	fr.add(lb6);
	fr.add(c1);
	fr.add(c2);
	fr.add(c3);
	fr.add(lb7);
	fr.add(t5);
	fr.add(lb8);
	fr.add(t6);
	fr.add(lb9);
	fr.add(t7);  
	fr.add(b1);
	fr.add(b2); 
	fr.add(b3); 
        

	fr.setLayout(null);
	fr.setExtendedState(JFrame.MAXIMIZED_BOTH);
	fr.setVisible(true);
	//fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	public void actionPerformed(ActionEvent e) 
	{  
		if(e.getSource() == b1)
		{
			if((t1.getText().trim().isEmpty()) || (t2.getText().isEmpty()) || (p1.getText().isEmpty()) || (p2.getText().isEmpty()) || (t5.getText().trim().isEmpty()) || (t6.getText().trim().isEmpty()) || (t7.getText().trim().isEmpty()))
				JOptionPane.showMessageDialog(null, "Empty Entry!");     
		
         			else
			{
					

					hh=new String(p2.getPassword());
					ii=new String(p1.getPassword());

					if(ii.equals(hh)== true)
					{
						if(r1.isSelected())
							gg="Male";
						if(r2.isSelected())
							gg="Female";
						yy=Integer.parseInt(c3.getItem(c3.getSelectedIndex()));
						mm=c2.getItem(c2.getSelectedIndex());
						dd=Integer.parseInt(c1.getItem(c1.getSelectedIndex()));
						cc=t5.getText();
						ee=t6.getText();
						bb=new String(p1.getPassword());
						ff=t7.getText();
						aa=t1.getText();
						p=t2.getText();
						
						JOptionPane.showMessageDialog(null, bb);
						JOptionPane.showMessageDialog(null, gg);
						JOptionPane.showMessageDialog(null, dd + "-" + mm + "-" + yy);
						JOptionPane.showMessageDialog(null, cc);
						JOptionPane.showMessageDialog(null, ee);
						JOptionPane.showMessageDialog(null, ff);
						JOptionPane.showMessageDialog(null, aa);
						JOptionPane.showMessageDialog(null, p);
						JOptionPane.showMessageDialog(null, "Sucessfully Read!");

						try
						{
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://118.185.43.122:3306/0537cs161006","0537cs161006","archit");
						// JOptionPane.showMessageDialog(null, "jdbc:mysql://localhost:3306/archit1");
						
						PreparedStatement pst=con.prepareStatement("insert into arc values(?,?,?,?,?,?,?,?);");
						pst.setString(1,aa);
						pst.setString(2,p);
						pst.setString(3,ii);
						pst.setString(4,gg);
						pst.setString(5,dd + "-" + mm + "-" + yy);
						pst.setString(6,cc);
						pst.setString(7,ee);
						pst.setString(8,ff);
						JOptionPane.showMessageDialog(null, pst);
						int res= pst.executeUpdate();
						
						if(res>0)
							JOptionPane.showMessageDialog(null, "Sucessfully submit!");
						else
							JOptionPane.showMessageDialog(null, "*********Error*************");     
						}

						catch(Exception except) { }
					}
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
	}
	public static void main(String arg[])
	{
		int flag=0;
		if (flag!=0)
		new form11();
		else
		JOptionPane.showMessageDialog(null, "Please Login First");
	}
} 
