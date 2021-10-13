package file.example;
/*
* 需求
*   把ArrayList集合中的学生数据写入到文本文件。要求：每一个学生对象的数据作为文件中的一行数据 格式：
学号,姓名,年龄,居住地 举例：itheima001,林青霞,30,西安
*
* 实现步骤
定义学生类
创建ArrayList集合
创建学生对象
把学生对象添加到集合中
创建字符缓冲输出流对象
遍历集合，得到每一个学生对象
把学生对象的数据拼接成指定格式的字符串
调用字符缓冲输出流对象的方法写数据
释放资源
* */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ArrayListToFileDemo {
    public static void main(String[] args) throws IOException {
        ArrayList<Student> array = new ArrayList<>();

        //创建学生对象
        Student s1 = new Student("shiyanshi1", "gongxiao", 22, "China");
        Student s2 = new Student("shiyanshi02", "demo",20,"Atimaric");
        Student s3 = new Student("shiyanshi03","xiaohau",32,"Jopense");

        //把学生对象添加到集合中
        array.add(s1);
        array.add(s2);
        array.add(s3);

        //创建字符缓冲输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\test\\yuanyuan.txt"));

        //遍历集合，得到每一一个学生的对象
        for (Student s : array){
            StringBuilder sb = new StringBuilder();

            sb.append(s.getSid()).append(",").append(s.getName()).append(",").append(s.getAge()).append(",").append(s.getAddress());

            //调用字符缓冲输出流对象的方法写数据
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        bw.close();


    }
}
