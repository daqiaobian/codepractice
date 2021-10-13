package inversion.improve;

public class DependecyInversion1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.reveive(new Email());
        person.reveive(new Weixin());
    }
}

interface IReceiver{
    public String getInfo();
}

class Email implements IReceiver{

    @Override
    public String getInfo() {
        return "电子邮件信息：helle,world0";
    }
}

//增加微信
class Weixin implements IReceiver{

    @Override
    public String getInfo() {
        return "微信消息：hello world";
    }
}

class Person{
    public void reveive(IReceiver receiver){
        System.out.println(receiver.getInfo());
    }
}