package Model;

import java.sql.Date;
import java.util.LinkedList;

public class Profile {

	private int profileId;
	private String fullName;
	private String userName;
	private String passWord;
	private Date dateOfCreation;
	private LinkedList<Journey> journeys;
	private double allDistance = 0;
	
	public Profile(int profileId, String fullName, String userName,
			String passWord,Date dateOfCreation, LinkedList<Journey> journeys) {
		super();
		this.profileId = profileId;
		this.fullName = fullName;
		this.userName = userName;
		this.passWord = passWord;
		this.dateOfCreation = dateOfCreation;
		this.journeys = journeys;
	}


	public int getProfileId() {
		return profileId;
	}


	public String getFullName() {
		return fullName;
	}


	public String getUserName() {
		return userName;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setJourneys(LinkedList<Journey> journeys) {
		this.journeys = journeys;
	}


	public LinkedList<Journey> getJourneys() {
		return journeys;
	}

	

	public Date getDateOfCreation() {
		return dateOfCreation;
	}

		

	public double getAllDistance() {
		return allDistance;
	}


	public void setAllDistance(double allDistance) {
		this.allDistance = allDistance;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Profile [profileId=" + profileId + ", fullName=" + fullName
				+ ", userName=" + userName + ", passWord=" + passWord
				+ ", journeys=" + journeys + "]\n");
		
		
		return sb.toString();
				
	}


	
	
	
	
	
}
