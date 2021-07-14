import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class login extends JFrame implements ActionListener{
	JButton b1;
	JButton b2;
	JLabel l1;
	JLabel l2;
	JTextField t1;
	JPasswordField t2;
	JLabel l3;
	 static private login k;
	 JFrame j;
	login()
	{
		j=new JFrame();
		j.setTitle("login");
		j.setVisible(true);
		j.setSize(400,300);
		j.setLocation(450,150);
		j.setLayout(null);
		l1=new JLabel("USERNAME ");
		l2=new JLabel("PASSWORD ");
		t1=new JTextField(10);
		t2=new JPasswordField(10);
		ImageIcon g=new ImageIcon(ClassLoader.getSystemResource("ni.jpg")) ;
		l3=new JLabel(g);
		b1=new JButton("cancel");
		b2=new JButton("login");
		
		
		j.add(l1);
		j.add(l2);
		j.add(t1);
		j.add(t2);
		j.add(b1);
		j.add(b2);
		j.add(l3);
		
		l1.setBounds(10,40,80,38);
		l2.setBounds(10,90,80,38);
		t1.setBounds(110,50,180,22);
		t2.setBounds(110,100,180,22);
		l3.setBounds(0,0,400,300);
		b1.setBounds(50,150,90,35);
		b2.setBounds(180,150,90,35);
		b1.setForeground(Color.WHITE);
		b2.setForeground(Color.WHITE);
		b1.setBackground(Color.RED);
		b2.setBackground(Color.BLUE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			t1.setText(null);
			t2.setText(null);
		}
		else
		{
			String n=t1.getText();
			String n1=t2.getText();
			
		if(n.contains("nidhi")&&n1.contains("1234"))
		{
			 JOptionPane.showMessageDialog(this, "login sucessfully");
			
			new snake().setVisible(true);
			j.dispose();
		}
		else
		{
			 JOptionPane.showMessageDialog(this, "try again");
		}
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String args[])
	{  
		     k=new login();
	}



}
