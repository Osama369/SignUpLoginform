package signupform;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class signup extends JFrame {

	private JPanel contentPane;
	private JTextField text3;
	private JTextField text2;
	private JTextField text1;
	private JPasswordField password1;
	private JPasswordField password2;
	private JTextField text4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup frame = new signup();
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
	public signup() {
		Connection con = Bd.dbconnection();
		setTitle("SignUp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 437);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl3 = new JLabel("Userid");
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl3.setBounds(33, 137, 58, 20);
		contentPane.add(lbl3);
		
		JLabel lbl5 = new JLabel("confrim pass");
		lbl5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl5.setBounds(28, 237, 82, 22);
		contentPane.add(lbl5);
		
		JLabel lbl4 = new JLabel("password");
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl4.setBounds(28, 188, 64, 23);
		contentPane.add(lbl4);
		
		text3 = new JTextField();
		text3.setColumns(10);
		text3.setBounds(138, 131, 155, 30);
		contentPane.add(text3);
		
		JLabel lbl2 = new JLabel("Last name");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl2.setBounds(28, 83, 82, 20);
		contentPane.add(lbl2);
		
		JLabel lbl1 = new JLabel("First name");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl1.setBounds(28, 35, 82, 20);
		contentPane.add(lbl1);
		
		text2 = new JTextField();
		text2.setColumns(10);
		text2.setBounds(138, 81, 155, 30);
		contentPane.add(text2);
		
		text1 = new JTextField();
		text1.setColumns(10);
		text1.setBounds(138, 33, 155, 30);
		contentPane.add(text1);
		
		JButton btn1 = new JButton("SignUp");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String first= text1.getText();
				String last= text2.getText();
				String userid= text3.getText();
				String pass= password1.getText();
				String cpass= password2.getText();
				String eMial= text4.getText();
				// fire quert by preparedStatement // data insert into table
				try {
					PreparedStatement pps= con.prepareStatement("insert into userinfo(fname,lname,userId,password,cpassword,email) values(?,?,?,?,?,?)");
				pps.setString(1,first);  // coloumn k according data insert hoga
				pps.setString(2, last);
				pps.setString(3,userid);
				pps.setString(4, pass);
				pps.setString(5,cpass);
				pps.setString(6,eMial);
				pps.executeUpdate();
				JOptionPane.showMessageDialog(null, "Data added");
				text1.setText("");
				text2.setText("");
				text3.setText("");
				password1.setText("");
				password2.setText("");
				text4.setText("");
				
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn1.setBounds(71, 334, 82, 35);
		contentPane.add(btn1);
		
		JButton btn2 = new JButton("Cancel");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn2.setBounds(182, 334, 82, 35);
		contentPane.add(btn2);
		
		password1 = new JPasswordField();
		password1.setBounds(138, 184, 155, 31);
		contentPane.add(password1);
		
		password2 = new JPasswordField();
		password2.setBounds(137, 232, 155, 31);
		contentPane.add(password2);
		
		JLabel lbl6 = new JLabel("Email");
		lbl6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl6.setBounds(28, 282, 82, 22);
		contentPane.add(lbl6);
		
		text4 = new JTextField();
		text4.setColumns(10);
		text4.setBounds(138, 285, 155, 30);
		contentPane.add(text4);
	}
}
