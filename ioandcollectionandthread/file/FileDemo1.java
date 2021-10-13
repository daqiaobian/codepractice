package file;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        //File(String pathname)：通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
      /*  File fiel  = new File("E:\\test\\java.txt");
        System.out.println(fiel.createNewFile());
        System.out.println("-------------");*/

        File f2 = new File("E:\\test\\javaSE");
        System.out.println(f2.mkdir());
        System.out.println("---------");

        File f3 = new File("E:\\test\\javaWEB\\HTML");
        System.out.println(f3.mkdirs());

        File f4 = new File("E:\\test");
        String[] strArray = f4.list();
        for(String str : strArray) {
            System.out.println(str);
        }
        System.out.println("--------");
        File[] fileArray = f4.listFiles();
        for(File file : fileArray) {
        // System.out.println(file);
        // System.out.println(file.getName());
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }
}
