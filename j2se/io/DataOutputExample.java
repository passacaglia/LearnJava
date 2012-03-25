import java.io.*;

public class DataOutputExample {
	public static void main(String[] args) {
		try {
			FileOutputStream fout = new FileOutputStream(args[0]);
			DataOutputStream dataOut = new DataOutputStream(fout);
			
			double data;
			
			for (int i=0; i<10; i++) {
				data = Math.random();
				System.out.println(data);
				System.out.println("Writing data to file.");
				dataOut.writeDouble(data);
			}
			
			dataOut.close();
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}