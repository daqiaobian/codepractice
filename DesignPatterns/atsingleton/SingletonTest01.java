package atsingleton;

public class SingletonTest01 {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println(instance1 == instance2);   //调用的是地址
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());     //同一个对象实例
    }
}
//饿汉式，用静态变量来完成的
class  Singleton{
    //1、构造器私有化
    private Singleton(){};

    //2、本类内部创建对象实例
    private final static Singleton instance = new Singleton();

    //3、对外提供一个共有的静态方法，返回实例对象
    public static Singleton getInstance(){
        return instance;
    }
    /*
    * 优点：有点比较简单，就是在类装载的时候完成实例化。避免了线程同步问题
    * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loding的效果，如果至始至终从未使用过这个实例，则会造成内存浪费
    * 结论：这种单例模式可用，可能会造成内存浪费
    * */
}