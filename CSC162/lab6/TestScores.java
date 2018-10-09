package lab6;

//Patrick Nogaj
//CSC-162-01
//LAB 6B

public class TestScores {
	
	private double[] scores;
	
	public TestScores(double[] scores) throws InvalidTestScore {
		this.scores = scores;
		
		for(int index = 0; index < scores.length; index++) {
			if(scores[index] < 0 || scores[index] > 100.0) {
				throw new InvalidTestScore("Invalid test score. \nElement: " + index + " [" + scores[index] + "]");
			}
		}
	}
	
	public double getAverage() {
		double average = 0;
		for(int index = 0; index < scores.length; index++) {
			average += scores[index];
		}
		return (average / scores.length);
	}

}
