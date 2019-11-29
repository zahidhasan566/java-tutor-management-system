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

public class Available_Student1 extends JFrame implements ActionListener
{
	private JLabel imgLabel, label, searchteacher;
	private JTextField TTF;
	private JButton delete, Show;
	private JButton Back;
	private JButton Logout;
	private JPanel panel;
	private ImageIcon img;
	private JTable table;
	private JScrollPane tableScrollPane;
	String uid;
	int xid, code;
	public Available_Student1(String id)
	{
		super (" Show_Student ");
		this.setSize(800,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);
		
		uid=id;
		xid=Integer.parseInt(id);
		
		label=new JLabel("Students Interested In My Subject: ");
		label.setForeground(Color.WHITE);
		label.setBounds(50, 70, 400, 30);
		panel.add(label);
		 
		 
		Back =new JButton("BACK");
		Back.setBounds(50,600,100,30);
		Back.setBackground(Color.GREEN);
		Back.addActionListener(this);
		panel.add(Back);
		
		Show =new JButton("SHOW ALL STUDENTS");
		Show.setBounds(530,600,200,30);
		Show.setBackground(Color.BLUE);
		Show.setForeground(Color.WHITE);
		Show.addActionListener(this);
		panel.add(Show);
		 
		Logout=new JButton("LOG OUT");
		Logout.setBounds(550, 20, 100, 30);
		Logout.setBackground(Color.RED);
		Logout.addActionListener(this);
		panel.add(Logout);
		
				
		//String [][]row;
		String []col ={"ID", "Name", "Phone", "Area", "Budget", "Grade", "Subject"};
		
		table = new JTable(0,7);
		
		//String header[] = {"name", "age", "gpa", "address", "color", "food"};
  
		for(int i=0;i<table.getColumnCount();i++)
		{
			TableColumn column1 = table.getTableHeader().getColumnModel().getColumn(i);
			column1.setHeaderValue(col[i]);
		} 
		
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		//model.addRow(new Object[]{"Column 1", "Column 2", "Column 3","Column 1", "Column 2", "Column 3", "col 7"});
	
		//db connection initialize
		try
		{
			//String query1="SELECT student.*, choice.SubCode_sca from student,choice where student.Sid_si=choice.Sid_sc";
			String query2="SELECT `Subjectcode_aa` FROM `teacher` WHERE `TID_ti`= ('"+xid+"');";
			
			//String query2="SELECT `TID_ta` FROM `assignedto` WHERE `TID_ta`= ('"+teacher_id+"');";
			System.out.println(query2);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a07", "root", "");
			Statement stm = con.createStatement();
			//ResultSet rs,rs2;
			ResultSet rs2= stm.executeQuery(query2);
			
			while(rs2.next())
			{
				code=rs2.getInt("Subjectcode_aa");
			}
			
			String query1="SELECT student.*, choice.SubCode_sca from student,choice where student.Sid_si=choice.Sid_sc AND choice.SubCode_sca=('"+code+"');";
			
			ResultSet rs= stm.executeQuery(query1);
			System.out.println("1");
			
			int x;
			
			while(rs.next()){
				//System.out.println(Integer.toString(rs.getInt("TID_ti")));
				String sub="NULL";
				x=rs.getInt("SubCode_sca");
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
				model.addRow(new Object[]{Integer.toString(rs.getInt("Sid_si")),
										 rs.getString("StudentName"),
										 Integer.toString(rs.getInt("PhoneNumber")),
										 rs.getString("Address"),
										 //Integer.toString(rs.getInt("Subjectcode_aa")),
										 Integer.toString(rs.getInt("Budget")),
										 Integer.toString(rs.getInt("Grade")),
										 sub});
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
		
		//
		
		tableScrollPane = new JScrollPane(table);
		tableScrollPane.setBounds(50,120,680,430);
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
		//String temp = ae.getActionCommand();
		if (ae.getSource()==Logout)
		{
			Login l  =new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
	    
		else if (ae.getSource()== Back)
		{
			Teacher l  =new Teacher(uid);
			l.setVisible(true);
			this.setVisible(false);
		}
		else if (ae.getSource()== Show)
		{
			Available_Student l  =new Available_Student(uid);
			l.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
	
}
