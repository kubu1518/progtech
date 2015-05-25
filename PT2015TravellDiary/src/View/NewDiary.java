package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.BoxLayout;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Component;

import javax.swing.Box;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class NewDiary {

	private JFrame frame;
	private JPanel contentPane;
	private JTextField textFieldJourneyName;
	private JComboBox comboBoxBDay;
	private JComboBox comboBoxBMonth;
	private JComboBox comboBoxBYear;
	private JComboBox comboBoxEDay;
	private JComboBox comboBoxEMonth;
	private JComboBox comboBoxEYear;
	private JRadioButton rdbtnBusiness;
	private JRadioButton rdbtnHoliday;
	private JButton btnNext;
	private JLabel lblValidinfo;

	/**
	 * Launch the application.
	 */
	public void showNewDiary() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewDiary.this.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewDiary() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 395, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJourneyName = new JLabel("Journey Name:");
		lblJourneyName.setBounds(36, 57, 73, 14);
		contentPane.add(lblJourneyName);
		
		textFieldJourneyName = new JTextField();
		textFieldJourneyName.setBounds(119, 54, 185, 20);
		contentPane.add(textFieldJourneyName);
		textFieldJourneyName.setColumns(10);
		
		JLabel lblBeginning = new JLabel("Beginning:");
		lblBeginning.setBounds(59, 94, 50, 14);
		contentPane.add(lblBeginning);
		
		comboBoxBDay = new JComboBox();
		comboBoxBDay.setBounds(119, 91, 50, 20);
		contentPane.add(comboBoxBDay);
		
		comboBoxBMonth = new JComboBox();
		comboBoxBMonth.setBounds(179, 91, 97, 20);
		contentPane.add(comboBoxBMonth);
		
		comboBoxBYear = new JComboBox();
		comboBoxBYear.setBounds(286, 91, 65, 20);
		contentPane.add(comboBoxBYear);
		
		JLabel lblEnding = new JLabel("Ending:");
		lblEnding.setBounds(73, 137, 36, 14);
		contentPane.add(lblEnding);
		
		comboBoxEDay = new JComboBox();
		comboBoxEDay.setBounds(119, 134, 50, 20);
		contentPane.add(comboBoxEDay);
		
		comboBoxEMonth = new JComboBox();
		comboBoxEMonth.setBounds(179, 134, 97, 20);
		contentPane.add(comboBoxEMonth);
		
		comboBoxEYear = new JComboBox();
		comboBoxEYear.setBounds(286, 134, 65, 20);
		contentPane.add(comboBoxEYear);
		
		JLabel lblTypeOfJ = new JLabel("Type of Journey:");
		lblTypeOfJ.setBounds(25, 179, 83, 14);
		contentPane.add(lblTypeOfJ);
		
		rdbtnBusiness = new JRadioButton("Business");
		rdbtnBusiness.setBounds(119, 175, 73, 23);
		contentPane.add(rdbtnBusiness);
		
		rdbtnHoliday = new JRadioButton("Holiday");
		rdbtnHoliday.setBounds(194, 175, 82, 23);
		contentPane.add(rdbtnHoliday);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnHoliday);
		bg.add(rdbtnBusiness);
		
		
		btnNext = new JButton("Next");
		btnNext.setBounds(280, 216, 89, 23);
		contentPane.add(btnNext);
		
		JPanel infoPanel = new JPanel();
		infoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		infoPanel.setBounds(10, 11, 356, 35);
		contentPane.add(infoPanel);
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
		
		JLabel lblNewDiary = new JLabel("New Diary");
		lblNewDiary.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewDiary.setFont(new Font("Aldhabi", Font.BOLD, 25));
		infoPanel.add(lblNewDiary);
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		infoPanel.add(horizontalStrut);
		
		JLabel lblFillinfo = new JLabel("Please, enter the base information of the Journey");
		lblFillinfo.setFont(new Font("Aldhabi", Font.PLAIN, 20));
		lblFillinfo.setForeground(new Color(218, 112, 214));
		infoPanel.add(lblFillinfo);
		
		lblValidinfo = new JLabel("");
		lblValidinfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblValidinfo.setBounds(10, 225, 260, 14);
		contentPane.add(lblValidinfo);
	}
	
	
	public JFrame getFrame(){
		return frame;
	}

	public JComboBox getComboBoxBDay() {
		return comboBoxBDay;
	}

	public JComboBox getComboBoxBMonth() {
		return comboBoxBMonth;
	}

	public JComboBox getComboBoxBYear() {
		return comboBoxBYear;
	}

	public JComboBox getComboBoxEDay() {
		return comboBoxEDay;
	}

	public JComboBox getComboBoxEMonth() {
		return comboBoxEMonth;
	}

	public JComboBox getComboBoxEYear() {
		return comboBoxEYear;
	}
	
	public String getActiveRadioButtom(){
		if (rdbtnBusiness.isSelected()) {
			return rdbtnBusiness.getText();
		}
		else if(rdbtnHoliday.isSelected()){
			return rdbtnHoliday.getText();
		}
		else
			return null;
		
	}
	
	public void  setValidInf(String msg){
		lblValidinfo.setText(msg);
	}
	
	public String getFNTextField(){
		return textFieldJourneyName.getText();
	} 
	
	public void addNextButtonListener(ActionListener forNext){
		btnNext.addActionListener(forNext);
	}
	
	
	
}
