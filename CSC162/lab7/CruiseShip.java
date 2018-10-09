package lab7;

//Patrick Nogaj
//CSC-162-01
//LAB 7B

public class CruiseShip extends Ship {
	
	private int maximumPassengers;
	
	public CruiseShip() {
		super();
		maximumPassengers = 0;
	}
	
	public CruiseShip(String shipName, int yearBuilt, int maximumPassengers) {
		super(shipName, yearBuilt);
		this.maximumPassengers = maximumPassengers;
	}
	
	public int getMaximumPassengers() {
		return maximumPassengers;
	}
	
	public void setMaximumPassengers(int maximumPassengers) {
		this.maximumPassengers = maximumPassengers;
	}
	
	public String toString() {
		return "Ship name: " + getShipName() + "\nMaximum passengers: " + getMaximumPassengers();
	}

}
