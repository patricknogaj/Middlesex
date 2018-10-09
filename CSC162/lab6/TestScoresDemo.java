package lab6;

//Patrick Nogaj
//CSC-162-01
//LAB 6B

public class TestScoresDemo {

	public static void main(String[] args) throws InvalidTestScore {	
		double[] goodScores = {97.5, 66.7, 88.0,  100.0, 99.0};
		double[] badScores = {97.5, 66.7, 88.0, 101.0, 99.0};
		try {			
			TestScores testBad = new TestScores(badScores);
			TestScores testGood = new TestScores(goodScores);	
		} catch (InvalidTestScore e) {
			System.out.println(e.getMessage());
		}
		System.out.println(new TestScores(goodScores).getAverage());
	}
	
}
