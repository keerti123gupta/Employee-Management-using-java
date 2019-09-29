import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class delete11
{
	public delete11(String p)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://118.185.43.122:3306/0537cs161006","0537cs161006","archit");
			//JOptionPane.showMessageDialog(null, "jdbc:mysql://localhost:3306/archit1");
						
			PreparedStatement pit=con.prepareStatement("delete from arc where email=?");
			pit.setString(1,p);
			//JOptionPane.showMessageDialog(null, pit);
			int res= pit.executeUpdate();
			if(res>0)
			JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
			else
			JOptionPane.showMessageDialog(null, "*********Error*************");     
			}

			catch(Exception except) { }
	}
	public static void main(String args[])
	{
		int flag=0;
		if (flag!=0)
		new delete11("arc@gmail.com");
		else
		JOptionPane.showMessageDialog(null, "Please Login First");
		
	}

}