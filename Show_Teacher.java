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

public class Show_Teacher extends JFrame implements ActionListener
{
	private JLabel imgLabel, label, searchteacher;
	private JTextField TTF;
	private JButton delete;
	private JButton Back;
	private JButton Logout;
	private JPanel panel;
	private ImageIcon img;
	private JTable table;
	private JScrollPane tableScrollPane;
	
	public Show_Teacher()
	{
		super (" Show_Teacher ");
		this.setSize(800,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);
		
		label=new JLabel("Teacher Information : ");
		label.setForeground(Color.WHITE);
		label.setBounds(50, 70, 200, 30);
		panel.add(label);
		 
		TTF=new JTextField();
		TTF.setBounds(50,460, 200, 30);
		//TTF.addActionListener(this);
		panel.add(TTF);
		
		delete =new JButton("DELETE");
		delete.setBounds(300,460,100,30);
		delete.setBackground(Color.RED);
		delete.setForeground(Color.WHITE);
		delete.addActionListener(this);
		panel.add(delete);
		 
		Back =new JButton("BACK");
		Back.setBounds(50,600,100,40);
		Back.setBackground(Color.GREEN);
		Back.addActionListener(this);
		panel.add(Back);
		 
		Logout=new JButton("LOG OUT");
		Logout.setBounds(550, 20, 100, 30);
		Logout.setBackground(Color.RED);
		Logout.addActionListener(this);
		panel.add(Logout);
		
				
		String []col ={"ID", "Name", "Phone", "Area", "Subject", "Wage", "Email"};
		
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
			String query1="SELECT * FROM teacher";
			//String query2="SELECT `TID_ta` FROM `assignedto` WHERE `TID_ta`= ('"+teacher_id+"');";
			System.out.println(query1);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a07", "root", "");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query1);
			System.out.println("1");
			
			
			while(rs.next()){
				//System.out.println(Integer.toString(rs.getInt("TID_ti")));
				model.addRow(new Object[]{Integer.toString(rs.getInt("TID_ti")),
										 rs.getString("TeacherName"),
										 Integer.toString(rs.getInt("PhoneNumber")),
										 rs.getString("Area"),
										 Integer.toString(rs.getInt("Subjectcode_aa")),
										 Integer.toString(rs.getInt("Wage")),
										 rs.getString("Mail")});
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
		tableScrollPane.setBounds(50,120,680,300);
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
	    else if (ae.getSource()==delete)
		{
			//JOptionPane.showMessageDialog(this,"Registered");
			//Login l  =new Login();
			//l.setVisible(true);
			//this.setVisible(false);
			removefromDB();
		}
		else if (ae.getSource()== Back)
		{
			Admin l  =new Admin();
			l.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
	public void removefromDB()
	{
		String teacher_id = TTF.getText();
		//String student_id = STF.getText();
        try
		{
		
			String query1="DELETE from assignedto WHERE  TID_ta= ('"+teacher_id+"');";
			String query2="DELETE from login WHERE  UserId_ui= ('"+teacher_id+"');";
			String query3="DELETE from teacher WHERE  TID_ti= ('"+teacher_id+"');";
			String query4="DELETE from rating WHERE  TID_ra= ('"+teacher_id+"');";
			String query5="DELETE from preference WHERE  Tid_tp= ('"+teacher_id+"');";
			//String query2="SELECT `TID_ta` FROM `assignedto` WHERE `TID_ta`= ('"+teacher_id+"');";
			System.out.println(query1);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a07", "root", "");
			Statement stm = con.createStatement();
			//stm.execute(query2);
			stm.execute(query1);
			stm.execute(query2);
			stm.execute(query4);
			stm.execute(query5);
			stm.execute(query3);
			System.out.println("1");
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this,"Deleted!!!");
			Show_Teacher l  =new Show_Teacher();
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
