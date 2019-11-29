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

public class ViewMyStudent extends JFrame implements ActionListener
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
	int teacher_id;
	public ViewMyStudent(String id)
	{
		super (" View_My_Student ");
		this.setSize(800,700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.setLayout(null);
		
		uid=id;
		teacher_id=Integer.parseInt(uid);
		
		label=new JLabel("My Students: ");
		label.setForeground(Color.WHITE);
		label.setBounds(50, 70, 200, 30);
		panel.add(label);
		 
				
		 
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
		
		String []col ={"ID", "Name", "Phone", "Area", "Grade"};
		
		table = new JTable(0,5);
		  
		for(int i=0;i<table.getColumnCount();i++)
		{
			TableColumn column1 = table.getTableHeader().getColumnModel().getColumn(i);
			column1.setHeaderValue(col[i]);
		} 
		
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		try
		{
	
			String query2="SELECT student.* FROM student, teacher, assignedto WHERE student.Sid_si=assignedto.Sid_sa AND teacher.TID_ti=assignedto.TID_ta AND teacher.TID_ti= ('"+teacher_id+"');";
			System.out.println(query2);
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a07", "root", "");
			Statement stm = con.createStatement();
			ResultSet rs2 = stm.executeQuery(query2);
			System.out.println("1");
			
			while(rs2.next())
			{
			
				model.addRow(new Object[]{Integer.toString(rs2.getInt("Sid_si")),
										 rs2.getString("StudentName"),
										 Integer.toString(rs2.getInt("PhoneNumber")),
										 rs2.getString("Address"),
										 //Integer.toString(rs.getInt("Subjectcode_aa")),
										 //Integer.toString(rs.getInt("Budget")),
										 Integer.toString(rs2.getInt("Grade"))});
				
			
				//rs.close();
				
			}
			rs2.close();
			stm.close();
			con.close();
			
		}
		
		catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
			JOptionPane.showMessageDialog(this, "Oops !!!");
        } 
		
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
		else{}
	}
	
}
