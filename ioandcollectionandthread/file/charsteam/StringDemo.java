package file.charsteam;

import sun.nio.cs.ext.GBK;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class StringDemo {
    public static void main(String[] args) throws IOException {
        /*String s = "中国";

        byte[] bysw = s.getBytes();
        System.out.println(Arrays.toString(bysw));

        String ss = new String(bysw, StandardCharsets.UTF_8);
        System.out.println(ss);*/

       /* InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\test\\java.txt"));

        char[] chs = new char[1024];
        int len;
        while ((len = isr.read(chs)) != -1){
            System.out.println(new String(chs, 0, len));
        }
        isr.close();

        try{
            BufferedReader bj = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("qingshuru:" );
            String nn = bj.readLine();

        }catch (IOException e){
            e.printStackTrace();

        }*/

        //创建字符缓冲输入流对象
        BufferedReader br = new BufferedReader(new
                FileReader("E:\\test\\java.txt"));
//创建ArrayList集合对象
        ArrayList<String> array = new ArrayList<String>();
//调用字符缓冲输入流对象的方法读数据
        String line;
        while ((line=br.readLine())!=null) {
//把读取到的字符串数据存储到集合中
            array.add(line);
        }
        //释放资源
        br.close();
//遍历集合
        for(String s : array) {
            System.out.println(s);
        }
    }
}
