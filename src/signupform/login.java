package signupform;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField text1;
	private JPasswordField password1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public login() {
		Connection con = Bd.dbconnection();
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 322, 322);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("UserID");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl1.setBounds(38, 90, 68, 26);
		contentPane.add(lbl1);
		
		text1 = new JTextField();
		text1.setBounds(116, 89, 162, 27);
		contentPane.add(text1);
		text1.setColumns(10);
		
		JLabel lbl2 = new JLabel("password");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl2.setBounds(38, 151, 68, 26);
		contentPane.add(lbl2);
		
		JButton btn1 = new JButton("Login");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// logic to login 
				String userid= text1.getText();
				String pass= password1.getText();
				// always use table varibele name fields in query
				PreparedStatement pps= ((Connection) con).prepareStatement("select * from userinfo where userId=? and password=?");
				                          // this is function
				// now we will setString 
				pps.setString(1, userid);
				pps.setString(2, pass);
				ResultSet r= pps.executeQuery();  // query execute save into resultset
				
				if(r.next()) {
					JOptionPane.showMessageDialog(null, "Login successfully");
				}else {
					JOptionPane.showMessageDialog(null, "Invalid userId or password");
				}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn1.setBounds(114, 218, 89, 34);
		contentPane.add(btn1);
		
		password1 = new JPasswordField();
		password1.setBounds(116, 151, 162, 26);
		contentPane.add(password1);
	}

}
