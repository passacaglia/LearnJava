//     package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;


public class Test {

public static void main(String args[]) throws IOException{

        File in=new File("a.mp3");
        File out=new File("b.mp3");
        if(!out.exists())
        out.createNewFile();
   copyFile(in,out);
}
public static void copyFile(File in,File out) throws IOException{
     FileChannel fin=new FileInputStream(in).getChannel();
     FileChannel fout=new FileOutputStream(out).getChannel();
     fout.transferFrom(fin,0,fin.size());
    
}
}