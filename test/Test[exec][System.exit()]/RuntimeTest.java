/**
*You may need to transfer an argument,and then it will transfer to the program "ExternalProgram".
* System.exit(0);//0 means exit normally
* System.exit(int status);//nonzero means exit abnormally
**/

public class RuntimeTest {
	public static void main(String args[]) {
		//String cmd = "notepad";
		String cmd = "java ExternalProgram ";//Need space in the end of the sentence , for adding the argument.

/**
*When you want to run the Windows program like 'notepad', you should del the following sentences.		
*
*The argument that is transfered will be added to the string "cmd".
*
**/
		if (args.length == 0) {
			cmd += 0;
			System.out.println("Run " + cmd);
		}
		else {
			cmd += args[0];//add the argument to the string "cmd"
		}
		
		try {
			Process ps = Runtime.getRuntime().exec(cmd);
			ps.waitFor();
			if (ps.exitValue() == 0) {
				System.out.println("The program '" + cmd + "' terminate normally!");
			}
			else {
				System.out.println("The program '" + cmd + "' terminate abnormally! :/");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}