package View;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTree;

import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;

import java.awt.Component;



import javax.swing.Box;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.JList;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class WorkWindow {

	private JFrame frame;
	private JPanel contentPane;
	private JTree tree;
	private DefaultMutableTreeNode root;
	private JPanel panelForDatas;
	private JLabel lblinfFN;
	private JLabel lblinfTOCP;
	private JLabel lblinfNOD;
	private JLabel lblinfAC;
	private JLabel lblinfATD;
	private JLabel lblinfASD;
	
	
	private JLabel lblJinfJN;
	private JLabel lblJinfDOC;
	private JLabel lblJinfNOD;
	private JLabel lblJinfAC;
	private JLabel lblJinfATD;
	private JLabel lblJinfTOJ;
	
	
	private JLabel lblDinfDOD;
	private JLabel lblDinfoTD;
	private JLabel lblDinfC;
	private JList listJLocations;
	private JList listDLocations;
	private JEditorPane dtrpnNote;
	private JLabel lblJinfDOB;
	private JLabel lblJinfDOE;
	private JMenuItem mntmNewDiary;
	/**
	 * Launch the application.
	 */
	public void showWorkWindows() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkWindow.this.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WorkWindow() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmNewDiary = new JMenuItem("New Diary");
		
		mnFile.add(mntmNewDiary);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panelForProfile = new JPanel();
		panelForProfile.setBorder(new LineBorder(SystemColor.text));
		contentPane.add(panelForProfile, BorderLayout.NORTH);
		panelForProfile.setLayout(new BoxLayout(panelForProfile, BoxLayout.X_AXIS));
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Segoe UI Symbol", Font.BOLD, 13));
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		panelForProfile.add(lblUser);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panelForProfile.add(horizontalStrut);
		
		JLabel lblUserName = new JLabel("here");
		panelForProfile.add(lblUserName);
		
		JPanel panelForTree = new JPanel();
		panelForTree.setBorder(new TitledBorder(new EmptyBorder(0, 0, 0, 0), "Your Diaries", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(59, 59, 59)));
		contentPane.add(panelForTree, BorderLayout.WEST);
		panelForTree.setLayout(new BorderLayout(0, 0));
		
		root = new DefaultMutableTreeNode("Journeys");
		tree = new JTree(root);
		
		tree.setVisibleRowCount(2);
		tree.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, SystemColor.textHighlight, null, null, null));
		tree.setFont(new Font("Segoe Print", Font.BOLD | Font.ITALIC, 15));
		tree.setForeground(Color.WHITE);
		tree.setBackground(SystemColor.menu);
		
		JScrollPane treeView = new JScrollPane(tree);
		panelForTree.add(treeView, BorderLayout.CENTER);
		
		panelForDatas = new JPanel(new CardLayout(0, 50));
		panelForDatas.setBorder(new TitledBorder(null, "General Profile Data", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(138, 43, 226)));
		
		JPanel dataofJRootCard = new JPanel();
		JPanel dataofJourneyCard = new JPanel();
		JPanel dataofDayCard = new JPanel();
		
		panelForDatas.add(dataofJRootCard,"r");
		dataofJRootCard.setLayout(new GridLayout(0, 2, 0, 10));
		
		JLabel lblFullName = new JLabel("Owner");
		lblFullName.setForeground(new Color(186, 85, 211));
		lblFullName.setOpaque(true);
		lblFullName.setBackground(new Color(230, 230, 250));
		lblFullName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFullName.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 18));
		dataofJRootCard.add(lblFullName);
		
		lblinfFN = new JLabel("");
		lblinfFN.setForeground(new Color(138, 43, 226));
		lblinfFN.setFont(new Font("Raavi", Font.ITALIC, 17));
		lblinfFN.setHorizontalAlignment(SwingConstants.CENTER);
		dataofJRootCard.add(lblinfFN);
		
		JLabel lbldateOfCreating = new JLabel("Time of creating Profile");
		lbldateOfCreating.setForeground(new Color(186, 85, 211));
		lbldateOfCreating.setOpaque(true);
		lbldateOfCreating.setBackground(new Color(230, 230, 250));
		lbldateOfCreating.setHorizontalAlignment(SwingConstants.RIGHT);
		lbldateOfCreating.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 18));
		dataofJRootCard.add(lbldateOfCreating);
		
		lblinfTOCP = new JLabel("");
		lblinfTOCP.setForeground(new Color(138, 43, 226));
		lblinfTOCP.setFont(new Font("Raavi", Font.ITALIC, 17));
		lblinfTOCP.setHorizontalAlignment(SwingConstants.CENTER);
		dataofJRootCard.add(lblinfTOCP);
		
		JLabel lblNumOfDiaries = new JLabel("Number of diaries");
		lblNumOfDiaries.setForeground(new Color(186, 85, 211));
		lblNumOfDiaries.setOpaque(true);
		lblNumOfDiaries.setBackground(new Color(230, 230, 250));
		lblNumOfDiaries.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumOfDiaries.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 18));
		dataofJRootCard.add(lblNumOfDiaries);
		
		lblinfNOD = new JLabel("");
		lblinfNOD.setForeground(new Color(138, 43, 226));
		lblinfNOD.setFont(new Font("Raavi", Font.ITALIC, 17));
		lblinfNOD.setHorizontalAlignment(SwingConstants.CENTER);
		dataofJRootCard.add(lblinfNOD);
		
		JLabel lblAllCosts = new JLabel("All costs");
		lblAllCosts.setForeground(new Color(186, 85, 211));
		lblAllCosts.setOpaque(true);
		lblAllCosts.setBackground(new Color(230, 230, 250));
		lblAllCosts.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAllCosts.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 18));
		dataofJRootCard.add(lblAllCosts);
		
		lblinfAC = new JLabel("");
		lblinfAC.setForeground(new Color(138, 43, 226));
		lblinfAC.setFont(new Font("Raavi", Font.ITALIC, 17));
		lblinfAC.setHorizontalAlignment(SwingConstants.CENTER);
		dataofJRootCard.add(lblinfAC);
		
		JLabel lblAllTraveledDistance = new JLabel("All traveled distance");
		lblAllTraveledDistance.setForeground(new Color(186, 85, 211));
		lblAllTraveledDistance.setOpaque(true);
		lblAllTraveledDistance.setBackground(new Color(230, 230, 250));
		lblAllTraveledDistance.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAllTraveledDistance.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 18));
		dataofJRootCard.add(lblAllTraveledDistance);
		
		lblinfATD = new JLabel("");
		lblinfATD.setForeground(new Color(138, 43, 226));
		lblinfATD.setFont(new Font("Raavi", Font.ITALIC, 17));
		lblinfATD.setHorizontalAlignment(SwingConstants.CENTER);
		dataofJRootCard.add(lblinfATD);
		
		JLabel lblAllSpentDays = new JLabel("All spent days");
		lblAllSpentDays.setForeground(new Color(186, 85, 211));
		lblAllSpentDays.setOpaque(true);
		lblAllSpentDays.setBackground(new Color(230, 230, 250));
		lblAllSpentDays.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAllSpentDays.setFont(new Font("Plantagenet Cherokee", Font.BOLD, 18));
		dataofJRootCard.add(lblAllSpentDays);
		
		lblinfASD = new JLabel("");
		lblinfASD.setForeground(new Color(138, 43, 226));
		lblinfASD.setFont(new Font("Raavi", Font.ITALIC, 17));
		lblinfASD.setHorizontalAlignment(SwingConstants.CENTER);
		dataofJRootCard.add(lblinfASD);
		
		panelForDatas.add(dataofJourneyCard,"j");
		dataofJourneyCard.setLayout(new BoxLayout(dataofJourneyCard, BoxLayout.Y_AXIS));
		
		JPanel dataofJourneypanel1 = new JPanel();
		dataofJourneypanel1.setBorder(new TitledBorder(null, "General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dataofJourneyCard.add(dataofJourneypanel1);
		dataofJourneypanel1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblJJourneyName = new JLabel("Journey Name");
		lblJJourneyName.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblJJourneyName.setHorizontalAlignment(SwingConstants.RIGHT);
		dataofJourneypanel1.add(lblJJourneyName);
		
		lblJinfJN = new JLabel("");
		lblJinfJN.setHorizontalAlignment(SwingConstants.CENTER);
		dataofJourneypanel1.add(lblJinfJN);
		
		JLabel lblJDateOfCreating = new JLabel("Date of creating");
		lblJDateOfCreating.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblJDateOfCreating.setHorizontalAlignment(SwingConstants.RIGHT);
		dataofJourneypanel1.add(lblJDateOfCreating);
		
		lblJinfDOC = new JLabel("");
		lblJinfDOC.setHorizontalAlignment(SwingConstants.CENTER);
		dataofJourneypanel1.add(lblJinfDOC);
		
		JLabel lblJDateOfBeginning = new JLabel("Beginning");
		lblJDateOfBeginning.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJDateOfBeginning.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		dataofJourneypanel1.add(lblJDateOfBeginning);
		
		lblJinfDOB = new JLabel("");
		lblJinfDOB.setHorizontalAlignment(SwingConstants.CENTER);
		dataofJourneypanel1.add(lblJinfDOB);
		
		JLabel lblJDateOfEnding = new JLabel("End");
		lblJDateOfEnding.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJDateOfEnding.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		dataofJourneypanel1.add(lblJDateOfEnding);
		
		lblJinfDOE = new JLabel("");
		lblJinfDOE.setHorizontalAlignment(SwingConstants.CENTER);
		dataofJourneypanel1.add(lblJinfDOE);
		
		JLabel lblJNumberOfDays = new JLabel("Number of Days");
		lblJNumberOfDays.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblJNumberOfDays.setHorizontalAlignment(SwingConstants.RIGHT);
		dataofJourneypanel1.add(lblJNumberOfDays);
		
		lblJinfNOD = new JLabel("");
		lblJinfNOD.setHorizontalAlignment(SwingConstants.CENTER);
		dataofJourneypanel1.add(lblJinfNOD);
		
		JLabel lblJAllCosts = new JLabel("All costs");
		lblJAllCosts.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblJAllCosts.setHorizontalAlignment(SwingConstants.RIGHT);
		dataofJourneypanel1.add(lblJAllCosts);
		
		lblJinfAC = new JLabel("");
		lblJinfAC.setHorizontalAlignment(SwingConstants.CENTER);
		dataofJourneypanel1.add(lblJinfAC);
		
		JLabel lblJAllTraveledDistance = new JLabel("All traveled distance");
		lblJAllTraveledDistance.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblJAllTraveledDistance.setHorizontalAlignment(SwingConstants.RIGHT);
		dataofJourneypanel1.add(lblJAllTraveledDistance);
		
		lblJinfATD = new JLabel("");
		lblJinfATD.setHorizontalAlignment(SwingConstants.CENTER);
		dataofJourneypanel1.add(lblJinfATD);
		
		JLabel lblJTypeOfJourney = new JLabel("Type of Journey");
		lblJTypeOfJourney.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		lblJTypeOfJourney.setHorizontalAlignment(SwingConstants.RIGHT);
		dataofJourneypanel1.add(lblJTypeOfJourney);
		
		lblJinfTOJ = new JLabel("");
		lblJinfTOJ.setHorizontalAlignment(SwingConstants.CENTER);
		dataofJourneypanel1.add(lblJinfTOJ);
		
		JPanel dataofJourneypanel2 = new JPanel();
		dataofJourneypanel2.setBorder(new TitledBorder(null, "Locations", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(59, 59, 59)));
		dataofJourneyCard.add(dataofJourneypanel2);
		dataofJourneypanel2.setLayout(new BorderLayout(0, 0));
		
		listJLocations = new JList();
		dataofJourneypanel2.add(listJLocations);
		
		
		panelForDatas.add(dataofDayCard,"d");
		dataofDayCard.setLayout(new BoxLayout(dataofDayCard, BoxLayout.Y_AXIS));
		
		JPanel dataOfDaypanel1 = new JPanel();
		dataOfDaypanel1.setBorder(new TitledBorder(null, "General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dataofDayCard.add(dataOfDaypanel1);
		dataOfDaypanel1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblDDateOfDay = new JLabel("Date");
		lblDDateOfDay.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDDateOfDay.setHorizontalAlignment(SwingConstants.RIGHT);
		dataOfDaypanel1.add(lblDDateOfDay);
		
		lblDinfDOD = new JLabel("");
		lblDinfDOD.setHorizontalAlignment(SwingConstants.CENTER);
		dataOfDaypanel1.add(lblDinfDOD);
		
		JLabel lblDTraveledDistOfDay = new JLabel("Traveled distance");
		lblDTraveledDistOfDay.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDTraveledDistOfDay.setHorizontalAlignment(SwingConstants.RIGHT);
		dataOfDaypanel1.add(lblDTraveledDistOfDay);
		
		lblDinfoTD = new JLabel("");
		lblDinfoTD.setHorizontalAlignment(SwingConstants.CENTER);
		dataOfDaypanel1.add(lblDinfoTD);
		
		JLabel lblDCostOfDay = new JLabel("Costs");
		lblDCostOfDay.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDCostOfDay.setHorizontalAlignment(SwingConstants.RIGHT);
		dataOfDaypanel1.add(lblDCostOfDay);
		
		lblDinfC = new JLabel("");
		lblDinfC.setHorizontalAlignment(SwingConstants.CENTER);
		dataOfDaypanel1.add(lblDinfC);
		
		JPanel dataOfDaypanel2 = new JPanel();
		dataOfDaypanel2.setBorder(new TitledBorder(null, "Note of the Day", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dataofDayCard.add(dataOfDaypanel2);
		dataOfDaypanel2.setLayout(new BorderLayout(0, 0));
		
		dtrpnNote = new JEditorPane();
		dtrpnNote.setEditable(false);
		dataOfDaypanel2.add(dtrpnNote, BorderLayout.CENTER);
		
		JPanel dataOfDaypanel3 = new JPanel();
		dataOfDaypanel3.setBorder(new TitledBorder(null, "Locations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dataofDayCard.add(dataOfDaypanel3);
		dataOfDaypanel3.setLayout(new BorderLayout(0, 0));
		
		listDLocations = new JList();
		dataOfDaypanel3.add(listDLocations, BorderLayout.CENTER);
		
		
		contentPane.add(panelForDatas, BorderLayout.CENTER);
		
	}
	
	public JFrame getFrame(){
		return frame;
	}

	public JTree getTree() {
		return tree;
	}
	
	public void addMenuItemNewDiaryListener(ActionListener listenerForItem){
		mntmNewDiary.addActionListener(listenerForItem);
	}

    public void addTreeListener(TreeSelectionListener forSelectedItem){
    	tree.getSelectionModel().addTreeSelectionListener(forSelectedItem);
    }
    
   

	public JPanel getPanelForDatas() {
		return panelForDatas;
	}
	
	

	public void setLblinfFN(String result) {
		this.lblinfFN.setText(result);
	}

	public void setLblinfTOCP(String result) {
		this.lblinfTOCP.setText(result);
	}

	public void setLblinfNOD(String result) {
		this.lblinfNOD.setText(result);
	}

	public void setLblinfAC(String result) {
		this.lblinfAC.setText(result);
	}

	public void setLblinfATD(String result) {
		this.lblinfATD.setText(result);
	}

	public void setLblinfASD(String result) {
		this.lblinfASD.setText(result);
		
		
		
	}

	public void setLblJinfJN(String result) {
		this.lblJinfJN.setText(result);
	}

	public void setLblJinfDOC(String result) {
		this.lblJinfDOC.setText(result);
	}

	public void setLblJinfNOD(String result) {
		this.lblJinfNOD.setText(result);
	}

	public void setLblJinfAC(String result) {
		this.lblJinfAC.setText(result);
	}

	public void setLblJinfATD(String result) {
		this.lblJinfATD.setText(result);
	}

	public void setLblJinfTOJ(String result) {
		this.lblJinfTOJ.setText(result);
	}
	
	public void setLblJinfDOB(String result) {
		this.lblJinfDOB.setText(result);
	}

	public void setLblJinfDOE(String result) {
		this.lblJinfDOE.setText(result);
	}
	
	
	

	public void setLblDinfDOD(String result) {
		this.lblDinfDOD.setText(result);
	}

	public void setLblDinfoTD(String result) {
		this.lblDinfoTD.setText(result);
	}

	public void setLblDinfC(String result) {
		this.lblDinfC.setText(result);
	}
	
	

	public JList getListJLocations() {
		return listJLocations;
	}

	public JList getListDLocations() {
		return listDLocations;
	}

	public JEditorPane getDtrpnNote() {
		return dtrpnNote;
	}

    
	
    
	
}
