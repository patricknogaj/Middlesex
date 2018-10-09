package lab4b;

//Patrick Nogaj
//CSC-162-01
//LAB #4-B

public class PassFailExam extends PassFailActivity {

	double numQuestions, numMissed;
	
	public PassFailExam(double numQuestions, double numMissed, double minScore) {
		super(minScore);
		this.numQuestions = numQuestions;
		this.numMissed = numMissed;
		score = (numQuestions * getPointsEach()) - (numMissed * getPointsEach());
		super.setScore(score);
	}
	
	public double getPointsEach() {
		return 5;
	}
	
	public double getNumMissed() {
		return numMissed;
	}

}

