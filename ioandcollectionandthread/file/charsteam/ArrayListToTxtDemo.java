package file.charsteam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayListToTxtDemo {
    public static void main(String[] args) throws IOException {
        ArrayList<String> array = new ArrayList<>();

        //往集合中添加字符串元素
        array.add("hello");
        array.add("world");
        array.add("java");

        //创建字符缓冲输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\test\\xixi.txt"));

        //遍历集合，得到每一个字符串数据
        for (String s : array){
            bw.write(s);
            bw.newLine();
            bw.flush();
        }
        //释放资源
        bw.close();
    }
}
