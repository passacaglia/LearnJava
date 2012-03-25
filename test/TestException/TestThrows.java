import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestThrows {
	public static void main(String args[]) {
		String fileName = "";
		
		do {
			System.out.println("Please input a file name: ");
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			try {
				fileName = br.readLine();
				openFile(fileName);
				break;
			}
			catch (IOException e) {
				System.err.println(e.toString());
				System.out.println("Let's do it again...");
			}
		} while (true);
		
		System.out.println("Successed!");
	}
	
	public static void openFile(String fileName) throws FileNotFoundException{
		FileInputStream f = new FileInputStream(fileName);
	}
}