package lab6;

import java.util.Scanner;

public class RetailItemDemo {

	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		RetailItem obj1 = new RetailItem();
		boolean prompt = false, units = false, price = false;
		
		System.out.println("Enter item description: ");
		obj1.setDescription(keyboard.next());
		
		while(!prompt) {
			try {
				while(!units) {
					System.out.println("Units on hand: ");
					obj1.setUnitsOnHand(keyboard.nextInt());
					units = true;
				}
				while(!price) {
					System.out.println("Item price: ");
					obj1.setPrice(keyboard.nextDouble());
					price = true;
				} prompt = true;
			} catch (NegativeUnitsException nue) {
				System.out.println(nue.getMessage());
			} catch (NegativePriceException npe) {
				System.out.println(npe.getMessage());
			} 
		} System.out.println(obj1);
	}
	
}
