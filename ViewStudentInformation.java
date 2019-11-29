import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*; 
public class ViewStudentInformation extends JFrame implements ActionListener 
{
	
	private JLabel userLabel,nameLabel,idLabel,phnLabel,arealabel,subjLabel,mailLabel,wagelabel,imgLabel;
	private JTextField nameTF,idTF,phnTF,areaTF,subjTF1,mailTF,wageTF,subjTF2,subjTF3;
	private ImageIcon img;
	private JCheckBox cb1, cb2,cb3;
	private JButton Back;
	private JButton Logout;
		
	private JPanel panel;
	String uid;
	int x;
	
	public ViewStudentInformation(String id)
	{
		super ("VIEW MY TEACHER INFORMATION");
		this.setSize(800,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);
		 
		uid=id;
			
		userLabel=new JLabel("INFORMATION:");
		userLabel.setBounds(150,60,200,100);
		userLabel.setForeground(Color.WHITE);
		panel.add(userLabel);
		 
		nameLabel=new JLabel("USER NAME: ");
		nameLabel.setBounds(150, 150, 200, 30);
		nameLabel.setForeground(Color.WHITE);
		panel.add(nameLabel);
		
		 
		nameTF=new JTextField();
		nameTF.setBounds(300, 150, 200, 30);
		nameTF.setBackground(Color.BLACK);
		nameTF.setEnabled(false);
		panel.add(nameTF);
		
		idLabel=new JLabel("USER ID: ");
		idLabel.setBounds(150, 200, 100, 30);
		idLabel.setForeground(Color.WHITE);
		panel.add(idLabel);
		 
		idTF=new JTextField();
		idTF.setBounds(300, 200, 200, 30);
		idTF.setBackground(Color.BLACK);
		idTF.setEnabled(false);
		panel.add(idTF);
		
		phnLabel=new JLabel("PHONE NUMBER: ");
		phnLabel.setBounds(150, 250, 100, 30);
		phnLabel.setForeground(Color.WHITE);
		panel.add(phnLabel);
		
		phnTF=new JTextField();
		phnTF.setBounds(300, 250, 200, 30);
		phnTF.setBackground(Color.BLACK);
		phnTF.setEnabled(false);
		panel.add(phnTF);
		
		arealabel=new JLabel("ADDRESS: ");
		arealabel.setBounds(150, 300, 100, 30);
		arealabel.setForeground(Color.WHITE);
		panel.add(arealabel);
		
		areaTF=new JTextField();
		areaTF.setBounds(300, 300, 200, 30);
		areaTF.setEnabled(false);
		areaTF.setBackground(Color.BLACK);
		panel.add(areaTF);
		
		
		subjLabel=new JLabel("SUBJECTS : ");
		subjLabel.setBounds(150, 350, 100, 30);
		subjLabel.setForeground(Color.WHITE);
		panel.add(subjLabel);
		
		subjTF1=new JTextField();
		subjTF1.setBounds(300, 350, 80, 30);
		subjTF1.setBackground(Color.BLACK);
		subjTF1.setEnabled(false);
		panel.add(subjTF1);
		
		subjTF2=new JTextField();
		subjTF2.setBounds(400, 350, 80, 30);
		subjTF2.setBackground(Color.BLACK);
		subjTF2.setEnabled(false);
		panel.add(subjTF2);
		
		subjTF3=new JTextField();
		subjTF3.setBounds(500, 350, 80, 30);
		subjTF3.setBackground(Color.BLACK);
		subjTF3.setEnabled(false);
		panel.add(subjTF3);
		
		mailLabel=new JLabel("GRADE: ");
		mailLabel.setBounds(150, 400, 100, 30);
		mailLabel.setForeground(Color.WHITE);
		panel.add(mailLabel);
	
		mailTF=new JTextField();
		mailTF.setBounds(300, 400, 200, 30);
		mailTF.setBackground(Color.BLACK);
		mailTF.setEnabled(false);
		panel.add(mailTF);
		
		
		wagelabel=new JLabel("BUDGET: ");
		wagelabel.setBounds(150, 450, 100, 30);
		wagelabel.setForeground(Color.WHITE);
		panel.add(wagelabel);
		
		wageTF=new JTextField();
		wageTF.setBounds(300, 450, 200, 30);
		wageTF.setBackground(Color.BLACK);
		wageTF.setEnabled(false);
		panel.add(wageTF);
		
		Back =new JButton("Back");
		Back.setBounds(150,550,100,40);
		Back.setBackground(Color.GREEN);
		Back.addActionListener(this);
		panel.add(Back);
		 
		Logout=new JButton("LOG OUT");
		Logout.setBounds(550, 20, 100, 30);
		Logout.setBackground(Color.RED);
		Logout.addActionListener(this);
		panel.add(Logout);
		
		x=Integer.parseInt(uid);
		
		try
		{
			String query1="SELECT student.*, choice.SubCode_sca from student, choice where `Sid_si`=('"+x+"') AND `Sid_sc`=('"+x+"');";
			//String query2="SELECT `TID_ta` FROM `assignedto` WHERE `TID_ta`= ('"+teacher_id+"');";
			System.out.println(query1);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a07", "root", "");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query1);
			System.out.println("1");
			
			while(rs.next())
			{
				//System.out.println(Integer.toString(rs.getInt("TID_ti")));
				
			nameTF.setText(rs.getString("StudentName"));
			phnTF.setText(Integer.toString(rs.getInt("PhoneNumber")));
			areaTF.setText(rs.getString("Address"));							 
			int sub=(rs.getInt("SubCode_sca"));
			
				if(sub==101)
				{
					subjTF1.setText("English");
				}
				else if(sub==102)
				{
					subjTF2.setText("Bangla");
				}
				else if(sub==103)
				{
					subjTF3.setText("Maths");
				}
				else{}
			
			wageTF.setText(Integer.toString(rs.getInt("Budget")));
			mailTF.setText(rs.getString("Grade"));
			idTF.setText(id);			
			}
			
			rs.close();
			stm.close();
			con.close();
			
		}
		
		catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
			JOptionPane.showMessageDialog(this, "Oops !!!");
        } 
		
		img = new ImageIcon("image2.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0, 0, 800, 700);
		panel.add(imgLabel);
		
		this.add(panel);
		 
	}
	public void actionPerformed(ActionEvent ae)
	{  
		String temp = ae.getActionCommand();
	 
		if (ae.getSource()==Back)
		{
			Student t  =new Student(uid);
			t.setVisible(true);
			this.setVisible(false);
		}
		else if (ae.getSource()==Logout)
		{   
			Login l  =new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
		else
		{
			
		}
	
	}
}