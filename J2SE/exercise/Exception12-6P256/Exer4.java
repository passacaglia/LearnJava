import java.io.File;
import java.io.IOException;

public class Exer4 {
	public static void main(String args[]) {
		
		//Change the String "test.txt" to the file name you want.
		File f = new File("test.tx");
		
		//If there isn't an exception, that is ok.
		try {
			Exer4.detectFile(f);
			System.out.println("OK");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	static void detectFile(File file) throws Exception {
		Exception e = new IOException("File not found");
		if (!file.exists()) throw e;
	}
	
	/**B
	static void detectFile(File file) throws IOException {
		if (!file.exists()) throw new IOException("File ' " + file.getName() + " ' not found!");
	}*/
	
	/**C
	static void detectFile(File file) throws IOException {
		if (!file.exists()) throw new IOException;
	}*/
	
	/**D
	static void detectFile(File file) {
		if (!file.exists()) throw "File not found !";
	}*/
	
	/**E
	static void detectFile(File file) throws IOException {
		if (!file.exists()) throw new IOException();
	}*/
}