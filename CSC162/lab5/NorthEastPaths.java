package lab5;

import java.util.*;

class NorthEastPaths{
	
	  public static void northEastPaths(int x, int y){  //static method to find all possible paths
	    char [] path = new char[x+y]; //create char array to store individual path
	    int n = x + y; //maximum length of each path
	    findPath(path,0,x,y); //subroutine to help me find the number of paths
	    double paths = paths(n,x,y); //subroutine to help me calculate number of paths
	    System.out.println((int)paths); //print out number of paths,typecast
	  }//end method
	 
	  //method to print all possible paths with north precedence
	  private static void findPath(char[] path, int i, int n, int e){
	    System.out.println("i = " + i);
	             System.out.println("n = " + n);
	         System.out.println("e = " + e);
	    if (i == path.length){ //terminating condition to print 1 path
	      for ( int j = 0 ; j < path.length; j++){
	      System.out.print(path[j] + " ");
	      } //print path
	      //paths++;
	      System.out.print("\n");
	    } //end if
	   else {
	         System.out.println("i = " + i);
	             System.out.println("n = " + n);
	         System.out.println("e = " + e);
	      if (n > 0) { // do a North step if possible
	         path[0]= 'N';
	System.out.println("n = " + n);
	System.out.println("e = " + e);
	findPath(path, i+1, n-1, e); //recursive call
	}//end if
	if (e > 0) { // do an East step if possible
	path[i]= 'E';
	System.out.println("n = " + n);
	System.out.println("e = " + e);
	findPath(path, i+1, n, e-1); //recursive call
	}//end if
	}//end else
	}//end method
	//method to calculate the total number of paths by formula
	private static double paths(int n, int x, int y){
	double paths = factorial(n)/(factorial(x) * factorial(y)); //subroute to help me find factorial of input
	return paths;
	}//end of method
	// find n factorial
	private static double factorial(int n){
	if (n == 0){
	return 1;
	}//end if
	return n * factorial(n-1); //recusive call
	}//end method
	public static void main (String[] args){ //start main
	Scanner scanner = new Scanner(System.in);//import scanner to scan input
	int x, y; //data members for north and east
	System.out.println("Enter x: "); //ask for input
	x = scanner.nextInt(); //scan for input North
	System.out.println("Enter y: "); //ask for input
	y = scanner.nextInt(); //scan for input East
	//paths = 0;
	northEastPaths(x,y); //method to print all paths
	//System.out.println((int)paths);
	}//end main
	}//end class NorthEastPaths 