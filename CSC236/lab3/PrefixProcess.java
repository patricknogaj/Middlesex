package lab3;

import java.util.Scanner;

/**
 * @author Patrick Nogaj
 * CSC-236
 * Lab 3
 */

public class PrefixProcess {
	
	/**
	 * This method validates by taking input of scanner and checking to see if counter == 0 to return
	 * true. If counter != 0, and the line is complete, it will return false. If the line hits 0 or -1
	 * prior to completion of the line, it will return false.
	 * 
	 * @param input - Scanner object to grab the line and validate if it is a valid or invalid expression
	 * @param counter - counter initialized to 1 in main() and increments if it is an operator
	 * 				and decrements if it is an operand.
	 **/
	public static boolean validate(Scanner input, int counter) {
		if(!input.hasNext() && counter == 0) {
			return true;
		} else if(!input.hasNext() && counter != 0) {
			return false;
		} else if(input.hasNext() && counter <= 0) {
			return false;
		} else {
			if(input.next().matches("[\\*/+-]")) {
				counter++;
			} else {
				counter--;
			} return validate(input, counter);
		} 
	}
	
	/**
	 * This method will take input from a Scanner object, and assign 
	 * operands/operators and pass it to evaluation.
	 * @param input - Scanner object to check if the next input would be a double
	 * 				if it is: it will store it into operand 1/2 respectively,
	 * 				if it is not: it will take the next input as an operand.
	 */
	public static double evaluate(Scanner input) {
		if(input.hasNextDouble()) 
			return input.nextDouble();
		else {
			String operator = input.next();
			double operand1 = evaluate(input);
			double operand2 = evaluate(input);
			return evaluate(operator, operand1, operand2);
		}
	}

	/**
	 * This method will evaluate a 1-operator and 2 operand problem and return
	 * it back to the caller evaluate(Scanner)
	 * @param operator - will decide which operator to perform
	 * @param operand1 - double operator
	 * @param operand2 - double operator
	 * @RunTimeException - will throw exception if operator is unknown.
	 */
	public static double evaluate(String operator, double operand1, double operand2) {
		if(operator.equals("+"))
			return operand1 + operand2;
		else if(operator.equals("-"))
			return operand1 - operand2;
		else if(operator.equals("*")) 
			return operand1 * operand2;
		else if(operator.equals("/"))
			return operand1 / operand2;
		else
			throw new RuntimeException("Illegal operator found: " + operator);
	}
	
}
