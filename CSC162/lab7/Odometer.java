package lab7;

//Patrick Nogaj
//CSC-162-01
//LAB 7A

public class Odometer {

	private int mileage;
	
	public Odometer() {
		mileage = 0;
	}
	
	public Odometer(int mileage) {
		this.mileage = mileage;
	}

	public int getMileage() {
		return mileage;
	}
	
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	
	public void isDriving(FuelGauge fuel) {
		if(mileage <= 999999)
			mileage++;
		else
			setMileage(0);
		
		if(mileage % 24 == 0) {
			fuel.burnFuel();
		}
	}
	
	public String toString() {
		return "Mileage: " + getMileage();
	}
	
}

