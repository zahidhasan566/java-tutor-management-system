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

public class Assign extends JFrame implements ActionListener
{
	private JLabel imgLabel,TeacherLabel,StudentLabel;
	private JTextField TTF,STF;
	private JButton Assign;
	private JButton Back;
	private JButton Logout;
	private JPanel panel;
	private ImageIcon img;
	private JTable table1, table2;
	private JScrollPane tableScrollPane1,tableScrollPane2;
	
	public Assign()
	{
		super (" Assign ");
		this.setSize(800,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);
		
		TeacherLabel=new JLabel("TEACHER ID : ");
		TeacherLabel.setBounds(150, 150, 200, 30);
		TeacherLabel.setForeground(Color.WHITE);
		panel.add(TeacherLabel);
		 
		TTF=new JTextField();
		TTF.setBounds(300,150, 200, 30);
		panel.add(TTF);
		
		StudentLabel=new JLabel("STUDENT ID : ");
		StudentLabel.setBounds(150, 200, 100, 30);
		StudentLabel.setForeground(Color.WHITE);
		panel.add(StudentLabel);
		
		STF=new JTextField();
		STF.setBounds(300, 200, 200, 30);
		panel.add(STF);
		
		Assign =new JButton("ASSIGN");
		Assign.setBounds(300,250,100,30);
		Assign.setBackground(Color.GREEN);
		Assign.addActionListener(this);
		panel.add(Assign);
		 
		Back =new JButton("BACK");
		Back.setBounds(50,600,100,40);
		Back.setBackground(Color.GREEN);
		Back.addActionListener(this);
		panel.add(Back);
		 
		Logout=new JButton("LOG OUT");
		Logout.setBounds(650,50,100,40);
		Logout.setBackground(Color.RED);
		Logout.addActionListener(this);
		panel.add(Logout);
		
		String []col1 ={"Teacher ID", "Name"};
		table1 = new JTable(0,2);
		
		for(int i=0;i<table1.getColumnCount();i++)
		{
			TableColumn column1 = table1.getTableHeader().getColumnModel().getColumn(i);
			column1.setHeaderValue(col1[i]);
		} 
		
		DefaultTableModel model1 = (DefaultTableModel) table1.getModel();
		
		try
		{
			String query1="SELECT * FROM teacher";
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
				model1.addRow(new Object[]{Integer.toString(rs.getInt("TID_ti")),
										 rs.getString("TeacherName")});
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
		
		tableScrollPane1 = new JScrollPane(table1);
		tableScrollPane1.setBounds(50,300,325,270);
		tableScrollPane1.setEnabled(false);
		panel.add(tableScrollPane1);
		
		/////
		String []col2 ={"Student ID", "Name"};
		table2 = new JTable(0,2);
		
		for(int i=0;i<table2.getColumnCount();i++)
		{
			TableColumn column1 = table2.getTableHeader().getColumnModel().getColumn(i);
			column1.setHeaderValue(col2[i]);
		} 
		
		DefaultTableModel model2 = (DefaultTableModel) table2.getModel();
		
		try
		{
			String query1="SELECT * FROM student";
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
				model2.addRow(new Object[]{Integer.toString(rs.getInt("Sid_si")),
										 rs.getString("StudentName")});
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
		
		tableScrollPane2 = new JScrollPane(table2);
		tableScrollPane2.setBounds(400,300,325,270);
		tableScrollPane2.setEnabled(false);
		panel.add(tableScrollPane2);
		
		img = new ImageIcon("image2.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0, 0, 800, 700);
		panel.add(imgLabel);
		
		this.add(panel);
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{  
		//String temp = ae.getActionCommand();
		if (ae.getSource()==Logout)
		{
			Login l  =new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
	    else if (ae.getSource()==Assign)
		{
			//JOptionPane.showMessageDialog(this,"Registered");
			//Login l  =new Login();
			//l.setVisible(true);
			//this.setVisible(false);
			insertIntoDB();
		}
		else if (ae.getSource()== Back)
		{
			Admin l  =new Admin();
			l.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
	
	public void insertIntoDB()
	{
		String teacher_id = TTF.getText();
		String student_id = STF.getText();
        try
		{
		
			String query1="INSERT into assignedto VALUES ('"+student_id+"','"+teacher_id+"');";
			System.out.println(query1);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a07", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			System.out.println("1");
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this,"Assigned");
			Assign l  =new Assign();
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