package lab6;

//Patrick Nogaj
//CSC-162-01
//LAB 6B

public class InvalidTestScore extends Exception {
	
	public InvalidTestScore() {
		super("Invalid test score.");
	}
	
	public InvalidTestScore(String msg) {
		super(msg);
	}

}
