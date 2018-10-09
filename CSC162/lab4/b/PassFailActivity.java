package lab4b;

//Patrick Nogaj
//CSC-162-01
//LAB #4-B

public class PassFailActivity extends GradedActivity  {

	private double minScore;
	
	public PassFailActivity(double minScore) {
		this.minScore = minScore;
	}
	
	public char getGrade() {
		if(score < minScore)
			grade = 'F';
		else
			grade = 'P';
		
		return grade;
	}
	
}
