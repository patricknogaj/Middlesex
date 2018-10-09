package lab7;

//Patrick Nogaj
//CSC-162-01
//LAB 7B

public class CargoShip extends Ship {
	
	private int capacity;
	
	public CargoShip() {
		super();
		capacity = 0;
	}
	
	public CargoShip(String shipName, int yearBuilt, int capacity) {
		super(shipName, yearBuilt);
		this.capacity = capacity;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public String toString() {
		return "Ship name: " + getShipName() + "\nCapacity: " + getCapacity();
	}

}
