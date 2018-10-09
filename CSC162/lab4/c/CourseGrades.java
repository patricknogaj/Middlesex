package lab4c;

//Patrick Nogaj
//CSC-162-01
//LAB #4-C

public class CourseGrades implements Analyzable {
	
	private final int NUM_OF_GRADES = 4;
	GradedActivity[] gradedActivity;

	public CourseGrades() {
		gradedActivity = new GradedActivity[NUM_OF_GRADES];
	}
	
	public void setLab(GradedActivity gA) {
		gradedActivity[0] = gA;
	}
	
	public void setPassFailExam(PassFailExam passFailExam) {
		gradedActivity[1] = passFailExam;
	}
	
	public void setEssay(Essay essay) {
		gradedActivity[2] = essay;
	}
	
	public void setFinalExam(FinalExam finalExam) {
		gradedActivity[3] = finalExam;
	}

	public double getAverage() {
		double average = 0.0;
		
		for(int i = 0; i < gradedActivity.length; i++) {
			average += gradedActivity[i].getScore();
		}
		return average / NUM_OF_GRADES;
	}

	public GradedActivity getHighest() {
		double maxValue = 0.0;
		int index = 0;
		
		for(int i = 0; i < gradedActivity.length; i++) {
			if(gradedActivity[i].getScore() > maxValue) {
				maxValue = gradedActivity[i].getScore();
				index = i;
			}
		} return gradedActivity[index];
	}

	public GradedActivity getLowest() {
		double minValue = 100;
		int index = 0;
		
		for(int i = 0; i < gradedActivity.length; i++) {
			if(gradedActivity[i].getScore() < minValue) {
				minValue = gradedActivity[i].getScore();
				index = i;
			}
		} return gradedActivity[index];
	}
	
	public String toString() {
		String highest = "";
		String lowest = "";
		
		if(getHighest().equals(gradedActivity[0]))
			highest = "Lab";
		else if(getHighest().equals(gradedActivity[1]))
			highest = "Pass/Fail Exam";
		else if(getHighest().equals(gradedActivity[2]))
			highest = "Essay";
		else if(getHighest().equals(gradedActivity[3]))
			highest = "Final Exam";
		
		if(getLowest().equals(gradedActivity[0]))
			lowest = "Lab";
		else if(getLowest().equals(gradedActivity[1]))
			lowest = "Pass/Fail Exam";
		else if(getLowest().equals(gradedActivity[2]))
			lowest = "Essay";
		else if(getLowest().equals(gradedActivity[3]))
			lowest = "Final Exam";
		
		return "Lab: " + gradedActivity[0].getScore() + " " + gradedActivity[0].getGrade() + " \n" +
				"Pass/Fail Exam: " + gradedActivity[1].getScore() + " " + gradedActivity[1].getGrade() + " \n" +
				"Essay: " + gradedActivity[2].getScore() + " " + gradedActivity[2].getGrade() + " \n" +
				"Final Exam: " + gradedActivity[3].getScore() + " " + gradedActivity[3].getGrade() + " \n" +
				"Average Grade: " + getAverage() + " \n" +
				"Highest Grade: " + highest + " \n" +
				"Lowest Grade: " + lowest;
	}
	
}