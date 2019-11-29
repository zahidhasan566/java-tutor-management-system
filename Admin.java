import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Admin extends JFrame implements ActionListener
{
	private JLabel userLabel,imgLabel;
	private JButton Teacher;
	private JButton Student;
	private JButton Assigned;
	private JButton Unassigned;
	private JButton Register;
	private JButton Logout;
	private ImageIcon img;
	private JPanel panel;
	
	public Admin()
	{
		super ("Admin Panel");
		this.setSize(800,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);
		 
		userLabel=new JLabel("WELCOME ADMIN !!!! ");
		userLabel.setForeground(Color.WHITE);
		userLabel.setBounds(300,20,700,100);
		panel.add(userLabel);
		 
		Teacher =new JButton("VIEW TEACHERS");
		Teacher.setBounds(150, 150, 150, 30);
		Teacher.setBackground(Color.GREEN);
		Teacher.addActionListener(this);
		panel.add(Teacher);
		 
		 
		Student =new JButton("VIEW STUDENTS");
		Student.setBounds(320, 150, 150, 30);
		Student.setBackground(Color.GREEN);
		Student.addActionListener(this);
		panel.add(Student);
		 
		 
		 
		Assigned =new JButton("ASSIGN");
		Assigned.setBounds(490, 150, 150, 30);
		Assigned.setBackground(Color.GREEN);
		Assigned.addActionListener(this);
		panel.add(Assigned);
		 
		 
		Unassigned=new JButton("UNASSIGN");
		Unassigned.setBounds(320, 200, 150, 30);
		Unassigned.setBackground(Color.GREEN);
		Unassigned.addActionListener(this);
		panel.add( Unassigned);
		 
		 
		Register=new JButton("REGISTER TEACHER");
		Register.setBounds(290, 250, 200, 30);
		Register.setBackground(Color.GREEN);
		Register.addActionListener(this);
		panel.add(Register);
		 
		Logout=new JButton(" LOG OUT ");
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
	 
		if (ae.getSource()==Assigned)
		{   
			Assign aa =new Assign();
			aa.setVisible(true);
			this.setVisible(false);
		}
		else if (ae.getSource()==Unassigned)
		{   
			Unassign ss =new Unassign();
			ss.setVisible(true);
			this.setVisible(false);
		}
		else if (ae.getSource()==Logout)
		{   
			Login l  =new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
		else if (ae.getSource()==Register)
		{
			Reg_Teacher r =new Reg_Teacher();
			r.setVisible(true);
			this.setVisible(false);
		}
		else if (ae.getSource()==Teacher)
		{
			Show_Teacher r =new Show_Teacher();
			r.setVisible(true);
			this.setVisible(false);
		}
		else if (ae.getSource()==Student)
		{
			Show_Student r =new Show_Student();
			r.setVisible(true);
			this.setVisible(false);
		}
		else 
		{
			
		}
	}
}