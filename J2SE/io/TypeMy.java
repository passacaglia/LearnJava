import java.io.FileInputStream;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.IOException;
import java.io.File;

public class TypeMy {
	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader(args[0]);
			LineNumberReader lnr = new LineNumberReader(fr);
			int ln = lnr.getLineNumber();
			String str = lnr.readLine();
						
			while (str != null) {
				System.out.println(" "+ (ln+1) + "	" + str);
				ln = lnr.getLineNumber();
				str = lnr.readLine();
			}
			
			fr.close();
			lnr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}