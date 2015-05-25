package Controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.StringJoiner;

import javax.sound.sampled.ReverbType;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.View;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import oracle.sql.DATE;

import org.joda.time.DateTime;

import com.google.maps.internal.StringJoin;

import Model.Day;
import Model.DbConnection;
import Model.GoogleRequest;
import Model.Journey;
import Model.Location;
import Model.Profile;
import View.Login;
import View.NewDiary;
import View.NewDiaryDetails;
import View.Registration;
import View.WorkWindow;
import Controller.SupporterMethods;

public class Controlling {
	private Login logView;
	private Registration regView;
	private WorkWindow workView;
	private NewDiary ndiaryView;
	private NewDiaryDetails detailsView;
	private Profile actProf;
	private LinkedList<String[]> dateForCB;
	private Journey newJourney = null;
	private int newJourneyDays = 0;

	public Controlling(Login logView) {
		super();
		this.logView = logView;

		this.logView.addSignInListener(new SignInListener());
		this.logView.addRegistrationListener(new RegistrationListener());
		
		this.dateForCB = new LinkedList<String[]>();
		this.dateForCB.add(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
										  "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
										  "24", "25", "26", "27", "28", "29", "30", "31" });
		
		this.dateForCB.add(new String[] { "01", "02", "03", "04", "05", "06", "07", 
											"08", "09", "10", "11", "12" });
		
