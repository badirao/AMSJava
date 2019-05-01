

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.*;
public class UI extends JFrame implements ActionListener {

    JPanel panel;
    JLabel detl,user_label, password_label, message1,message2,message3,loginl,ruser_label,rpassword_label,regl,rid_label,rname_label,rdays_label,rdept_label,did_label,dname_label,ddays_label,ddept_label;
    JTextField userName_text,ruserName_text,rpassword_text,rid_text,rdays_text,rname_text,rdept_text,did_text,ddays_text,dname_text,ddept_text;
    JPasswordField password_text;
    JButton login, cancel,register;

    UI() {
        
        // User Label
    	loginl = new JLabel();
    	loginl.setText("LOGIN TAB");
        user_label = new JLabel();
        user_label.setText("User Name :");
        userName_text = new JTextField();
        
        // Password

        password_label = new JLabel();
        password_label.setText("Password :");
        password_text = new JPasswordField();

        // Submit

        login = new JButton("Login");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(loginl);
        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);

        message1 = new JLabel();
        message2 = new JLabel();
        message3 = new JLabel();
        
        panel.add(message1);
        panel.add(message2);
        panel.add(message3);
        panel.add(login);
        regl = new JLabel();
    	regl.setText("REGISTER TAB");
        ruser_label = new JLabel();
        ruser_label.setText("User Name :");
        ruserName_text = new JTextField();
        
        // Password

        rpassword_label = new JLabel();
        rpassword_label.setText("Password :");
        rpassword_text = new JTextField();
        
        rname_label = new JLabel();
        rname_label.setText("Name :");
        rname_text = new JTextField();
        
        rid_label = new JLabel();
        rid_label.setText("Employee ID :");
        rid_text = new JTextField();
        
        rdept_label = new JLabel();
        rdept_label.setText("Department :");
        rdept_text = new JTextField();
        
        rdays_label = new JLabel();
        rdays_label.setText("Days Attended :");
        rdays_text = new JTextField();
        // Submit
        
        register = new JButton("Register");

        panel.add(regl);
        panel.add(ruser_label);
        panel.add(ruserName_text);
        panel.add(rpassword_label);
        panel.add(rpassword_text);
        panel.add(rname_label);
        panel.add(rname_text);
        panel.add(rid_label);
        panel.add(rid_text);
        panel.add(rdept_label);
        panel.add(rdept_text);
        panel.add(rdays_label);
        panel.add(rdays_text);
        panel.add(register);
        detl = new JLabel("DETAILS");
        dname_label = new JLabel();
        dname_label.setText("Name :");
        dname_text = new JTextField();
        
        did_label = new JLabel();
        did_label.setText("Employee ID :");
        did_text = new JTextField();
        
        ddept_label = new JLabel();
        ddept_label.setText("Department :");
        ddept_text = new JTextField();
        
        ddays_label = new JLabel();
        ddays_label.setText("Days Attended :");
        ddays_text = new JTextField();
        panel.add(detl);
        panel.add(dname_label);
        panel.add(dname_text);
        panel.add(did_label);
        panel.add(did_text);
        panel.add(ddept_label);
        panel.add(ddept_text);
        panel.add(ddays_label);
        panel.add(ddays_text);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Adding the listeners to components..
        register.addActionListener(this);
        login.addActionListener(this);
        add(panel);
        
        setTitle("Attendance Management System");
        setSize(700, 700);
        setVisible(true);

    }

    public static void main(String[] args) {
        new UI();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource() == register) {
    	
    	
    	try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/ams","root","adithya");  
			//here sonoo is database name, root is username and password  
			Statement stmt = con.createStatement();
			String username = ruserName_text.getText();
	        String password = rpassword_text.getText();
	        String emp_name = rname_text.getText();
	        String emp_id = rid_text.getText();
	        String department = rdept_text.getText();
	        int no_of_days = Integer.parseInt(rdays_text.getText());
	        String last_updated = "Aug 25";
	        String sql3 = "insert into employee values('"+ username + "','" + password + "','" + emp_name + "','" + emp_id + "','" + department + "','" + no_of_days + "','" + last_updated + "');";
	        JOptionPane.showMessageDialog(panel,"Successfully Registered!");
			stmt.executeUpdate(sql3);
        
    	}catch(Exception e){ System.out.println(e);}  
    }
    	else if(ae.getSource() == login)
    	{
    		try{
    			Calendar cal=Calendar.getInstance();
    			SimpleDateFormat month_date = new SimpleDateFormat("MMM");
    			String month_name = month_date.format(cal.getTime());
    			int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
    			String dayOfMonthStr = String.valueOf(dayOfMonth);
    			String date = month_name + dayOfMonth;
    			Class.forName("com.mysql.jdbc.Driver");  
    			Connection con=DriverManager.getConnection(  
    			"jdbc:mysql://localhost:3306/ams","root","adithya");  
    			//here sonoo is database name, root is username and password  
    			Statement stmt = con.createStatement();
    			String userName = userName_text.getText();
    	        String password = password_text.getText();
    			String sql2 = "SELECT * FROM employee WHERE username='"+ userName +"'and password ='"+ password +"';";
    			ResultSet rs=stmt.executeQuery(sql2);
    			while(rs.next())
    			{
    				if(rs.getString(7).equals(date))
    				{
    					JOptionPane.showMessageDialog(panel, "Updated for date"+" "+date);
    				
    				}
    				else if(rs.getString(7) != date)
    				{
    					System.out.println(rs.getString(7));
    					System.out.println(date);
    					int updated_days = rs.getInt(6) + 1;
    					PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("update employee set no_of_days=? where username =? and password = ?");
    					ps.setInt(1,updated_days);
    					ps.setString(2, userName);
    					ps.setString(3, password);
    					PreparedStatement ps1 = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("update employee set last_updated=? where username =? and password = ?");
    					ps1.setString(1, date);
    					ps1.setString(2, userName);
    					ps1.setString(3, password);
    					ps1.executeUpdate();
    					ps.executeUpdate();
    					
    				}
    				did_text.setText(rs.getString(4));
    				ddays_text.setText(Integer.toString(rs.getInt(6)));
    				dname_text.setText(rs.getString(3));
    				ddept_text.setText(rs.getString(5));
    				
    				
    			}
            
        	}catch(Exception e){ System.out.println(e);}  	
    	}
    }
}
