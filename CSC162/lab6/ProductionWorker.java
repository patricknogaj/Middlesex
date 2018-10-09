package lab6;

//Patrick Nogaj
//CSC-162-01
//LAB 6D

import java.text.DecimalFormat;

public class ProductionWorker extends Employee {
	
	DecimalFormat df = new DecimalFormat("####.00");

	private double payRate;
	private String shift;
	
	public ProductionWorker() {
		super();
		shift = "";
		payRate = 0;
	}
	
	public ProductionWorker(String name, String employeeNumber, String hireDate, String shift, double payRate) {
		super(name, employeeNumber, hireDate);
		this.shift = shift;
		this.payRate = payRate;
	}
	
	public double getPayRate() {
		return payRate;
	}
	
	public String getShift() {
		return shift;
	}
	
	public void setPayRate(double payRate) throws InvalidPayRate {
		this.payRate = payRate;
		if(this.getPayRate() < 0.00) throw new InvalidPayRate("Invalid pay rate.");
	}
	
	public void setShift(String shift) throws InvalidShift {
		this.shift = shift;
		if(!(this.getShift().equalsIgnoreCase("day shift") || this.getShift().equalsIgnoreCase("night shift")))
			throw new InvalidShift("Invalid shift.");
	}
	
	public String toString() {
		return "Name: " + getName()
		+ " \nEmployee ID: " + getEmployeeNumber()
		+ " \nHire date: " + getHireDate() 
		+ "\nShift: " + getShift()
		+ "\nPay rate: $" + df.format(getPayRate()) + "/hr";
	}
	
}

