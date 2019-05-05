import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.*;

import javax.swing.*;
public class MainUI implements ActionListener{
	JPanel panel,panel1,panel2,panel3;
    JLabel dusername_label,stq_label,sid_label,stl_label,sdept_label,detl,user_label, password_label, sl,suser_label,sname_label,sl_label,message1,message2,message3,loginl,ruser_label,rpassword_label,regl,rid_label,rname_label,rdays_label,rdept_label,did_label,dname_label,ddays_label,ddept_label;
    JTextField dusername_text,suserid_text,stq_text,suserName_text,sname_text,sid_text,sdept_text,stl_text,userName_text,ruserName_text,rpassword_text,rid_text,rdays_text,rname_text,rdept_text,did_text,ddays_text,dname_text,ddept_text;
    JPasswordField password_text;
    JButton login, cancel,register,submit,search,add_leave,update,clear1,clear2,update_button,delete_button;
    JFrame f,f1,f2,f3;
    JComboBox leave_types;
    public void createLoginUI()
    {
    	f = new JFrame("AMS-Login");
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
        register = new JButton("Register");
        register.addActionListener(this);
        login = new JButton("Login");
        login.addActionListener(this);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(loginl);
        panel.add(user_label);
        panel.add(userName_text);
        panel.add(password_label);
        panel.add(password_text);
        panel.add(login);
        panel.add(register);
        
        f.add(panel);
        f.setSize(300, 200);
        f.setVisible(true);
    }
    
