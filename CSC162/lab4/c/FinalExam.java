package lab4c;

//Patrick Nogaj
//CSC-162-01
//LAB #4-C

public class FinalExam extends GradedActivity {

	private double questionAmount, numMissed;
	
	public FinalExam(double questionAmount, double numMissed) {
		this.questionAmount = questionAmount;
		this.numMissed = numMissed;
		setScore((questionAmount * getPointsEach()) - (numMissed * getPointsEach()));
	}
	
	public double getPointsEach() {
		return 2;
	}
	
	public double getQuestionAmount() {
		return questionAmount;
	}
	
	public double getNumMissed() {
		return numMissed;
	}

}