package lab6;

//Patrick Nogaj
//CSC-162-01
//LAB 6D

public class InvalidShift extends Exception {
	
	public InvalidShift() {
		super("Invalid shift type.");
	}
	
	public InvalidShift(String msg) {
		super(msg);
	}

}
