package controller;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import Model.Day;
import Model.Journey;
import Model.Location;
import Model.Profile;

public class SupporterMethodsTest {
	
	private static Profile testProf;
	
	@Before
	 public void setUp(){
		
		
		LinkedList<Location> loc1 = new LinkedList<Location>();
		LinkedList<Location> loc2 = new LinkedList<Location>();
		LinkedList<Location> loc3 = new LinkedList<Location>();
		loc1.add(new Location(1, "Jánkmajtis", "", ""));
		loc1.add(new Location(2, "Kisnamény", "", ""));
		loc2.add(new Location(2, "Kisnamény", "", ""));
		loc2.add(new Location(3, "Darnó", "", ""));
		loc3.add(new Location(3, "Darnó", "", ""));
		loc3.add(new Location(1, "Jánkmajtis", "", ""));
		
		LinkedList<Day> days = new LinkedList<Day>();
		days.add(new Day(10, 1, "", 400));
		days.getLast().setLocations(loc1);
		days.add(new Day(11, 2, "", 320));
		days.getLast().setLocations(loc2);
		days.add(new Day(12, 3, "", 250));
		days.getLast().setLocations(loc3);
		
		LinkedList<Journey> journeys = new LinkedList<Journey>();
		journeys.add(new Journey(1, "Teszt1", new Date(0), new Date(0) , "B", new Date(0), days));
		
		testProf = new Profile(1, "Gipsz Jakab", "gJaki", "1234", new Date(0), journeys);
		
	}
	
	@Test
	public void testCollectDataForProfile() {
		LinkedList<String> result = SupporterMethods.CollectDataForProfile(testProf);
		String[] tmp = new String[5];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = result.get(i + 2);
		}
		
		assertArrayEquals(new String[] {"1","970","12","12","3"},tmp);
		
	}
	
	
	@Test
	public void testCollectDataForProfile2() {
		
		
		LinkedList<Location> loc1 = new LinkedList<Location>();
		LinkedList<Location> loc2 = new LinkedList<Location>();
		LinkedList<Location> loc3 = new LinkedList<Location>();
		loc1.add(new Location(1, "Jánkmajtis", "", ""));
		loc1.add(new Location(5, "Zsarolyán", "", ""));
		loc2.add(new Location(5, "Zsarolyán", "", ""));
		loc2.add(new Location(6, "Kisszekeres", "", ""));
		loc3.add(new Location(6, "Kisszekeres", "", ""));
		loc3.add(new Location(7, "Nagyszekeres", "", ""));
		loc3.add(new Location(1, "Jánkmajtis", "", ""));
		
		
		LinkedList<Day> days = new LinkedList<Day>();
		days.add(new Day(13, 1, "", 2020));
		days.getLast().setLocations(loc1);
		days.add(new Day(14, 2, "", 3000));
		days.getLast().setLocations(loc2);
		days.add(new Day(15, 3, "", 4500));
		days.getLast().setLocations(loc3);
		
		testProf.getJourneys().add(new Journey(2, "Teszt2", new Date(0), new Date(0) , "H", new Date(0), days));
		
		
		LinkedList<String> result = SupporterMethods.CollectDataForProfile(testProf);
		String[] tmp = new String[5];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = result.get(i + 2);
			System.out.println(tmp[i]);
		}
		
		assertArrayEquals(new String[] {"2","10490","33","17","6"},tmp);
		
	}

	@Test
	public void testCollectDataForActJourney() {
		LinkedList<String> result = SupporterMethods.CollectDataForActJourney(testProf, 1);
		String[] tmp = new String[5];
		for (int i = 0; i < 5; i++) {
			tmp[i] = result.get(i + 4);
		}
		
		assertArrayEquals(new String[] {"3","970","12","4","B"},tmp);
	}
	
	@Test
	public void testCollectDataForActJourney2() {
		testProf.getJourneys().getFirst().getDays().add(new Day(13, 4, "", 510));
		testProf.getJourneys().getFirst().getDays().getLast().setLocations( new LinkedList<Location>());
		testProf.getJourneys().getFirst().getDays().getLast().getLocations().add(new Location(1, "Jánkmajtis", "", ""));
		testProf.getJourneys().getFirst().getDays().getLast().getLocations().add(new Location(2, "Darnó", "", ""));
		testProf.getJourneys().getFirst().getDays().getLast().getLocations().add(new Location(4, "Csaholc", "", ""));
		LinkedList<String> result = SupporterMethods.CollectDataForActJourney(testProf, 1);
		String[] tmp = new String[5];
		for (int i = 0; i < 5; i++) {
			tmp[i] = result.get(i + 4);
		}
		
		assertArrayEquals(new String[] {"4","1480","24","6","B"},tmp);
	}
	
	
	

	@Test
	public void testCollectDataForActDay() {
		LinkedList<String> result = SupporterMethods.CollectDataForActDay(testProf, 11);
		String[] tmp = new String[2];
		for (int i = 0; i < 2; i++) {
			tmp[i] = result.get(i + 1);
			
		}
		
		assertArrayEquals(new String[] {"3","320"},tmp);
	}
	
	@Test
	public void testCollectDataForActDay2() {
		testProf.getJourneys().getFirst().getDays().get(0).getLocations().add(new Location(4, "Csaholc", "", ""));
		LinkedList<String> result = SupporterMethods.CollectDataForActDay(testProf, 10);
		String[] tmp = new String[2];
		for (int i = 0; i < 2; i++) {
			tmp[i] = result.get(i + 1);
		}
		
		assertArrayEquals(new String[] {"10","400"},tmp);
	}

}
