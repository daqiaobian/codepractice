package iotofile.system;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputDemotrue {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\test\\mangmang.txt"));
        Object obj = ois.readObject();
        Student s = (Student) obj;
        System.out.println(s.getName()+"," + s.getAge());
        ois.close();
    }
}
