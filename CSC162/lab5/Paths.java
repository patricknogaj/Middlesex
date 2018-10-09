package lab5;

public class Paths {

	public static void main(String[] args) {
		System.out.println(numberOfPaths(0, 1, 3, 2));
	}
	
	public static int numberOfPaths(int x1, int y1, int x2, int y2) {
		if(x1 > x2 || y1 > y2) return 0; //no path
		if(x1 == x2 && y1 == y2) return 0; //same path
		if(x1 == x2 - 1 && y1 == y2) { System.out.println("E"); return 1; } //step east
		if(x1 == x2 && y1 == y2 - 1) { System.out.println("N"); return 1; } //step up
		return numberOfPaths(x1 + 1, y1, x2, y2) + numberOfPaths(x1, y1 + 1, x2, y2);
	}
}