    public void createRegisterUI()
    {
    	f1 = new JFrame("AMS-Register");
    	regl = new JLabel();
    	regl.setText("REGISTER TAB");
        ruser_label = new JLabel();
        ruser_label.setText("User Name :");
        ruserName_text = new JTextField();
        panel1 = new JPanel();
        // Password
        submit = new JButton("SUBMIT");
        submit.addActionListener(this);
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
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(regl);
        panel1.add(ruser_label);
        panel1.add(ruserName_text);
        panel1.add(rpassword_label);
        panel1.add(rpassword_text);
        panel1.add(rname_label);
        panel1.add(rname_text);
        panel1.add(rid_label);
        panel1.add(rid_text);
        panel1.add(rdept_label);
        panel1.add(rdept_text);
        
        panel1.add(submit);
        
        f1.add(panel1);
        f1.setSize(300, 300);
        f1.setVisible(true);
    }
    public void createAdminUI()
    {
    	f2 = new JFrame("AMS-Administrator");
    	sl = new JLabel();
    	sl.setText("Search Tab");
        suser_label = new JLabel();
        suser_label.setText("ID :");
        suserid_text = new JTextField();
        panel2 = new JPanel();
       
        search = new JButton("Search");
        search.addActionListener(this);
        add_leave = new JButton("Add Leave");
        add_leave.addActionListener(this);
        sname_label = new JLabel();
        sname_label.setText("Name :");
        sname_text = new JTextField();
        
        
        update_button = new JButton("Update ID");
        update_button.addActionListener(this);
        sdept_label = new JLabel();
        sdept_label.setText("Department :");
        sdept_text = new JTextField();
       
        stl_label = new JLabel();
        stl_label.setText("Leave History");
        stl_text = new JTextField();
        stq_label = new JLabel();
        stq_label.setText("Duration:");
        delete_button = new JButton("Delete Employee");
        delete_button.addActionListener(this);
        stq_text = new JTextField();
        String leave_type[]={"Sick","Vacation","Maternity","Undisclosed"};       
        leave_types =new JComboBox(leave_type);    
        leave_types.setBounds(50, 50,90,20);
        clear1 = new JButton("Clear");
        clear1.addActionListener(this);
        panel2 = new JPanel();
        panel2.add(clear1);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(sl);
        panel2.add(suser_label);
        panel2.add(suserid_text);
        panel2.add(stq_label);
        panel2.add(stq_text);
        panel2.add(sname_label);
        panel2.add(sname_text);
        
        panel2.add(sdept_label);
        panel2.add(sdept_text);
        panel2.add(stl_label);
        panel2.add(stl_text);
        panel2.add(search);
        panel2.add(delete_button);
        panel2.add(update_button);
        panel2.add(add_leave);
        panel2.add(leave_types);
        f2.add(panel2);
        f2.setSize(300, 300);
        f2.setVisible(true);
    }
    public void createDetailsUI()
    {	
    	f3 = new JFrame("AMS-User Details");
    	detl = new JLabel("DETAILS");
    	dusername_label = new JLabel();
    	dusername_label.setText("Username :");
    	dusername_text = new JTextField();
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
        ddays_label.setText("Leave History :");
        ddays_text = new JTextField();
        update = new JButton("Update");
        clear2 = new JButton("Clear");
        
        update.addActionListener(this);
        clear2.addActionListener(this);
        panel3 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel3.add(detl);
        panel3.add(dusername_label);
        panel3.add(dusername_text);
        panel3.add(dname_label);
        panel3.add(dname_text);
        panel3.add(did_label);
        panel3.add(did_text);
        panel3.add(ddept_label);
        panel3.add(ddept_text);
        panel3.add(ddays_label);
        panel3.add(ddays_text);
        panel3.add(update);
        panel3.add(clear2);
        f3.add(panel3);
        f3.setSize(300, 300);
        f3.setVisible(true);
    }
    public static void main(String[] args) {
    	MainUI ui= new MainUI();
        ui.createLoginUI();
    }
    public void actionPerformed(ActionEvent ae)
    {	
    	String a = new String();
    	if(ae.getSource() == login)
    	{
    		
    		String username = userName_text.getText();
    		a = username;
	        String password = password_text.getText();
	        if(username.equals("admin") && password.equals("admin"))
	        {
	        	
	        	f.setVisible(false);
	        	MainUI ui1 = new MainUI();
	        	ui1.createAdminUI();
	        	
	        }
	        else
	        {
	        	f.setVisible(false);
	        	MainUI ui3 = new MainUI();
	        	ui3.createDetailsUI();
	        }
    	}
    	if(ae.getSource() == register)
    	{
    		f.setVisible(false);
        	MainUI ui1 = new MainUI();
        	ui1.createRegisterUI();
    	}
    	if(ae.getSource() == submit)
    	{
    		try{  
    			Class.forName("com.mysql.jdbc.Driver");  
    			Connection con=DriverManager.getConnection(  
    			"jdbc:mysql://localhost:3306/nams","root","adithya");  
    			//here sonoo is database name, root is username and password  
    			Statement stmt = con.createStatement();
    			String username = ruserName_text.getText();
    	        String password = rpassword_text.getText();
    	        String emp_name = rname_text.getText();
    	        int emp_id = Integer.parseInt(rid_text.getText());
    	        String department = rdept_text.getText();
    	        
    	        String last_updated = "Aug 25";
    	        String sql3 = "insert into emp_det1 values('"+ username + "','" + password + "','" + emp_id + "','" + emp_name + "','"+ department + "');";
    	        JOptionPane.showMessageDialog(panel,"Successfully Registered!");
    			stmt.executeUpdate(sql3);
            
        	}catch(Exception e){ System.out.println(e);}  
    	}
    	if(ae.getSource() == search)
    	{
    		try{  
    			Class.forName("com.mysql.jdbc.Driver");  
    			Connection con=DriverManager.getConnection(  
    			"jdbc:mysql://localhost:3306/nams","root","adithya");  
    			//here sonoo is database name, root is username and password  
    			Statement stmt = con.createStatement();
    			
    	        int id = Integer.parseInt(suserid_text.getText());
    	        
    	        
    	       
    	        String sql2  = "SELECT * FROM emp_det1 WHERE id='"+ id + "';";
    	        
    	        ResultSet rs=stmt.executeQuery(sql2);
    	        while(rs.next())
    	        {
    	        	sname_text.setText(rs.getString(4));
    	        	sdept_text.setText(rs.getString(5));
    	        	
    	        }
    	        String sql8 = "select tol,dur from leave_db where id ='"+id+"';";
    	        ResultSet rs9=stmt.executeQuery(sql8);
    	        while(rs9.next())
    	        {
    	        	String type = rs9.getString(1);
    	        	String dur = Integer.toString(rs9.getInt(2));
    	        	String code  = type + "-" + dur;
    	        	stl_text.setText(stl_text.getText() + "," +code); 
    	        }
    	        
            
        	}catch(Exception e) {System.out.println(e); }
        }
    	if(ae.getSource() == add_leave)
    	{
    		try{  
    			Class.forName("com.mysql.jdbc.Driver");  
    			Connection con=DriverManager.getConnection(  
    			"jdbc:mysql://localhost:3306/nams","root","adithya");  
    			//here sonoo is database name, root is username and password  
    			Statement stmt = con.createStatement();
    			
    	        int id = Integer.parseInt(suserid_text.getText());
    	        
    	        int duration = Integer.parseInt(stq_text.getText());
    	        String tol = leave_types.getSelectedItem().toString();
    	        String sql4 = "insert into leave_db values('"+ id  + "','" + id + "','" + tol + "','" + duration + "');";
    	        JOptionPane.showMessageDialog(panel,"Successfully Applied for Leave!");
    			stmt.executeUpdate(sql4);
    	        String sql5 = "select tol,dur from leave_db where id ='"+id+"';";
    	        ResultSet rs2=stmt.executeQuery(sql5);
    	        while(rs2.next())
    	        {
    	        	String type = rs2.getString(1);
    	        	String dur = Integer.toString(rs2.getInt(2));
    	        	String code  = type + "-" + dur;
    	        	stl_text.setText(stl_text.getText() + "," +code); 
    	        }
    	        
        	}catch(Exception e) {System.out.println(e); }
    	}
    	if(ae.getSource() == update)
    	{
    		try{  
    			Class.forName("com.mysql.jdbc.Driver");  
    			Connection con=DriverManager.getConnection(  
    			"jdbc:mysql://localhost:3306/nams","root","adithya");  
    			//here sonoo is database name, root is username and password  
    			Statement stmt = con.createStatement();

        		String username1 = dusername_text.getText();
    	        
    	        
    	        String sql6 =  "SELECT * FROM emp_det1 WHERE username='"+ username1 + "';";
    	        
    	        ResultSet rs3=stmt.executeQuery(sql6);
    	        System.out.println(username1);
    	        int eid = 0;
    	        while(rs3.next())
    	        {
    	        	dname_text.setText(rs3.getString(4));
    	        	did_text.setText(Integer.toString(rs3.getInt(3)));
    	        	ddept_text.setText(rs3.getString(5));
    	        	eid = rs3.getInt(3);
    	        }
    	        String sql7 = "select tol,dur from leave_db where id ='"+eid+"';";
    	        ResultSet rs4=stmt.executeQuery(sql7);
    	        while(rs4.next())
    	        {
    	        	String type = rs4.getString(1);
    	        	String dur = Integer.toString(rs4.getInt(2));
    	        	String code  = type + "-" + dur;
    	        	ddays_text.setText(ddays_text.getText() + "," +code); 
    	        }
    	        
        	}catch(Exception e) {System.out.println(e); }
    	}
    		if(ae.getSource()== clear1)
    		{
    			sname_text.setText("");
    			suserid_text.setText("");
    			sdept_text.setText("");
    			stl_text.setText("");
    			stq_text.setText("");
    		}
    		if(ae.getSource() == clear2)
    		{   
    			dusername_text.setText("");
    			dname_text.setText("");
    			did_text.setText("");
    			ddept_text.setText("");
    			ddays_text.setText("");
    		}
    		if(ae.getSource()==update_button)
    		{   try{  
    			Class.forName("com.mysql.jdbc.Driver");  
    			Connection con=DriverManager.getConnection(  
    			"jdbc:mysql://localhost:3306/nams","root","adithya");  
    			//here sonoo is database name, root is username and password  
    			PreparedStatement ps = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("update emp_det1 set name=? where id =?");
    			ps.setString(1,sname_text.getText());
				ps.setInt(2, Integer.parseInt(suserid_text.getText()));
				JOptionPane.showMessageDialog(panel2,"Successfully Updated Details!");
				ps.executeUpdate();
        		
    	        }catch(Exception e) {System.out.println(e); }
    		}
    		if(ae.getSource() == delete_button)
    		{
    			try{  
        			Class.forName("com.mysql.jdbc.Driver");  
        			Connection con=DriverManager.getConnection(  
        			"jdbc:mysql://localhost:3306/nams","root","adithya");  
        			//here sonoo is database name, root is username and password  
        			PreparedStatement ps4 = (com.mysql.jdbc.PreparedStatement) con.prepareStatement("delete from emp_det1 where id = ?");
        			ps4.setInt(1,Integer.parseInt(suserid_text.getText()));
        			JOptionPane.showMessageDialog(panel2,"Successfully Deleted!");
        			ps4.executeUpdate();
    			}catch(Exception e) {System.out.println(e); }
    		}
	        
    	}
    	
    }

    		
		
