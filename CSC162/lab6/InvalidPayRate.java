package lab6;

//Patrick Nogaj
//CSC-162-01
//LAB 6D

public class InvalidPayRate extends Exception {
	
	public InvalidPayRate() {
		super("Invalid pay rate.");
	}
	
	public InvalidPayRate(String msg) {
		super(msg);
	}

}
