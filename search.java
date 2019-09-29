import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class search implements ActionListener
{
	JFrame fr;
	JLabel lb1,lb2,lb3,lb5,lb6,lb7,lb8,lb9;
	JLabel lb11,lb22,lb33,lb44,lb55,lb66;		
	JTextField t1;
	JPasswordField p1;
	JButton b1,b2,b3,b4;
	int a,b,c,d,g,f;
	String p=" ",aa=" ";
	
	String bb=" ";
	String cc=" ";
	String ff=" ";
	String ee=" ";
	String gg=" ";
	String hh=" ";
	String xy=" ";	

	public search()
	{	
		fr=new JFrame("Search");
		lb1=new JLabel("Email*");
		t1=new JTextField(20);
		lb3=new JLabel("Password*");
		p1=new JPasswordField();
		b1=new JButton("Search");
		b2=new JButton("Insert");
		b3=new JButton("Delete");
		b4=new JButton("Update");
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);

		lb2=new JLabel();
		lb22=new JLabel();
		lb5=new JLabel();
		lb11=new JLabel();
		lb6=new JLabel();
		lb33=new JLabel();
		lb7=new JLabel();
		lb44=new JLabel();
		lb8=new JLabel();
		lb55=new JLabel();
		lb9=new JLabel();
		lb66=new JLabel();
	

	lb1.setBounds(50,50,100,25);
	t1.setBounds(150,50,210,25);
	lb3.setBounds(50,80,100,25);
	p1.setBounds(150,80,210,25);
	b1.setBounds(100,120,100,25);
	b2.setBounds(200,120,100,25);
	b3.setBounds(200,600,100,25);
	b4.setBounds(400,600,100,25);
	lb2.setBounds(50,250,200,25);
	lb22.setBounds(150,250,200,25);
	lb5.setBounds(50,280,200,25);
	lb11.setBounds(150,280,200,25);
	lb6.setBounds(50,310,200,25);
	lb33.setBounds(150,310,200,25);
	lb7.setBounds(50,340,200,25);
	lb44.setBounds(150,340,200,25);
	lb8.setBounds(50,370,200,25);
	lb55.setBounds(150,370,200,25);
	lb9.setBounds(50,400,200,25);
	lb66.setBounds(150,400,200,25);
	
	

	fr.add(lb1);
	fr.add(t1);
	fr.add(lb3);
	fr.add(p1);


	fr.add(b1);
	fr.add(b2);  
	fr.add(b3); 
	fr.add(b4);

	fr.add(lb2);
	fr.add(lb5);
	fr.add(lb6);
	fr.add(lb7);
	fr.add(lb8);
	fr.add(lb9);

	fr.add(lb11);
	fr.add(lb22);
	fr.add(lb33);
	fr.add(lb44);
	fr.add(lb55);
	fr.add(lb66);
	       

	fr.setLayout(null);
	fr.setSize(300,300);
	fr.setVisible(true);
	fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	}

	public void actionPerformed(ActionEvent e) 
	{  
		if(e.getSource() == b1)
		{
			if( (t1.getText().trim().isEmpty()) || (p1.getText().isEmpty()) )
				JOptionPane.showMessageDialog(null, "Empty Entry!");     
         		else
			{ 
				p=t1.getText();
				xy=new String(p1.getPassword());
				c=0;d=0;g=0;f=0;
				int x=p.length();
				
				for(int i=0;i<x;i=i+1)
				{
					a=(int)p.charAt(i);
					//System.out.println(a);
					if((a>=64 && a<=90) || (a>=97 && a<=122) || a==95 || a==46 || (a>=48 && a<=57))
					{
						if((int)a==64)
						{c=i; g=g+1;}
						if((int)a==46)
						{d=i; f=f+1;}

						//System.out.println(i);
					}
					else	{
							//JOptionPane.showMessageDialog(null, "Email is invalid!");
							break;
						}	
					
				}
				
				if(c<d && g==1 && f>0)
				{
					try
						{
						Class.forName("com.mysql.jdbc.Driver");
						
						Connection con=DriverManager.getConnection("jdbc:mysql://118.185.43.122:3306/0537cs161006","0537cs161006","archit");
						
						PreparedStatement pit=con.prepareStatement("select * from arc where email=? and password=?");
						pit.setString(1,p);
						pit.setString(2,xy);
										
						//JOptionPane.showMessageDialog(null, pit);
						ResultSet rs= pit.executeQuery();

						if(rs.next())
						{
							JOptionPane.showMessageDialog(null, "Record Found");
							
							bb=rs.getString(1);
							gg=rs.getString(4);
							hh=rs.getString(5);
							cc=rs.getString(6);
							ee=rs.getString(7);
							ff=rs.getString(8);

							lb2.setText("Name ==>");
							lb5.setText("Gender ==>");
							lb6.setText("Date of Birth ==>");
							lb7.setText("City ==>");
							lb8.setText("State ==>");
							lb9.setText("Pincode ==>");

							lb22.setText(bb);
							lb11.setText(gg);
							lb33.setText(hh);
							lb44.setText(cc);
							lb55.setText(ee);
							lb66.setText(ff);
						}
						else{
						JOptionPane.showMessageDialog(null, "Record not Found!\n Please Insert");
						lb2.setText(null);
						lb5.setText(null);
						lb6.setText(null);
						lb7.setText(null);
						lb8.setText(null);
						lb9.setText(null);
						lb22.setText(null);
						lb11.setText(null);
						lb33.setText(null);
						lb44.setText(null);
						lb55.setText(null);
						lb66.setText(null);
						}
						
						}

						catch(Exception except) { }

						
				}
				else
					JOptionPane.showMessageDialog(null, "Wrong E-mail!");
			}		
			
		}

		if(e.getSource() == b2)
		{
			new form11();					//bb=name
			//System.exit(0);
		}

		if(e.getSource()== b3)
		{
			new delete11(p);
			//JOptionPane.showMessageDialog(null, "Deleated!");
		}
		
		if(e.getSource()== b4)
		{
			new update11(bb);
			//JOptionPane.showMessageDialog(null, "Deleated!");
		}

	} 



	public static void main(String args[])  
	{  
   		int flag=0;
		if (flag!=0)
		new search();
		else
		JOptionPane.showMessageDialog(null, "Please Login First"); 
	}
  
}  

 

	
