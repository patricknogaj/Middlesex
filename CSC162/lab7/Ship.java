package lab7;

//Patrick Nogaj
//CSC-162-01
//LAB 7B

public class Ship {

	private String shipName;
	private int yearBuilt;
	
	public Ship() {
		shipName = "";
		yearBuilt = 0;
	}
	
	public Ship(String shipName, int yearBuilt) {
		this.shipName = shipName;
		this.yearBuilt = yearBuilt;
	}
	
	public String getShipName() {
		return shipName;
	}
	
	public int getYearBuilt() {
		return yearBuilt;
	}
	
	public void setShipName(String shipName) {
		this.shipName = shipName;
	}
	
	public void setYearBuilt(int yearBuilt) {
		this.yearBuilt = yearBuilt;
	}
	
	public String toString() {
		return "Ship name: " + getShipName() + "\nYear built: " + getYearBuilt();
	}
	
}
