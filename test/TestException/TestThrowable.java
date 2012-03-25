/**
*The program is used to show you the different kinds of exception message.
**/

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestThrowable {
	
	public static void main(String args[]) {
		
		try {
			FileInputStream f = new FileInputStream("test.txt");
		}
		catch (FileNotFoundException e) {
			System.out.println("\n---toString()---");
			System.out.println(e.toString());
			System.out.println(e);
			System.err.println(e.toString());//System.err
			System.err.println(e);
			
			
			System.out.println("\n---getLocalizedMessage()---");
			System.out.println(e.getLocalizedMessage());
			
			System.out.println("\n---getMessage()---");
			System.out.println(e.getMessage());
			
			System.out.println("\n---printStackTrace()---");
			e.printStackTrace();
		}
	}
}