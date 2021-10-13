package atsingleton.atsingleton02;

public class SingletonTest02 {
    public static void main(String[] args) {
        //测试
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
        System.out.println("instance1.hashCode="+s1.hashCode());
        System.out.println("instance2.hashCode="+s2.hashCode());
    }
}

class  Singleton{
   //1、构造器私有化，外部不能new
    private Singleton(){};
    //2、本类内部创建对象实例
    private static  Singleton instance;

    static {//在静态代码块中，创建单例对象
        instance = new Singleton();
    }
    //3、提供一个共有的静态方法，返回实例对象
    public static Singleton getInstance(){
        return instance;
    }
}