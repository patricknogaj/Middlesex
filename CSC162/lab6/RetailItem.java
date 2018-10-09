package lab6;

import java.text.DecimalFormat;

//Patrick Nogaj
//CSC-162-01
//LAB 6C

public class RetailItem {
	
	DecimalFormat df = new DecimalFormat("##,###.00");

	private String description;
	private int unitsOnHand;
	private double price;
	
	public RetailItem() {
		description = "";
		unitsOnHand = 0;
		price = 0.0;
	}
	
	public RetailItem(String description, int unitsOnHand, double price) {
		this.description = description;
		this.unitsOnHand = unitsOnHand;
		this.price = price;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setUnitsOnHand(int unitsOnHand) throws NegativeUnitsException {
		this.unitsOnHand = unitsOnHand;
		
		if(unitsOnHand < 0) throw new NegativeUnitsException("Error: Negative number given for units: " + unitsOnHand);
	}
	
	public void setPrice(double price) throws NegativePriceException {
		this.price = price;
		
		if(price < 0.00) throw new NegativePriceException("Error: Negative number given for price: " + price);
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getUnitsOnHand() {
		return unitsOnHand;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return "The item is: " + getDescription() + " \n"
				+ "We have " + getUnitsOnHand() + " in stock.\n"
				+ "They sell for $" + df.format(getPrice()) + " per unit.\n";
	}
	
}
