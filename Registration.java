import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Random;
//import java.util.HashSet;
import java.sql.*;

public class Registration extends JFrame implements ActionListener 
{
	
	private JLabel userLabel,nameLabel,idLabel,passlabel,phnLabel,addresslabel,subjLabel,gradeLabel,budjetlabel,imgLabel;
	private JTextField nameTF,idTF,passTF,phnTF,addressTF,subjTF,gradeTF,budjetTF;
	private JCheckBox cb1, cb2,cb3;
	private JButton Back, gen1, gen2;
	private JButton Register;
	private ImageIcon img;
	private JPanel panel;
	private int count, max;
	Random r=new Random();
	//HashSet<Integer> set=new HashSet<>();
	
	public Registration()
	{
		super ("Registration Student");
		
		this.setSize(800,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);
		
		 
		 
		userLabel=new JLabel("Please only register if you are a student. If you are a teacher please contact the office");
		userLabel.setBounds(20,20,700,100);
		userLabel.setForeground(Color.WHITE);
		panel.add(userLabel);
		 
		nameLabel=new JLabel("USER NAME: ");
		nameLabel.setBounds(150, 150, 200, 30);
		nameLabel.setForeground(Color.WHITE);
		panel.add(nameLabel);
		System.out.println("reg1");
		 
		nameTF=new JTextField();
		nameTF.setBounds(300, 150, 200, 30);
		panel.add(nameTF);
		
		idLabel=new JLabel("USER ID: ");
		idLabel.setBounds(150, 200, 100, 30);
		idLabel.setForeground(Color.WHITE);
		panel.add(idLabel);
		 
		idTF=new JTextField();
		idTF.setBounds(300, 200, 200, 30);
		idTF.setEnabled(false);
		panel.add(idTF);
		
		gen1=new JButton("GENERATE");
		gen1.setBounds(550,200,100,30);
		gen1.addActionListener(this);
		panel.add(gen1);
		
		passlabel=new JLabel("PASSWORD: ");
		passlabel.setBounds(150, 250, 100, 30);
		passlabel.setForeground(Color.WHITE);
		panel.add(passlabel);	
		

		passTF=new JTextField(r.nextInt(20)+1100);
		passTF.setBounds(300, 250, 200, 30);
		passTF.setVisible(true);
		passTF.setEnabled(false);
		panel.add(passTF);
		
		gen2=new JButton("GENERATE");
		gen2.setBounds(550,250,100,30);
		gen2.addActionListener(this);
		panel.add(gen2);
		
		phnLabel=new JLabel("PHONE NUMBER: ");
		phnLabel.setBounds(150, 300, 100, 30);
		phnLabel.setForeground(Color.WHITE);
		panel.add(phnLabel);
		
		phnTF=new JTextField();
		phnTF.setBounds(300, 300, 200, 30);
		panel.add(phnTF);
		
		addresslabel=new JLabel("ADDRESS: ");
		addresslabel.setBounds(150, 350, 100, 30);
		addresslabel.setForeground(Color.WHITE);
		panel.add(addresslabel);
		
		addressTF=new JTextField();
		addressTF.setBounds(300, 350, 200, 30);
		panel.add(addressTF);
		
		
		subjLabel=new JLabel("SUBJECTS: ");
		subjLabel.setBounds(150, 400, 100, 30);
		subjLabel.setForeground(Color.WHITE);
		panel.add(subjLabel);
		
		
		cb1 = new JCheckBox("BANGLA");
        cb1.setBounds(300, 400, 100, 30);
		cb1.setForeground(Color.WHITE);
		cb1.setOpaque(false);
        panel.add(cb1);
		
		cb2 = new JCheckBox("ENGLISH");
        cb2.setBounds(400, 400, 100, 30);
		cb2.setForeground(Color.WHITE);
		cb2.setOpaque(false);
        panel.add(cb2);
		
		cb3 = new JCheckBox("MATH");
        cb3.setBounds(500, 400, 100, 30);
		cb3.setForeground(Color.WHITE);
		cb3.setOpaque(false);
        panel.add(cb3);
		
		
		gradeLabel=new JLabel("CLASS : ");
		gradeLabel.setBounds(150, 450, 100, 30);
		gradeLabel.setForeground(Color.WHITE);
		panel.add(gradeLabel);
	
		gradeTF=new JTextField();
		gradeTF.setBounds(300, 450, 200, 30);
		panel.add(gradeTF);
		
		
		budjetlabel=new JLabel("BUDGET : ");
		budjetlabel.setBounds(150, 500, 100, 30);
		budjetlabel.setForeground(Color.WHITE);
		panel.add(budjetlabel);
		
		
		
		budjetTF=new JTextField();
		budjetTF.setBounds(300, 500, 200, 30);
		panel.add(	budjetTF);
		
	   
		
		Back =new JButton("Back");
		Back.setBounds(300,550,100,40);
		Back.setBackground(Color.GREEN);
		Back.addActionListener(this);
		panel.add(Back);
		 
		Register =new JButton("Register");
		Register.setBounds(430,550,100,40);
		Register.setBackground(Color.BLUE);
		Register.setForeground(Color.WHITE);
		Register.addActionListener(this);
		panel.add(Register);
		
		img = new ImageIcon("image2.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0, 0, 800, 700);
		panel.add(imgLabel);
		
		this.add(panel);
		 
	}
	public void actionPerformed(ActionEvent ae)
	 {  
		//String temp = ae.getActionCommand();
		if (ae.getSource()==Back)
		{
			Login l  =new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
	    else if (ae.getSource()==Register)
		{
			insertIntoDB();
		}
		else if (ae.getSource()==gen1)
		{
		
			try
			{
				String query1="SELECT COUNT(*) AS `total` from `student`";
				String query2="SELECT MAX(Sid_si) AS `m` from `student`";
				//String query2="SELECT `TID_ta` FROM `assignedto` WHERE `TID_ta`= ('"+teacher_id+"');";
				System.out.println(query1);
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a07", "root", "");
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(query1);
				System.out.println("1");
				
				while(rs.next())
				{
					count=rs.getInt("total");
				}
				
				//count=rs.getInt("total");
				System.out.println(count);
				if(count==0)
				{
					System.out.println("count1");
					int x=1700;
					idTF.setText(""+x);
					System.out.println("count2");
				}
				else 
				{
					rs = stm.executeQuery(query2);
					while(rs.next())
					{
						max=rs.getInt("m");
					}
					//int x= rs.getInt("m");
					idTF.setText(""+(max+1));
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
		}
		else if (ae.getSource()==gen2)
		{
			int x=r.nextInt(999)+1000;
			passTF.setText(""+x);
		}
	}
	
	public void insertIntoDB()
	{
		String new_name = nameTF.getText();
		String new_id = idTF.getText();
		int new_pass = Integer.parseInt(passTF.getText());
		String new_phone = phnTF.getText();
		String new_address = addressTF.getText();
		String sub1=null;
		String sub2=null;
		String sub3=null;
		
		
		
		String new_budget = budjetTF.getText();
		String new_grade = gradeTF.getText();
		//String role=tf4.getText();
		
		int status = 2;
		int a=102;
		int b=101;
		int c=103;
		//System.out.println(query1);
		//System.out.println(query2);
        try
		{

			//String y=Integer.toString(r.nextInt(1000000));
			//String a="";
			//double x=Double.parseDouble(tf3.getText());
			//double z=Double.parseDouble(tf6.getText());
			//String phnNo = tf3.getText();

			String query2 = "INSERT INTO Login VALUES ('"+new_id+"','"+new_pass+"',"+status+");";
			System.out.println(query2);
            String query1="INSERT into student VALUES ('"+new_id+"','"+new_name+"','"+new_phone+"','"+new_address+"','"+new_budget+"','"+new_grade+"');";
			System.out.println(query1);
			//String query1="INSERT into student VALUES ('"+new_id+"','"+new_name+"','"+new_phone+"','"+new_address+"','"+new_budget+"','"+new_grade+"');";
			String query3a = "INSERT INTO choice VALUES ('"+new_id+"','"+a+"');";
			String query3b = "INSERT INTO choice VALUES ('"+new_id+"','"+b+"');";
			String query3c = "INSERT INTO choice VALUES ('"+new_id+"','"+c+"');";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a07", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			System.out.println("1");
			stm.execute(query2);
			System.out.println("2");
			if(cb1.isSelected())
			{
				stm.execute(query3a);
				System.out.println("3a");
			}
			if(cb2.isSelected())
			{
				stm.execute(query3b);
				System.out.println("3b");
			}
			if(cb3.isSelected())
			{
				stm.execute(query3c);
				System.out.println("3c");
			}
			/*else
			{
				JOptionPane.showMessageDialog(this,"Vacant Field");
				Registration r  =new Registration();
				r.setVisible(true);
				this.setVisible(false);
			}*/
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this,"Registered!!!");
			Login l  =new Login();
			l.setVisible(true);
			this.setVisible(false);			
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
    }
}