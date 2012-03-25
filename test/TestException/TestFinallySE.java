/**
*If your input is zero,it will cause ArithmeticException too.
*Because 10/0 is wrong.
**/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class TestFinallySE {
	
	public static void main(String args[]) {
		
		int i = 0;
		String s = "";
		
		//detect i,if "i" is exist and if "i" is a number. If not,let user to input again.

		if (args.length == 0) {
			
			//Here we need you to input a number.If you input a letter,we would ask you to input again.
			//The string "s" helps to check the input.
			//Don't worry, we will make it a number later.
			do {
				System.out.println("\nThe program need a number:");
				InputStreamReader isr = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(isr);
				
				try {
					s = br.readLine();
					checkNumber(s);
					break;
				}
				catch (IOException e) {
					System.out.println("Please do it again :");
				}
				catch (NumberFormatException e) {
					System.out.println("Please do it again :");
				}
			} while (true);//Seems always true.Any way,that is just what we want.
			
			//We have checked what you have input.Nothing wrong now, so we can make it a number.
			i = Integer.parseInt(s);
			
		}
		else {
			i = Integer.parseInt(args[0]);
		}

		
		//This is what we want to do
		//And here we want the exception,so there is not a "do...while" circle.
		//Wrong input will cause an exception.
		try {
			int ans = 10 / i;
			System.out.println("ans = " + ans);
		}
		catch (ArithmeticException e) {
			System.err.println(e);
		}
		finally {
			System.out.println("\n*****");
			System.out.println("*In the finally block!");
			System.out.println("*****");
		}
		
		System.out.println("\nEnd of program.");
	}
	
	//check the string if it can be "Integer.parseInt()"
	public static void checkNumber(String str) throws NumberFormatException{
		
			int i = Integer.parseInt(str);

	}

}