package Model;

import java.sql.Date;
import java.util.LinkedList;

public class Journey {
	 private int journeyId;
     private String journeyName;
     private Date beginOfJourney;
     private Date endOfJourney;
     private String JType;
     private Date dateOfCreation;
     private LinkedList<Day> days;
     private double allJDistance = 0;
     
     
	public Journey(int journeyId, String journeyName, Date beginOfJourney,
			Date endOfJourney, String jType,Date dateOfCreation, LinkedList<Day> days) {
		super();
		this.journeyId = journeyId;
		this.journeyName = journeyName;
		this.beginOfJourney = beginOfJourney;
		this.endOfJourney = endOfJourney;
		this.JType = jType;
		this.dateOfCreation = dateOfCreation;
		this.days = days;
	}


	public LinkedList<Day> getDays() {
		return days;
	}


	public void setDays(LinkedList<Day> days) {
		this.days = days;
	}


	public int getJourneyId() {
		return journeyId;
	}


	public String getJourneyName() {
		return journeyName;
	}


	public Date getBeginOfJourney() {
		return beginOfJourney;
	}


	public Date getEndOfJourney() {
		return endOfJourney;
	}


	public String getJType() {
		return JType;
	}

	

	public Date getDateOfCreation() {
		return dateOfCreation;
	}
	
	


	public double getAllJDistance() {
		return allJDistance;
	}


	public void setAllJDistance(double allJDistance) {
		this.allJDistance = allJDistance;
	}


	@Override
	public String toString() {
		return "Journey [journeyId=" + journeyId + ", journeyName="
				+ journeyName + ", beginOfJourney=" + beginOfJourney
				+ ", endOfJourney=" + endOfJourney + ", JType=" + JType
				+ ", days=" + days + "]";
	}
	
	
	
     
     
}
