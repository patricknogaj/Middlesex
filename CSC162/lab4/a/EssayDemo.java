package lab4a;

//Patrick Nogaj
//CSC-162-01
//LAB #4-A

public class EssayDemo {
	
	public static void main(String[] args) {
		Essay essay = new Essay();
		essay.setScore(25, 18, 20, 25);
		System.out.println(essay.getScore() + " " + essay.getGrade());
	}

}
