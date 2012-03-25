/**
*serializable½Ó¿Ú
*transient¹Ø¼ü×Ö
*
*
**/

import java.io.*;

public class TestObject_Stream {
	public static void main(String[] args) {
		try {
			//write
			FileOutputStream fout = new FileOutputStream("./TestObj.txt");
			ObjectOutputStream objOut = new ObjectOutputStream(fout);

			T t = new T();
			t.d = 888;
			objOut.writeObject(t);
			objOut.flush();
			objOut.close();
			
			//read
			FileInputStream fin = new FileInputStream("./TestObj.txt");
			ObjectInputStream objIn = new ObjectInputStream(fin);
			
			T tRe = (T)(objIn.readObject());
			System.out.println(tRe.a + " " + tRe.b + " " + tRe.c + " " + tRe.d );
		} catch (FileNotFoundException fne) {
			fne.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException cne) {
			cne.printStackTrace();
		}
	}
}

class T implements Serializable {
	int a = 1;
	int b = 2;
	double c = 3.3;
	int d = 89;
}