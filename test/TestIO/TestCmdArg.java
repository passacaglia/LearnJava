/**
*To use this program,you should add some arguments behind "java TestCmdArg".
*Like this: "java TestCmdArg abc 8923 u2"
**/

public class TestCmdArg {
	public static void main(String args[]) {
		System.out.println("You have input " + args.length + " argument(s).");//args.length <--- String args[]
		
		for (int i=0; i<args.length; i++) {
			System.out.println("argument " + (i+1) + " : " + args[i]);
		}
		
	}
}