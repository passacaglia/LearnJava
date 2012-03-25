import java.io.File;
import java.io.IOException;

public class TestFile {
	public static void main(String[] args) {
		String separator = File.separator;
		String filename = "myfile.txt";
		String directory = "mydir001" + separator + "mydir2";
		//String directory = "mydir001/mydir2";
		
		File f = new File(directory, filename);
		if (f.exists()) {
			System.out.println("FileName: " + f.getAbsolutePath());
			System.out.println("FileSize: " + f.length());
		} else {
			f.getParentFile().mkdirs();
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}