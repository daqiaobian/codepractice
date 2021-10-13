package studentSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentSystem {
    /*
    * 1、用输出语句完成主界面的编写
    * 2、用Scanner实现键盘录入数据
    * 3、用switch语句完成操作的选择
    * 4、用循环完成再次回到主界面
    * */
    public static void main(String[] args) {
        //创建集合对象，存储学生数据
        ArrayList<Student> array = new ArrayList<Student>();
        while (true){
        System.out.println("----------欢迎来到学生管理系统----------");
        System.out.println("1、添加学生");
        System.out.println("2、删除学生");
        System.out.println("3、修改学生");
        System.out.println("4、查看所有学生");
        System.out.println("5、退出");

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的选择：");
        String line = sc.nextLine();

        switch(line) {
            case "1":
                //System.out.println("添加学生");
                addStudent(array);
                break;
            case "2":
                //System.out.println("删除学生");
                deleteStudent(array);
                break;
            case "3":
                System.out.println("修改学生");
                break;
            case "4":
               // System.out.println("查看所有学生");
                findAllStudent(array);
                break;
            case "5":
                System.out.println("谢谢使用！");
                System.exit(0);
        }
        }
    }

    //定义一个方法，用于添加学生
    //返回值  参数
    public static void addStudent(ArrayList<Student> array){
        //键盘录入学生对象所需要的数据，显示提示信息，提示要输入何种信息
        Scanner sc = new Scanner(System.in );
        System.out.println("请输入学生学号");
        String sid = sc.nextLine();
        System.out.println("请输入学生姓名");
        String name = sc.nextLine();
        System.out.println("请输入学生年龄");
        String age = sc.nextLine();
        System.out.println("请输入学生居住地");
        String address = sc.nextLine();

        //创建学生对像，把键盘录入的数据赋值给学生对象的成员变量
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);
        //将学生对象添加到集合中
        array.add(s);
        //输出添加成功提示
        System.out.println("添加学生成功");
    }

    //定义一个方法，用于查看学生信息
    /*
    public static void findAllStudent(ArrayList<Student> array){
        //显示表头信息
        System.out.println("学号\t\t\t姓名\t\t年龄\t居住地");

        //将集合中数据取出按照对应格式显示学生信息，年龄显示补充“岁”
        for (int i = 0; i< array.size();i++){
            Student s = array.get(i);
            System.out.println(s.getSid()+"\t"+s.getName() + "\t"+s.getAge()+"岁\t"+s.getAddress());
        }
    }
    **/
    public static void findAllStudent(ArrayList<Student> array){
        //判断集合中是否有数据，如果没有显示信息
        if (array.size() == 0){
            System.out.println("无信息请先添加信息！");
            //为了不让程序往下执行给出return;
            return;
        }
        //显示表头信息
        System.out.println("学号\t\t\t姓名\t\t年龄\t\t居住地");
        //将集合中数据取出按照对应格式显示学生信息，年龄显示补充“岁”
        for (int i = 0;i< array.size();i++){
            Student s = array.get(i);
            System.out.println(s.getSid()+"\t\t"+s.getName() + "\t\t"+s.getAge()+"岁\t"+s.getAddress());
        }

    }

    //定义一个方法，用于删除学生的信息
    public static void deleteStudent(ArrayList<Student> array){
        //键盘录入要删除学生的学号
        Scanner sc = new Scanner(System.in );
        System.out.println("请输入要删除学生学号：");
        String sid = sc.nextLine();
        //遍历集合将对应学生对象从集合中删除
        for (int i = 0;i< array.size();i++){
            Student s = array.get(i);
            if (s.getSid().equals(sid)){
                array.remove(i);
                break;
            }
        }
        //给出删除成功提示
        System.out.println("删除成功");
    }

    //定义一个方法，用于修改学生
    public static void updateStudent(ArrayList<Student> array){
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入要修改的学生学号：");
        String sid = sc.nextLine();
//键盘录入要修改学生的新信息
        System.out.println("请输入学生新姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生新年龄：");
        String age = sc.nextLine();
        System.out.println("请输入学生新居住地：");
        String address = sc.nextLine();

        //创建学生对象
        Student s = new Student();
        s.setSid(sid);
        s.setName(name);
        s.setAge(age);
        s.setAddress(address);

        //遍历集合修改对应的学生信息
        for (int i = 0;i< array.size();i++){
            Student student = new Student();
            if (student.getSid().equals(sid)){
                //修改集合对应的信息
                array.set(i,s);
                break;
            }
        }
    }
}
