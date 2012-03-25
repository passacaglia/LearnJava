import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class TestStdInput {
	public static void main(String args[]) {
		String inputString = "";
		
		System.out.println("Please input something ...");
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		
		try {
			inputString = br.readLine();
		}
		catch (IOException e) {
			System.out.println("Please input something &^%^$#%@%");
			e.toString();
		}
	
		
		System.out.println("You hava input :");
		System.out.println(inputString);
	}
}