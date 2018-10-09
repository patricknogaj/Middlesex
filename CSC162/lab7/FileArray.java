package lab7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//Patrick Nogaj
//CSC-162-01
//LAB 7D

public class FileArray {
	
	public static void writeArray(String fileName, int[] array) throws IOException {
		FileOutputStream fileStream = new FileOutputStream(fileName);
		DataOutputStream outStream = new DataOutputStream(fileStream);
		
		for(int index = 0; index < array.length; index++) {
			outStream.writeInt(array[index]);
		}
		
		outStream.close();
	}
	
	public static void readArray(String fileName, int[] array) throws IOException {
		FileInputStream fileStream = new FileInputStream(fileName);
		DataInputStream inStream = new DataInputStream(fileStream);
		
		for(int index = 0; index < array.length; index++) {
			array[index] = inStream.readInt();
		}
		
		inStream.close();
	}
	
}
