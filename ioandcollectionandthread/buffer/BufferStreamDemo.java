package buffer;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BufferStreamDemo  {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\test\\java.txt"));
        bos.write("hello\r\n".getBytes(StandardCharsets.UTF_8));
        bos.write("xixi".getBytes(StandardCharsets.UTF_8));

        bos.close();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\test\\java.txt"));
        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1){
            System.out.println(new String(bys, 0, len));
        }
        bis.close();
    }
}
