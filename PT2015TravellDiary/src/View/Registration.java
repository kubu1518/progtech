package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.border.MatteBorder;

import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

<<<<<<< HEAD
public class Registration {

	private JFrame frame;
=======
public class Registration extends JFrame {

>>>>>>> 6879f3a50d8323e44357ae604634ad065c80e79f
	private JPanel contentPane;
	private JTextField textFieldFullName;
	private JTextField textFieldUserName;
	private JPasswordField pwdPfpass;
	private JPasswordField pwdPfconfirm;
	private JButton btnSignUp;
	private JButton btnBack;
	private JLabel lblValidInfo;

	/**
	 * Launch the application.
	 */
<<<<<<< HEAD
	public void showRegistration() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration.this.frame.setVisible(true);
=======
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
>>>>>>> 6879f3a50d8323e44357ae604634ad065c80e79f
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration() {
<<<<<<< HEAD
		frame = new JFrame();
		frame.setTitle("Registration");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 271);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
=======
		setTitle("Registration");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 271);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
>>>>>>> 6879f3a50d8323e44357ae604634ad065c80e79f
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Travel Diary");
		lblTitle.setBounds(10, 11, 138, 27);
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setForeground(new Color(147, 112, 219));
		lblTitle.setFont(new Font("Buxton Sketch", Font.BOLD, 20));
		lblTitle.setBorder(new MatteBorder(0, 0, 2, 0,
						(Color) SystemColor.activeCaption));
		lblTitle.setBackground(Color.WHITE);
		contentPane.add(lblTitle);
		
		JLabel lblInfo = new JLabel("You can registrate a new profile. Please, fill all fields!");
		lblInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInfo.setBounds(10, 49, 305, 14);
		contentPane.add(lblInfo);
		
		JLabel lblFullName = new JLabel("Full name");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFullName.setBounds(83, 76, 46, 14);
		contentPane.add(lblFullName);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUserName.setBounds(81, 101, 48, 14);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPassword.setBounds(83, 126, 46, 14);
		contentPane.add(lblPassword);
		
		JLabel lblConfPass = new JLabel("Confirm the password");
		lblConfPass.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblConfPass.setBounds(21, 151, 108, 14);
		contentPane.add(lblConfPass);
		
		textFieldFullName = new JTextField();
		textFieldFullName.setFont(new Font("Trebuchet MS", Font.ITALIC, 11));
		textFieldFullName.setForeground(new Color(138, 43, 226));
		textFieldFullName.setBounds(139, 74, 217, 20);
		contentPane.add(textFieldFullName);
		textFieldFullName.setColumns(10);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setFont(new Font("Trebuchet MS", Font.ITALIC, 11));
		textFieldUserName.setForeground(new Color(138, 43, 226));
		textFieldUserName.setBounds(139, 98, 217, 20);
		contentPane.add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		btnSignUp = new JButton("Sign up");
		btnSignUp.setBounds(345, 212, 89, 23);
		contentPane.add(btnSignUp);
		
		btnBack = new JButton("Back");
		btnBack.setBounds(246, 212, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblStatus = new JLabel("");
		lblStatus.setBounds(31, 176, 46, 14);
		contentPane.add(lblStatus);
		
		pwdPfpass = new JPasswordField();
		pwdPfpass.setFont(new Font("Trebuchet MS", Font.ITALIC, 11));
		pwdPfpass.setForeground(new Color(138, 43, 226));
		pwdPfpass.setBounds(139, 123, 108, 20);
		contentPane.add(pwdPfpass);
		
		pwdPfconfirm = new JPasswordField();
		pwdPfconfirm.setFont(new Font("Trebuchet MS", Font.ITALIC, 11));
		pwdPfconfirm.setForeground(new Color(138, 43, 226));
		pwdPfconfirm.setBounds(139, 148, 108, 20);
		contentPane.add(pwdPfconfirm);
		
		lblValidInfo = new JLabel("");
		lblValidInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValidInfo.setBounds(139, 176, 295, 14);
		contentPane.add(lblValidInfo);
	}
	
<<<<<<< HEAD
	
	
	public JFrame getFrame() {
		return frame;
	}

=======
>>>>>>> 6879f3a50d8323e44357ae604634ad065c80e79f
	public String getFullName(){
		return this.textFieldFullName.getText();
	}
	
	public String getUserName(){
		return this.textFieldUserName.getText();
	}
	
	public void setValidInfo(String msg){
		this.lblValidInfo.setText(msg);
	}

	public String getPassword(){
		return new String(this.pwdPfpass.getPassword()).toString();
	}
	
	public String getPasswordConfirm(){
		return new String(this.pwdPfconfirm.getPassword()).toString();
	}
	
	public void addSignUpListener(ActionListener listenerForSignUpButton){
		this.btnSignUp.addActionListener(listenerForSignUpButton);
	}
	
	public void addBackListener(ActionListener listenerForBackButton){
		this.btnBack.addActionListener(listenerForBackButton);
	}
}
