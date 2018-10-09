package lab7;

import java.io.IOException;

//Patrick Nogaj
//CSC-162-01
//LAB 7D

public class FileArrayDemo {
	
	public static void main(String[] args) throws IOException {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] test = new int[numbers.length];
		FileArray.writeArray("test1.dat", numbers);
		FileArray.readArray("test1.dat", test);
		for(int index = 0; index < test.length; index++) {
			System.out.print(test[index] + " ");
		}
	}
}