		this.dateForCB.add(generateYear());

	}

	public Profile getActProf() {
		return actProf;
	}

	class RegistrationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			logView.setVisible(false);
			regView = new Registration();
			regView.addSignUpListener(new SignUpListener());
			regView.addBackListener(new BackListener());
			regView.setVisible(true);
		}

	}

	class SignInListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String u = logView.getUsername();
			String p = logView.getPassword();

			if (u.isEmpty() || p.isEmpty())
				logView.setValidStatus("Unfilled fields.");
			else {
				try {
					if (!DbConnection.validateProfile(logView.getUsername(),
							logView.getPassword()))
						logView.setValidStatus("This profile doesn't exist.");
					else {
						logView.dispose();
						actProf = DbConnection.allDateToProfile();
						workView = new WorkWindow();
						workView.getTree().setModel(buildTree());
						workView.addTreeListener(new SelectedItemListener());
						workView.addMenuItemNewDiaryListener(new NewDiaryListener());
						workView.showWorkWindows();

					}

				} catch (RuntimeException e1) {
					e1.printStackTrace();
				}
			}
		}

	}
	
	
	class NewDiaryListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			workView.getFrame().setVisible(false);
			ndiaryView = new NewDiary();
			ndiaryView.getComboBoxBDay().setModel(new DefaultComboBoxModel(dateForCB.get(0)));
			ndiaryView.getComboBoxBMonth().setModel(new DefaultComboBoxModel(dateForCB.get(1)));
			ndiaryView.getComboBoxBYear().setModel(new DefaultComboBoxModel(dateForCB.get(2)));
			ndiaryView.getComboBoxEDay().setModel(new DefaultComboBoxModel(dateForCB.get(0)));
			ndiaryView.getComboBoxEMonth().setModel(new DefaultComboBoxModel(dateForCB.get(1)));
			ndiaryView.getComboBoxEYear().setModel(new DefaultComboBoxModel(dateForCB.get(2)));
			ndiaryView.addNextButtonListener(new NextListener());
			
			ndiaryView.showNewDiary();
			
			
			
		}
		
	}
	
	
	
	class NextListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			StringJoiner sj = new StringJoiner("-");
			sj.add(ndiaryView.getComboBoxBYear().getSelectedItem().toString());
			sj.add(ndiaryView.getComboBoxBMonth().getSelectedItem().toString());
			sj.add(ndiaryView.getComboBoxBDay().getSelectedItem().toString());
			
			LocalDate l1 = LocalDate.parse(sj.toString());
					
			sj = new StringJoiner("-");
			sj.add(ndiaryView.getComboBoxEYear().getSelectedItem().toString());
			sj.add(ndiaryView.getComboBoxEMonth().getSelectedItem().toString());
			sj.add(ndiaryView.getComboBoxEDay().getSelectedItem().toString());
			
			
			LocalDate l2 = LocalDate.parse(sj.toString());
			
			 if((l1.compareTo(l2) < 0 || l1.compareTo(l2) == 0) && !(ndiaryView.getActiveRadioButtom() == null) && !ndiaryView.getFNTextField().isEmpty()){
				 String[] daysForCombo;
				
				 
				newJourney = new Journey(actProf.getJourneys().get(0).getJourneyId()+10,
						ndiaryView.getFNTextField(), Date.valueOf(l1), Date.valueOf(l2),
						ndiaryView.getActiveRadioButtom().equals("Holiday") ? "H" : "D", Date.valueOf(LocalDate.now()), null);
						ndiaryView.getFrame().dispose();
						detailsView = new NewDiaryDetails();
						
						 int dif = (int)ChronoUnit.DAYS.between(l1, l2) + 1;
						 LinkedList<Day> days = new LinkedList<Day>(); 
						 
						 daysForCombo = new String[dif];
						 for (int i = 1; i <= dif; i++) {
							days.add(new Day(newJourney.getJourneyId()+10+i, i, "", 0));
							daysForCombo[i-1] = i+".day";
						}
						
						 newJourney.setDays(days);
						 
						 
						 detailsView.getComboBoxDays().setModel(new DefaultComboBoxModel(daysForCombo));
						 detailsView.setSaveButtonText("Save " + String.valueOf(detailsView.getComboBoxDays().getSelectedIndex() + 1) + ".day");
						 detailsView.addComboBoxListener(new DaysComboBoxListener());
						 detailsView.addSaveButtonListener(new SaveButtonListener());
						 detailsView.addAddButtonListener(new AddButtonListener());
						 //detailsView.addFinishButtonListener(new FinishButtonListener());
						
						
						detailsView.showDetails();
						
						
			 }
			 else{
				 ndiaryView.setValidInf("Some field has been filled incorrect!");
			 }
			
		}
		
	}
	
	class SaveButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(!detailsView.getCost().equals("") && !detailsView.getEditorPaneNote().equals("") && detailsView.getListLocations().getModel().getSize() != 0){
			
			for ( Day d : newJourney.getDays()) {
				
				if(d.getNumberOfDay() == detailsView.getComboBoxDays().getSelectedIndex()+1){
					d.setCost(Double.parseDouble(detailsView.getCost()));
					d.setDescriptionOfDay(detailsView.getEditorPaneNote());
					d.setLocations(new LinkedList<Location>());
					
					for(int i = 0; i < detailsView.getListLocations().getModel().getSize(); i++){
						int id = d.getDayId()+10 + i + 1;
						String name = (String)detailsView.getListLocations().getModel().getElementAt(i);
						double[] geo = GoogleRequest.getGeoCodeOfCity(name);
						
						d.getLocations().add(new Location(id, name, String.valueOf(geo[0]), String.valueOf(geo[1])));
					}
					break;
					
				}
			}
			
			detailsView.setSaveValid(String.valueOf(detailsView.getComboBoxDays().getSelectedIndex() + 1) + ".day is saved");
			}
			else
			{
				detailsView.setSaveValid("Unfilled fields in " + String.valueOf(detailsView.getComboBoxDays().getSelectedIndex() + 1) + ".day");
			}
		
			
		}
		
	}
	
	class DaysComboBoxListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			detailsView.setSaveButtonText(String.valueOf(detailsView.getComboBoxDays().getSelectedIndex() + 1));
			boolean flag = false;
			
			for ( Day d : newJourney.getDays()){
				if(detailsView.getComboBoxDays().getSelectedIndex()+1 == d.getNumberOfDay()){
					detailsView.setCost(String.valueOf(d.getCost()));
					detailsView.setEditorPaneNote(d.getDescriptionOfDay());
					detailsView.getListLocations().setListData(d.getLocations().toArray());
					flag = true;
					break;
				}
				
			} 
			
			if(!flag){
				detailsView.setCost("");
				detailsView.setEditorPaneNote("");
				detailsView.getListLocations().setListData(new String[]{});
			}
			
		}
		
	}
	
	class AddButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(!detailsView.getTextFieldLocation().equals("")){
				
				
				String[] tmp = new String[detailsView.getListLocations().getModel().getSize() + 1]; 
				
				for (int i = 0; i < detailsView.getListLocations().getModel().getSize(); i++) {
					tmp[i] = (String)detailsView.getListLocations().getModel().getElementAt(i);
				}
				
				tmp[detailsView.getListLocations().getModel().getSize()] = detailsView.getTextFieldLocation();
				
				
				detailsView.getListLocations().setListData(tmp);
				detailsView.setTextFieldLocation("");
				
			}
			
		}
		
	}
	
	class SelectedItemListener implements TreeSelectionListener{

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			CustomMutableTreeNode cnode = (CustomMutableTreeNode) workView.getTree().getLastSelectedPathComponent();
			System.out.println(cnode.nodeId);
			
			if(cnode.nodeType.equals("r")){
            	CardLayout c1 = (CardLayout)workView.getPanelForDatas().getLayout();
            	c1.show(workView.getPanelForDatas(), "r");
            	
            	LinkedList<String> result = SupporterMethods.CollectDataForProfile(actProf);
            	
            	
            	workView.setLblinfFN(result.get(0));
            	workView.setLblinfTOCP(result.get(1));
            	workView.setLblinfNOD(result.get(2));
            	workView.setLblinfAC(result.get(3));
            	workView.setLblinfATD(result.get(4));
            	workView.setLblinfASD(result.get(5));
            	
            }
			
            if(cnode.nodeType.equals("j")){
            	CardLayout c1 = (CardLayout)workView.getPanelForDatas().getLayout();
            	c1.show(workView.getPanelForDatas(), "j");
            	
            	LinkedList<String> result = SupporterMethods.CollectDataForActJourney(actProf,cnode.nodeId);
            	workView.setLblJinfJN(result.remove(0));
            	workView.setLblJinfDOC(result.remove(0));
            	workView.setLblJinfDOB(result.remove(0));
            	workView.setLblJinfDOE(result.remove(0));
            	workView.setLblJinfNOD(result.remove(0));
            	workView.setLblJinfAC(result.remove(0));
            	workView.setLblJinfATD(result.remove(0));
            	workView.setLblJinfTOJ(result.remove(0));
            	
            	workView.getListJLocations().setListData(result.toArray());
            	
            }
            
            if(cnode.nodeType.equals("d")){
            	CardLayout c1 = (CardLayout)workView.getPanelForDatas().getLayout();
            	c1.show(workView.getPanelForDatas(), "d");
            	
            	LinkedList<String> result = SupporterMethods.CollectDataForActDay(actProf,cnode.nodeId);
            	
            	workView.setLblDinfDOD(result.remove(0));
            	workView.setLblDinfoTD(result.remove(0));
            	workView.setLblDinfC(result.remove(0));
            	workView.getDtrpnNote().setText(result.remove(0));
            	
            	workView.getListDLocations().setListData(result.toArray());
            	
            }
			
		}

		
		
	}

	class SignUpListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String fn = regView.getFullName();
			String us = regView.getUserName();
			String pa = regView.getPassword();
			String pac = regView.getPasswordConfirm();

			if (fn.isEmpty() || us.isEmpty() || pa.isEmpty() || pac.isEmpty())
				regView.setValidInfo("Unfilled fields.");
			else if (pa.length() >= 4 && pa.length() <= 6)
				regView.setValidInfo("The passwords is not valid (exactly 5 character)");
			else if (!pa.equals(pac))
				regView.setValidInfo("The passwords don't equal.");
			else if (DbConnection.createNewProfile(fn, us, pa)) {
				logView.setValidStatus("Registration was succes.");
				regView.dispose();
				logView.setVisible(true);
			} else {
				regView.setValidInfo("Username exists.");
			}
		}

	}

	class BackListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			logView.setVisible(true);
			regView.dispose();
		

		}

	}

	class CustomMutableTreeNode extends DefaultMutableTreeNode {
		private int nodeId;
		private String nodeName;
		private String nodeType;

		public CustomMutableTreeNode(String name, int nodeId,String nodeType) {
			super(name);
			this.nodeId = nodeId;
			this.nodeName = name;
			this.nodeType = nodeType;
		}

		public int getID() {
			return nodeId;
		}

		
		

		
	}

	public DefaultTreeModel buildTree() {
		CustomMutableTreeNode root = new CustomMutableTreeNode("Journeys",0,"r");
		CustomMutableTreeNode journey = null;
		CustomMutableTreeNode day = null;

		for (Journey j : getActProf().getJourneys()) {
			journey = new CustomMutableTreeNode(j.getJourneyName(),j.getJourneyId(),"j");
			for (Day d : j.getDays()) {
				journey.add(new CustomMutableTreeNode(d.getNumberOfDay()
						+ ". day",d.getDayId(),"d"));
			}
			root.add(journey);
		}

		return new DefaultTreeModel(root);

	}
	
	
	public static String[] generateYear() {
        DateTime now = new DateTime();
        
     String[] tmp = new String[now.getYear() + 4 - 1970 + 1];
     for (int i = 1970; i <= (now.getYear() + 4); i++) {
         tmp[i - 1970] = Integer.toString(i);
     }
     return tmp;
 }
	
	

}
