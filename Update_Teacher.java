import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*; 
public class Update_Teacher extends JFrame implements ActionListener, MouseListener 
{
	
	private JLabel passLabel,prefLabel,userLabel,nameLabel,idLabel,phnLabel,arealabel,subjLabel,mailLabel,wagelabel,imgLabel;
	private JTextField nameTF,passTF,phnTF,areaTF,subjTF1,mailTF,wageTF,subjTF2,subjTF3;
	private ImageIcon img;
	private JRadioButton cb1, cb2,cb3; 
	private JRadioButton sl1, sl2;
	private ButtonGroup bg;
	private JButton Back;
	private JButton Logout, Update;
		
	private JPanel panel;
	String uid;
	int x;
	boolean flag_sub=false;
	boolean flag_pref=false;
	
	public Update_Teacher(String id)
	{
		super ("Update Teacher's Information");
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
		//nameTF.setBackground(Color.BLACK);
		//nameTF.setEnabled(false);
		nameTF.addMouseListener(this);
		panel.add(nameTF);
		
		passLabel=new JLabel("Password: ");
		passLabel.setBounds(150, 200, 100, 30);
		passLabel.setForeground(Color.WHITE);
		panel.add(passLabel);
		 
		passTF=new JTextField();
		passTF.setBounds(300, 200, 200, 30);
		//passTF.setBackground(Color.BLACK);
		//idTF.setEnabled(false);
		passTF.addMouseListener(this);
		panel.add(passTF);
		
		phnLabel=new JLabel("PHONE NUMBER: ");
		phnLabel.setBounds(150, 250, 100, 30);
		phnLabel.setForeground(Color.WHITE);
		panel.add(phnLabel);
		
		phnTF=new JTextField();
		phnTF.setBounds(300, 250, 200, 30);
		//phnTF.setBackground(Color.BLACK);
		//phnTF.setEnabled(false);
		phnTF.addMouseListener(this);
		panel.add(phnTF);
		
		arealabel=new JLabel("AREA: ");
		arealabel.setBounds(150, 300, 100, 30);
		arealabel.setForeground(Color.WHITE);
		panel.add(arealabel);
		
		areaTF=new JTextField();
		areaTF.setBounds(300, 300, 200, 30);
		//areaTF.setEnabled(false);
		//areaTF.setBackground(Color.BLACK);
		areaTF.addMouseListener(this);
		panel.add(areaTF);
		
		
		subjLabel=new JLabel("SUBJECTS : ");
		subjLabel.setBounds(150, 350, 100, 30);
		subjLabel.setForeground(Color.WHITE);
		panel.add(subjLabel);
		
		cb1=new JRadioButton("English");
		cb1.setBounds(300, 350, 80, 30);
		cb1.setForeground(Color.WHITE);
		//subjTF1.setEnabled(false);
		cb1.setOpaque(false);
		panel.add(cb1);
		
		cb2=new JRadioButton("Bangla");
		cb2.setBounds(430, 350, 80, 30);
		cb2.setForeground(Color.WHITE);
		//subjTF1.setEnabled(false);
		cb2.setOpaque(false);
		panel.add(cb2);
		
		cb3=new JRadioButton("Maths");
		cb3.setBounds(560, 350, 80, 30);
		cb3.setForeground(Color.WHITE);
		//subjTF1.setEnabled(false);
		cb3.setOpaque(false);
		panel.add(cb3);
		
		bg = new ButtonGroup();
        bg.add(cb1);
        bg.add(cb2);
        bg.add(cb3);
		
		mailLabel=new JLabel("MAIL: ");
		mailLabel.setBounds(150, 400, 100, 30);
		mailLabel.setForeground(Color.WHITE);
		panel.add(mailLabel);
	
		mailTF=new JTextField();
		mailTF.setBounds(300, 400, 200, 30);
		//mailTF.setBackground(Color.BLACK);
		//mailTF.setEnabled(false);
		mailTF.addMouseListener(this);
		panel.add(mailTF);
		
		wagelabel=new JLabel("WAGE : ");
		wagelabel.setBounds(150, 450, 100, 30);
		wagelabel.setForeground(Color.WHITE);
		panel.add(wagelabel);
		
		wageTF=new JTextField();
		wageTF.setBounds(300, 450, 200, 30);
		//wageTF.setBackground(Color.BLACK);
		//wageTF.setEnabled(false);
		wageTF.addMouseListener(this);
		panel.add(wageTF);
		
		Back =new JButton("Back");
		Back.setBounds(150,550,100,40);
		Back.setBackground(Color.GREEN);
		Back.addActionListener(this);
		panel.add(Back);
		
		Update =new JButton("UPDATE");
		Update.setBounds(350,550,100,40);
		Update.setBackground(Color.BLUE);
		Update.setForeground(Color.WHITE);
		Update.addActionListener(this);
		panel.add(Update);
		 
		Logout=new JButton("LOG OUT");
		Logout.setBounds(550, 20, 100, 30);
		Logout.setBackground(Color.RED);
		Logout.addActionListener(this);
		panel.add(Logout);
		
		prefLabel=new JLabel("PREFERENCE: ");
		prefLabel.setBounds(150, 500, 100, 30);
		prefLabel.setForeground(Color.WHITE);
		panel.add(prefLabel);
		
		sl1=new JRadioButton("By Mail");
		sl1.setBounds(300, 500, 80, 30);
		//wageTF.setBackground(Color.BLACK);
		//wageTF.setEnabled(false);
		sl1.setOpaque(false);
		sl1.setForeground(Color.WHITE);
		panel.add(sl1);
		
		sl2=new JRadioButton("By Phone");
		sl2.setBounds(430, 500, 80, 30);
		//wageTF.setBackground(Color.BLACK);
		//wageTF.setEnabled(false);
		sl2.setOpaque(false);
		sl2.setForeground(Color.WHITE);
		panel.add(sl2);
		
		x=Integer.parseInt(uid);
		
		try
		{
			String query1="SELECT * FROM `teacher` where `TID_ti`=('"+x+"');";
			//String query2="SELECT `Password` FROM `login` where `UserId_ui`=('"+x+"');";
			//String query2="SELECT `TID_ta` FROM `assignedto` WHERE `TID_ta`= ('"+teacher_id+"');";
			System.out.println(query1);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a07", "root", "");
			Statement stm = con.createStatement();
			ResultSet rs1= stm.executeQuery(query1);
			//ResultSet rs2 = stm.executeQuery(query2);
			System.out.println("100");
			
			while(rs1.next())
			{
				//System.out.println(Integer.toString(rs.getInt("TID_ti")));
				
			nameTF.setText(rs1.getString("TeacherName"));
			phnTF.setText(Integer.toString(rs1.getInt("PhoneNumber")));
			areaTF.setText(rs1.getString("Area"));							 
			
			wageTF.setText(Integer.toString(rs1.getInt("Wage")));
			mailTF.setText(rs1.getString("Mail"));
			//idTF.setText(id);
			System.out.println("12");						
			}
			/*System.out.println("12");
			while(rs2.next())
			{
				passTF.setText(Integer.toString(rs2.getInt("Password")));		
			}
			*/
			//rs2.close();
			//rs.close();
			stm.close();
			con.close();
			
		}
		
		catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
			JOptionPane.showMessageDialog(this, "Oops !!!");
        } 
		
		
		try
		{
			
			String query2="SELECT `Password` FROM `login` where `UserId_ui`=('"+x+"');";
			System.out.println(query2);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a07", "root", "");
			Statement stm = con.createStatement();
			
			ResultSet rs2 = stm.executeQuery(query2);
			System.out.println("100");
			
			System.out.println("12");
			while(rs2.next())
			{
				passTF.setText(Integer.toString(rs2.getInt("Password")));		
			}
			//rs2.close();
			//rs.close();
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
			Teacher t  =new Teacher(uid);
			t.setVisible(true);
			this.setVisible(false);
		}
		else if (ae.getSource()==Logout)
		{   
			Login l  =new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getSource()==Update)
		{
			goUpdate();
		}
	
	}
	
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}
	public void mouseClicked(MouseEvent me)
	{
		if(me.getSource()==nameTF)
		{
			nameTF.setText("");
		}
		else if(me.getSource()==passTF)
		{
			passTF.setText("");
		}
		else if(me.getSource()==phnTF)
		{
			phnTF.setText("");
		}
		else if(me.getSource()==areaTF)
		{
			areaTF.setText("");
		}
		else if(me.getSource()==wageTF)
		{
			wageTF.setText("");
		}
		else if(me.getSource()==mailTF)
		{
			mailTF.setText("");
		}
	}
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void goUpdate()
	{
		String new_name = nameTF.getText();
		int new_pass = Integer.parseInt(passTF.getText());
		String new_phone = phnTF.getText();
		String new_address = areaTF.getText();
		String new_mail= mailTF.getText();
		//String sub1=null;
		//String sub2=null;
		//String sub3=null;
		
		String new_budget = wageTF.getText();
		String new_sub = null;
		String new_pref = null;
		//String new_grade = gradeTF.getText();
		//String role=tf4.getText();
		
		int a=102;
		int prefmail=0;
		int prefphn=0;
		
		//int c=103;
		
		if(cb2.isSelected())
		{
			//stm.execute(query3a);
			//System.out.println("3a");
			new_sub=cb2.getText();
			a=102;
			flag_sub=true;
		}
		else if(cb1.isSelected())
		{
			//stm.execute(query3b);
			//System.out.println("3b");
			new_sub=cb1.getText();
			a=101;
			flag_sub=true;
		}
		else if(cb3.isSelected())
		{
			//stm.execute(query3c);
			//System.out.println("3c");
			new_sub=cb3.getText();
			a=103;
			flag_sub=true;
		}
		else{}
		if(sl1.isSelected())
		{
			//stm.execute(query3a);
			//System.out.println("3a");
			new_pref=sl1.getText();
			prefmail=1;
			flag_pref=true;
		}
		else if(sl2.isSelected())
		{
			//stm.execute(query3a);
			//System.out.println("3a");
			new_pref=sl2.getText();
			prefphn=1;
			flag_pref=true;
		}
		else{}
		
		try
		{
			if(flag_sub==false)
			{
				JOptionPane.showMessageDialog(this,"Missing!!!, Retry");
				Update_Teacher l  =new Update_Teacher(uid);
				l.setVisible(true);
				this.setVisible(false);
				return ;
			}
			else if(flag_pref==false)
			{
				JOptionPane.showMessageDialog(this,"Missing!!!, Retry");
				Update_Teacher l  =new Update_Teacher(uid);
				l.setVisible(true);
				this.setVisible(false);
				return ;
				
			}
			
			String query2 = "UPDATE `Login` set `Password`=('"+new_pass+"') where `UserId_ui`=('"+uid+"');";
			System.out.println(query2);
            String query1="UPDATE `Teacher` set `TeacherName`=('"+new_name+"'),`PhoneNumber`=('"+new_phone+"'),`Area`=('"+new_address+"'),`Subjectcode_aa`=('"+a+"'),`Wage`=('"+new_budget+"'), `Mail`=('"+new_mail+"') where `TID_ti`=('"+uid+"');";
			System.out.println(query1);
			//String query1="INSERT into student VALUES ('"+new_id+"','"+new_name+"','"+new_phone+"','"+new_address+"','"+new_budget+"','"+new_grade+"');";
			String query3a = "UPDATE `Preference` set `IsMail`=('"+prefmail+"'),`IsPhone`=('"+prefphn+"') where `TID_tp`=('"+uid+"');";
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
			JOptionPane.showMessageDialog(this,"Updated!!!");
			Update_Teacher l  =new Update_Teacher(uid);
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