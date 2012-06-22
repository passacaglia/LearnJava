import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Exer1 {
	public static void main(String args[]) {
		try {
			FileInputStream f = new FileInputStream("test.txt");
			System.out.println("Open file Successed!");
		}
		catch (FileNotFoundException fe) {
			System.out.println("File not found!");
		}
		catch (IOException ie) {
			System.out.println("IO Exception!");
		}
		catch (Exception e) {
			System.out.println("General Exception!");
		}
		finally {
			System.out.println("Do finally block.");
		}
		
		System.out.println("Out of try block.");
	}
}