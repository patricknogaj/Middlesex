package lab5;

//Patrick Nogaj
//CSC-162-01
//LAB 5B

public class Fractal {

	public static void main(String[] args) {
		pattern(0, 8);
	}
	
	public static void pattern(int i, int n) { 
		if(n == 0) return;
		pattern(i, n / 2);
		for(int k = 0; k < i; k++) System.out.print(" ");
		for(int k = 0; k < n; k++) System.out.print("*");
		System.out.println();
		pattern (i + n / 2, n / 2);
	}
	
}
