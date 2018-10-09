package lab4b;

//Patrick Nogaj
//CSC-162-01
//LAB #4-B

public class CoursesGradeDemo {

	public static void main(String[] args) {
		GradedActivity lab = new GradedActivity();
		PassFailExam exam = new PassFailExam(20, 3, 70);
		Essay essay = new Essay();
		FinalExam finalExam = new FinalExam(50, 10);
		CourseGrades courseGrades = new CourseGrades();
		
		lab.setScore(85);
		essay.setScore(25, 18, 17, 20);
		
		courseGrades.setEssay(essay);
		courseGrades.setFinalExam(finalExam);
		courseGrades.setLab(lab);
		courseGrades.setPassFailExam(exam);
		
		System.out.println(courseGrades);
	}

}
