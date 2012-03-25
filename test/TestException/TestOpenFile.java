import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestOpenFile {
	
	public static void main(String args[]) {
		
		String fileName = "";
		
		do {
			System.out.print("Please input a file name : ");
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			try {
				fileName = br.readLine();
			}
			catch (IOException e) {
				e.toString();
			} 
		} while (!openFile(fileName));
		
		System.out.println("Successed !");
	}
	
	public static boolean openFile(String fileName) {
		
		try {
			FileInputStream f = new FileInputStream(fileName);
			return true;
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}
}