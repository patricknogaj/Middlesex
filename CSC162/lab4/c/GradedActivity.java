package lab4c;

//Patrick Nogaj
//CSC-162-01
//LAB #4-C

public class GradedActivity {

	protected double score;
	protected char grade;
	
	public void setScore(double score) {
		this.score = score;
	}
	
	public double getScore() {
		return score;
	}
	
	public char getGrade() {
		if(score >= 90)
			grade = 'A';
		else if (score >= 80)
			grade = 'B';
		else if (score >= 70)
			grade = 'C';
		else if (score >= 60)
			grade = 'D';
		else
			grade = 'F';
		
		return grade;
	}
	
}
