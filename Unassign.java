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

public class Unassign extends JFrame implements ActionListener
{
	private JLabel imgLabel, TeacherLabel, StudentLabel;
	private JTextField TTF, STF;
	private JButton unassign;
	private JButton Back;
	private JButton Logout;
	private JPanel panel;
	private ImageIcon img;
	private JTable table;
	private JScrollPane tableScrollPane;
	
	public Unassign()
	{
		super (" Unassign ");
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
		
		unassign =new JButton("UNASSIGN");
		unassign.setBounds(300,250,100,30);
		unassign.setBackground(Color.GREEN);
		unassign.addActionListener(this);
		panel.add(unassign);
		 
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
		/////////////
		String []col ={"Teacher ID", "Student ID"};
		
		table = new JTable(0,2);
		
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
			String query1="SELECT * FROM assignedto";
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
				model.addRow(new Object[]{Integer.toString(rs.getInt("TID_ta")),
										 Integer.toString(rs.getInt("Sid_sa"))});
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
		tableScrollPane.setBounds(50,300,680,270);
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
	    else if (ae.getSource()==unassign)
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
		String student_id = STF.getText();
        try
		{
		
			String query1="DELETE from assignedto WHERE  TID_ta= ('"+teacher_id+"') AND Sid_sa=('"+student_id+"');";
			//String query2="SELECT `TID_ta` FROM `assignedto` WHERE `TID_ta`= ('"+teacher_id+"');";
			System.out.println(query1);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a07"w, "root", "");
			Statement stm = con.createStatement();
			//stm.execute(query2);
			stm.execute(query1);
			System.out.println("1");
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this,"Unassigned!!!");
			Unassign l  =new Unassign();
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