package lab4;

import java.util.Iterator;
import java.util.Scanner;

/**
 * @author Patrick Nogaj
 * Lab 4 | CSC-236
 */

public class OlympicAthletes {
	
	Scanner input = new Scanner(System.in); //Scanner for input
	
	/**
	 * Three SortedABLists
	 * - Standard list
	 * - Alphabetical List <uses Comparator found in Athlete object to compare each Athlete object in list>
	 * - Alphabetical Event List <uses Comparator found in Athlete object to compare each Athlete object in list>
	 */
	SortedABList<Athlete> athleteList = new SortedABList<Athlete>();
	SortedABList<Athlete> alphabeticalAthleteList = new SortedABList<>(Athlete.sortAlphabetical());
	SortedABList<Athlete> alphabeticalEventList = new SortedABList<>(Athlete.sortAlphabeticalEvent());
	
	Iterator<Athlete> listIter; //Iterator for multiple data cycling.
	
	/**
	 * Adds an athlete object into the SortedABList
	 * @param athlete - defined by Athlete default or overloaded constructor
	 */
	public void add(Athlete athlete) {
		athleteList.add(athlete);
		alphabeticalAthleteList.add(athlete);
		alphabeticalEventList.add(athlete);
	}
	
	/**
	 * Removes an athlete object into the SortedABList
	 * @param athlete - defined by Athlete default or overloaded constructor
	 */
	public void delete(Athlete athlete) {
		athleteList.remove(athlete);
		alphabeticalAthleteList.remove(athlete);
		alphabeticalEventList.add(athlete);
	}
	
	/**
	 * Assigns listIter the standard list, and calls print()
	 * print() - cycles through iterator, and prints out objects.
	 */
	public void printAll() {
		listIter = athleteList.iterator();
		print();
	}
	
	/**
	 * Prints an Athlete if first name, last name, and country are valid by utilizing equals() method in Athlete
	 * @param firstName - String provided by user input
	 * @param lastName - String provided by user input
	 * @param country - String provided by user input
	 */
	public void printNameCountry(String firstName, String lastName, String country) {
		Athlete temp = new Athlete(firstName, lastName, country, " ", " ", " ");
		listIter = athleteList.iterator();
		while(listIter.hasNext()) {
			Athlete t = listIter.next();
			if(t.equals(temp)) {
				System.out.println(t + "\n");
			}
		}
	}
	
	/**
	 * Prints an Athlete when it returns true that the param equals the Athletes field 'event'. Utilizes queryEvent() which returns
	 * true if both event strings are equal.
	 * @param event - String provided by user input	
	 */
	public void printEvent(String event) {
		listIter = athleteList.iterator();
		while(listIter.hasNext()) {
			Athlete temp = listIter.next();
			if(temp.queryEvent(event)) {
				System.out.println(temp + "\n");
			}
		}
	}
	
	/**
	 * Prints an Athlete when it returns true that the param equals the Athletes field 'country'. Utilizes queryCountry() which returns
	 * true if both event strings are equal. If true, it will check to see if it contains results 1-3 respectively.
	 * @param country - String provided by user input	
	 */
	public void printMedalsCountry(String country) {
		listIter = athleteList.iterator();
		while(listIter.hasNext()) {
			Athlete temp = listIter.next();
			if(temp.queryCountry(country)) {
				if(temp.queryResult("gold") || temp.queryResult("silver") || temp.queryResult("bronze")) {
					System.out.println(temp + "\n");
				}
			}
		}
	}
	
	/**
	 * Prints an Athlete when it returns true that the param equals the Athletes field 'event'. Utilizes queryEvent() which returns
	 * true if both event strings are equal. Once true, it will query the object to see if the result equals bronze/silver/gold.
	 * @param event - String provided by user input	
	 */
	public void printMedalsEvent(String event) {
		listIter = athleteList.iterator();
		while(listIter.hasNext()) {
			Athlete temp = listIter.next();
			if(temp.queryEvent(event)) {
				if(temp.queryResult("gold") || temp.queryResult("silver") || temp.queryResult("bronze")) {
					System.out.println(temp + "\n");
				}
			}
		}
	}
	
	/**
	 * Prints an Athlete when it returns true that the param equals the Athletes field 'medal'. Utilizes queryEvent() which returns
	 * true if both event strings are equal.
	 * @param medal - String provided by user input	
	 */
	public void printMedals(String medal) {
		listIter = athleteList.iterator();
		while(listIter.hasNext()) {
			Athlete temp = listIter.next();
			if(temp.queryResult(medal)) {
				System.out.println(temp + "\n");
			}
		}
	}
	
	/**
	 * Sets listIter to the Iterator of the alphabetical list.
	 * print() - goes through iterator and prints out each object.
	 */
	public void printAlphabetical() {
		listIter = alphabeticalAthleteList.iterator();
		print();
	}
	
	/**
	 * Sets listIter to the Iterator of the event alphabetical list.
	 * print() - goes through iterator and prints out each object.
	 */
	public void printEventAlphabetical() {
		listIter = alphabeticalEventList.iterator();
		print();
	}
	
	/**
	 * Prints out objects once listIter has been initialized.
	 */
	public void print() {
		while(listIter.hasNext()) {
			System.out.println(listIter.next() + "\n");
		}	
	}

}
