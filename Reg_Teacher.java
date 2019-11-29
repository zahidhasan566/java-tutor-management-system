import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Random;
//import java.util.HashSet;
import java.sql.*;

public class Reg_Teacher extends JFrame implements ActionListener 
{
	
	private JLabel imgLabel,userLabel,nameLabel,idLabel,passlabel,phnLabel,addresslabel,subjLabel,budjetlabel, mailLabel;
	private JTextField nameTF,idTF,passTF,phnTF,addressTF,subjTF,budjetTF, mailTF;
	private JButton Back, logout, reg, gen1, gen2;;
	//private JButton Exit;
	private JPanel panel;
	private JRadioButton rb1, rb2, rb3;
	private ButtonGroup bg;
	private ImageIcon img;
	private int count, max;
	Random r=new Random();
	
	public Reg_Teacher()
	{
		super ("Tutor Management System");
		this.setSize(800,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);
		 
		 
		/*userLabel=new JLabel("Please only register if you are a student ;if you are a teacher please contact the office ");
		userLabel.setBounds(20,20,700,100);
	    panel.add(userLabel);*/
		 
		nameLabel=new JLabel("TEACHER NAME : ");
		nameLabel.setBounds(150, 150, 200, 30);
		nameLabel.setForeground(Color.WHITE);
		panel.add(nameLabel);
		
		 
		nameTF=new JTextField();
		nameTF.setBounds(300, 150, 200, 30);
		panel.add(nameTF);
		
		idLabel=new JLabel("USER ID : ");
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
		
		passlabel=new JLabel("PASSWORD : ");
		passlabel.setBounds(150, 250, 100, 30);
		passlabel.setForeground(Color.WHITE);
		panel.add(passlabel);
		
		passTF=new JTextField();
		passTF.setBounds(300, 250, 200, 30);
		passTF.setVisible(true);
		passTF.setEnabled(false);
		panel.add(passTF);

		gen2=new JButton("GENERATE");
		gen2.setBounds(550,250,100,30);
		gen2.addActionListener(this);
		panel.add(gen2);		
		
		phnLabel=new JLabel("PHONE NUM : ");
		phnLabel.setBounds(150, 300, 100, 30);
		phnLabel.setForeground(Color.WHITE);
		panel.add(phnLabel);
		
		phnTF=new JTextField();
		phnTF.setBounds(300, 300, 200, 30);
		panel.add(phnTF);
		
		mailLabel=new JLabel("Email : ");
		mailLabel.setBounds(150, 350, 100, 30);
		mailLabel.setForeground(Color.WHITE);
		panel.add(mailLabel);
		
		mailTF=new JTextField();
		mailTF.setBounds(300, 350, 200, 30);
		panel.add(mailTF);
		
		
		subjLabel=new JLabel("SUBJECTS : ");
		subjLabel.setBounds(150, 400, 100, 30);
		subjLabel.setForeground(Color.WHITE);
		panel.add(subjLabel);
		
		
		rb1=new JRadioButton("Bangla");
		rb1.setBounds(300, 400, 100, 30);
		rb1.setForeground(Color.WHITE);
		rb1.setOpaque(false);
		panel.add(rb1);
		
		rb2=new JRadioButton("English");
		rb2.setBounds(400, 400, 100, 30);
		rb2.setForeground(Color.WHITE);
		rb2.setOpaque(false);
		panel.add(rb2);
		
		rb3=new JRadioButton("Maths");
		rb3.setBounds(500, 400, 100, 30);
		rb3.setForeground(Color.WHITE);
		rb3.setOpaque(false);
		panel.add(rb3);
		
		bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
		
		addresslabel=new JLabel("AREA : ");
		addresslabel.setBounds(150, 450, 100, 30);
		addresslabel.setForeground(Color.WHITE);
		panel.add(addresslabel);
	
		addressTF=new JTextField();
		addressTF.setBounds(300, 450, 200, 30);
		panel.add(addressTF);
		
		
		budjetlabel=new JLabel("WAGE : ");
		budjetlabel.setBounds(150, 500, 100, 30);
		budjetlabel.setForeground(Color.WHITE);
		panel.add(budjetlabel);
		
		
		budjetTF=new JTextField();
		budjetTF.setBounds(300, 500, 200, 30);
		panel.add(	budjetTF);
		
		Back =new JButton("Back");
		Back.setBounds(50,600,100,40);
		Back.setBackground(Color.GREEN);
		Back.addActionListener(this);
		panel.add(Back);
		 
		reg =new JButton("REGISTER");
		reg.setBounds(350,550,100,40);
		reg.setBackground(Color.BLUE);
		reg.addActionListener(this);
		reg.setForeground(Color.WHITE);
		panel.add(reg);
		
		logout =new JButton("LOG OUT");
		logout.setBounds(650,50,100,40);
		logout.setBackground(Color.RED);
		logout.addActionListener(this);
		panel.add(logout);
		
		img = new ImageIcon("image2.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0, 0, 800, 700);
		panel.add(imgLabel);
		
		this.add(panel);
		 
	}
	public void actionPerformed(ActionEvent ae)
	{  
		//String temp = ae.getActionCommand();
		if (ae.getSource()==logout)
		{
			Login l  =new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
	    else if (ae.getSource()==reg)
		{
			//JOptionPane.showMessageDialog(this,"Registered");
			//Login l  =new Login();
			//l.setVisible(true);
			//this.setVisible(false);
			insertIntoDB();
		}
		else if (ae.getSource()==gen1)
		{
			try
			{
				String query1="SELECT COUNT(*) AS `total` from `teacher`";
				String query2="SELECT MAX(TID_ti) AS `m` from `teacher`";
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
					int x=1900;
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
		else if (ae.getSource()== Back)
		{
			Admin l  =new Admin();
			l.setVisible(true);
			this.setVisible(false);
		}
	}
	
	public void insertIntoDB()
	{
		String new_name = nameTF.getText();
		String new_id = idTF.getText();
		int new_pass = Integer.parseInt(passTF.getText());
		String new_phone = phnTF.getText();
		String new_address = addressTF.getText();
		String new_mail= mailTF.getText();
		//String sub1=null;
		//String sub2=null;
		//String sub3=null;
		
		String new_budget = budjetTF.getText();
		String new_sub = null;
		//String new_grade = gradeTF.getText();
		//String role=tf4.getText();
		
		int a=102;
		int b=1;
		//int c=103;
		
		if(rb1.isSelected())
		{
			//stm.execute(query3a);
			//System.out.println("3a");
			new_sub=rb1.getText();
			a=102;
		}
		else if(rb2.isSelected())
		{
			//stm.execute(query3b);
			//System.out.println("3b");
			new_sub=rb2.getText();
			a=101;
		}
		else if(rb3.isSelected())
		{
			//stm.execute(query3c);
			//System.out.println("3c");
			new_sub=rb3.getText();
			a=103;
		}
		else{}
		int status = 3;
		
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
            String query1="INSERT into teacher VALUES ('"+new_id+"','"+new_name+"','"+new_phone+"','"+new_address+"','"+a+"','"+new_budget+"','"+new_mail+"');";
			System.out.println(query1);
			//String query1="INSERT into student VALUES ('"+new_id+"','"+new_name+"','"+new_phone+"','"+new_address+"','"+new_budget+"','"+new_grade+"');";
			String query3a = "INSERT INTO preference VALUES ('"+b+"','"+b+"','"+new_id+"');";
			//String query3b = "INSERT INTO choice VALUES ('"+new_id+"','"+b+"');";
			//String query3c = "INSERT INTO choice VALUES ('"+new_id+"','"+c+"');";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a07", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			System.out.println("1");
			stm.execute(query2);
			System.out.println("2");
			stm.execute(query3a);
			System.out.println("3");
			
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this,"Registered!!!");
			Reg_Teacher l  =new Reg_Teacher();
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