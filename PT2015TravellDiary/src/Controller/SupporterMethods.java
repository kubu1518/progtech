package Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;

import Model.Day;
import Model.GoogleRequest;
import Model.Journey;
import Model.Location;
import Model.Profile;

public abstract class SupporterMethods {

	public static LinkedList<String> CollectDataForProfile(Profile actprof) {
		LinkedList<String> tmp = new LinkedList<String>();
		tmp.add(actprof.getFullName());
		tmp.add(actprof.getDateOfCreation().toString());

		tmp.add(String.valueOf(actprof.getJourneys().size()));

		double allcosts = 0;
		int alldays = 0;
		for (Journey j : actprof.getJourneys()) {
			alldays += j.getDays().size();
			for (Day d : j.getDays()) {
				allcosts += d.getCost();
			}
		}

		tmp.add(String.valueOf(allcosts));

		if (actprof.getAllDistance() > 0) {
			tmp.add(String.valueOf(actprof.getAllDistance()));
		} else {
			double distance = allTraveledDistance(actprof.getJourneys());
			actprof.setAllDistance(distance);
			tmp.add(String.valueOf(distance));
		}

		tmp.add(String.valueOf(alldays));

		return tmp;
	}

	public static double allTraveledDistance(LinkedList<Journey> journeys) {
		LinkedList<Location> allLocInOrder = new LinkedList<Location>();
		System.out.println("distance");
		long tmp = 0;
		for (Journey j : journeys) {
			for (Day d : j.getDays()) {

				allLocInOrder.addAll(d.getLocations());

			}
		}

		for (int i = 0; i < allLocInOrder.size() - 1; i++) {

			tmp += GoogleRequest.getDistanceBetweenCities(allLocInOrder.get(i)
					.getLocName(), allLocInOrder.get(i + 1).getLocName());
		}

		return tmp / 1000.0;
	}

	public static LinkedList<String> CollectDataForActJourney(Profile actProf,
			int nodeId) {
		LinkedList<String> tmp = new LinkedList<String>();

		Journey jtmp = null;
		for (Journey j : actProf.getJourneys()) {
			if (j.getJourneyId() == nodeId) {
				jtmp = j;
				break;
			}
		}

		tmp.add(jtmp.getJourneyName());
		tmp.add(jtmp.getDateOfCreation().toString());
		tmp.add(jtmp.getBeginOfJourney().toString());
		tmp.add(jtmp.getEndOfJourney().toString());
		tmp.add(String.valueOf(jtmp.getDays().size()));

		double allcosts = 0;
		for (Day d : jtmp.getDays()) {
			allcosts += d.getCost();
		}

		tmp.add(String.valueOf(allcosts));

		if (jtmp.getAllJDistance() > 0) {
			tmp.add(String.valueOf(jtmp.getAllJDistance()));
		} else {
			double distance = journeyAllDistance(jtmp.getDays());
			jtmp.setAllJDistance(distance);
			tmp.add(String.valueOf(distance));
		}

		tmp.add(jtmp.getJType());

		for (Day d : jtmp.getDays()) {
			for (Location l : d.getLocations()) {
				tmp.add(l.getLocName());
			}
		}

		return tmp;

	}

	private static double journeyAllDistance(LinkedList<Day> days) {
		LinkedList<Location> allLocInOrder = new LinkedList<Location>();
		double tmp = 0;
		for (Day d : days) {
			allLocInOrder.addAll(d.getLocations());
		}

		for (int i = 0; i < allLocInOrder.size() - 1; i++) {
			tmp += GoogleRequest.getDistanceBetweenCities(allLocInOrder.get(i)
					.getLocName(), allLocInOrder.get(i + 1).getLocName());
		}

		return tmp / 1000.0;
	}

	public static LinkedList<String> CollectDataForActDay(Profile actProf,
			int nodeId) {
		LinkedList<String> tmp = new LinkedList<String>();
		LocalDate loc1 = null;
		Day dtmp = null;
		for (Journey j : actProf.getJourneys()) {
			for (Day d : j.getDays()) {
				if (d.getDayId() == nodeId) {
					dtmp = d;
					loc1 = j.getBeginOfJourney().toLocalDate();
					break;
				}
			}
			if (loc1 != null)
				break;

		}

		tmp.add(loc1.minusDays(1).plusDays(dtmp.getNumberOfDay()).toString());


		if (dtmp.getAllDdistance() > 0) {
			tmp.add(String.valueOf(dtmp.getAllDdistance()));
		} else {
			double distance = DistanceOnDay(dtmp.getLocations());
			dtmp.setAllDdistance(distance);
			tmp.add(String.valueOf(distance));
		}

		tmp.add(String.valueOf(dtmp.getCost()));
		tmp.add(dtmp.getDescriptionOfDay());
		for (Location l : dtmp.getLocations()) {
			tmp.add(l.getLocName());
		}

		return tmp;
	}

	private static double DistanceOnDay(LinkedList<Location> locations) {
		double tmp = 0;
		for (int i = 0; i < locations.size() - 1; i++) {
			tmp += GoogleRequest.getDistanceBetweenCities(locations.get(i)
					.getLocName(), locations.get(i + 1).getLocName());
		}
		return tmp / 1000.0;
	}
}
