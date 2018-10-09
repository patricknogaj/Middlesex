package lab6;

public class NegativeUnitsException extends Exception {

	public NegativeUnitsException() {
		super("Error: Negative number given for units.");
	}
	
	public NegativeUnitsException(String msg) {
		super(msg);
	}
	
}
