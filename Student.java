import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Student extends JFrame implements ActionListener
{
	private JLabel userLabel,imgLabel;
	private JButton viewstudent;
	private JButton updateinformation;
	private JButton searchstudent;
	private JButton viewmyinformation;
	private ImageIcon img;
	private JButton Logout;
	private JPanel panel;
	String uid;
	public Student(String id)
	{
		super (" Student Homepage");
		this.setSize(800,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);
		
		uid=id;
		
		userLabel=new JLabel("WELCOME STUDENT!!!! ");
		userLabel.setBounds(300,20,700,100);
		userLabel.setForeground(Color.WHITE);
		panel.add(userLabel);
		 
		viewstudent=new JButton("VIEW MY TEACHERS");
		viewstudent.setBounds(280, 150, 200, 30);
		viewstudent.setBackground(Color.GREEN); 
		viewstudent.addActionListener(this);
		panel.add(viewstudent);
		 
		updateinformation=new JButton("UPDATE INFORMATION");
		updateinformation.setBounds(280, 200, 200, 30);
		updateinformation.setBackground(Color.GREEN);
		updateinformation.addActionListener(this);
		panel.add(updateinformation);
		
		searchstudent=new JButton("AVAILABLE TEACHERS");
		searchstudent.setBounds(280, 250, 200, 30);
		searchstudent.setBackground(Color.GREEN);
		searchstudent.addActionListener(this);
		panel.add(searchstudent);
		 
		 
		viewmyinformation=new JButton("VIEW MY INFORMATION");
		viewmyinformation.setBounds(280, 300, 200, 30);
		//viewmyinformation.addActionListener(this);
		viewmyinformation.addActionListener(this);
		viewmyinformation.setBackground(Color.GREEN);
		panel.add( viewmyinformation);
		 
		Logout=new JButton("LOG OUT");
		Logout.setBounds(550, 20, 100, 30);
		Logout.setBackground(Color.RED);
		Logout.addActionListener(this);
		panel.add(Logout);
		 
		img = new ImageIcon("image2.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0, 0, 800, 700);
		panel.add(imgLabel);
		 
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{  
		String temp = ae.getActionCommand();
	 
		if (ae.getSource()==Logout)
		{   Login l  =new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
		else if (ae.getSource()==viewmyinformation)
		{   
			ViewStudentInformation v  =new ViewStudentInformation(uid);	
			v.setVisible(true);
			this.setVisible(false);
		}
		else if (ae.getSource()==searchstudent)
		{   
			Available_Teacher v  =new Available_Teacher(uid);	
			v.setVisible(true);
			this.setVisible(false);
		}
		else if (ae.getSource()==viewstudent)
		{   
			ViewMyTeacher v  =new ViewMyTeacher(uid);	
			v.setVisible(true);
			this.setVisible(false);
		}
		else if (ae.getSource()==updateinformation)
		{   
			Update_Student v  =new Update_Student(uid);	
			v.setVisible(true);
			this.setVisible(false);
		}
	}
}