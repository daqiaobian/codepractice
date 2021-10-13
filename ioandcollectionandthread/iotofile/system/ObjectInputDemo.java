package iotofile.system;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectInputDemo {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\test\\mangmang.txt"));
        //创建对象
        Student s = new Student("zhangjinjin", 21);
        oos.writeObject(s);
        oos.close();
    }
}
