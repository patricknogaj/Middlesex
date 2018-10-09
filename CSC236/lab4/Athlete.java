package lab4;

import java.util.Comparator;

/**
 * @author Patrick Nogaj
 * Lab 4 | CSC-236
 */

public class Athlete implements Comparable<Object> {
	
	private String firstName, lastName, country, sport, event, result; //fields for an Athlete object
	
	/**
	 * Default constructor which initializes all fields to empty Strings.
	 */
	public Athlete() {
		firstName = " ";
		lastName = " ";
		country = " ";
		sport = " ";
		event = " ";
		result = " ";
	}

	/**
	 * Overloaded constructor which initializes fields to user input in main();
	 * @param firstName - String provided by user input
	 * @param lastName - String provided by user input
	 * @param country - String provided by user input
	 * @param sport - String provided by user input
	 * @param event - String provided by user input
	 * @param result - String provided by user input
	 */
	public Athlete(String firstName, String lastName, String country, String sport, String event, String result) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.sport = sport;
		this.event = event;
		if(result.equals("1")) {
			this.result = "Gold";
		} else if (result.equals("2")) {
			this.result = "Silver";
		} else if(result.equals("3")) {
			 this.result = "Bronze";
		} else {
			 this.result = result;
		}
	}
	
	/**
	 * Checks to see if the current object and @param are equal
	 * @param firstName - String provided by user input
	 * @return true if Strings are equal ignoring case.
	 */
	public boolean queryFirstName(String firstName) {
		return (this.firstName.equalsIgnoreCase(firstName));
	}
	
	/**
	 * Checks to see if the current object and @param are equal
	 * @param lastName - String provided by user input
	 * @return true if Strings are equal ignoring case.
	 */
	public boolean queryLastName(String lastName) {
		return (this.lastName.equalsIgnoreCase(lastName));
	}
	
	/**
	 * Checks to see if the current object and @param are equal
	 * @param country - String provided by user input
	 * @return true if Strings are equal ignoring case.
	 */
	public boolean queryCountry(String country) {
		return (this.country.equalsIgnoreCase(country));
	}
	
	/**
	 * Checks to see if the current object and @param are equal
	 * @param sport - String provided by user input
	 * @return true if Strings are equal ignoring case.
	 */
	public boolean querySport(String sport) {
		return (this.sport.equalsIgnoreCase(sport));
	}
	
	/**
	 * Checks to see if the current object and @param are equal
	 * @param event - String provided by user input
	 * @return true if Strings are equal ignoring case.
	 */
	public boolean queryEvent(String event) {
		return (this.event.equalsIgnoreCase(event));
	}
	
	/**
	 * Checks to see if the current object and @param are equal
	 * @param result - String provided by user input
	 * @return true if Strings are equal ignoring case.
	 */
	public boolean queryResult(String result) {
		return (this.result.equalsIgnoreCase(result));
	}
	
	/**
	 * equals method() - checks to see if the current Athlete object is an Object.
	 * if true: it will create an temporary Athlete object and cast Athlete to @param o. Then it will provide true or false
	 * based if firstName, lastName, and country are equals ignoring case sensitivity.
	 * if false: will return false, and exit the boolean.
	 */
	public boolean equals(Object o) {
		if(o == this) 
			return true;
		if(!(o instanceof Athlete))
			return false;
		Athlete athlete = (Athlete) o;
		return (this.firstName.equalsIgnoreCase(athlete.firstName) && this.lastName.equalsIgnoreCase(athlete.lastName) &&
				this.country.equalsIgnoreCase(athlete.country));
	}
	
	/**
	 * Checks to see if o is an instance of Athlete. If it is, it will create a temporary Athlete object and cast Athlete to 
	 * @param o. It will then compare countries by utilizing compareTo. If compareTo == 0, it will compare lastName. If compareTo != 0,
	 * it will assign the current object, and the called object in order depending if compareTo returns -1 or 1. When lastName compareTo is 
	 * returned a 0, it will compare firstName. This is the last final comparison compareTo will check for.
	 */
	public int compareTo(Object o) {
		if(o instanceof Athlete) {
			Athlete athlete = (Athlete) o;
			int compareCountry = this.country.compareTo(athlete.country);
			
			if(compareCountry == 0) {
				int compareLastName = this.lastName.compareTo(athlete.lastName);
				
				if(compareLastName == 0) {
					int compareFirstName = this.firstName.compareTo(athlete.firstName);
					return compareFirstName;
				}
				return compareLastName;
			} else {
				return compareCountry;
			}
		}
		return 0;
	}
	
	/**
	 * Comparator that sorts the Athlete objects by alphabetical order by comparing lastName, then firstName. If the comparison is 0,
	 * it will check for firstName comparison.
	 */
	public static Comparator<Athlete> sortAlphabetical() {
		return new Comparator<Athlete>() {
			public int compare(Athlete athlete, Athlete athlete2) {
				int lastName = athlete.lastName.compareTo(athlete2.lastName);
				if(lastName == 0) {
					int firstName = athlete.firstName.compareTo(athlete2.firstName);
					return firstName;
				}
				return lastName;
			}
		};
	}
	
	/**
	 * Comparator that sorts the Athlete objects by alphabetical order by comparing event.
	 */
	public static Comparator<Athlete> sortAlphabeticalEvent() {
		return new Comparator<Athlete>() {
			public int compare(Athlete athlete, Athlete athlete2) {
				int eventAlphabetical = athlete.event.compareToIgnoreCase(athlete2.event);
				return eventAlphabetical;
			}
		};
	}
	
	/**
	 * toString - overridden to display fields of data of an Athlete object.
	 */
	public String toString() {
		return "Name: " + firstName + " " + lastName + "\nCountry: " + country + "\nSport: " + sport + " at " 
				+ event + "\nResult: " + result;
	}

}
