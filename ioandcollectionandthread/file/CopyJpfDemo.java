package file;

import java.io.*;

public class CopyJpfDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("E:\\test\\QQ图片20210408091034.jpg"));
        //根据目的地创建字节流对象
        FileOutputStream fos = new FileOutputStream(new File("E:\\test\\javaSE\\QQ图片20210408091034.jpg"));

        //读写数据，复制图片（一次读取一个字节数组，一次写入一个字节数组）
        byte[] bys = new byte[1024];
        int len;
        while ((len = fis.read(bys)) != -1){
            fos.write(bys,0,len);
        }
        fis.close();
        fos.close();
    }
}
