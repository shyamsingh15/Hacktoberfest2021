package swing;

import JDBC.studentDatabase.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
public class Login extends JFrame implements ActionListener
{
	JTextField tf1,tf2;
	JButton b1,b2;
	JLabel res;
	public Login()
	{
		super("Login Page");
		setLayout(null);
		setSize(350,370);
		setLocation(300,90);
		//setUndecorated(true);
		JLabel l1=new JLabel("Please Login Here");
		l1.setBounds(50,40,280,35);
		l1.setFont(new Font("Monaco", Font.BOLD, 25));
		add(l1);
		
		JLabel l2=new JLabel("Enter Your ID:");
		l2.setBounds(40,110,130,30);
		l2.setFont(new Font("Monaco", Font.BOLD, 18));
	    tf1= new JTextField();
		tf1.setFont(new Font("Monaco", Font.BOLD, 16));
		tf1.setSize(120,30);
		tf1.setLocation(200,110);

		JLabel l3=new JLabel("Enter Your Password:");
		l3.setBounds(10,160,190,30);
		l3.setFont(new Font("Monaco", Font.BOLD, 16));
	    tf2= new JTextField();
		tf2.setFont(new Font("Monaco", Font.BOLD, 18));
		tf2.setSize(120,30);
		tf2.setLocation(200,160);
		
		res=new JLabel("");
		res.setBounds(90,200,200,13);
		res.setForeground(Color.RED);
		add(res);
		
		Icon icon = new ImageIcon("D:/java/swing/login.png");
	    b1=new JButton(icon);
		b1.setLocation(120,230);
		b1.setSize(110,32);
		//b1.setFont(new Font("Monaco", Font.BOLD, 25));
		b1.addActionListener(this);
		
	    icon = new ImageIcon("D:/java/swing/register.png");
	    b2=new JButton(icon);
		b2.setLocation(5,300);
		b2.setSize(110,25);
		b2.setFont(new Font("Monaco", Font.BOLD, 10));
		b2.addActionListener(this);
	   /* tf3= new JTextField();
		tf3.setSize(100,30);
		tf3.setLocation(10,120);*/
		add(l2);
		add(l3);
		add(tf1);
		add(tf2);
		add(b1);
		add(b2);
		
		
		//8009573157
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()== b2){
		setVisible(false);
		try{
		new JDBCConnection().stopConnection();
		}
		catch(Exception ex)
			{
				System.out.println(ex);
			}
		Registration reg=new Registration();
		}
		else
		{
			String id="",pass="",name="";
			id=tf1.getText();
			pass=tf2.getText();
			try{
			Connection con=new JDBCConnection().getConnection();
		    Statement st=con.createStatement();
			String query="select name from Registration where mob_no='"+id+"'";
			ResultSet rs=st.executeQuery(query);
			if(rs.next()){
			name=rs.getString(1);
			System.out.println(name+" "+pass);
			}
			if(!pass.equals(name)||name.equals(""))
			 res.setText("Not Match, Try Again");
			else{
			 res.setText("Log in Successfully");
			 setVisible(false);
			 new UserDetail(id);
			}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
	}
	
	
	public static void main(String args[])
	{
		new Login();
	}
}