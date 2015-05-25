package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import java.awt.FlowLayout;

import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

import java.awt.Component;

import javax.swing.Box;

import java.awt.Font;
import java.awt.event.ActionListener;

public class NewDiaryDetails {

	private JFrame frame;	
	private JPanel contentPane;
	private JPanel panelLocations;
	private JList listLocations;
	private JTextField textFieldLocation;
	private JButton btnAddLocation;
	private JComboBox comboBoxDays;
	private JEditorPane editorPaneNote;
	private JButton btnFinish;
	private JLabel lblCost;
	private JTextField textFieldCost;
	private JLabel lblValut;
	private JButton btnSave;
	private JLabel lblSavevalid;

	/**
	 * Launch the application.
	 */
	public void showDetails() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewDiaryDetails.this.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewDiaryDetails() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 624, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBoxDays = new JComboBox();
		comboBoxDays.setBounds(10, 61, 121, 20);
		contentPane.add(comboBoxDays);
		
		panelLocations = new JPanel();
		panelLocations.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Locations", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelLocations.setBounds(10, 178, 121, 212);
		contentPane.add(panelLocations);
		panelLocations.setLayout(new BorderLayout(0, 0));
		
		listLocations = new JList();
		listLocations.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelLocations.add(listLocations, BorderLayout.CENTER);
		
		textFieldLocation = new JTextField();
		textFieldLocation.setBounds(10, 123, 121, 20);
		contentPane.add(textFieldLocation);
		textFieldLocation.setColumns(10);
		
		btnAddLocation = new JButton("Add");
		btnAddLocation.setBounds(10, 154, 121, 23);
		contentPane.add(btnAddLocation);
		
		JPanel panelNote = new JPanel();
		panelNote.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Note of the day", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelNote.setBounds(141, 61, 444, 278);
		contentPane.add(panelNote);
		panelNote.setLayout(new BorderLayout(0, 0));
		
		editorPaneNote = new JEditorPane();
		panelNote.add(editorPaneNote);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBounds(10, 11, 575, 39);
		contentPane.add(panelInfo);
		panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.X_AXIS));
		
		JLabel lblDateilsOfThe = new JLabel("Details of the Dairy");
		lblDateilsOfThe.setFont(new Font("Source Code Pro Light", Font.BOLD, 16));
		panelInfo.add(lblDateilsOfThe);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panelInfo.add(horizontalStrut);
		
		JLabel lblInfoLabel = new JLabel("Please, write some line from each day and add locations to the days!");
		panelInfo.add(lblInfoLabel);
		
		btnFinish = new JButton("Finish");
		btnFinish.setBounds(496, 394, 89, 23);
		contentPane.add(btnFinish);
		
		lblCost = new JLabel("Cost:");
		lblCost.setBounds(141, 353, 35, 14);
		contentPane.add(lblCost);
		
		textFieldCost = new JTextField();
		textFieldCost.setBounds(177, 350, 86, 20);
		contentPane.add(textFieldCost);
		textFieldCost.setColumns(10);
		
		lblValut = new JLabel("Ft");
		lblValut.setBounds(274, 353, 16, 14);
		contentPane.add(lblValut);
		
		btnSave = new JButton("");
		btnSave.setBounds(300, 350, 115, 23);
		contentPane.add(btnSave);
		
		lblSavevalid = new JLabel("");
		lblSavevalid.setBounds(177, 387, 309, 14);
		contentPane.add(lblSavevalid);
	}

	public JFrame getFrame() {
		return frame;
	}

	public JList getListLocations() {
		return listLocations;
	}
	
	public String getCost(){
		return textFieldCost.getText();
	}
	
	public void setCost(String s){
		textFieldCost.setText(s);
	}

	public String getEditorPaneNote() {
		return editorPaneNote.getText();
	}
	
	
	public void setEditorPaneNote(String s) {
		editorPaneNote.setText(s);
	}


	public String getTextFieldLocation() {
		return textFieldLocation.getText();
	}
	
	public void setTextFieldLocation(String s) {
		textFieldLocation.setText(s);
	}

	public JComboBox getComboBoxDays() {
		return comboBoxDays;
	}
	
	
	
	public void addAddButtonListener(ActionListener forAdd){
		btnAddLocation.addActionListener(forAdd);
	}
	
	public void addComboBoxListener(ActionListener forComboBox){
		comboBoxDays.addActionListener(forComboBox);
	}
	
	public void addFinishButtonListener(ActionListener forFinish){
		btnFinish.addActionListener(forFinish);
	}
	
	public void addSaveButtonListener(ActionListener forSave){
		btnSave.addActionListener(forSave);
	}
	
	public void setSaveButtonText(String s){
		btnSave.setText(s);
	}
	
	public void setSaveValid(String s){
		lblSavevalid.setText(s);
	}
	
}
