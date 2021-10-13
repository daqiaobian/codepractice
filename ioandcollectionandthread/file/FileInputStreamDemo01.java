package file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamDemo01 {
    public static void main(String[] args) throws IOException {
         /*FileInputStream fis = new FileInputStream(new File("E:\\test\\java.txt"));
         int by;
         while ((by = fis.read()) != -1){
             System.out.print((char)by);
         }
         fis.close();*/

        /*FileInputStream fis = new FileInputStream(new File("E:\\test\\java.txt"));
        FileOutputStream fos = new FileOutputStream(new File("E:\\test\\java1.txt"));
        //读写数据操作，复制文本文件（一次读取一个字节，一次写入一个字节）
        int by;
        while ((by = fis.read()) != 1){
            fos.write(by);
        }
        fos.close();
        fis.close();*/

        FileInputStream fis = new FileInputStream(new File("E:\\test\\java.txt"));
        //调用字节输入流对象的读数据方法
        //int read (byte[] b): 从该输入流读取最多b.length个字节数组
        byte[] bys = new byte[1024];
        int len;

        while((len= fis.read(bys)) != -1){
            System.out.print(new String(bys, 0, len));
        }
        fis.close();
    }
}
