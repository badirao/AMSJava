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

import javax.swing.*;
public class MainUI implements ActionListener{
	JPanel panel,panel1;
    JLabel detl,user_label, password_label, message1,message2,message3,loginl,ruser_label,rpassword_label,regl,rid_label,rname_label,rdays_label,rdept_label,did_label,dname_label,ddays_label,ddept_label;
    JTextField userName_text,ruserName_text,rpassword_text,rid_text,rdays_text,rname_text,rdept_text,did_text,ddays_text,dname_text,ddept_text;
    JPasswordField password_text;
    JButton login, cancel,register,submit;
    JFrame f,f1;
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
        suser_label.setText("User Name :");
        suserName_text = new JTextField();
        panel2 = new JPanel();
        // Password
        search = new JButton("Search");
        
        add_leave = new JButton("Add Leave")
        sname_label = new JLabel();
        sname_label.setText("Name :");
        sname_text = new JTextField();
        
        sid_label = new JLabel();
        sid_label.setText("Employee ID :");
        sid_text = new JTextField();
        
        sdept_label = new JLabel();
        sdept_label.setText("Department :");
        sdept_text = new JTextField();
        
        stl_label = new JLabel();
        stl_label.setText("Leave History");
        stl_text = new JTextField();
        String leave_type[]={"Sick","Vacation","Maternity","Undisclosed"};       
        leave_types =new JComboBox(leave_type);    
        leave_types.setBounds(50, 50,90,20);
        
        panel2 = new JPanel();
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.add(sl);
        panel2.add(suser_label);
        panel2.add(suserName_text);
        
        panel2.add(sname_label);
        panel2.add(sname_text);
        panel2.add(sid_label);
        panel2.add(sid_text);
        panel2.add(sdept_label);
        panel2.add(sdept_text);
        panel2.add(stl_label);
        panel2.add(stl_text);
        panel2.add(search);
        panel2.add(add_leave);
        f2.add(panel2);
        f2.setSize(300, 300);
        f2.setVisible(true);
    }
    public static void main(String[] args) {
    	MainUI ui= new MainUI();
        ui.createLoginUI();
    }
    public void actionPerformed(ActionEvent ae)
    {
    	if(ae.getSource() == login)
    	{
    		String username = userName_text.getText();
	        String password = password_text.getText();
	        if(username.equals("admin") && password.equals("admin"))
	        {
	        	f.setVisible(false);
	        	MainUI ui1 = new MainUI();
	        	ui1.createAdminUI();
	        }
    	}
    	if(ae.getSource() == register)
    	{
    		f.setVisible(false);
        	MainUI ui1 = new MainUI();
        	ui1.createRegisterUI();
    	}
    		
    }
}
