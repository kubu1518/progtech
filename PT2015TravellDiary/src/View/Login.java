package View;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField usernameTf;
	private JPasswordField passwPf;
	private JButton btnRegistration;
	private JButton btnSignIn;
	private JLabel lblValidStatus;

	/**
	 * Launch the application.
	 */
	public void showLogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login.this.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		frame = new JFrame();
		frame.setForeground(Color.WHITE);
		frame.setResizable(false);
		frame.setTitle("Travel Diary");
		frame.setBackground(new Color(255, 255, 255));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 294, 262);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		usernameTf = new JTextField();
		usernameTf.setForeground(new Color(138, 43, 226));
		usernameTf.setBounds(110, 109, 158, 20);
		contentPane.add(usernameTf);
		usernameTf.setColumns(10);

		passwPf = new JPasswordField(5);
		passwPf.setColumns(5);
		passwPf.setForeground(new Color(138, 43, 226));
		passwPf.setCaretColor(new Color(70, 130, 180));
		passwPf.setBounds(110, 140, 158, 20);

		contentPane.add(passwPf);

		JLabel lblUn = new JLabel("Username");
		lblUn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUn.setBounds(30, 112, 70, 14);
		contentPane.add(lblUn);

		JLabel lblPw = new JLabel("Password");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setBounds(30, 143, 70, 14);
		contentPane.add(lblPw);

		btnRegistration = new JButton("Registration");
		btnRegistration.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistration
				.setToolTipText("If you don't have a profile, you can registrate one here.");

		btnRegistration.setBounds(10, 199, 107, 23);
		contentPane.add(btnRegistration);

		btnSignIn = new JButton("Sign In");
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSignIn.setBounds(189, 199, 89, 23);
		contentPane.add(btnSignIn);

		JLabel lblTitle = new JLabel("Travel Diary");
		lblTitle.setBorder(new MatteBorder(0, 0, 2, 0,
				(Color) SystemColor.activeCaption));
		lblTitle.setLabelFor(contentPane);
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setFont(new Font("Buxton Sketch", Font.BOLD, 20));
		lblTitle.setForeground(new Color(147, 112, 219));
		lblTitle.setBackground(Color.WHITE);
		lblTitle.setBounds(10, 11, 258, 38);
		contentPane.add(lblTitle);

		JLabel lblLogInfo = new JLabel("Please, log into your profile!");
		lblLogInfo.setFont(new Font("Simplified Arabic", Font.BOLD, 11));
		lblLogInfo.setBounds(10, 73, 248, 14);
		contentPane.add(lblLogInfo);
		
		lblValidStatus = new JLabel("");
		lblValidStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblValidStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValidStatus.setBounds(110, 171, 158, 14);
		contentPane.add(lblValidStatus);
	}
	
	
	public JFrame getFrame() {
		return frame;
	}

	public String getUsername(){
		return this.usernameTf.getText();
	}
	
	public String getPassword(){
		return new String(this.passwPf.getPassword()).toString();
	}
	
	public void setValidStatus(String msg){
		this.lblValidStatus.setText(msg);
	}
	
	public void addRegistrationListener(ActionListener listenForRegButton){
		this.btnRegistration.addActionListener(listenForRegButton);
	}
	
	 public void addSignInListener(ActionListener listenForSignInButton){
		this.btnSignIn.addActionListener(listenForSignInButton);
	}
}
