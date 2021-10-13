package file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileoutputStreamDemo01 {
    public static void main(String[] args)  {
        /*try {
            FileOutputStream fos = new FileOutputStream("E:\\test\\fos.txt");
            fos.write(97);
            //void close()：关闭此文件输出流并释放与此流相关联的任何系统资源。
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }*/

        /*FileOutputStream fos = new FileOutputStream("E:\\test\\fos.txt");
        byte[] bys = "acbdg".getBytes();
        fos.write(bys,1,3);
        fos.close();*/

       /* FileOutputStream fos = new FileOutputStream(new File("E:\\test\\fos.txt"), true);
        for (int i = 0; i < 10; i++){
            fos.write("hello".getBytes(StandardCharsets.UTF_8));
            fos.write("\r\n".getBytes(StandardCharsets.UTF_8));
        }
        fos.close();*/

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("E:\\test\\fos1.txt"));
            fos.write("hello".getBytes(StandardCharsets.UTF_8));
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
