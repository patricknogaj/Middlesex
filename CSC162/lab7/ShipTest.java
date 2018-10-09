package lab7;

//Patrick Nogaj
//CSC-162-01
//LAB 7B

public class ShipTest {

	public static void main(String[] args) {
		Ship[] ship = new Ship[3];
		ship[0] = new Ship("Lolipop", 1960);
		ship[1] = new CruiseShip("DisneyMagic", 1988, 2400);
		ship[2] = new CargoShip("Black Pearl", 1800, 50000);
		
		for(int index = 0; index < ship.length; index++) {
			System.out.println(ship[index]);
			System.out.println();
		}
	}
	
}
