package lab4a;

//Patrick Nogaj
//CSC-162-01
//LAB #4-A

public class Essay extends GradedActivity {
	
	private double grammar, spelling, length, content;
	
	public void setScore(double grammar, double spelling, double length, double content) {
		setGrammar(grammar);
		setSpelling(spelling);
		setCorrectLength(length);
		setContent(content);
		
		score = getGrammar() + getSpelling() + getCorrectLength() + getContent();
	}
	
	public double getGrammar() {
		return grammar;
	}
	
	public double getSpelling() {
		return spelling;
	}
	
	public double getCorrectLength() {
		return length;
	}
	
	public double getContent() {
		return content;
	}
	
	public double getScore() {
		return score;
	}

	private void setGrammar(double grammar) {
		if(grammar < 0 || grammar > 30)
			grammar = 0;
		else 
			this.grammar = grammar;
	}
	
	private void setSpelling(double spelling) {
		if(spelling < 0 || spelling > 20)
			spelling = 0;
		else
			this.spelling = spelling;
	}	
	
	private void setCorrectLength(double length) {
		if(length < 0 || length > 20)
			length = 0;
		else
			this.length = length;
	}
	
	private void setContent(double content) {
		if(content < 0 || content > 30)
			content = 0;
		else
			this.content = content;
	}
	
}
