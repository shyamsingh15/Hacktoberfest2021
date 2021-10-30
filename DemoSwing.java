package SwingExample;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DemoSwing extends JFrame
{
	JTextField tf3;
	DemoSwing()
	{
		setLayout(null);
		setSize(500,500);
		JTextField tf1= new JTextField();
		tf1.setSize(100,30);
		tf1.setLocation(0,0);
		JTextField tf2= new JTextField();
		tf2.setSize(100,30);
		tf2.setLocation(100,0);
		JButton b1=new JButton("Click!!");
		b1.setLocation(200,0);
		b1.setSize(100,30);
		
	    tf3= new JTextField();
		tf3.setSize(100,30);
		tf3.setLocation(300,0);
		add(tf1);
		add(tf2);
		add(b1);
		b1.addActionListener(new ActionListener() { // Add action listener for Alpha.
                   public void actionPerformed(ActionEvent ae) {
                      System.out.println("hello");
					  String a=tf1.getText();
					  String b=tf2.getText();
					  tf3.setText(""+(Integer.parseInt(a)+Integer.parseInt(b)));
                    }
                  });
		add(tf3);
		//8009573157
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String args[])
	{
		new DemoSwing();
	}
}