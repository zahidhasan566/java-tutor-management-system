import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Random;
//import java.util.HashSet;
import java.sql.*;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class ViewMyTeacher extends JFrame implements ActionListener
{
	private JLabel imgLabel, label, rateteacher;
	private JTextField trate;
	private JButton Back;
	private JButton Logout,rate;
	private JPanel panel;
	private ImageIcon img;
	private JTable table;
	private JScrollPane tableScrollPane;
	private JRadioButton r1, r2, r3, r4, r5;
	private ButtonGroup bg;
	String uid;
	int student_id;
	public ViewMyTeacher(String id)
	{
		super (" View_My_Teacher ");
		
		this.setSize(800,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);
		
		uid=id;
		student_id=Integer.parseInt(uid);
		
		label=new JLabel("My Teachers: ");
		label.setForeground(Color.WHITE);
		label.setBounds(50, 70, 200, 30);
		panel.add(label);
		 
		trate=new JTextField();
		trate.setBounds(50,460, 200, 30);
		System.out.println("In constructor");
		//trate.addActionListener(this);
		panel.add(trate);
		
		rate =new JButton("Rate");
		rate.setBounds(300,460,100,30);
		rate.setBackground(Color.RED);
		rate.setForeground(Color.WHITE);
		rate.addActionListener(this);
		panel.add(rate);
		
		rateteacher=new JLabel("Stars: ");
		rateteacher.setForeground(Color.WHITE);
		rateteacher.setBounds(50,500, 100, 30);
		panel.add(rateteacher);
		
		r1=new JRadioButton("1");
		r1.setBounds(100,500, 40, 30);
		r1.setForeground(Color.WHITE);
		//subjTF1.setEnabled(false);
		r1.setOpaque(false);
		panel.add(r1);
		
		r2=new JRadioButton("2");
		r2.setBounds(150,500, 40, 30);
		r2.setForeground(Color.WHITE);
		//subjTF1.setEnabled(false);
		r2.setOpaque(false);
		panel.add(r2);
		
		r3=new JRadioButton("3");
		r3.setBounds(200,500, 40, 30);
		r3.setForeground(Color.WHITE);
		//subjTF1.setEnabled(false);
		r3.setOpaque(false);
		panel.add(r3);
		
		r4=new JRadioButton("4");
		r4.setBounds(250,500, 40, 30);
		r4.setForeground(Color.WHITE);
		//subjTF1.setEnabled(false);
		r4.setOpaque(false);
		panel.add(r4);
		
		r5=new JRadioButton("5");
		r5.setBounds(300,500, 40, 30);
		r5.setForeground(Color.WHITE);
		//subjTF1.setEnabled(false);
		r5.setOpaque(false);
		panel.add(r5);
		
		bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
		bg.add(r4);
		bg.add(r5);
		
		Back =new JButton("BACK");
		Back.setBounds(50,600,100,30);
		Back.setBackground(Color.GREEN);
		Back.addActionListener(this);
		panel.add(Back);
		
		Logout=new JButton("LOG OUT");
		Logout.setBounds(550, 20, 100, 30);
		Logout.setBackground(Color.RED);
		Logout.addActionListener(this);
		panel.add(Logout);
		
		String []col ={"ID","Name","Phone","Mail","Area","Subject","Wage"};
		
		table = new JTable(0,7);
		  
		for(int i=0;i<table.getColumnCount();i++)
		{
			TableColumn column1 = table.getTableHeader().getColumnModel().getColumn(i);
			column1.setHeaderValue(col[i]);
		} 
		
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		try
		{
			String query1="Select teacher.*, preference.IsMail AS Mail1, preference.IsPhone As Phone1 from teacher, preference,assignedto where TID_ti= Tid_tp AND TID_ta=Tid_tp AND Sid_sa=('"+student_id+"');";
			//String query2="SELECT `TID_ta` FROM `assignedto` WHERE `TID_ta`= ('"+teacher_id+"');";
			System.out.println(query1);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a07", "root", "");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query1);
			System.out.println("1");
			
			int x;
			
			while(rs.next()){
				//System.out.println(Integer.toString(rs.getInt("TID_ti")));
				String sub="NULL";
				x=rs.getInt("Subjectcode_aa");
				int m=rs.getInt("Mail1");
				int p=rs.getInt("Phone1");
				String prefm=null;
				int prefp=0;
				if(x==101)
				{
					sub="English";
				}
				else if(x==102)
				{
					sub="Bangla";
				}
				else if(x==103)
				{
					sub="Maths";
				}
				else{}
				if(m==1)
				{
					prefm=rs.getString("Mail");
				}
				else
				{
					prefm="Hidden";
				}
				if(p==1)
				{
					prefp=rs.getInt("PhoneNumber");
				}
				else
				{
					prefp=0000;
				}
				model.addRow(new Object[]{Integer.toString(rs.getInt("TID_ti")),
										 rs.getString("TeacherName"),
										 Integer.toString(prefp),
										 prefm,
										 rs.getString("Area"),
										 sub,
										 Integer.toString(rs.getInt("Wage"))});
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
		
		tableScrollPane = new JScrollPane(table);
		tableScrollPane.setBounds(50,120,680,330);
		tableScrollPane.setEnabled(false);
		panel.add(tableScrollPane);

		
		img = new ImageIcon("image2.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0, 0, 800, 700);
		panel.add(imgLabel);
		 
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{  
		
		if (ae.getSource()==Logout)
		{
			Login l  =new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
		else if (ae.getSource()== Back)
		{
			Student l  =new Student(uid);
			l.setVisible(true);
			this.setVisible(false);
		}
		else if (ae.getSource()== rate)
		{
			goRate();
		}
		else{}
	}
	public void goRate()
	{
		int search = Integer.parseInt(trate.getText());
		double r=0;
		boolean flag=true;
		if(r1.isSelected())
		{
			r=Double.parseDouble(r1.getText());
		}
		else if(r2.isSelected())
		{
			r=Double.parseDouble(r2.getText());
		}
		else if(r3.isSelected())
		{
			r=Double.parseDouble(r3.getText());
		}
		else if(r4.isSelected())
		{
			r=Double.parseDouble(r4.getText());
		}
		else if(r5.isSelected())
		{
			r=Double.parseDouble(r5.getText());
		}
		else
		{
			flag=false;
		}
		
		try
		{
			if(flag==false)
			{
				JOptionPane.showMessageDialog(this,"Missing!!!, Retry");
				ViewMyTeacher l  =new ViewMyTeacher(uid);
				l.setVisible(true);
				this.setVisible(false);
				return ;
			}
			
            String query1="INSERT INTO rating VALUES ('"+r+"','"+student_id+"',"+search+");";
			System.out.println(query1);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a07", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			System.out.println("1");
			
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this,"Rated!!!");
			ViewMyTeacher l  =new ViewMyTeacher(uid);
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
