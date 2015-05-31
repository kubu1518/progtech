package Model;

import java.util.LinkedList;

public class Day {
	private int DayId;
     private int NumberOfDay;
     private String DescriptionOfDay;
     private double cost;
     private LinkedList<Location> locations;
     private double allDdistance = 0;
     
     
	public Day(int dayId, int numberOfDay, String descriptionOfDay,
			double cost) {
		super();
		DayId = dayId;
		NumberOfDay = numberOfDay;
		DescriptionOfDay = descriptionOfDay;
		this.cost = cost;
	}


	public LinkedList<Location> getLocations() {
		return locations;
	}


	public void setLocations(LinkedList<Location> locations) {
		this.locations = locations;
	}


	public int getDayId() {
		return DayId;
	}


	public int getNumberOfDay() {
		return NumberOfDay;
	}


	public String getDescriptionOfDay() {
		return DescriptionOfDay;
	}


	public double getCost() {
		return cost;
	}

	

	public double getAllDdistance() {
		return allDdistance;
	}


	public void setAllDdistance(double allDdistance) {
		this.allDdistance = allDdistance;
	}
	
	
	


	public void setDescriptionOfDay(String descriptionOfDay) {
		DescriptionOfDay = descriptionOfDay;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	@Override
	public String toString() {
		return "Day [DayId=" + DayId + ", NumberOfDay=" + NumberOfDay
				+ ", DescriptionOfDay=" + DescriptionOfDay + ", cost=" + cost
				+ ", locations=" + locations + "]";
	}
	
	
     
     
     
}
