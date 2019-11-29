import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener, MouseListener
{
	JLabel title,title2, userLabel, passLabel,imgLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton loginBtn, exitBtn, regBtn, btn;
	private ImageIcon img;
	JPanel panel;
	
	public Login()
	{
		super("Tutor Management System");
		
		this.setSize(800, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("Please Login");
		title.setBounds(250, 200, 350, 30);
		title.setForeground(Color.WHITE);
		panel.add(title);
		
		title2 = new JLabel("WELCOME !!!");
		title2.setBounds(370, 150, 350, 30);
		title2.setForeground(Color.GREEN);
		panel.add(title2);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(250, 250, 60, 30);
		userLabel.setForeground(Color.WHITE);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(370, 250, 100, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(250, 300, 70, 30);
		passLabel.setForeground(Color.WHITE);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(370, 300, 100, 30);
		panel.add(passPF);
		
		btn = new JButton("Show Password");
		btn.setBounds(500, 300, 150,30);
		btn.addMouseListener(this);
		panel.add(btn);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(350, 350, 80, 30);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(440, 350, 80, 30);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
		regBtn = new JButton("Register");
		regBtn.setBounds(530, 350, 120, 30);
		regBtn.addActionListener(this);
		panel.add(regBtn);
		
		img = new ImageIcon("image2.jpg");
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0, 0, 800, 700);
		panel.add(imgLabel);
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(loginBtn.getText()))
		{
			checkLogin();
		}
		else if(text.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		else if(text.equals(regBtn.getText()))
		{    
			Registration r=new Registration();
			
			r.setVisible(true);
			this.setVisible(false);
			/*Registration r= new Registration();
			r.setVisible(true);
			this.setVisible(false);*/
 		}
	}
	
	public void mouseEntered(MouseEvent me){}
	public void mouseExited(MouseEvent me){}
	public void mouseClicked(MouseEvent me){}
	public void mouseReleased(MouseEvent me)
	{
		if(me.getSource().equals(btn))
		{
			passPF.setEchoChar('*');
		}
	}
	public void mousePressed(MouseEvent me)
	{
		if(me.getSource().equals(btn))
		{
			passPF.setEchoChar((char)0);
		}
	}
	
	public void checkLogin()
	{
		String query = "SELECT `userId_ui`, `password`, `status` FROM `login`;";     
        Connection con=null;//for connection
        Statement st = null;//for query execution
		ResultSet rs = null;//to get row by row result from DB
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/a07","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			
			boolean flag = false;			
			while(rs.next())
			{
                String userId = rs.getString("userId_ui");
				String password = Integer.toString(rs.getInt("password"));
				int status = rs.getInt("status");
				
				if(userId.equals(userTF.getText()) && password.equals(passPF.getText()))
				{
					flag=true;
					if(status==1)
					{
						Admin eh = new Admin();	
						eh.setVisible(true);
						this.setVisible(false);
						System.out.println("Success");
					}
					else if(status==2)
					{
						System.out.println("Success 1");
						Student ch = new Student(userId);
						ch.setVisible(true);
						this.setVisible(false);
						System.out.println("Success 2");
					}
					else if(status==3)
					{
						Teacher eh = new Teacher(userId);	
						eh.setVisible(true);
						this.setVisible(false);
						System.out.println("Success at t");
					}
					else{System.out.println("Failed");}
				}
			}
			if(!flag)
			{
				JOptionPane.showMessageDialog(this,"Invalid ID or Password"); 
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
	}
}