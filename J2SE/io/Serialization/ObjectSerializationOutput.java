import java.io.*;

public class ObjectSerializationOutput {
	public static void main(String[] args) {
		
		if (args.length != 4) {
			System.out.println("Usage: java ObjectSerializationOutput \"Student Name\" \"Chinese Score\" \"English Score\" \"Math Score\"");
			System.exit(-1);
		}
		
		int c = Integer.parseInt(args[1]);
		int e = Integer.parseInt(args[2]);
		int m = Integer.parseInt(args[3]);
				
		Student st = new Student(args[0], c, e, m);
		st.printData();

		try {
			FileOutputStream fout = new FileOutputStream("Data.txt");
			ObjectOutputStream objOut = new ObjectOutputStream(fout);
			
			System.out.println("\nNow, writing data to \"Data.txt\"");
			objOut.writeObject(st);
			
			objOut.close();			
			fout.close();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
}