package lab7;

//Patrick Nogaj
//CSC-162-01
//LAB 7A

public class Car {

	public static void main(String[] args) {
		Odometer odo = new Odometer(0);
		FuelGauge fuel = new FuelGauge(0);
		
		for(int x = fuel.getFuelAmount(); x < fuel.MAX_GALLONS; x++) {
			fuel.fillUp();
		}
		
		while(fuel.getFuelAmount() > 0) {
			odo.isDriving(fuel);
			if(odo.getMileage() % 24 == 0) {
				System.out.println(odo);
				System.out.println(fuel);
			}
			
		}
	}
	
}
