package lab6;

//Patrick Nogaj
//CSC-162-01
//LAB 6C

public class NegativePriceException extends Exception {

	public NegativePriceException() {
		super("Error: Negative number given for the price.");
	}
	
	public NegativePriceException(String msg) {
		super(msg);
	}
	
}
