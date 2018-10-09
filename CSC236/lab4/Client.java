package lab4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Patrick Nogaj
 * Lab 4 | CSC-236
 */

public class Client {
	
	public static void main(String[] args) throws IOException {
		OlympicAthletes athletes = new OlympicAthletes();
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter file input:");
		String response = input.next();
		
		Scanner file = new Scanner(new File(response));
		build(athletes, file);

		System.out.println("Select an option from the following menu:");
		System.out.println("1 - Add an athlete.");
		System.out.println("2 - Delete an athlete.");
		System.out.println("3 - Print all athletes.");
		System.out.println("4 - Print a particular athlete: given the name and country of the athlete, print all the entries for that athlete.");
		System.out.println("5 - Print an event: given the name of the event, print all athletes that competed in that event.");
		System.out.println("6 - Print medal winners by country: given the name of the country, print all the athletes from that country that won medals.");
		System.out.println("7 - Print medal winners by event: given the name of the event, print the medal winners for that event.");
		System.out.println("8 - Print medal winners by medal: given the name of the medal, print all athletes that won that medal.");
		System.out.println("9 - Print all Athletes in the List in alphabetical order by Athlete name (last name, first name).");
		System.out.println("10 - Print all Athletes in the List in alphabetical order by event.");
		System.out.println("11 - Exit.");
		boolean done = false;
		while(done != true) {
			String optionSelect = input.nextLine();
			
			switch(optionSelect) {
			case "1":
				System.out.println("Enter first name:");
				String addFirst = input.nextLine();
				System.out.println("Enter last name:");
				String addLast = input.nextLine();
				System.out.println("Enter country:");
				String addCountry = input.nextLine();
				System.out.println("Enter sport:");
				String addSport = input.nextLine();
				System.out.println("Enter event:");
				String addEvent = input.nextLine();
				System.out.println("Enter result:");
				String addResult = input.nextLine();
				Athlete add = new Athlete(addFirst, addLast, addCountry, addSport, addEvent, addResult);
				athletes.add(add);
				break;
			case "2":
				System.out.println("Enter first name:");
				String delFirst = input.nextLine();
				System.out.println("Enter last name:");
				String delLast = input.nextLine();
				System.out.println("Enter country:");
				String delCountry = input.nextLine();
				System.out.println("Enter sport:");
				String delSport = input.nextLine();
				System.out.println("Enter event:");
				String delEvent = input.nextLine();
				System.out.println("Enter result:");
				String delResult = input.nextLine();
				Athlete delete = new Athlete(delFirst, delLast, delCountry, delSport, delEvent, delResult);
				athletes.add(delete);
				break;
			case "3":
				athletes.printAll();
				break;
			case "4":
				System.out.println("Enter first name");
				String first = input.nextLine();
				System.out.println("Enter last name:");
				String last = input.nextLine();
				System.out.println("Enter country:");
				String area = input.nextLine();
				athletes.printNameCountry(first, last, area);
				break;
			case "5":
				System.out.println("Enter a event:");
				String event = input.next();
				athletes.printEvent(event);
				break;
			case "6":
				System.out.println("Enter a country:");
				String countryType = input.next();
				athletes.printMedalsCountry(countryType);
				break;
			case "7":
				System.out.println("Enter a event:");
				String eventType = input.next();
				athletes.printMedalsEvent(eventType);
				break;
			case "8":
				System.out.println("Enter a medal: (Gold, Silver, Bronze)");
				String medalType = input.next();
				athletes.printMedals(medalType);
				break;
			case "9":
				athletes.printAlphabetical();
				break;
			case "10":
				athletes.printEventAlphabetical();
				break;
			case "11":
				done = true;
				break;
			}
		}
		
	}
		
	public static void build(OlympicAthletes athletes, Scanner input) {
		String firstName, lastName, country, sport, event, result;
		
		while(input.hasNext()) {
			firstName = input.nextLine();
			lastName = input.nextLine();
			country = input.nextLine();
			sport = input.nextLine();
			event = input.nextLine();
			result = input.nextLine();
			Athlete athlete = new Athlete(firstName, lastName, country, sport, event, result);
			athletes.add(athlete);
		}
	}

}
