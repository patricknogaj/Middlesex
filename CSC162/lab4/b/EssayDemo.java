package lab4b;

//Patrick Nogaj
//CSC-162-01
//LAB #4-B

public class EssayDemo {
	
	public static void main(String[] args) {
		Essay essay = new Essay();
		essay.setScore(25, 18, 20, 25);
		System.out.println(essay.getScore() + " " + essay.getGrade());
	}

}
