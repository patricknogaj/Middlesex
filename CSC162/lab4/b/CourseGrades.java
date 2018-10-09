package lab4b;

//Patrick Nogaj
//CSC-162-01
//LAB #4-B

public class CourseGrades {
	
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
	
	public String toString() {
		return "Lab: " + gradedActivity[0].getScore() + " " + gradedActivity[0].getGrade() + " \n" +
				"Pass/Fail Exam: " + gradedActivity[1].getScore() + " " + gradedActivity[1].getGrade() + " \n" +
				"Essay: " + gradedActivity[2].getScore() + " " + gradedActivity[2].getGrade() + " \n" +
				"Final Exam: " + gradedActivity[3].getScore() + " " + gradedActivity[3].getGrade() + " ";
	}
	
}
