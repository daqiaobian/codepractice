package inversion;

public class DependecyInversion {
    public static void main(String[] args) {
        Person per = new Person();
        per.receive(new Email());
    }
}

/*
* 比较容易想到此方案
* 如果从获取的对象时微信，短信等等。则新增类，同时Person类也要增加相应的增加方法
* 解决思路： 引入一个抽象的接口 IReceiver，表示接受者，这样Person类与接口发生依赖
*           因为Email，微信等，输入接收者的范围。各自实现Irceiver接口，符合依赖倒置原则
*
* */
class Email{
    public String getInfo(){
        return "电子邮件信息：helle,world0";
    }
}
class Person{
    public void receive(Email email){
        System.out.println(email.getInfo());
    }
}
