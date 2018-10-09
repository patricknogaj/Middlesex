package lab3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Patrick Nogaj
 * CSC-236
 * Lab 3
 */

public class PrefixMain {
	
	
	/**
	 * This method starts off by creating a Scanner(File) object by prompting user the name.
	 * It then into a while() loop to take one line of the File, and validate it.
	 * If the line is valid: it will evaluate the expression.
	 * If the line is invalid: it will return a false expression and the token (line).
	 * 
	 * The PrintWriter object is defined to output the data to an external file which is defined
	 * as "prefix.out". At the end of the method, we close both data streams to the Scanner, and
	 * PrintWriter.
	 * @throws IOException - exception is included incase file is not found when prompted for file name.
	 */
	public static void main(String[] args) throws IOException {	
		PrintWriter output = new PrintWriter("prefix.out");
		Scanner input = new Scanner(input());
		
		while(input.hasNextLine()) {	
			String token = input.nextLine();
			Scanner validate = new Scanner(token);
			
			if(PrefixProcess.validate(validate, 1) == true) {
				Scanner evaluate = new Scanner(token);
				output.println(token + " = " +PrefixProcess.evaluate(evaluate));
			} else {
				output.println("False Expression: " + token);
			}
		}
		input.close();
		output.close();
	}
	
	/**
	 * This method prompts the user for an input.
	 * The input is assigned to a string and returned into a File(String) object.
	 */
	public static File input() {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter file name:");
		String name = input.next();
		return new File(name);
	}

}
