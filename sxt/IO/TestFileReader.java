/**
*汉字不会乱码
****/

import java.io.*;

public class TestFileReader {
  public static void main(String[] args) {
    FileReader fr = null; 
    int c = 0;//存放读出的字符。
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
      System.out.println("文件读取错误");
      e.printStackTrace();
    }

  }
}