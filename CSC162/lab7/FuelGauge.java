package lab7;

//Patrick Nogaj
//CSC-162-01
//LAB 7A

public class FuelGauge {

	private int fuelAmount;
	final int MAX_GALLONS = 15;
	
	public FuelGauge() {
		fuelAmount = 0;
	}
	
	public FuelGauge(int fuelAmount) {
		setFuelAmount(fuelAmount);
	}
	
	public int getFuelAmount() {
		return fuelAmount;
	}
	
	public void setFuelAmount(int fuelAmount) {
		if(fuelAmount <= MAX_GALLONS) this.fuelAmount = fuelAmount;
		else
			System.out.println("ERR: Invalid fuel amount");
	}
	
	public void fillUp() {
		if(fuelAmount < MAX_GALLONS)
			fuelAmount++;
		else
			System.out.println("Fuel tank full");
	}
	
	public void burnFuel() {
		if(fuelAmount > 0)
			fuelAmount--;
		else
			System.out.println("Out of fuel");
	}
	
	public String toString() {
		return "Fuel level: " + getFuelAmount() + " of gallons";
	}
	
}
