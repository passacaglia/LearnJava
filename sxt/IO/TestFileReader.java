/**
*���ֲ�������
****/

import java.io.*;

public class TestFileReader {
  public static void main(String[] args) {
    FileReader fr = null; 
    int c = 0;//��Ŷ������ַ���
    try {
      fr = new FileReader("./TestFileReader.java");

      while ((c = fr.read()) != -1) {
        System.out.print((char)c);
      }
      fr.close();
    } catch (FileNotFoundException e) {
      System.out.println("File not found.");
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("�ļ���ȡ����");
      e.printStackTrace();
    }

  }
}