package lab2;

/**
 * @author Patrick Nogaj
 * CSC-236
 * Lab 2
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Client {
	
	static Scanner input;
	
	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, StackOverflowException, StackUnderflowException {
		input = new Scanner(input());
		while(input.hasNext()) {
			String data = input.nextLine();
			Tags.split(data);
		}
	
		if(Validator.isFileValid() == true) {
			System.out.println("File is VALID.");
		} else {
			System.out.println("File is INVALID.");
		}
		
	}
	
	public static File input() throws IOException {
		System.out.println("Enter the file name you wish to import:");
		input = new Scanner(System.in);
		String response = input.nextLine();		
		return new File(response);
	}

}
