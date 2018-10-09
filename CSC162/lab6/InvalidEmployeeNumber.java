package lab6;

//Patrick Nogaj
//CSC-162-01
//LAB 6D

public class InvalidEmployeeNumber extends Exception {
	
	public InvalidEmployeeNumber() {
		super("Invalid employee number.");
	}
	
	public InvalidEmployeeNumber(String msg) {
		super(msg);
	}

}
