import java.io.*;

public class ObjSerInput {
	public static void main(String[] args) {
		try {
			FileInputStream fin = new FileInputStream("Data.txt");
			ObjectInputStream objIn = new ObjectInputStream(fin);
			
			Student st = (Student)objIn.readObject();
			st.printData();
			
			objIn.close();
			fin.close();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}
}